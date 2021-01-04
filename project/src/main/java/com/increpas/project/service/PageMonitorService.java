package com.increpas.project.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.increpas.project.dao.UrlCrawlDAO;
import com.increpas.project.vo.UrlCrawlVO;

/*

	PageMonitorService
		- 12시간마다 웹 페이지의 변화를 감지하여 페이지의 상품 정보가 바뀌었을 경우,
			해당 페이지의 cuno를 리스트에 담아 파이썬 서버로 전달하는 백그라운드 서비스
		- 웹페이지 변화 감지 방법
			- 웹페이지의 상품 정보의 hashcode를 DB에 저장하고,
				기존의 hashcode와 새로 크롤링한 hashcode의 값을 비교함
				- hashcode = 페이지를 크롤링하여 얻어진 
					다수의 상품 정보 String text의 hashCode()의 합

 */

public class PageMonitorService {

	@Autowired
	private UrlCrawlDAO urlDAO;
	// Spring 서버에서 다른 서버로 요청을 전달하기 위해 사용하는 객체
	@Autowired
	private RestTemplate restTemplate;

	private final String IP = "127.0.0.1";
//	private final String IP = "119.196.57.81";
	private final String PORT = "9000";
	private final String URI = "/updateData.project";
	
	// Content Div와 개별 상품 정보 Div 태그의 CSS Selector 값을 저장한 Map
	// key = 소셜커머스 이름, value = String[] css selector
	private HashMap<String, String[]> map;

	// 객체가 생성된 후 1번 실행됨을 의미하는 Annotation
	@PostConstruct
	public void init() {
		// Map Initialization
		map = new HashMap<String, String[]>();
		map.put("11st", new String[] { "div#bestPrdList", "div.ranking_pd" });
		System.out.println("========= " + this.getClass().getName() + " Initialized! =========");
//		try {
//			sendChangedPageList();
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
	}

	// 스케줄링 Annotation cron = "ss mm hh dd MM YY"
//	@Scheduled(cron = "0 0 /12 * * *")
	@Scheduled(cron = "0 0 0/1 * * *")
	public Object sendChangedPageList() throws UnsupportedEncodingException {
		// 변화된 웹페이지의 cuno를 담은 리스트를 파이썬 서버로 전송
		
		// 변화된 웹페이지의 cuno list 가져오기
		List<Integer> list = getChangedWebPages();
		// URL 세팅
		String url = "http://" + IP + ":" + PORT + URI;
		// 전송 방식, 타입, 데이터 입력
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		// Full URL을 만들어 주는 Builder 객체
		UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
													.queryParam("cunoList", list)
													.queryParam("_type", "json").build(false); // 자동으로 encode해주는 것을 막기 위해 false
		System.out.println(builder.toUriString());
		// 데이터 전송 및 응답
		Object response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, new HttpEntity<String>(headers),
				String.class);
		return response;
	}

	// 기존 해시코드와 새로 크롤링한 해시코드를 비교하여 
	// 변화된 페이지의 cuno를 리스트에 담아 반환하는 메소드
	protected List<Integer> getChangedWebPages() {
		// 변화된 페이지의 cuno를 저장할 리스트
		List<Integer> cunoList = new ArrayList<Integer>();
		// 변화를 감시할 페이지의 정보를 담고 있는 리스트
		List<UrlCrawlVO> list = urlDAO.selectAll();
		for (UrlCrawlVO vo : list) {
			// 크롤링하여 얻은 해시코드를 tempHashCode에 저장
			int tempHashCode = getDivHashCode(vo);
			// 기존의 해시코드와 새로운 해시코드가 다르면, 페이지의 변화가 있음을 의미
			if (vo.getHashCode() != tempHashCode) {
				// 새로운 해시코드를 VO에 저장
				vo.setHashCode(tempHashCode);
				// DB UPDATE
				urlDAO.updateHashCode(vo);
				// cunoList에 변화한 페이지의 cuno 저장
				cunoList.add(vo.getCuno());
			}
		}
		return cunoList;
	}

	// 크롤링하여 처리한 해시코드를 반환해주는 메소드
	protected int getDivHashCode(UrlCrawlVO vo) {
		int hash = 0;
		Document doc;
		try {
			// Jsoup을 이용하여 페이지의 html을 받아옴
			doc = Jsoup.connect(vo.getUrlCrawl()).get();
			// Map에서 css selector 정보를 받아옴 
			// ( 소셜커머스마다 페이지의 구조나 클래스 및 아이디가 모두 다름 )
			String[] selectors = map.get(vo.getScName());
			// 전체 html에서 상품 정보만을 담은 content div를 가져옴
			// ( 상품 정보 이외에도 다른 곳에서 같은 클래스를 사용하고 있을 가능성이 있으므로 )
			Element contentDiv = doc.select(selectors[0]).get(0);
			// content div에서 개별 상품 정보들을 가져옴
			Elements prodDivs = contentDiv.select(selectors[1]);
			for (Element prodDiv : prodDivs) {
				// 각 상품 정보의 text 데이터의 hash값을 hash 변수에 누적
				hash += prodDiv.text().hashCode();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return hash;
	}

}

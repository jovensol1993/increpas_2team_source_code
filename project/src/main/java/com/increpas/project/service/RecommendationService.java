package com.increpas.project.service;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.increpas.project.dao.CategoriesDAO;
import com.increpas.project.dao.ProductDAO;
import com.increpas.project.vo.CategoriesVO;
import com.increpas.project.vo.MemberVO;
import com.increpas.project.vo.ProductVO;

public class RecommendationService {

	@Autowired
	private CategoriesDAO cDAO;
	@Autowired
	private ProductDAO pDAO;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ObjectMapper mapper;
	
	private final String IP = "127.0.0.1";
	private final String PORT = "9000";

	public List<ProductVO> getRecommendationByInfo(MemberVO mVO) {
		String uri = "/getCnoList.project";
		Calendar cal = Calendar.getInstance();
		int ageGroup = mVO.getAgeGroup();
		String day = getStringDayOfWeek(cal.get(Calendar.DAY_OF_WEEK));
		int month = cal.get(Calendar.MONTH) + 1;
		String gender = mVO.getGender();

		String url = "http://" + IP + ":" + PORT + uri;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		UriComponents builder = UriComponentsBuilder.fromHttpUrl(url).queryParam("gender", gender.toLowerCase())
				.queryParam("month", month).queryParam("age", ageGroup).queryParam("day", day)
				.queryParam("_type", "json").build(false); // 자동으로 encode해주는 것을 막기 위해 false
		ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET,
				new HttpEntity<String>(headers), String.class);
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<HashMap<String, List<Integer>>> typeRef = 
				new TypeReference<HashMap<String, List<Integer>>>() {};
		HashMap<String, List<Integer>> map = null;
		try {
			map = mapper.readValue(response.getBody(), typeRef);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return pDAO.selectProductsFromCnoList(map.get("list"));
	}
	
	private String getStringDayOfWeek(int dayOfWeek) {
		String sDayOfWeek = "";
		switch (dayOfWeek) {

		case 1:
			sDayOfWeek = "Mon";
			break;
		case 2:
			sDayOfWeek = "Tue";
			break;
		case 3:
			sDayOfWeek = "Wed";
			break;
		case 4:
			sDayOfWeek = "Thur";
			break;
		case 5:
			sDayOfWeek = "Fri";
			break;
		case 6:
			sDayOfWeek = "Sat";
			break;
		case 0:
			sDayOfWeek = "Sun";
			break;
		default:
			break;

		}
		return sDayOfWeek;
	}

	public List<ProductVO> getRecommendationBySimilarity(MemberVO mVO) {
		String uri = "/getSimilarProductList.project";
		
		String url = "http://" + IP + ":" + PORT + uri;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("mno", mVO.getMno())
				.queryParam("_type", "json").build(false); // 자동으로 encode해주는 것을 막기 위해 false
		ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET,
				new HttpEntity<String>(headers), String.class);
		TypeReference<HashMap<String, List<Integer>>> typeRef = 
				new TypeReference<HashMap<String, List<Integer>>>() {};
		HashMap<String, List<Integer>> map = null;
		try {
			map = mapper.readValue(response.getBody(), typeRef);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return pDAO.selectListedProducts(map.get("list"));
	}

	public List<ProductVO> getRecommendationByMaxLikeCnt(MemberVO mVO) {
		return pDAO.selectListByMaxLikeCnt(mVO);
	}

	public void updateUSV() {
		String uri = "/updateUSV.project";

		String url = "http://" + IP + ":" + PORT + uri;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("_type", "json").build(false); // 자동으로 encode해주는 것을 막기 위해 false
		restTemplate.exchange(builder.toUriString(), HttpMethod.GET,
				new HttpEntity<String>(headers), String.class);
	}

	public HashMap<String, List> getTabData() {
		HashMap<String, List> map = new HashMap<String, List>();
		List<CategoriesVO> cList = cDAO.selectTop5Categories();
		List<ProductVO> pList = pDAO.selectProductsFromListedCategories(cList);
		map.put("cList", cList);
		map.put("pList", pList);
		return map;
	}
	
}

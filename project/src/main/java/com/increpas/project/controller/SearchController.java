package com.increpas.project.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.increpas.project.categories.SearchCategories;
import com.increpas.project.dao.SearchDAO;
import com.increpas.project.vo.SearchVO;

@Controller
@RequestMapping("/search")
public class SearchController {

	@Autowired
	SearchDAO sDAO;
	
//	
//	//메인으로 리다이렉트 컨트롤러
//	@RequestMapping("/main.project")
//	public ModelAndView goToMain(ModelAndView mv) {
//		mv.setViewName("메인뷰이름");
//		return mv;
//	}
//	
	//검색창 첫화면 전체품목 표시 컨트롤러
	@RequestMapping("/search.project")
	public ModelAndView searchMainPage(ModelAndView mv, HttpServletRequest req) {
		//총 품목 수 기억 변수
		int total = sDAO.countAll();

		//소셜커머스 별 품목 갯수
		List<SearchVO> list2 = sDAO.listCountSc();
		List<SearchVO> list3 = sDAO.listCountCateg();
		
		//변수이름은 scname이지만 사이드바에서 소셜커머스, 카테고리 모두 포함
		//파라미터 요청 후 만약 사이드바를 누른적이 없다면 (null) 그냥 전체목록 불러오고
		//만약 사이드바 필터를 눌렀다면 그에 따라 필터링된 목록 불러온다.
		String filtername = req.getParameter("filterbutton");
		if(filtername == null) {
			List<SearchVO> list = sDAO.getAll();
			mv.addObject("LIST", list);
		} else if (filtername != null) {
			List<SearchVO> list = sDAO.getFilterAll(filtername);
			mv.addObject("LIST", list);
		}
		
		//리스트 데이터 뷰에 심고
		mv.addObject("LIST2", list2);
		mv.addObject("LIST3", list3);
		mv.addObject("CNT", total);
		mv.setViewName("search/Search");
		return mv;
	}

	//검색어 입력후 검색결과 
	@RequestMapping("/searchResult.project")
	public ModelAndView searchResult(ModelAndView mv, HttpServletRequest request, String searchword, SearchVO sVO) {
		searchword = request.getParameter("searchword");
		
		//빈 검색어 입력시 검색 메인화면으로
		if(searchword == "") {
			mv.setViewName("redirect:/search/search.project");
		}
		
		//검색된 품목 갯수 기억변수
		int total = sDAO.countSearch(searchword);
		
		//검색된 제품 목록 가져오고
		List<SearchVO> list = sDAO.searchProduct(searchword);
		
		//사이드바 데이터용 
		//소셜커머스 별 품목 갯수
		List<SearchVO> list2 = sDAO.countSearchBySc(searchword);
		//카테고리별 품목 갯수
		List<SearchVO> list3 = sDAO.countSearchByCateg(searchword);
		

		//리스트 데이터 뷰에 심는다
		mv.addObject("SWORD", searchword);
		mv.addObject("LIST", list);
		mv.addObject("LIST2", list2);
		mv.addObject("LIST3", list3);
		mv.addObject("CNT", total);
		
		mv.setViewName("search/SearchResult");
		return mv;
	}
	
	//검색된 결과 필터별로 보여주는 컨트롤러
	@RequestMapping("/searchResultFilter.project")
	public ModelAndView searchResultFilter(ModelAndView mv, HttpServletRequest request) throws JsonProcessingException {
		//hashmap 사용해서 호출한 DAO 결과 담을 list 빈 변수
		List<SearchVO> list;
		
		//배열정보 불러오고
		SearchCategories temp = new SearchCategories();
		String[] test = temp.FilterCategoryList();
		
		//유지된 검색어 가져오고
		String searchword = request.getParameter("searchword");
		//필터 텍스트 parameter 가져오고
		String filtercode = request.getParameter("scode");
		//소셜커머스, 카테고리 parameter 가져오고
		String sidefilter = request.getParameter("filterbutton");
		
		//좋아요, 가격ASC/DESC, 할인율 ASC/DESC 별로 sql문 다르게 처리하기 위한 빈 변수
		String scode="";
		//사이드바 필터 대분류 (소셜커머스/카테고리)
		String sidefilteroption = "";
		//사이드바 필터 소분류 (11st, 유아용품)
		String sidefiltername = "";
		
		//검색된 품목 갯수 기억변수
		int total = sDAO.countSearch(searchword);
		
//filtercode가 null이 아닌가? 
//--filtercode가 null이 아니고 sidefilter가 null인가? --> searchResult에서 좋아요순 등 누른거
//--filtercode가 null이 아니고 sidefilter도 null이 아닌가? --> 필터된 목록 한번 더 필터
//filtercode가 null인가? 
//--sidefilter가 null이 아닌가? -->searchResult에서 소셜커머스나 카테고리 누른거
			
		if (!filtercode.equals("") && !sidefilter.equals("")) {
			//한 번 정렬 후 다시 카테고리별로 정렬시키는 경우
			switch(filtercode) {
			//위에서 파라미터 심은걸 다시 읽어와서 쿼리에 설정
			case "pricedesc":
				scode = "pprice DESC";
				break;
			case "priceasc":
				scode = "pprice ASC";
				break;
			case "dcratedesc":
				scode = "dcrate DESC";
				break;
			case "dcrateasc":
				scode = "dcrate ASC";
				break;
			case "plike":
				scode = "likes DESC";
				break;
			}
			
			for(int i = 0; i < test.length; i++) {
				//만약 categories.SearchCategories 배열의 정보와
				//사이드바에서 누른 버튼의 파라미터가 일치하는 경우
				if(test[i].equals(sidefilter)) {
					//그리고 만약 그게 소셜커머스 이름이라면
					if(test[i].equals("11st")||test[i].equals("Auction")) {
						sidefilteroption = "scname";
						sidefiltername = test[i];
						break;
					} else {
					//아니고 그냥 카테고리 이름이라면
					sidefilteroption = "categname";
					sidefiltername = test[i];
					break;
					}
				}
			}

				HashMap<String, String> map = new HashMap<String, String>();
				map.put("searchword", searchword);
				map.put("sidefilteroption", sidefilteroption);
				map.put("sidefiltername", sidefiltername);
				map.put("scode", scode);
				list = sDAO.filterProductListPlusSideFilter(map);
				mv.addObject("SCODE", filtercode);
				mv.addObject("FILTERBUTTON", sidefiltername);
				mv.addObject("LIST", list);
		
		}
		else if(!filtercode.equals("") && sidefilter.equals("")) {
				switch(filtercode) {
				case "pricedesc":
					scode = "pprice DESC";
					break;
				case "priceasc":
					scode = "pprice ASC";
					break;
				case "dcratedesc":
					scode = "dcrate DESC";
					break;
				case "dcrateasc":
					scode = "dcrate ASC";
					break;
				case "plike":
					scode = "likes DESC";
					break;
				}
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("searchword", searchword);
				map.put("scode", scode);
				list = sDAO.filterProductList(map);
				mv.addObject("LIST", list);
				//사이드바 카테고리를 눌렀을 때 파라미터 사용하도록 다시 심어준다.
				mv.addObject("SCODE", filtercode);
		}
		else if(filtercode.equals("") && !sidefilter.equals("")) {
			//검색 후 바로 사이드바 카테고리를 눌러서 넘어오는 경우
			for(int i = 0; i < test.length; i++) {
				if(test[i].equals(sidefilter)) {
					if(test[i].equals("11st")||test[i].equals("Auction")) {
						sidefilteroption = "scname";
						sidefiltername = test[i];
						break;
					} else {
					sidefilteroption = "categname";
					sidefiltername = test[i];
					break;
					}
				}
			}
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("searchword", searchword);
				map.put("sidefilteroption", sidefilteroption);
				map.put("sidefiltername", sidefiltername);
				list = sDAO.filterProductListUsingSideFilter(map);
				mv.addObject("LIST", list);
				//위에서 다시 파라미터 사용할 수 있도록 다시 심어준다.
				mv.addObject("FILTERBUTTON", sidefiltername);
		} 
		
		
		//사이드바 데이터용 
		//소셜커머스 별 품목 갯수
		List<SearchVO> list2 = sDAO.countSearchBySc(searchword);
		//카테고리별 품목 갯수
		List<SearchVO> list3 = sDAO.countSearchByCateg(searchword);
		
		mv.addObject("SWORD", searchword);
		mv.addObject("LIST2", list2);
		mv.addObject("LIST3", list3);
		mv.addObject("CNT", total);
		mv.setViewName("search/SearchResultFilter");
		return mv;
	}
}

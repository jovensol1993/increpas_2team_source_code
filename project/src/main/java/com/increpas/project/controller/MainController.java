package com.increpas.project.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.increpas.project.service.CategoriesService;
import com.increpas.project.service.MemberService;
import com.increpas.project.service.RecommendationService;
import com.increpas.project.vo.MemberVO;
import com.increpas.project.vo.ProductVO;

@Controller
public class MainController {

//	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	@Autowired
	private RecommendationService recommendationService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private CategoriesService categoriesService;

	@RequestMapping(value="/main.project", method = RequestMethod.GET)
	public ModelAndView main(ModelAndView mv, HttpSession session, HttpServletRequest request, MemberVO mVO) {
		String sid = (String) session.getAttribute("SID");
		if (sid != null) {
			mVO = memberService.getMemberInfoByEmail(sid);
			mv.addObject("mVO", mVO);
		}
		mv.addObject("LIST",categoriesService.selectCategoryList());
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping(value="/main/getRecommendedBySimilarity.project", method = RequestMethod.GET) 
	@ResponseBody
	public List<ProductVO> getRecommendedBySimilarity(MemberVO mVO) {
		return recommendationService.getRecommendationBySimilarity(mVO);
	}

	@RequestMapping(value="/main/getRecommendationByInfo.project", method = RequestMethod.GET) 
	@ResponseBody
	public List<ProductVO> getRecommendationByInfo(MemberVO mVO) {
		return recommendationService.getRecommendationByInfo(mVO);
	}
	
	@RequestMapping(value="/main/getRecommendationByMaxLikeCnt.project", method = RequestMethod.GET) 
	@ResponseBody
	public List<ProductVO> getRecommendationByMaxLikeCnt(MemberVO mVO) {
		return recommendationService.getRecommendationByMaxLikeCnt(mVO);
	}
	
	@RequestMapping(value="/main/getTabData.project", method = RequestMethod.GET) 
	@ResponseBody
	public HashMap<String, List> getTabData() {
		return recommendationService.getTabData();
	}
	
}

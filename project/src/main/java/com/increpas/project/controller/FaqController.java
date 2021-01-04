package com.increpas.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.increpas.project.dao.FaqDAO;
import com.increpas.project.vo.FaqVO;

@Controller
public class FaqController {
	@Autowired(required=true)
	private FaqDAO fDAO;
	
	//FAQ 페이지 이동
	@RequestMapping("/faqBoard.project")
	public ModelAndView FaqBoard(ModelAndView mv, FaqVO fVO, HttpSession session ) {
		// SYSTEM.OUT.println("FaqBoard 진입");
		String sid = (String) session.getAttribute("SID");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		int totalCnt = fDAO.selectFaqListCount(fVO);
		if(totalCnt != 0) {
			list = fDAO.selectFaqList(fVO);
		}
		mv.addObject("SID", sid);
		mv.addObject("fVO", fVO);
		mv.addObject("FaqList", list);
		mv.setViewName("faqBoard");
		
		return mv;
	}
	
	//FAQ 목록 조회
	@RequestMapping(value="/selectFaqList.project", method = RequestMethod.POST)
	public ModelAndView selectNoticeList(ModelAndView mv, FaqVO fVO) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		int totalCnt = fDAO.selectFaqListCount(fVO);
		if(totalCnt != 0) {
			list = fDAO.selectFaqList(fVO);
		}
		
		mv.addObject("fVO", fVO);
		mv.addObject("FaqList", list);
		mv.setViewName("faqBoard");
		
		return mv;
	}
	
	// FAQ 게시판 등록 작업
	@RequestMapping(value="/faqWriteProc.project", method=RequestMethod.POST)
	public @ResponseBody ModelAndView FaqWriteProc(ModelAndView mv, HttpSession session, FaqVO fVO) {
		// SYSTEM.OUT.println(fVO.getType());
		// SYSTEM.OUT.println(fVO.getTitle());
		// SYSTEM.OUT.println(fVO.getContents());
		
		int cnt = 0;
		cnt = fDAO.writeFaq(fVO);
		if(cnt == 1) {
			// SYSTEM.OUT.println("#####글 등록 성공#####");
			mv.setViewName("redirect:/faqBoard.project");
		} else {
			// SYSTEM.OUT.println("###글 등록 성공####");
			mv.setViewName("redirect:/faqBoard.project");
		}
		
		return mv;
	}
	// FAQ 게시판 삭제 작업
	@RequestMapping(value="/faqDelProc.project", method=RequestMethod.POST)
	public @ResponseBody ModelAndView FaqDelProc(ModelAndView mv, HttpSession session, FaqVO qVO) {
		// SYSTEM.OUT.println(qVO.getTitle());
		int cnt = 0;
		cnt = fDAO.delFaq(qVO);
		if(cnt == 1) {
			// SYSTEM.OUT.println("#####글 삭제(제외) 성공#####");
			mv.setViewName("redirect:/faqBoard.project");
		} else {
			// SYSTEM.OUT.println("###글 삭제(제외) 실패####");
			mv.setViewName("redirect:/faqBoard.project");
		}
		
		return mv;
	}
	
}

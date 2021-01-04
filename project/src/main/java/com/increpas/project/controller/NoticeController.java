package com.increpas.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.increpas.project.dao.CategoriesDAO;
import com.increpas.project.dao.NoticeDAO;
import com.increpas.project.util.PageUtil;
import com.increpas.project.vo.NoticeVO;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	NoticeDAO nDAO;
	
	@Autowired
	CategoriesDAO cDAO;
	
//	@RequestMapping("/notice.project")
//	public ModelAndView getList(ModelAndView mv) {
//		mv.addObject("LIST", nDao.getList());
//		mv.setViewName("notice/notice");
//		return mv;
//	}
	@RequestMapping("/notice.project")
	public ModelAndView getList(ModelAndView mv, HttpSession session, PageUtil page, NoticeVO nVO ) {
		String sid = (String) session.getAttribute("SID");
		// 페이지 가져오기
		int total = nDAO.getListCount();
		page.setTotalCount(total); // TotalCount 13
		page.setPage();	// nowPage, totalCount ,3 ,3
		nVO.setPage(page);
		mv.addObject("SID", sid);
		mv.addObject("LIST",cDAO.selectCategoryList());
		mv.addObject("NLIST", nDAO.getList(page));
		mv.addObject("PAGE",page);
		mv.setViewName("notice/notice");
		return mv;
	}
	
	@RequestMapping("/noticeDetail.project")
	public ModelAndView getNoticeDetail(ModelAndView mv, NoticeVO nVO) {
		int cnt = nDAO.updateHit(nVO);
		nVO = nDAO.getDetail(nVO);
		mv.addObject("nVO", nVO);
		mv.setViewName("notice/noticeDetail");
		return mv;
	}
	
	@RequestMapping("/noticeEditProc.project")
	public ModelAndView updataNoticeDetail(ModelAndView mv, NoticeVO nVO) {
		String view = "";
		
		int cnt = nDAO.updateContents(nVO);
		if(cnt != 0) {
			view = "/notice/noticeDetail.project";
		} else {
			view = "/notice/noticeEdit.project";
		}
		mv.addObject("URI", 	view);
		mv.addObject("ID", nVO.getNno());
//		System.out.println(nVO.getTitle()); null
		mv.setViewName("notice/redirect");
		return mv;
	}
	
	@RequestMapping("/noticeEdit.project")
	public ModelAndView getNoticeEdit(ModelAndView mv, NoticeVO nVO) {
		
		nVO = nDAO.getEdit(nVO);
		mv.addObject("nVO", nVO);
		mv.setViewName("notice/noticeEdit");
		return mv;
	}
	
	@RequestMapping("/noticeDel.project")
	public ModelAndView updateDel(ModelAndView mv, NoticeVO nVO) {
		int cnt  = nDAO.updateDel(nVO);
		
		mv.setViewName("redirect:/notice/notice.project");
		return mv;
	}
	
	@RequestMapping("/noticeWrite.project")
	public ModelAndView getNoticeWrite(ModelAndView mv) {
		mv.setViewName("notice/noticeWrite");
		return mv;
	}
	
	@RequestMapping("/noticeWriteProc.project")
	public ModelAndView insertNotice(ModelAndView mv, NoticeVO nVO) {
		String view ="";
		int cnt = nDAO.getNoticeWrite(nVO);
		if(cnt == 1) {
			view = "/notice/notice.project";
		} else {
			 view = "/notice/noticeWrite.project";
		}
		mv.addObject("TITLE", nVO.getTitle());
		mv.addObject("CONTENTS", nVO.getContents());
		mv.addObject("URI",view);
		mv.setViewName("notice/redirect");
		return mv;
	}
}

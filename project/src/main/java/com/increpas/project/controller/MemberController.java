package com.increpas.project.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.increpas.project.dao.MemberDAO;
import com.increpas.project.service.RecommendationService;
import com.increpas.project.vo.MemberVO;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired(required=true)
	MemberDAO mDAO;
	@Autowired
	RecommendationService recommendationService;
	
	@RequestMapping("/logoutProc.project")
	public String logout(HttpSession session) {
		session.setAttribute("SID", null);
		return "redirect:/main.project";
	}
	
	//로그인 보여주고
	@RequestMapping("/login.project")
	public String LoginPage(HttpSession session) {
		System.out.println("Member.java LoginPage() called..");
		session.setAttribute("SID", null);
		return "login";
	}
	
	//로그인 처리
	@RequestMapping("/loginProc.project")
	@ResponseBody
	public Map<String, String> joinForm(ModelAndView mv, HttpSession session, MemberVO mVO) {
		System.out.println("loginProc called..");
		Map<String, String> map = new HashMap<String, String>();

		String sid = (String) session.getAttribute("SID");
		int cnt = 0;
		
		if(sid != null) {
			// 세션이 존재할 경우, 메인페이지로 이동
			mv.setViewName("redirect:/main.project");
		} else {
			cnt = mDAO.memberLogin(mVO);
			if(cnt == 1) {
				System.out.println("로그인 성공");
				session.setAttribute("SID", mVO.getEmail());
				map.put("result", "OK");
				
			} else {
				System.out.println("로그인실패");
				map.put("result", "NO");
			}
		}
		
		return map;
	}
	
	//회원가입페이지 보여주기
	@RequestMapping("/join.project")
	public ModelAndView joinPage(ModelAndView mv,HttpSession session) {
		System.out.println("member.joinPage() called..");
		String sid = (String)session.getAttribute("SID");
		if(sid == null) {
			mv.setViewName("join");
			System.out.println("true : "+ sid);
		} else {
			System.out.println("else : "+ sid);
			mv.setViewName("redirect:/member/login.project");
		}
		
		return mv;
	}
	
	//아이디 중복확인
	@RequestMapping("/idCheck.project")
	@ResponseBody
	public Map<String, String> idCheck(String email) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("result", (mDAO.getEmailCnt(email) == 0) ? "OK" : "NO");
		return map;
	}
	
	//전화번호 중복 확인
	@RequestMapping("/telCheck.project")
	@ResponseBody
	public Map<String, String> telCheck(String tel) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("result", (mDAO.getTelCnt(tel) == 0) ? "OK" : "NO");
		return map;
	}
	
	//회원가입 처리
	@RequestMapping(value="/joinProc.project", method=RequestMethod.POST)
	public ModelAndView joinProc(ModelAndView mv, HttpSession session, MemberVO mVO) {
		System.out.println("member.joinProc() called..");
		System.out.println("###Submit_values###");
		System.out.println("Submit_Email : "+mVO.getEmail());
		System.out.println("Submit_Pw : "+mVO.getPassword());
		System.out.println("Submit_Gen : "+mVO.getGender());
		System.out.println("Submit_Birth : "+mVO.getBirthday());
		System.out.println("Submit_Tel : "+mVO.getTel());
		System.out.println("###################");
		
		int cnt = 0;
		cnt = mDAO.addMember(mVO);
		if(cnt == 1) {
			recommendationService.updateUSV();
			System.out.println("#####가입성공#####");
			mv.setViewName("redirect:/member/login.project");
		} else {
			System.out.println("###가입실패####");
			mv.setViewName("redirect:/member/join.project");
		}
			
		return mv;
	}
	
	//비밀번호 찾기 보여주기 
	@RequestMapping("/findPw.project")
	public ModelAndView findPw(ModelAndView mv, HttpSession session) {
		System.out.println("findPW called..");
		String sid = (String)session.getAttribute("SID");
		if(sid == null) {
			mv.setViewName("findPw");
		} else {
			mv.setViewName("redirect:/main.project");
		}
		return mv;
		
	}
	
	//비밀번호 찾기 기능처리
	@RequestMapping("/findPwProc.project")
	@ResponseBody
	public Map<String, String> findPwProc(ModelAndView mv, MemberVO mVO) {
		String pw = mDAO.findPw(mVO);
		
		Map<String, String> map = new HashMap<String, String>();
		
		if(pw == null || pw == "") {
			map.put("result", "NO");
			map.put("resultPw", "");
		} else {
			map.put("result", "OK");
			map.put("resultPw", pw);
		}
		
		return map;
		
	}
}

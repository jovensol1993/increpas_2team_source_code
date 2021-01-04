package com.increpas.project.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.increpas.project.dao.MemberDAO;
import com.increpas.project.vo.MemberVO;

public class MemberService {

	@Autowired
	MemberDAO mDAO;
	
	public MemberVO getMemberInfoByEmail(String email) {
		MemberVO mVO = mDAO.selectInfoByEmail(email);
		mVO.setLikeCnt(mDAO.selectLikeCntOfMember(mVO.getMno()));
		return mVO;
	}

	
}

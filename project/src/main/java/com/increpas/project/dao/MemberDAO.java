package com.increpas.project.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.increpas.project.vo.MemberVO;

@Repository
public class MemberDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public int memberLogin(MemberVO mVO) {
		
		return sqlSession.selectOne("mSQL.memberLogin",mVO);
	}
	// 회원 이메일체크 
	public int getEmailCnt(String id) {
		return sqlSession.selectOne("mSQL.emailCount", id);
	}
	// 회원 전화번호 체크
	public int getTelCnt(String tel) {
		return sqlSession.selectOne("mSQL.telCheck", tel);
	}
	// 회원가입 처리 전담 함수
	public int addMember(MemberVO mVO) {
		return sqlSession.insert("mSQL.addMember", mVO);
	}
	
	//비밀번호 찾기
	public String findPw(MemberVO mVO) {
		return sqlSession.selectOne("mSQL.findPw",mVO);
	}
	/*
	  //아이디 찾기 public int idChk(String user_email) { return
	  sqlSession.selectOne("mSQL.idChk",user_email); }
	 */
	//가입시 중복이면 깨지는것 방지
	/*
	  public int regChk(String email) { return
	  sqlSession.selectOne("mSQL.regChk",email); }
	 */
	public MemberVO selectInfoByEmail(String email) {
		return sqlSession.selectOne("mSQL.selectInfoByEmail", email);
	}
	public int selectLikeCntOfMember(int mno) {
		return sqlSession.selectOne("mSQL.selectLikeCntOfMember", mno);
	}
	
}


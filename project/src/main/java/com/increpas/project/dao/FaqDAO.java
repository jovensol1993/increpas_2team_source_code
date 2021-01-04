package com.increpas.project.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.increpas.project.vo.FaqVO;

@Repository
public class FaqDAO {
	@Autowired
	SqlSessionTemplate sqlSession;

	// 공지사항 목록 조회
	public List<Map<String, Object>> selectFaqList(FaqVO fVO) {
		return sqlSession.selectList("fSQL.selectFaqList", fVO);
	}
	
	// 공지사항 전체 건수
	public int selectFaqListCount(FaqVO fVO) {
		return sqlSession.selectOne("fSQL.selectFaqListCount", fVO);
	}

	// 공지사항 내용 조회
	public Map<String, Object> selectFaq(FaqVO fVO) {
		return sqlSession.selectOne("fSQL.selectFaq", fVO);
	}
	// 게시물 등록
	public int writeFaq(FaqVO fVO) {
		return sqlSession.insert("fSQL.writeFaq", fVO);
	}
	// 게시물 등록
	public int delFaq(FaqVO fVO) {
		return sqlSession.update("fSQL.delFaq", fVO);
	}
	
	/*
	 * // 조회수 업데이트 public int updateNoticeHits(FaqVO qVO) { return
	 * sqlSession.update("nSQL.updateNoticeHits", qVO); }
	 */
}

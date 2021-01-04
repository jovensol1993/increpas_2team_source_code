package com.increpas.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.increpas.project.util.PageUtil;
import com.increpas.project.vo.NoticeVO;

public class NoticeDAO {
	// 자동의존 주입  , bean처리가 되어있어야 가져올 수 있다.
	@Autowired
	SqlSessionTemplate sqlSession;
	
	// 게시물 총 갯수
	public int getListCount() {
		return sqlSession.selectOne("nSQL.getListCount");
	}
	
	// 게시물 가져오기 전담 처리함수
	public List<NoticeVO> getList(PageUtil page) {
		return sqlSession.selectList("nSQL.getList", page);
	}
	
	// 멤버 번호 가져오기 처리함수
	public NoticeVO getMno() {
		return sqlSession.selectOne("nSQL.getMno");
	}
	
	public int updateContents(NoticeVO nVO) {
		return sqlSession.update("nSQL.updateContents", nVO);
	}
	
	public NoticeVO getDetail(NoticeVO nVO) {
		return sqlSession.selectOne("nSQL.getDetail", nVO);
	}
	// edit view에 보여지는 함수
	public NoticeVO getEdit(NoticeVO nVO) {
		return sqlSession.selectOne("nSQL.getEdit", nVO);
	}
	
	// 공지사항 삭제 전담 처리 함수
	public int updateDel(NoticeVO nVO) {
		return sqlSession.update("nSQL.updateDel", nVO);
	}
	
	// 조회수 처리 함수
	public int updateHit(NoticeVO nVO) {
		return sqlSession.update("nSQL.updateHit", nVO);
	}
	
	// 글 생성 함수
	public int getNoticeWrite(NoticeVO nVO) {
		return sqlSession.insert("nSQL.insertNotice", nVO);
	}
	
}

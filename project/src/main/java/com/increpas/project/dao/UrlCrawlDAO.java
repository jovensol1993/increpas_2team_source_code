package com.increpas.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.increpas.project.vo.UrlCrawlVO;

public class UrlCrawlDAO {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	public List<UrlCrawlVO> selectAll() {
		return sqlSession.selectList("urlSQL.selectAll");
	}
	
	public int updateHashCode(UrlCrawlVO urlVO) {
		return sqlSession.update("urlSQL.updateHashCode", urlVO);
	}
}

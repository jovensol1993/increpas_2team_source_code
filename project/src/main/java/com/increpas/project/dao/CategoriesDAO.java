package com.increpas.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.increpas.project.vo.CategoriesVO;

public class CategoriesDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<CategoriesVO> selectTop5Categories() {
		return sqlSession.selectList("cSQL.selectTop5Categories");
	}
	
	public List<CategoriesVO> selectCategoryList() {
		return sqlSession.selectList("cSQL.selectCategoryList");
	}
}

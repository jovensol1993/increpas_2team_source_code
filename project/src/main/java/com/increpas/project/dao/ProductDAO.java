package com.increpas.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.increpas.project.vo.CategoriesVO;
import com.increpas.project.vo.MemberVO;
import com.increpas.project.vo.ProductVO;

public class ProductDAO {

	@Autowired
	SqlSessionTemplate sqlSession;

	public List<ProductVO> selectListedProducts(List<Integer> list) {
		return sqlSession.selectList("pSQL.selectListedProducts", list);
	}

	public List<ProductVO> selectProductsFromCnoList(List<Integer> list) {
		return sqlSession.selectList("pSQL.selectProductsFromCnoList", list);
	}

	public List<ProductVO> selectListByMaxLikeCnt(MemberVO mVO) {
		return sqlSession.selectList("pSQL.selectListByMaxLikeCnt", mVO);
	}
	
	public List<ProductVO> selectProductsFromListedCategories(List<CategoriesVO> list) {
		return sqlSession.selectList("pSQL.selectProductsFromListedCategories", list);
	}
}

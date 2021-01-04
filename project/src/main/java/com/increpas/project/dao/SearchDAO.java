package com.increpas.project.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.increpas.project.vo.SearchVO;

public class SearchDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
		
	//검색 첫화면 혹은 빈 검색어 입력시 
	//모든 상품 조회 전담 처리함수
	public List<SearchVO> getAll(){
		return sqlSession.selectList("sSQL.getAll");
	}
	
	//모든 상품 필터링 조회 전담 처리함수
	public List<SearchVO> getFilterAll(String filtername){
		return sqlSession.selectList("sSQL.getFilterAll", filtername);
	}
	
	//총 상품 갯수 전담 처리함수
	public int countAll() {
		return sqlSession.selectOne("sSQL.countAll");
	}
	
	//소셜커머스별 상품 갯수 목록
	public List<SearchVO> listCountSc(){
		return sqlSession.selectList("sSQL.listAndCountSc");
	}
	
	//품목별 상품 갯수
	public List<SearchVO> listCountCateg(){
		return sqlSession.selectList("sSQL.listAndCountCateg");
	}
//////////////////////////////////////////////////////////////////
	//searchResult
	
	//검색어 입력 검색 전담 처리함수
	public List<SearchVO> searchProduct(String searchword){
		return sqlSession.selectList("sSQL.searchProduct", searchword);
	}
	
	//검색어 입력 검색 결과수 전담 처리함수
	public int countSearch(String searchword) {
		return sqlSession.selectOne("sSQL.countSearch", searchword);
	}
	
	//검색어 입력 검색 결과수 사이드바 전담 처리함수
	//검색어 입력 검색 결과수 소셜커머스별 전담 처리함수
	public List<SearchVO> countSearchBySc(String searchword){
		return sqlSession.selectList("sSQL.searchAndCountSc", searchword);
	}
	
	//검색어 입력 검색 결과수 카테고리별 전담 처리함수
	public List<SearchVO> countSearchByCateg(String searchword){
		return sqlSession.selectList("sSQL.searchAndCountCateg", searchword);
	}
	
/////////////////////////////////////////////////////////////////////
	//searchResultFilter
	
	//좋아요, 가격순 등 필터링 전담 처리함수
	public List<SearchVO> filterProductList(HashMap<String, String> map){
		return sqlSession.selectList("sSQL.resultFilter", map);
	}
	
	//사이드바 필터 필터링 전담 처리함수
	public List<SearchVO> filterProductListUsingSideFilter(HashMap<String, String> map){
		return sqlSession.selectList("sSQL.resultSideFilter", map);
	}
	
	//검색결과 필터링+사이드바 필터링 전담 처리함수
	public List<SearchVO> filterProductListPlusSideFilter(HashMap<String, String> map){
		return sqlSession.selectList("sSQL.resultAndSideFilter", map);
	}
	
	
}

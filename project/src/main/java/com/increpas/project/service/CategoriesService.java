package com.increpas.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.increpas.project.dao.CategoriesDAO;
import com.increpas.project.vo.CategoriesVO;

public class CategoriesService {

	@Autowired
	private CategoriesDAO cDAO;
	
	public List<CategoriesVO> selectCategoryList() {
		return cDAO.selectCategoryList();
	}
	
}

package com.increpas.project.vo;

import java.io.Serializable;

public class CategoriesVO implements Serializable {

	private static final long serialVersionUID = -1787005034017927472L;

	private int cno, parentCno, likeCnt;
	private String name;

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getParentCno() {
		return parentCno;
	}

	public void setParentCno(int parentCno) {
		this.parentCno = parentCno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	@Override
	public String toString() {
		return "CategoriesVO [cno=" + cno + ", parentCno=" + parentCno + ", likeCnt=" + likeCnt + ", name=" + name
				+ "]";
	}

}

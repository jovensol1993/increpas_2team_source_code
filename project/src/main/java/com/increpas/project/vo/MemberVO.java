package com.increpas.project.vo;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MemberVO {

	private int mno, ageGroup, likeCnt;
	private String email, password, gender, birthday, tel, isshow;
	private Date birthDate;

	
	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public int getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(int ageGroup) {
		this.ageGroup = ageGroup;
	}

	public void setAgeGroup(Date birthDate) {
		Calendar cal = Calendar.getInstance();
		int yearToday = cal.get(Calendar.YEAR);
		cal.setTime(birthDate);
		int yearBirth = cal.get(Calendar.YEAR);
		this.ageGroup = (yearToday - yearBirth + 1) / 10 * 10;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getIsshow() {
		return isshow;
	}

	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
		setAgeGroup(birthDate);
		setBirthday(new SimpleDateFormat("yyyy-MM-dd").format(birthDate));
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	@Override
	public String toString() {
		return "MemberVO [mno=" + mno + ", ageGroup=" + ageGroup + ", email=" + email + ", password=" + password
				+ ", gender=" + gender + ", birthday=" + birthday + ", tel=" + tel + ", isshow=" + isshow
				+ ", birthDate=" + birthDate + "]";
	}


}

package com.increpas.project.vo;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

import com.increpas.project.util.PageUtil;

public class NoticeVO {
	private int nno, hits;
	private String title, contents, sdate, isshow;
	private Date ndate;
	private Time ntime;
	private PageUtil page;

	public PageUtil getPage() {
		return page;
	}

	public void setPage(PageUtil page) {
		this.page = page;
	}

	public String getIsshow() {
		return isshow;
	}

	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}

	public int getNno() {
		return nno;
	}

	public void setNno(int nno) {
		this.nno = nno;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getSdate() {
		return sdate;
	}

	public void setNdate(String sdate) {
		this.sdate = sdate;
	}

	// 입력받은 SQL쿼리 날짜 데이터로 변환시켜주기 위해 오버로딩
	public void setSdate() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm");
		sdate = form1.format(ndate) + " " + form2.format(ntime);
	}

	public Date getNdate() {
		return ndate;
	}

	public void setNdate(Date wdate) {
		this.ndate = wdate;
	}

	public Time getNtime() {
		return ntime;
	}

	public void setNtime(Time ntime) {
		this.ntime = ntime;
		// setwtime이 셋 될때 sdate가 셋팅되도록 해주기 위해
		setSdate();
	}
}

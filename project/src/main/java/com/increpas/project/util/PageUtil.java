package com.increpas.project.util;

public class PageUtil {
	private int nowPage;	// 현재 페이지
	private int totalCount;	// 총 게시물 수
	private int totalPage;	// 총 페이지 수
	
	private int pageRow;	// 한 페이지에 보여줄 게시물 수
	private int pageGroup;	// 한 페이지에서 이동 가능한 페이지수
	
	private int startPage;	// 해당 화면에서 보여질 이동 시작 페이지
	private int endPage;	// 해당 화면에서 보여질 이동 끝 페이지
	
	private int startCont;	// 현재 페이지에서 보여줄 시작 게시물 로우넘버
	private int endCont;	// 현재 페이지에서 보여룾 마지막 게시물 로우넘버
	
	public PageUtil() {
		nowPage = 1;
	}

	public void setPage() {
		setPage(nowPage, totalCount, 10, 10);
	}
	
	public void setPage(int totalCount) {
		setPage(nowPage, totalCount, 3, 3);
	}
	public void setPage(int totalCount, int pageRow, int pageGroup) {
		setPage(nowPage, totalCount, pageRow, pageGroup);
	}
	
	public void setPage(int nowPage, int totalCount) {
		setPage(nowPage, totalCount, 3, 3);
	}
	
	public void setPage(int nowPage, int totalCount, int pageRow, int pageGroup) {
		this.nowPage = nowPage;
		this.totalCount = totalCount;
		this.pageRow = pageRow;
		this.pageGroup = pageGroup;
		
		calcPage();
		calcStart();
		calcEnd();
		calcCont();
	}
	
	//총 페이지 수(totalPage) 계산하는 함수
	public void calcPage() {
		/*
			총 페이지 수는 총 게시물 수 (totalCount)를 
			한 화면에 표시할 게시물 갯수(pageRow)로 나누면 된다.
			단, 경우에 따라서는 한페이지가 증가 될 수 있다.
		 */
		totalPage = (totalCount % pageRow) == 0 ? 
				(totalCount != 0 ? totalCount / pageRow : 1) : (totalCount /pageRow + 1);
	// totalPage = 2 == 0? 42/5 -> 9
	// 			 = 40 = 0? 40/5 -> 8 not 1
	// totalPage(전체페이지 수)
	}
	
	// 시작 페이지 계산 함수
	public void calcStart() {
		// 현재 보고있는 페이지 그룹을 계산한다
		int tmpGroup = (nowPage - 1) / pageGroup;
						// 1 - 1 / 3 = 0
						// 2 - 1 / 3 = 0.33
						// 3 - 1 / 3 = 0.66
						// 4 - 1 / 3 = 1
		// 현재 보는 페이지 그룹의 시작 페이지 번호를 계산
		startPage = tmpGroup * pageGroup + 1;
		//startPage = 1
		// 1
		// 1
		
	}
	
	// 마지막 페이지 계산 함수
	public void calcEnd() {
		// 현재 보는 페이지 그룹을 계산한다.
		int tmpGroup = (nowPage - 1) / pageGroup;
						// 0
						//5 / 5 = 1 
		// 현재 보는 페이지 그룹의 시작 페이지 번호를 계산
		endPage = (tmpGroup + 1) * pageGroup;
		// 5
		// 2 * 5 = 10
		// 종료페이지가 총 페이지수 보다 큰경우 처리
		if(endPage > totalPage) {
			// 10 > 9
			// 10 > 9
			endPage = totalPage;
			//endpage = 9
		}
	}
	
	// 시작과 종료 게시물 번호를 계산해주는 함수
	public void calcCont() {
		startCont = (nowPage -1) * pageRow + 1;
		// 1 6 11 16...
		endCont = (nowPage * pageRow > totalCount) ? totalCount : (nowPage * pageRow) ;
		// 5 10 15 20...
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageRow() {
		return pageRow;
	}

	public void setPageRow(int pageRow) {
		this.pageRow = pageRow;
	}

	public int getPageGroup() {
		return pageGroup;
	}

	public void setPageGroup(int pageGroup) {
		this.pageGroup = pageGroup;
	}

	public int getStartPage() {
		return startPage;
	}
	
	void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartCont() {
		return startCont;
	}

	public void setStartCont(int startCont) {
		this.startCont = startCont;
	}

	public int getEndCont() {
		return endCont;
	}

	public void setEndCont(int endCont) {
		this.endCont = endCont;
	}

	@Override
	public String toString() {
		return "PageUtil [nowPage=" + nowPage + ", totalCount=" + totalCount + ", totalPage=" + totalPage + ", pageRow="
				+ pageRow + ", pageGroup=" + pageGroup + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", startCont=" + startCont + ", endCont=" + endCont + "]";
	}
	
}


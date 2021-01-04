package com.increpas.project.util;

public class PageUtil {
	private int nowPage;	// ���� ������
	private int totalCount;	// �� �Խù� ��
	private int totalPage;	// �� ������ ��
	
	private int pageRow;	// �� �������� ������ �Խù� ��
	private int pageGroup;	// �� ���������� �̵� ������ ��������
	
	private int startPage;	// �ش� ȭ�鿡�� ������ �̵� ���� ������
	private int endPage;	// �ش� ȭ�鿡�� ������ �̵� �� ������
	
	private int startCont;	// ���� ���������� ������ ���� �Խù� �ο�ѹ�
	private int endCont;	// ���� ���������� ������ ������ �Խù� �ο�ѹ�
	
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
	
	//�� ������ ��(totalPage) ����ϴ� �Լ�
	public void calcPage() {
		/*
			�� ������ ���� �� �Խù� �� (totalCount)�� 
			�� ȭ�鿡 ǥ���� �Խù� ����(pageRow)�� ������ �ȴ�.
			��, ��쿡 ���󼭴� ���������� ���� �� �� �ִ�.
		 */
		totalPage = (totalCount % pageRow) == 0 ? 
				(totalCount != 0 ? totalCount / pageRow : 1) : (totalCount /pageRow + 1);
	// totalPage = 2 == 0? 42/5 -> 9
	// 			 = 40 = 0? 40/5 -> 8 not 1
	// totalPage(��ü������ ��)
	}
	
	// ���� ������ ��� �Լ�
	public void calcStart() {
		// ���� �����ִ� ������ �׷��� ����Ѵ�
		int tmpGroup = (nowPage - 1) / pageGroup;
						// 1 - 1 / 3 = 0
						// 2 - 1 / 3 = 0.33
						// 3 - 1 / 3 = 0.66
						// 4 - 1 / 3 = 1
		// ���� ���� ������ �׷��� ���� ������ ��ȣ�� ���
		startPage = tmpGroup * pageGroup + 1;
		//startPage = 1
		// 1
		// 1
		
	}
	
	// ������ ������ ��� �Լ�
	public void calcEnd() {
		// ���� ���� ������ �׷��� ����Ѵ�.
		int tmpGroup = (nowPage - 1) / pageGroup;
						// 0
						//5 / 5 = 1 
		// ���� ���� ������ �׷��� ���� ������ ��ȣ�� ���
		endPage = (tmpGroup + 1) * pageGroup;
		// 5
		// 2 * 5 = 10
		// ������������ �� �������� ���� ū��� ó��
		if(endPage > totalPage) {
			// 10 > 9
			// 10 > 9
			endPage = totalPage;
			//endpage = 9
		}
	}
	
	// ���۰� ���� �Խù� ��ȣ�� ������ִ� �Լ�
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


package com.increpas.project.vo;

public class UrlCrawlVO implements Comparable<UrlCrawlVO> {

	private int cuno, scno, hashCode;
	private String scName, description, urlCrawl;

	public int getHashCode() {
		return hashCode;
	}

	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}

	public int getCuno() {
		return cuno;
	}

	public void setCuno(int cuno) {
		this.cuno = cuno;
	}

	public int getScno() {
		return scno;
	}

	public void setScno(int scno) {
		this.scno = scno;
	}

	public String getScName() {
		return scName;
	}

	public void setScName(String scName) {
		this.scName = scName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrlCrawl() {
		return urlCrawl;
	}

	public void setUrlCrawl(String urlCrawl) {
		this.urlCrawl = urlCrawl;
	}

	@Override
	public int compareTo(UrlCrawlVO vo) {
		return this.scno - vo.getScno();
	}

	@Override
	public String toString() {
		return "UrlCrawlVO [cuno=" + cuno + ", scno=" + scno + ", scName=" + scName + ", description=" + description
				+ ", urlCrawl=" + urlCrawl + ", hashCode=" + hashCode + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UrlCrawlVO other = (UrlCrawlVO) obj;
		if (cuno != other.cuno)
			return false;
		if (hashCode != other.hashCode)
			return false;
		return true;
	}


}

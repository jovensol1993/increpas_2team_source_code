package com.increpas.project.vo;

public class SearchVO {
	private int ppno, pscno, pcno, pino, oprice, pprice, dcrate, pcuno, likes, cnt, parentCno;
	private String pname, purl, ilink, ipath, ifname, scname, searchword, categname, name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParentCno() {
		return parentCno;
	}

	public void setParentCno(int parentCno) {
		this.parentCno = parentCno;
	}

	public int getPpno() {
		return ppno;
	}

	public void setPpno(int ppno) {
		this.ppno = ppno;
	}

	public int getPscno() {
		return pscno;
	}

	public void setPscno(int pscno) {
		this.pscno = pscno;
	}

	public int getPcno() {
		return pcno;
	}

	public void setPcno(int pcno) {
		this.pcno = pcno;
	}

	public int getPino() {
		return pino;
	}

	public void setPino(int pino) {
		this.pino = pino;
	}

	public int getOprice() {
		return oprice;
	}

	public void setOprice(int oprice) {
		this.oprice = oprice;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public int getDcrate() {
		return dcrate;
	}

	public void setDcrate(int dcrate) {
		this.dcrate = dcrate;
	}

	public int getPcuno() {
		return pcuno;
	}

	public void setPcuno(int pcuno) {
		this.pcuno = pcuno;
	}

	public String getPname() {
		return pname.replace("\r\n", "<br>");
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPurl() {
		return purl;
	}

	public void setPurl(String purl) {
		this.purl = purl;
	}

	public String getIlink() {
		return ilink;
	}

	public void setIlink(String ilink) {
		this.ilink = ilink;
	}

	public String getIpath() {
		return ipath;
	}

	public void setIpath(String ipath) {
		this.ipath = ipath;
	}

	public String getIfname() {
		return ifname;
	}

	public void setIfname(String ifname) {
		this.ifname = ifname;
	}

	public String getScname() {
		return scname;
	}

	public void setScname(String scname) {
		this.scname = scname;
	}

	public String getSearchword() {
		return searchword;
	}

	public void setSearchword(String searchword) {
		this.searchword = searchword;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getCategname() {
		return categname;
	}

	public void setCategname(String categname) {
		this.categname = categname;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "SearchVO [ppno=" + ppno + ", pscno=" + pscno + ", pcno=" + pcno + ", pino=" + pino + ", oprice="
				+ oprice + ", pprice=" + pprice + ", dcrate=" + dcrate + ", pcuno=" + pcuno + ", likes=" + likes
				+ ", cnt=" + cnt + ", pname=" + pname + ", purl=" + purl + ", ilink=" + ilink + ", ipath=" + ipath
				+ ", ifname=" + ifname + ", scname=" + scname + ", searchword=" + searchword + ", categname="
				+ categname + "]";
	}

}

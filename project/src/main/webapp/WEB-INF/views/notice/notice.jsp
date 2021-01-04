<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/project/css/w3.css">
<link rel="stylesheet" type="text/css" href="/project/css/cls.css">
<script type="text/javascript" src="/project/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="/project/js/notice.js"></script>
<style>
body{
         background-image: url("https://www.analogouscolors.com/image/2560x1440/f0f8ff.jpg");
       
        /* background-color: white; */
        background-repeat: repeat;
       
        }
</style>
<title>공지사항</title>
</head>

<body>
	<form method="POST" id="frm" name="frm">
		<input type="hidden" name="nno" id="nno"> 
		<input type="hidden" name="contents" id="contents">
	</form>
<div class="w3-content mw1000">  
	<!-- 헤더2 -->
	<div class="w3-col header">
		<jsp:include page="/WEB-INF/views/header2.jsp" flush="false"></jsp:include>
	</div>
	<!-- 사이드바 -->
	<div class="w3-col s12 m2 l2 header" style="margin-top : 100px;"	>
		<jsp:include page="/WEB-INF/views/sidebar.jsp" flush="false"></jsp:include>
	</div>
	<!-- 게시글 리스트 -->
<c:if test='${sessionScope.SID eq "user1@increpas.com"}'>
	<div class="w3-col s12 m10 l10 w3-margin-top">
		<div class="mw800 " style="margin-top : 50px;">
			<div class="w3-col m2 txt16 fontweight12 w3-left clsbold" style="">공지사항</div>
			<div class="w3-col  ">
				<div class="w3-col w3-border w3-margin-top w3-center">
					<div class="w3-col m1 w3-light-grey w3-border-right">번호</div>
					<div class="w3-col m7 w3-light-grey w3-border-right">제목</div>
					<div class="w3-col m1 w3-light-grey w3-border-right">작성일</div>
					<div class="w3-col m1 w3-light-grey w3-border-right">조회수</div>
					<div class="w3-col m2 w3-light-grey w3-border-right">기능</div>
				</div>
				<div class="w3-col w3-border-left w3-border-right w3-margin-bottom">
					<c:forEach var="data" items="${NLIST}">
						<div class="w3-col w3-center w3-border-bottom w3-centered">
							<div class="w3-col m1 w3-border-right w3-margin-top"
								id="${data.nno}">${data.nno}</div>
							<div class="w3-col m7  btn w3-margin-top w3-border-right"
								id="${data.nno}">
								<span class="title w3-button w3-left w3-hover-none w3-hover-text-grey" id="t${data.nno}">${data.title}</span>
								<div class="w3-col m2  w3-margin-top w3-hide">
									${data.contents}</div>
							</div>
							<div class="w3-col m1 w3-border-right w3-margin-top"
								style="font-size: 5pt">${data.ndate}</div>
							<div class="w3-col m1 w3-border-right w3-margin-top">${data.hits}</div>
								<div class="w3-btn w3-col m1 w3-border-right delbtn w3-hover-none w3-hover-text-grey"
									id="d${data.nno}">삭제</div>
								<div class="w3-btn w3-col m1 w3-border-right editbtn w3-hover-none w3-hover-text-grey"
									id="e${data.nno}">편집</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	
	
</c:if>	

<c:if test='${sessionScope.SID ne "user1@increpas.com"}'>
	<div class="w3-col s12 m10 l10 w3-margin-top">
		<div class="mw800 " style="margin-top : 50px;">
			<div class="w3-col m2 txt16 fontweight12 w3-left clsbold" style="">공지사항</div>
			<div class="w3-col  ">
				<div class="w3-col w3-border w3-margin-top w3-center">
					<div class="w3-col m1 w3-light-grey w3-border-right">번호</div>
					<div class="w3-col m9 w3-light-grey w3-border-right">제목</div>
					<div class="w3-col m1 w3-light-grey w3-border-right">작성일</div>
					<div class="w3-col m1 w3-light-grey ">조회수</div>
				</div>
				<div class="w3-col w3-border-left w3-border-right w3-margin-bottom">
					<c:forEach var="data" items="${NLIST}">
						<div class="w3-col w3-center w3-border-bottom w3-centered">
							<div class="w3-col m1 w3-border-right w3-margin-top"
								id="${data.nno}">${data.nno}</div>
							<div class="w3-col m9  btn w3-margin-top w3-border-right"
								id="${data.nno}">
								<span class="title w3-button w3-left w3-hover-none w3-hover-text-grey" id="t${data.nno}">${data.title}</span>
								<div class="w3-col m2  w3-margin-top w3-hide">
									${data.contents}</div>
							</div>
							<div class="w3-col m1 w3-border-right w3-margin-top"
								style="font-size: 5pt">${data.ndate}</div>
							<div class="w3-col m1  w3-margin-top">${data.hits}</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</c:if>
<div class=" w3-col m1 w3-button writebtn w3-border w3-hover-none w3-hover-text-none" style="margin-left: 160px; width">글쓰기</div>
<!-- 페이징 버튼 -->
<div class="w3-col w3-margin-top w3-center">
	<form method="POST" action="/project/notice/notice.project" name="pfrm" id="pfrm" class="w3-bar w3-border w3-round">
		<input type="hidden" id="nowPage" name="nowPage" value="">
		<!-- 이전 버튼 처리 -->
	  	<c:if test="${PAGE.startPage != 1}">
	  		<span class="w3-bar-item w3-button w3-hover-lime pagebtn" id="${PAGE.startPage - 1}">&laquo;</span>
	  	</c:if>
	  
	  	<c:forEach var="page" begin="${PAGE.startPage}" end="${PAGE.endPage}">
	  		<span class="w3-bar-item w3-button w3-hover-lime pagebtn" id="${page}">${page}</span>
	  	</c:forEach>
	  
		<!-- 다음 버튼 처리 -->
	  	<c:if test="${PAGE.endPage != PAGE.totalPage}">
	  		<span class="w3-bar-item w3-button w3-hover-lime pagebtn" id="${PAGE.endPage + 1}">&raquo;</span>
	  	</c:if>
	  </form>	
</div>
</div>
</body>
</html>
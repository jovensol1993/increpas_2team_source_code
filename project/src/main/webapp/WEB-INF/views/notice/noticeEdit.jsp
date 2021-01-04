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
	<div class="w3-content mw1000">
		<div class="w3-col header">
			<jsp:include page="/WEB-INF/views/header2.jsp" flush="false"></jsp:include>
		</div>
		<!-- 사이드바 -->
		<div class="w3-col s12 m2 l2 header">
			<jsp:include page="/WEB-INF/views/sidebar.jsp" flush="false"></jsp:include>
		</div>
		<!-- top -->
		<div class="w3-col m10" style="margin-top: 50px;"></div>
		<div class="w3-col m10 w3-margin-top">
			<form method="POST" id="frm">
				<input type="hidden" name="nno" value="${nVO.nno}">
				<div class="w3-col w3-border w3-margin-top w3-center">
					<div class="w3-col m1 w3-light-grey w3-border-right">번호</div>
					<div class="w3-col m11 w3-light-grey w3-border-right">내용</div>
				</div>

				<div class="w3-col w3-border-left w3-border-right w3-margin-bottom " >
					<div class="w3-col w3-center w3-border-bottom" >
						<div class="w3-col m1  w3-margin-top">${nVO.nno}</div>
						<div class="w3-col w3-border-left m11 w3-margin-top">
								<textarea class="w3-col w3-margin-top w3-border w3-margin " style="width: 600px; height: 50px;" id="title" name="title" value="${nVO.title}">${nVO.title}</textarea>
								<textarea class="w3-col w3-margin-top w3-border w3-padding " style="width: 600px; height: 300px;" id="contents" name="contents" value="${nVO.contents}">${nVO.contents}</textarea>
						</div>
					</div>
				</div>
			</form>
			<div class="w3-left m2 w3-btn w3-border" id="editCancleBtn">취소</div>
			<div class="w3-right m2 w3-btn w3-border" id="editBtn">수정완료</div>
		</div>
	</div>
</body>
</html>
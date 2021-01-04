<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/project/css/w3.css">
<link rel="stylesheet" type="text/css" href="/project/css/cls.css">
<script>

$(".boardbtn").click(function(){
	location.href = "/project/notice/notice.project";
});
$(".faqbtn").click(function(){
	location.href = "/project/faqBoard.project";
});

</script>

</head>
<body>
	<!-- 	 사이드바  -->
	<div class="w3-content mw100 sidebar-postion w3-text-grey">
		<div class=" w3-margin-bottom link boardbtn w3-button w3-hover-none w3-left w3-hover-text-grey">⊙  공지사항</div>
		<div class=" link faqbtn w3-button w3-hover-none w3-left w3-hover-text-grey">⊙ FAQ</div>
	</div>
</body>
</html>
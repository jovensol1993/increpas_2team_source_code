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
function myFunction() {
	  var x = document.getElementById("modalBoard");
	  if (x.style.display === "none") {
	    x.style.display = "block";
	  } else {
	    x.style.display = "none";
	  }
	}
	
function enterkey() {
    if (window.event.keyCode == 13) {
         // 엔터키가 눌렸을 때 실행할 내용
         searchForm.submit();
    }
}

$(document).ready(function(){
    
    $(".loginbtn").click(function(){
    	location.replace("/project/login/login.project");
    });
    
    $(".logoutbtn").click(function(){
    	sessionStorage.clear();
    	location.replace("/project/main.project");
    });
    
    $(".boardbtn").click(function(){
    	location.replace("/project/notice/notice.project");
    });
    
    $(".questionbtn").click(function(){
    	location.replace("/project/question/question.project");
    });
});
</script>
</head>
<body>
		<!-- 헤더 --> 
<div class="w3-light-blue" style="width: 100vw; position: absolute;">
	<div class="w3-margin-bottom  header w3-center"	 style="width: 100%; height: 380px;">
		<div class=" w3-padding">
		<div  style="font-size: 24px;" class="w3-col w3-margin-top">	
			<span class=" w3-text-white w3-button w3-margin-right w3-circle">☰</span>
			<span><a class="txt16 logo w3-text-white w3-margin-right w3-text-purple textdecoNone" href="/project/main.project" style="padding-top: 2px;">Increpas</a></span>
			<span>&nbsp;</span>
			<span>&nbsp;</span>
			<span>&nbsp;</span>
			<span class=" search-input w3-content ">
<!-- 			<form method="GET" action="/project/search/seachDetailList.project" id="search" name="search"> -->
			<input style="visibility: hidden;"class="w550 w3-light-grey w3-border-gray w3-padding	" placeholder="상품을 검색하세요" >
<!-- 			</form> -->
			</span>
			<span class="w200">&nbsp;</span>
			<c:if test="${admin != 9999}"> 
				<span class=" w3-text-white w3-margin-right w3-button w3-circle  loginbtn" style="font-size: 20px;">로그인</span>
			</c:if>	
			<c:if test="${admin == 9999}">
				<span class=" w3-text-white w3-margin-right w3-button w3-circle  logoutbtn" style="font-size: 20px;" >로그아웃</span>
			</c:if>
			<div class="showBoard w3-text-white w3-margin-right w3-button w3-circle" style="width: 77px;" onclick="myFunction()"><span>⋯</span>
		</div>	
				<div class="w3-col w3-right " style="width: 150px; ">
					<div id="modalBoard" style="width: 150px; height: 100px; display: none ">
						<div style="padding: 14px 0px 16px">
							<div class="clsbold" style="padding: 0px 32px 8px; ">고객센터</div>
							<div class="w3-button w3-col boardbtn" style="padding: 4px 32px; font-size: 12px;">공지사항</div>
							<div class="w3-button w3-col questionbtn" style="padding: 4px 32px; font-size: 12px;">1:1 문의</div>
						</div>	
					</div>
				</div>
			</div>
			<br><br><br><br><br>
			<div class="w3-col w3-margin-top">
				<div class="w3-padding w3-col w3-center" style="font-size: 40px;"><a href="" class="w3-padding w3-left textdecoNone w3-text-white clsbold">지금까지 이런 인크레파스 팀은 없었다.</a></div>
				<div class=" search-input w3-content w3-col w3-padding">
		<!-- 			<form method="GET" action="/project/search/seachDetailList.project" id="search" name="search"> -->
					<input onkeyup="enterkey();" name="search" id="search" class="w550 w3-light-grey w3-border-gray w3-padding w3-left" placeholder="상품을 검색하세요">
		<!-- 			</form> -->
				</div>
			</div>
		</div>	
	</div>
</div>
</body>
</html>
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
<script type="text/javascript" src="/project/js/main.js"></script>
<script>
</script>
</head>
<body>
<!-- 카테고리 목록창에서 선택 시 이동하는 폼 태그 -->
<form method="GET" action="/project/search/searchResult.project" id="CategSearchForm" name="CategSearchForm">
	<input type="hidden" id="InputCateg" name="searchword" value="">
</form>

<!-- 카테고리 하나씩 넣어주는 태그 그룹 -->
<c:forEach var="data" items="${LIST}" varStatus="status">
		<!-- 카테고리 창 -->
	<c:if test="${data.parentCno == 0 && status.index == 0}">	
	<div id=categoryBoard class="w3-col w3-light-blue w3-padding w3-margin" style="height: 850px; display: none; overflow:auto; position: absolute; left: 0px; z-index: 5;">
		<div class="xbar w3-col w3-padding clsbold " style="height: 40px;">&nbsp;&nbsp;&nbsp;&nbsp;<span class=" w3-button" onclick="document.getElementById('categoryBoard').style.display='none'">&times;</span></div>
		<div class="categoryframe w3-col w3-padding w3-center" style="height: 800px;">
			<div class="w3-col m2 w3-border w3-white"  style="height: 790px; width: 180px; margin-left: 60px;">
				<div class="w3-col w3-margin-bottm  clsbold w3-button category" style="height: 30px; margin-bottom: 5px;" id="${data.name}">${data.name}</div>
				<div>
	</c:if>	
	<c:if test="${data.parentCno == 0 && status.index != 0}">
				</div>
			</div>	
			<div class="w3-col m2 w3-border w3-white"  style="height: 790px;  width: 180px;">
				<div class="w3-col w3-margin-bottm  clsbold w3-button category" style="height: 30px; margin-bottom: 5px;" id="${data.name}">${data.name}</div>
				<div>
	</c:if>	
	<c:if test="${data.parentCno != 0}">			
				<div class="w3-col w3-button category" style="padding: 0px;" id="${data.name}">${data.name}</div>
	</c:if>			
	<c:if test="${data.parentCno != 0 && status.index == 205}">			
				</div>
			</div>
		</div>	
	</div>
	</c:if>			
</c:forEach>

	
		<!-- 헤더 -->
	<div class="w3-content header w3-margin-bottom header" style="width: 100%; margin-top: 60px;">
		<div class="w3-col m1 w3-text-grey w3-button categorybtn w3-hover-none w3-hover-text-grey" onclick="categoryBoard()">☰</div>
		<div><a class="w3-col m2 txt16 logo w3-text-grey textdecoNone" href="/project/main.project" style="text-decoration: none;">Increpas</a></div>
		<div class="w3-col m6 search-input ">
			<form class="w3-col" method="GET" action="/project/search/searchResult.project" id="searchForm" name="searchForm">
				<input style="width: 490px; border-radius: 8px;" onkeypress="enterkey();"name="searchkeyword" id="searchkeyword" class="search w3col w3-light-white w3-border-gray w3-padding" placeholder="상품을 검색하세요" value="">
				<input type="hidden" name="searchword" id="searchword" value="">
			</form> 
		</div>
		<c:if test="${empty SID}"> 
			<div class="w3-col m2 w3-text-grey w3-button loginbtn w3-hover-none w3-hover-text-grey">로그인</div>
		</c:if>	
		<c:if test="${not empty SID}">
			<div class="w3-col m2 w3-text-grey w3-button logoutbtn w3-hover-none w3-hover-text-grey">로그아웃</div>
		</c:if>
		<div class="w3-col m1 showBoard w3-text-grey  w3-button   w3-hover-none w3-hover-text-grey" onclick="modalBoard()"><span>⋯</span>
			<div class="w3-col w3-right w3-border-grey" style="width: 100px; position: absolute; cursor: default;">
				<div id="modalBoard" style="width: 150px; height: 130px; display: none ">
					<div style="padding: 14px 0px 16px">
						<div class="clsbold " style="padding: 0px 32px 8px; ">고객센터</div>
						<div class="w3-button w3-col boardbtn w3-hover-none w3-hover-text-grey" style="padding: 4px 32px; font-size: 12px;">공지사항</div>
						<div class="w3-button w3-col faqbtn w3-hover-none w3-hover-text-grey" style="padding: 4px 32px; font-size: 12px;">FAQ</div>
					</div>	
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--금액에 쉼표 찍기 위한 taglib  -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${SWORD} 검색결과 </title>
<link rel="stylesheet" type="text/css" href="/project/css/w3.css">
<link rel="stylesheet" type="text/css" href="/project/css/cls.css">
<link rel="stylesheet" type="text/css" href="/project/css/tp.css">
<link rel="stylesheet" type="text/css" href="/project/css/search.css">
<script type="text/javascript" src="/project/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="/project/js/search/searchResult.js"></script>

<style>
</style>

<script type="text/javascript">
</script>
</head>
<body>

	<form class="w3-container w3-center w3-border w3-light-blue mlrauto" style="height:100px; width: 100%;" 
			method="POST" action="/project/search/searchResultFilter.project" id="frm" name="frm">
		<input type="button" id="goSearch" value="Search">
		<input type="text" class="search" name="searchkeyword" id="searchkeyword" 
		placeholder="제품을 검색하세요" onkeypress="enterkey()" style="width: 600px;">
		<input type="hidden" name="searchword" id="searchword" value="${SWORD}">
		<input type="hidden" name="scode" id="scode" value="">
		<input type="hidden" name="filterbutton" id="filterbutton" value="">
	</form>	
	
		<div class="w3-container w3-margin w3-white" style="padding-left:250px;">
		<!-- 필터 사이드바 -->
		<div class="sidenav w3-border" style="width:250px;">
			<div class="sidetitle w3-border-bottom">
				<c1>필터</c1>
			</div>
			<div class="sidefilter w3-left w3-margin-bottom">
				<c3>쇼핑몰</c3>
<c:forEach var="list" items="${LIST2}">
				<c4 class="w3-button filterbtn" style="text-align:left;"  id="${list.scname}" >${list.scname} <span>(${list.cnt})</span></c4>
</c:forEach>
				<c3>카테고리</c3>
<c:forEach var="categlist" items="${LIST3}">
				<c4 class="w3-button categbtn" style="text-align:left;" id="${categlist.categname}">${categlist.categname}<span>(${categlist.cnt})</span></c4>
</c:forEach>
			</div>
		</div>
		<!--필터 사이드바  -->
		
		<div class="w3-container w3-center w3-white mlrauto" style="width:900px; margin-left: 250px;">
			
			<div class="w3-col w3-left m4 w3-grey w3-margin w3-padding">검색결과 : <span>${CNT}</span>개 상품</div>
			<input type="hidden" name="result" id=result>
			
			<div class="w3-col w3-border-top w3-border-bottom">
				<div class="w3-col w3-button w3-border-right searchBtn" id="plike"  style="width: 90px;">좋아요순</div>
				<div class="w3-col w3-button w3-border-right searchBtn" id="pricedesc"  style="width: 90px;">높은가격순</div>
				<div class="w3-col w3-button w3-border-right searchBtn" id="priceasc"  style="width: 90px;">낮은가격순</div>
				<div class="w3-col w3-button w3-border-right searchBtn" id="dcratedesc"  style="width: 120px;">할인율 높은순</div>
				<div class="w3-col w3-button w3-border-right searchBtn" id="dcrateasc"  style="width: 120px;">할인율 낮은순</div>
			</div>
			
			<!-- forEach로 데이터 채울 구간 -->
			<!-- 위에서 버튼을 누를때마다 다른 목록을 뽑아오게 하는 식으로 처리? -->



<c:forEach var="data" items="${LIST}">
			<div class="w3-col w3-margin-top product">
				<div class="w3-border portrait pimage">
					<img src="${data.ilink}" class="imagebox" id="pimage">
				</div>

				<div class="pinfo w3-border" style="text-align:left;">
					<h2 class="productname" id="productname"><a href="${data.purl}">${data.pname}</a></h2>
					<h2 id="originalprice" style="margin-top:5px;">기존가: <span><fmt:formatNumber value="${data.oprice}" pattern="#,###" />원</span></h2>
					<h2 id="productprice">할인가: <span><fmt:formatNumber value="${data.pprice}" pattern="#,###" />원</span></h2>
					<h2 id="discountrate">할인율: <span>${data.dcrate}%</span></h2>
				</div>
			
				<div class="pprice w3-border" style="text-align:left; width:100%;">
					<h2 class="w3-padding-top productsc" id="productsc">${data.scname}</h2>
					<h2 class="w3-padding-top" id="likecount">좋아요: <span>${data.likes}</span></h2>
				</div>
			</div>
</c:forEach>
			
		</div>
	</div>
	
<!-- FOOTER 부분  -->
<footer style="height: 400px;">
	<div class="footer">
		<div class="inner w3-border-bottom">
			<ul class="area-link w3-border-top">
				<li><a class="app-download">앱 다운로드</a></li>
				<li><a class="app-download">고객센터</a></li>
				<li><a class="app-download">서비스 이용약관</a></li>
				<li><a class="app-download">위치정보 이용약관</a></li>
				<li><a class="app-download">개인정보처리방침</a></li>
				<li><a class="app-download">마케팅 센터</a></li>
				<li><a class="app-download">입점 및 광고 안내</a></li>
			</ul>
			<div class="area-text">
				<p>
				2조는 상품에 직접 관여하지 않으며 상품 주문, 배송 및 환불의
				의무와 책임은 각 판매업체에 있습니다.
				</p>
			</div>
			<div class="area-bottom">
				<div class="info">
					<span>(주)인크레파스</span>
					<span>대표 김의산</span>
					<span>사업자 등록번호 19-97-1229</span>
				</div>
				<div class="address w3-margin-top">
					<span>서울특별시 구로구 석천빌딩 7층</span>
					<span>고객센터<a>support@increpas.com</a></span>
					<span>입점/광고<a>inquiry@increpas.com</a></span>
				</div>
				<div class="copyright w3-margin-top">
					<p>
					ⓒ2020. SerchFy Inc. All Rights Reserved.
					</p>
				</div>
			</div>
		</div>
	</div>
</footer>
	
	
</body>
</html>
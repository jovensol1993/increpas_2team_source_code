<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/project/css/w3.css">
<link rel="stylesheet" type="text/css" href="/project/css/cls.css">
<script type="text/javascript" src="/project/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="/project/js/main.js"></script>
</head>
<script type="text/javascript">

</script>
<body>
<!-- 카테고리 목록창에서 선택 시 이동하는 폼 태그 -->
<form method="GET" action="/project/search/searchResult.project" id="CategSearchForm" name="CategSearchForm">
	<input type="hidden" id="InputCateg" name="searchword" value="">
</form>	
	<div class="colorBox w3-light-blue" style="width: 100%; height: 400px;" >
	
	
	<!-- 카테고리 창 -->
	<div id=categoryBoard class="w3-col w3-light-blue w3-padding " style="height: 850px; display: none; overflow:auto; position: absolute; z-index: 5;">
		<div class="xbar w3-col w3-padding clsbold " style="height: 40px;">&nbsp;&nbsp;&nbsp;&nbsp;<span class=" w3-button w3-hover-none"  onclick="document.getElementById('categoryBoard').style.display='none'">&times;</span></div>
		<div class="categoryframe w3-col w3-padding w3-center" style="height: 800px;">

<!-- 카테고리 하나씩 넣어주는 태그 그룹 -->
<c:forEach var="data" items="${LIST}" varStatus="status">
	<c:if test="${data.parentCno == 0 && status.index == 0}">	
			<div class="w3-col m2 w3-border w3-white"  style="height: 790px; width: 180px; margin-left: 60px;">
				<div class="w3-col w3-margin-bottm w3-padding clsbold w3-button category" style="height: 30px; margin-bottom: 5px;" id="${data.name}">${data.name}</div>
				<div>
	</c:if>	
	<c:if test="${data.parentCno == 0 && status.index != 0}">
				</div>
			</div>	
			<div class="w3-col m2 w3-border w3-white"  style="height: 790px;  width: 180px;">
				<div class="w3-col w3-margin-bottm w3-padding clsbold w3-button category" style="height: 30px; margin-bottom: 5px;" id="${data.name}">${data.name}</div>
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
	
<!-- 카테고리 하나씩 넣어주는 태그 그룹	 -->
	<div class="wrapper w3-content w3-center mw1080">
		<!-- HEADER 김영선 -->
		<div class="w3-col mainHeader">
			<div class="w3-col w3-margin-bottom">
				<div class="w3-col w3-padding-top w3-padding-bottom">
					<div class="w3-col w3-margin-top" style="font-size: 24px;">	
						<div class="w3-col m1  w3-text-white w3-button  w3-hover-none categorybtn w3-hover-text-light-grey" onclick="categoryBoard();">☰</div>
						<div class="w3-col m2 w3-circle">
							<a class="w3-col txt16 w3-text-white textdecoNone w3-hover-none" href="/project/main.project" style="margin-top: 10px;">Increpas</a>
						</div>
						<div class="w3-col m6 w3-hover-none">&nbsp;</div>
			<c:if test="${empty SID}">  
						<div class="w3-col m2  w3-text-white w3-button  w3-hover-none loginbtn w3-hover-text-light-grey" style="font-size: 20px; margin-top: 5px;">로그인</div>
			</c:if>	
			<c:if test="${not empty SID}">
						<div class="w3-col m2  w3-text-white w3-button  w3-hover-none logoutbtn w3-hover-text-light-grey" style="font-size: 20px; margin-top: 5px;" >로그아웃</div>
			</c:if>
						<div class="w3-col m1  w3-text-white   " style="width: 77px;" onclick="modalBoard()">
							<span class="w3-button w3-hover-none w3-hover-text-light-grey onclick="modalBoard();">⋯</span>
						<div class="w3-col w3-right w3-white" style="width: 150px; position: absolute;  border-radius: 5px;">
							<div id="modalBoard" style="width: 150px; height: 130px; display: none ">
								<div style="padding: 14px 0px 16px">
									<div class="clsbold" style="padding: 0px 32px 8px; font-size: 18px;">고객센터</div>
									<div class="w3-button w3-col boardbtn w3-hover-none" style="padding: 4px 32px; font-size: 12px;">공지사항</div>
									<div class="w3-button w3-col w3-hover-none faqbtn" style="padding: 4px 32px; font-size: 12px;">FAQ</div>
								</div>	
							</div>
						</div>
						</div>	
													
						<div class="w3-col" style="margin-top: 80px;"></div>
						<div class="w3-col w3-rest w3-padding  w3-text-white clsbold w3-left w3-margin-left" style="font-size: 35px; width: 800px; text-align: left;" >
							<div class="w3-button w3-hover-none textdecoNone w3-hover-text-light-grey" style="font-size: 30px;">지금까지 이런 치킨은 없었다 치킨인가 갈비인가</div>
						</div>
						<div class="w3-col search-input w3-content w3-padding w3-left w3-margin-left">
							<form method="GET" action="/project/search/searchResult.project" id="searchForm" name="searchForm">
			                     <input type="text" onkeypress="enterkey();" name="searchkeyword" id="searchkeyword" class="search w550 w3-white w3-border-gray w3-padding w3-left" placeholder="상품을 검색하세요" style="border-radius: 15px;">
			                     <input type="hidden" name="searchword" id="searchword" value="">
					         </form>
						</div>
					</div>
				</div>
			</div>	
		</div>
		
		<!-- CONTENT 김의산 -->
		<div class="w3-col content" style="margin-top: 220px;">
			<div class="w3-col recommend_list_wrapper">
		<c:if test="${not empty mVO && mVO.likeCnt > 3}">	
				<div class="recommend_by_similarity w3-margin-bottom" style="height:300px;"></div>
		</c:if>
		<c:if test="${not empty mVO}">
				<div class="recommend_by_info w3-margin-bottom" style="height:300px;"></div>
		</c:if>				 
		<c:if test="${not empty mVO}">
				<div class="recommend_by_max_like_cnt w3-margin-bottom" style="height:300px;"></div>
		</c:if>				 
				<div class="recommend_top_5_categories w3-margin-bottom" style="height:1400px;">
					<div class="w3-col">
						<div class= "w3-col s3 tab_btn" style="height:50px;"></div>
					</div>
					<div class="w3-col w3-container">
						<div class="w3-col w3-display-container" style="height:250px;">
						</div>
					</div>
				</div>
			</div>
		</div>
	<c:if test="${not empty mVO}">
		<div class="w3-hide">
			<div id="mno">${mVO.mno}</div>
			<div id="ageGroup">${mVO.ageGroup}</div>
			<div id="gender">${mVO.gender}</div>
			<div id="likeCnt">${mVO.likeCnt}</div>
		</div>
	</c:if>
		<div class="w3-hide">
			<div id="tabList"></div>
			<div id="tabData"></div>
		</div>
	</div>
	</div>
</body>
</html>
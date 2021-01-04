<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>

<title>Document</title>
</head>
<style type="text/css">
    body{
        background-image: url("https://www.analogouscolors.com/image/2560x1440/f0f8ff.jpg");
       
        /* background-color: white; */
        background-repeat: repeat;
       
        }
    .form-control{
        background-color:#e8f0f2;
    }
    .md-3{
        color: #17a2b8;
    }
</style>

<script type="text/javascript">
$(document).ready(function(){
	// 페이지 버튼 클릭
	$('.btnPage').click(function() {
		var clickNum = $(this).text();
		selectNoticeList(clickNum);
	});
	
	// 목록 Row 클릭
	$('.rowTitle').click(function() {
		var $rowContent = $(this).next();
		var showYn = $rowContent.css("display");
		
		$('.rowContent').hide();
		
		if(showYn == 'none') {
			$rowContent.fadeIn("fast");
			
			/*
			// 공지사항 contents 조회
			var nno = $(this).children('.nno').text();
			$.ajax({
				url: "/cls/selectNotice.cls",
			    data: { nno : nno },
			    type: "POST",
			    dataType: "json",
			    success: function(data) {
			    	debugger;
			    	console.log(data);
			    	console.log($rowContent);
			    	$rowContent.children("td").text(data.content);
			    	$rowContent.fadeIn("fast");
			    },
			    error: function(e) {
			    	debugger;	
			    }
			});
			*/
		}
	});
	
});

// 공지사항 목록 조회
function selectNoticeList(pageIndex) {
	$('#pageIndex').val(pageIndex);
	alert($('#pageIndex').val());
	$('#nForm').submit();
}

</script>

<body class="pt-5">

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="#">이조</a>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="#">홈
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/cls/login.cls">로그인</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/cls/join.cls">회원가입</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Page Content -->
	<div class="container">
		<div class="row">

			<div class="col-lg-3">

				<h3 class="my-4 text-center">카테고리</h3>
				<div class="list-group mb-4">
					<a class="list-group-item list-group-item-warning text-center font-weight-bold">QnA</a>
					<a class="list-group-item list-group-item-warning text-center font-weight-bold mt-1">미정</a>
					<a class="list-group-item list-group-item-warning text-center font-weight-bold mt-1">미정</a>
					
				</div>

			</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-9 my-4 mb-4">
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col" style="width:10%;" class="text-center">번호</th>
							<th scope="col" style="width:50%;" class="text-center">제목</th>
							<th scope="col" style="width:15%;" class="text-center">글쓴이</th>
							<th scope="col" style="width:15%;" class="text-center">작성일</th>
							<th scope="col" style="width:10%;" class="text-center">조회수</th>
						</tr>
					<tbody>
						<c:forEach var="notice" items="${NoticeList}" varStatus="status">
							<tr class="rowTitle">
								<td scope="row" class="text-center nno">${notice.nno }</td>
								<td class="">${notice.title }</td>
								<td class="text-center">${notice.isshow }</td>
								<td class="text-center">${notice.ndate }</td>
								<td class="text-center">${notice.hits }</td>
							</tr>
							<tr class="rowContent" style="display:none;">
								<td scope="row" class=""></td>
								<td scope="row" colspan="3" class=""><pre style="overflow:hidden">${notice.contents }</pre></td>
								<td scope="row" class=""></td>
							</tr> 
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		
			<hr />
			<a class="btn btn-primary">글쓰기</a>
			<!-- 페이징 -->
			<form action="/cls/selectNoticeList.cls" method="POST" name="nForm" id="nForm">
				<input type="hidden" id="pageIndex" name="pageIndex">
				<div class="text-center">
					<ul class="pagination justify-content-center">
						<li class="page-item"><a class="page-link" href="javascript:void(0);">Previous</a></li>
						<li class="page-item"><a class="page-link btnPage" href="javascript:void(0);">1</a></li>
						<li class="page-item"><a class="page-link btnPage" href="javascript:void(0);">2</a></li>
						<li class="page-item"><a class="page-link btnPage" href="javascript:void(0);">3</a></li>
						<li class="page-item"><a class="page-link" href="javascript:void(0);">Next</a></li>
					</ul>
				</div>
			</form>
		</div>
</body>
</html>
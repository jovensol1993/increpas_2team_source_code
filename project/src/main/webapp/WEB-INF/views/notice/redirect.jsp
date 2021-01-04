<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Edit Redirect</title>
<script type="text/javascript" src="/project/js/jquery-3.5.1.min.js">아</script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#frm').submit();
	});
</script>
</head>
<body>
	<form method="POST" action="/project${URI}" id="frm">
<!-- 	view = "/notice/noticeDetail.project"; -->
		<input type="hidden" name="nno" value="${ID}">
		<input type="hidden" name="title" value="${TITLE}">
		<input type="hidden" name="contents" value="${URI}">
<!-- 	mv.addObject("ID", nVO.getNno()); -->
	</form>	
</body>
</html>   
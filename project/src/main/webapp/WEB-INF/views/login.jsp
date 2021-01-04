<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<script type="text/javascript" src="/project/js/login.js"></script>

<style type="text/css">
body {
	background-image:
		url("https://www.analogouscolors.com/image/2560x1440/f0f8ff.jpg");
	/* background-color: white; */
	background-repeat: repeat;
}
.form-control {
	background-color: #e8f0f2;
}
</style>

<title>로그인</title>
</head>
<body>
	<!-- 안내창 모달 -->
	<div class="container">
	    <div class="row">
	        <div class="col-md-12">
	
	          <div class="modal fade" id="myModal">
	              <div class="modal-dialog modal-lg">
	                  <div class="modal-content">
	                      <div class="modal-header">
	                          <h5 class="modal-title">안내 메세지</h5>
							  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
							    <span aria-hidden="true">&times;</span>
							  </button>
	                      </div>
	                      <div class="modal-body">
	                          
	                      </div>
	                      <div class="modal-footer">
	                          <input class="btn btn-primary" data-dismiss="modal" value="close"">
	                      </div>
	                  </div>
	              </div>
	          </div>
	        </div>
	    </div>
	</div>
	<div class="container">
		<div class="py-5 text-align">
			<img class="d-block mx-auto mb-4" src="/project/images/cat.png">

			<div class="login">
				<div class="container">
					<div class="row justify-content-center align-items-center">
						<div class="col-md-6">
							<div class="col-md-12">
								<div>
									<h3 class="text-center text-info">로그인</h3>
									<!-- <form id="loginfrm" method="post" action="loginProc.project"> -->
									<form id="loginfrm">	
										<div class="form-group">
											<label for="useremail" class="text-info">email:</label><br>
											<input type="text" name="email" id="email"
												class="form-control">

										</div>
										<div class="form-group">
											<label for="userpw" class="text-info">password:</label><br>
											<input type="password" name="password" id="password"
												class="form-control">

										</div>
									</form>
									<div class="form-group ">
										<div id="register-link" class="text-right">
											<a href="/project/member/findPw.project" class="text-info" id="findpw">비밀번호
												찾기</a> <span class="text-info">|</span> <a href="/project/member/join.project"
												class="text-info">회원가입</a>
										</div>
										<input type="button" id="btn_login" class="btn btn-info btn-md"
											value="로그인">
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
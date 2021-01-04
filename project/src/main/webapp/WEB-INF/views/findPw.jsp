<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <script type="text/javascript" src="/project/js/findPw.js"></script>
    <style type="text/css">
		body{
			background-image: url("https://www.analogouscolors.com/image/2560x1440/f0f8ff.jpg");
	        /* background-color: white; */
	        background-repeat: repeat;
        }
        .form-control{
            background-color:#e8f0f2;
        }
       .find{
           background-color: #f0f8ff;
           font-size: 15pt;
       }
	</style>
    <title>비밀번호 찾기</title>
</head>
<body>

<!-- 안내팝업 -->
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

<!-- 비밀번호 출력 팝업 -->
<div class="container">
    <div class="row">
        <div class="col-md-12">
          <div class="modal fade" id="pwModal">
              <div class="modal-dialog modal-sm modal-dialog-centered">
                  <div class="modal-content">
                      <div class="modal-header">
						<h5 class="modal-title">비밀번호 찾기</h5>
                      </div>
                      <div class="modal-body">
						고객님의 비밀번호는 <br/>
						<kbd id="resultPw">test</kbd> 입니다.
                      </div>
                      <div class="modal-footer">
                          <input class="btn btn-block btn-primary" id="goLogin" data-dismiss="modal" value="로그인 페이지로 이동">
                      </div>
                  </div>
              </div>
          </div>
        </div>
    </div>
</div>

<div class="container">
    <div class="py-5 text-align">
        <img class="d-block mx-auto mb-4" src="/project/images/pwcat.png">
    
        <div class="findpage">
            <div class="container">
                <div class="row justify-content-center align-items-center">
                    <div class="col-md-6">
                        <div class="col-md-12">
                            <form>
                                <h3 class="text-left text-info">FIND PW</h3>
                                <nav aria-label="breadcrumb find"></nav>
                                    <ol class="breadcrumb find">
                                      <li class="breadcrumb-item active">비밀번호 찾기</li>
                                    </ol>
                                  </nav>
                                  
                                <div class="form-group">
                                    <label for="email" class="text-info">email:</label><br>
                                    <input type="text" name="email" id="email" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label for="tel" class="text-info">휴대폰번호:</label><br>
                                    <input type="text" name="tel" id="tel" class="form-control">
                                </div>
                                <button type="button" class="btn btn-primary btn-lg btn-block" id="btn_check">확인</button>
                           		<!-- < type="button" class="btn btn-outline-info btn-md col-3" id="join">회원 가입</button> -->
                                <a href="/project/main.project"><p class="text-right text-secondary">홈으로</p></a>
                            </form>
                         <div class="mt-4"> </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    
</body>
</html>
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
    <script type="text/javascript" src="/project/js/join.js"></script>
    

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
<body>

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
</div>images
    <div class="container">
        <div class="py-5 text-align ">
            <img class="d-block mx-auto mb-1 text-align" src="/project/images/cat.png">
            <!-- <p class="lead">회원가입페이지</p> -->
        </div>
        <div class="row justify-content-center align-items-center">
            <div class="col-md-6 order-md-1">
                <h2 class="text-center text-info">회 원 가 입</h2>
                <!-- 회원정보 입력 -->
                <!-- <h4 class="mb-3">회원정보</h4> -->
                <form id="joinfrm" method="POST" action="/project/member/joinProc.project">
                	<input type="hidden" id="semail" name="email" value="">
                	<input type="hidden" id="spw" name="password"value="">
                	<input type="hidden" id="sgen" name="gender"value="">
                	<input type="hidden" id="sbirth" name="birthday"value="">
                	<input type="hidden" id="stel" name="tel"value="">
                	<input type="hidden" id="sisshow" name="isshow"value="Y">
                	
                </form>
                    <div class="mb-3 text-info">
                        <label for="email">이메일</label>
                        <input type="email" class="form-control" id="email" placeholder="이메일을 입력하세요" name="email">
                        <!-- <div class="invalid-email">올바른 이메일을 입력하세요</div> -->
                       <div class="check_font" id="email_check"></div>
                       
                        
                    </div>

                    <div class="mb-3 text-info">
                        <label for="password">비밀번호</label>
                        <input type="password" class="form-control " id="pw" placeholder="비밀번호를 입력하세요" value="" name="password">
                        <label for="re-password" class="mt-1">비밀번호 확인</label>
                        <input type="password" class="form-control" id="re-pw" placeholder="비밀번호를 다시입력하세요" value="" name="re-password">
                       
                    </div>
                    <div class="mb-3 text-info">
                        <label for="gen">성별</label><br>
                        <div class="radio-group">
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="radioValue" id="gen1" value="M">
                                <label class="form-check-label mr-5" for="gen1">
                                남자
                                </label>
                            </div>
                           
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="radioValue" id="gen2" value="F">
                                <label class="form-check-label" for="gen2">
                                여자
                                </label>
                            </div>
                        </div>
                        
                    </div>
                    <!-- 이메일 -->
                    <div class="mt-3 text-info">
                        <!-- <div class="invalid-email">올바른 이메일을 입력하세요</div> -->
                      <!-- 생년월일 -->
                        <div class="form-row mt-3">
                            <div class="form-group col-md-6">
                              <label for="inputYear">출생년도</label>
                              <input type="text" class="form-control" id="inputYear" placeholder="년(4자)" class="int" maxlength="4">
                            </div>
                            
                            <div class="form-group col-md-3">
                              <label for="inputMonth">월</label>
                              <select id="inputMonth" class="form-control">
                                <option selected>-</option>
                                
                                <option value="01">
                                    1
                                </option>
                                   <option value="02">
                                    2
                                </option>
                                   <option value="03">
                                    3
                                </option>
                                   <option value="04">
                                    4
                                </option>
                                   <option value="05">
                                    5
                                </option>
                                   <option value="06">
                                    6
                                </option>
                                   <option value="07">
                                    7
                                </option>
                                   <option value="08">
                                    8
                                </option>
                                   <option value="09">
                                    9
                                </option>
                                   <option value="10">
                                    10
                                </option>
                                   <option value="11">
                                    11
                                </option>
                                   <option value="12">
                                    12
                                </option>
                              </select>
                            </div>
                            <div class="form-group col-md-3">
                              <label for="inputDay">일</label>
                              <input type="text" class="form-control" id="inputDay">
                            </div>
                          </div>
                    </div>
                    <div class="mt-3 text-info">
                        <label for="tel">전화번호</label>
                        <div class="form-row">
                            <div class="form-row form-group col-md-3">
                                
                                <select id="first_num" class="form-control">
                                    <option selected value="010">
                                        010
                                    </option>
                                    <option value="02">
                                        011
                                    </option>
                                    <option value="02">
                                        016
                                    </option>
                                    <option value="02">
                                        017
                                    </option>
                                    <option value="02">
                                        018
                                    </option>
                                    <option value="02">
                                        019
                                    </option>
                                </select>
                            </div>
                            <div class="form-group col-md-9">
                                <input type="tel" class="form-control" id="tel" placeholder="휴대폰번호를 입력하세요" name="tel">
                                
                            </div>
                        </div>
                                            
                    </div>
                    
                    <hr class="mb-4">
                    
                    <button type="button" class="btn btn-primary btn-lg btn-block" id='btn_join'>가입하기</button>
                    <hr class="mb-4">
                
        </div>
    </div>
</div>
</body>
</html>
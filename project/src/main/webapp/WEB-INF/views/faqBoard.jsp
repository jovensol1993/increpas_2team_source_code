<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<!-- <link rel="stylesheet" type="text/css" href="/project/css/w3.css">
<link rel="stylesheet" type="text/css" href="/project/css/cls.css"> -->
<!-- <script type="text/javascript" src="/project/js/jquery-3.5.1.min.js"></script> -->
<script type="text/javascript" src="/project/js/main.js"></script>

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
<title>FAQ</title>
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
      selectFaqList(clickNum);
   });
   
   // 목록 Row 클릭
   $('.rowTitle').click(function() {
      var $rowContent = $(this).next();
      var showYn = $rowContent.css("display");
      
      $('.rowContent').hide();
      
      if(showYn == 'none') {
         $rowContent.fadeIn("fast");
      }
   });
   
   // 카테고리 클릭
   $('#category a').click(function() {
      $('#category a').removeClass("active");
      $(this).addClass("active");
      
      // FAQ 목록 조회
      var nowPage = $('#pageIndex').val();
      selectFaqList(nowPage);
   });
   
   //글쓰기버튼클릭 (mygusdnd@gmail.com 으로 확인/ 변경필요)
   $('#write').click(function(){
      $('#myModal').modal('show');
   })
   $('#tesbtn').click(function(){
      alert("1");
      $('#myModal').modal('show');
   })
   
   //모달창에 글등록 버튼 클릭
   $('#btn_submit').click(function(){
      var type = $('#selectType option:selected').val();
      var contents = $('#contents').val();
      var title = $('#title').val();
      $('#sselectType').val(type);
      $('#stitle').val(title);
      $('#scontents').val(contents);
      
      $('#writefrm').submit();

      
   });
   $('#del').click(function(){
      $('#myModal_del').modal('show');
   });
   
   $('#btn_del').click(function(){
      $('#dtitle').val($('#selectDelType option:selected').val());
      $('#writeDelfrm').submit();
   });
   
   
});

// FAQ 목록 조회
function selectFaqList(pageIndex) {
   $('#pageIndex').val(pageIndex);
   $('#type').val($('#category a.active').text());
   
   $('#nForm').submit();
}

</script>

<body class="">

   <!-- Page Content -->
   <div class="container">
   <div class="w3-col header" style="margin-bottom: 50px;">
      
   </div>
      <div class="row" style="margin-top: 50px;">

         <div class="col-lg-3" style="margin-top: 80px;">

            <!-- <h3 class="my-4 text-center">카테고리</h3> -->
            <c:set var="a" value="전체"></c:set>
            <c:set var="b" value="서비스문의"></c:set>
            <c:set var="c" value="상품문의"></c:set>
            <c:set var="d" value="입점/광고문의"></c:set>
            <c:set var="e" value="기타문의"></c:set>
            <div class="list-group mt-4 mb-4" id="category">
               <a class="list-group-item text-center list-group-item-action <c:if test='${fVO.type eq a }'>active</c:if>">전체</a>
               <a class="list-group-item text-center list-group-item-action <c:if test='${fVO.type eq b }'>active</c:if>">서비스문의</a>
               <a class="list-group-item text-center list-group-item-action <c:if test='${fVO.type eq c }'>active</c:if>">상품문의</a>
               <a class="list-group-item text-center list-group-item-action <c:if test='${fVO.type eq d }'>active</c:if>">입점/광고문의</a>
               <a class="list-group-item text-center list-group-item-action <c:if test='${fVO.type eq e }'>active</c:if>">기타문의</a>
            </div>
         <!-- 사이드바 -->
         
         </div>
         <!-- /.col-lg-3 -->

         <div class="col-lg-9 my-4 mb-4" style="margin-top: 50px;" >
            <div class="w3-col m2 txt16 fontweight12 w3-left clsbold" style="">FAQ</div>
            <table class="table table-hover" style="table-layout:fixed; margin-top: 80px;">
               <thead >
                  <tr>
                     <th scope="col" style="width:10%;" class="text-center">번호</th>
                     <th scope="col" style="width:20%;" class="text-center">구분</th>
                     <th scope="col" style="width:70%;" class="text-center">제목</th>
                  </tr>
               <tbody>
                  <c:forEach var="fno" items="${FaqList}" varStatus="status">
                     <tr class="rowTitle">
                        <%-- <td scope="row" class="text-center nno">${qno.qno }</td> --%>
                        <td scope="row" class="text-center">${status.count }</td>
                        <td class="text-center">${fno.type }</td>
                        <td class="text-left">${fno.title }</td>
                     </tr>
                     <tr class="rowContent" style="display:none;">
                        <td scope="row" class=""></td>
                        <td colspan="2" class=""><pre style="white-space: pre-wrap;word-break:break-all;">${fno.contents }</pre></td>
                     </tr> 
                  </c:forEach>
               </tbody>
            </table>
         </div>
      </div>
      
         <hr />
<!--          <div class=btn id="tesbtn">말썽부리지마라</div> -->
         <!-- 관리자 세션 확인 / 관리자일시 글쓰기 버튼 오픈 -->
         <c:if test='${sessionScope.SID eq "user1@increpas.com"}'>
            <a class="btn btn-primary" id="write" name="write">글쓰기</a>
            <a class="btn btn-danger"id="del">글삭제</a>
         </c:if>
         
         <!-- 페이징 -->
         <form action="/project/selectFaqList.project" method="POST" name="nForm" id="nForm">
            <input type="hidden" id="pageIndex" name="pageIndex" value="1">
            <input type="hidden" id="type" name="type" value="전체">
            <!-- TODO: 추후 구현
            <div class="text-center">
               <ul class="pagination justify-content-center">
                  <li class="page-item"><a class="page-link" href="javascript:void(0);">Previous</a></li>
                  <li class="page-item active"><a class="page-link btnPage" href="javascript:void(0);">1</a></li>
                  <li class="page-item"><a class="page-link btnPage" href="javascript:void(0);">2</a></li>
                  <li class="page-item"><a class="page-link btnPage" href="javascript:void(0);">3</a></li>
                  <li class="page-item"><a class="page-link" href="javascript:void(0);">Next</a></li>
               </ul>
            </div> 
            -->
         </form>
      </div>
      
      <!-- 글쓰기를 위한 모달 -->
   <div id="myModal"class="modal fade"aria-labelledby="myModalLabel"aria-hidden="true"tabindex="-1"role="dialog"> 
    <div class="modal-dialog"> 
        <div class="modal-content"> 
            <div class="modal-header"> 
                <button type="button"class="close"data-dismiss="modal"aria- hidden="true"> × </button> 
                <h4 class="modal-title"> FAQ 글 등록 </h4> 
            </div> 
            <div class="modal-body"id="myModalBody"> 
                <form id="contactform "role="form "> 
                 <div class="form-group col-lg px-0">
                         <label for="selectType">구분</label>
                         <select id="selectType" class="form-control">
                           <option selected value="서비스문의">
                        서비스문의</option>
                              <option value="상품문의">
                                  상품문의
                           </option>
                              <option value="입점/광고문의">
                        입점/광고문의
                           </option>
                              <option value="기타문의">
                        기타문의
                           </option>
                         </select>
                       </div>
                    <div class="form-group"> 
                        <label for="title"> 제목 </label> 
                        <input type="text"id="title"placeholder="제목을 입력하세요" class="form-control"/> 
                    </div> 
                    <div class="form-group">
                        <label for="contents"> 내용 </label> 
                        <textarea id="contents"rows="10"placeholder="내용을 입력하세요" class="form-control"> </textarea> 
                    </div> 
                </form> 
            </div> 
            <div class="modal-footer"> 
                <button type="btn" class="btn btn-success" id="btn_submit"> 등록 </button> 
            </div> 
        </div> 
    </div> 
   <form id="writefrm" method="POST" action="faqWriteProc.project">
                   <input type="hidden" id="sselectType" name="type" value="">
                   <input type="hidden" id="stitle" name="title"value="">
                   <input type="hidden" id="scontents" name="contents"value="">
                   <input type="hidden" id="sisshow" name="isshow"value="Y">
     </form>
</div>
   
   <!-- 글삭제 -->
   <div id="myModal_del"class="modal fade"aria-labelledby="myModalLabel"aria-hidden="true"tabindex="-1"role="dialog"> 
    <div class="modal-dialog"> 
        <div class="modal-content"> 
            <div class="modal-header"> 
                <button type="button"class="close"data-dismiss="modal"aria- hidden="true"> × </button> 
                <h4 class="modal-title"> FAQ 글 삭제 </h4> 
            </div> 
            <div class="modal-body"id="myModalBody"> 
                <form id="contactform "role="form "> 
                 <div class="form-group col-lg px-0">
                         <label for="selectDelType">구분</label>
                         <select id="selectDelType" class="form-control">
                           <option selected value="서비스문의">
                        삭제할 FAQ 선택 (필수)</option>
                            <c:forEach var="fno" items="${FaqList}" varStatus="status">
                        <%-- <td scope="row" class="text-center nno">${qno.qno }</td> --%>
                        <option value="${fno.title}">${fno.title}</option>
                     </c:forEach>
                         </select>
                       </div>
                </form> 
            </div> 
            <div class="modal-footer"> 
                <button class="btn btn-success" id="btn_del"> 삭제 </button> 
            </div> 
        </div> 
    </div> 
   <form id="writeDelfrm" method="POST" action="faqDelProc.project">
                   <input type="hidden" id="dtitle" name="title"value="">
                   
     </form>
</div>
</body>
</html>
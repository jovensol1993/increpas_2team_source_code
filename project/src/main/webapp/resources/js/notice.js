$(document).ready(function() {
	$('.title').click(function() {
		var nno = $(this).attr('id').substring(1); // nno
//		console.log(nno); 6이 찍혀서
		$('#nno').val(nno);
		$('#frm').attr('action', '/project/notice/noticeDetail.project');
		$('#frm').submit();
	});

//	삭제
	$('.delbtn').click(function(){
		var sno = $(this).attr('id').substring(1);
		$('#nno').val(sno);
		$('#frm').attr('action', '/project/notice/noticeDel.project');
		$('#frm').submit();
	});

// 편집버튼
	$('.editbtn').click(function(){
		var sno = $(this).attr('id').substring(1);
//		var contentDiv = $(this).siblings().find('#' + sno).children().eq(1);
//		var scontents = contentDiv.text();
		$('#nno').val(sno);
//		$('')
		$('#frm').attr('action', '/project/notice/noticeEdit.project');
		$('#frm').submit();
	});
	
	$('#editCancleBtn').click(function(){
		location.href = "/project/notice/notice.project";
	})
	
	$('#backbtn_detail').click(function(){
		location.href = "/project/notice/notice.project";
	})
	
	$('#editBtn').click(function(){
		$('#frm').attr('action', '/project/notice/noticeEditProc.project');
		$('#frm').submit();
	})
	$('.pagebtn').click(function(){
		// 어떤 버튼이 클릭되었는지 알아낸다.
		var str = $(this).text();
		 
		var sno = $(this).attr('id');
		
		if(!sno){
			// sno가 null 또는 undefined 인 경우는 페이지 번호 버튼이다.
			sno = $(this).text();
		}
		
		$('#nowPage').val(sno);
		$('#pfrm').submit();
	});
	
	$('.writebtn').click(function(){
		location.href ="/project/notice/noticeWrite.project";	
	});
	
	$(".writeProcbtn").click(function(){
		$('#frm').attr('action','/project/notice/noticeWriteProc.project');
		$('#frm').submit();
	})
	
});	
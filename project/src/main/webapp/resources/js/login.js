$(document).ready(function(){
    /*로그인 버튼*/
	$('#submit').click(function(){
        var email = $('#email').val();
        var pw = $('#password').val();
		
		// TODO: 입력값  체크 수정
        if((email&&pw)==null){
            return;
        }
        $('#loginfrm').submit();
    });
	$('#email').blur(function(){
		var email = $(this).val();
		var email_pattern =/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		// TODO: 입력값  체크 
		if(email == null || email ==""){
			return;
		} else{
			var res = email_pattern.test(email);
			if(!res){
				$('#email').val('');
				$('.modal-body').text('이메일 형식을 확인해주세요.');
				$('#myModal').modal('show');
				return;
			} else {
				$('#password').val("");
			}	
		}
	});
	
	$('#password').blur(function(){
		var email = $('#email').val();
		if(email == null || email == ""){
			return;
		} 
	})

	$('#btn_login').click(function() {
		var email = $('#email').val();
        var pw = $('#password').val();
		var email_pattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		// TODO: 입력값  체크 
		if(email == null || email ==""){
			$('#email').val('');
			$('.modal-body').text('이메일을 입력해 주세요.');
			$('#myModal').modal('show');
			return;
		} else{
			var res = email_pattern.test(email);
			if(!res){
				$('#email').val('');
				$('.modal-body').text('이메일 형식을 확인해주세요.');
				$('#myModal').modal('show');
				return;
			}			
		}

		if(pw == null || pw ==""){
			$('#email').val('');
			$('.modal-body').text('비밀번호를 입력해 주세요');
			$('#myModal').modal('show');
			return;
		}
		// ajax 로그인 처리
		$.ajax({
			url: '/project/member/loginProc.project',
			type: 'POST',
			dataType: 'json',
			data: {
				email: email,
				password : pw
			},
			success: function(data) {
				if (data.result == 'NO') {
					$('.modal-body').text('이메일 혹은 비밀번호가 일치하지 않습니다.');
					$('#myModal').modal('show');
					
				} else {
					// 메인페이지 이동
					document.location.href = "/project/main.project";
				}
			},
			error: function() {
				alert('### 에러 발생 : 관리자에게 문의해 주세요 errcode : 11002  ###');
			}
		});

	});

	

});
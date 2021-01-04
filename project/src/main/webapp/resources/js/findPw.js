$(document).ready(function() {
	//이메일 체크
	$('#email').blur(function() {

		var val = $('#email').val();
		var pattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		if (val == null || val == '') {
			return;
		} else {
			var result = pattern.test(val);
			if(!result) {
				$('#email').val('');
				$('.modal-body').text('이메일 형식을 확인해주세요.');
				$('#myModal').modal('show');
				return;
			}
		}
	});

	//전화번호 입력체크
	$('#tel').blur(function() {
		var val = $(this).val();
		//하이픈 있을경우 제거
//		var chk_val = val.replace(/\-/g, '');
		var pattern = /^(01[016789]{1})-([0-9]{3,4})-([0-9]{4})$/;

		if (val == null || val == '') {
			return;
		}
		var res = pattern.test(val);

		if (res == true) {
			$('#tel').val(val);
			return;
			
		} else {
			$('.modal-body').text('잘못된 형식입니다.');
			$('#myModal').modal('show');
		}
	});

	// 확인버튼(비밀번호찾기)
	$('#btn_check').click(function() {
		var email = $('#email').val();
		var tel = $('#tel').val();

		// 이메일 리체크
		if(email == null || email == "") {
			$('.modal-body').text('입력되지 않은 부분이 있습니다.');
			$('#myModal').modal('show');
			return;
		} else {
			var pattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			var result = pattern.test(email);
			if(!result) {
				$('#email').val('');
				$('.modal-body').text('이메일 형식을 확인해주세요.');
				$('#myModal').modal('show');
				return;
			}
		}
		//전화번호 형식 리체크
		if(tel == null || tel == "") {
			$('.modal-body').text('입력되지 않은 부분이 있습니다.');
			$('#myModal').modal('show');
			return;
		} else {
//			var chk_tel = tel.replace(/\-/g, '');
			var pattern = /^(01[016789]{1})-([0-9]{3,4})-([0-9]{4})$/;
			var res = pattern.test(tel);
			if (res) {
				$('#tel').val(tel);
			} else {
				$('.modal-body').text('잘못된 전화번호 형식입니다.');
				$('#myModal').modal('show');
				return;
			}
			
		}

		// 비밀번호 찾기 ajax
		$.ajax({
			url: '/project/member/findPwProc.project',
			type: 'POST',
			dataType: 'json',
			data: {
				email: email,
				tel : tel
			},
			success: function(data) {
				if (data.result == 'NO') {
					$('.modal-body').text('등록되지 않은 사용자입니다.');
					$('#myModal').modal('show');
					$('#email').val('');
					$('#tel').val('');
				} else {
					$('#resultPw').text(data.resultPw);
					$('#pwModal').modal('show');
				}
			},
			error: function() {
				alert('### 에러 발생 : 관리자에게 문의해 주세요 errcode : 11001  ###');
			}
		});
	});
	
	// 로그인화면으로 이동
	$('#goLogin').click(function() {
		document.location.href = "/project/member/login.project";
	});
});
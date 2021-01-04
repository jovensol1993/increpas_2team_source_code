$(document).ready(function() {
	//이메일 체크
	$('#email').blur(function() {

		var val = $('#email').val();
		var pattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		if (val == null || val == '') {
			return;
		} else {
			var result = pattern.test(val);
			if (result) {
				//이메일 체크 ajax
				$.ajax({
					url: '/project/member/idCheck.project',
					type: 'POST',
					dataType: 'json',
					data: {
						email: val
					},
					success: function(data) {
						if (data.result == 'OK') {
							// 사용가능한 이메일인 경우
						} else {
							// 사용 불가능한 이메일인 경우
							$('.modal-body').text('이미 등록된 이메일입니다.');
							$('#myModal').modal('show');
							$('#email').val('');
						}
					},
					error: function() {
						alert('### 에러 발생 : 관리자에게 문의해 주세요 errcode : 11003  ###');
					}
				});
				
				return;

			} else {
				$('#email').val('');
				$('.modal-body').text('이메일 형식을 확인해주세요.');
				$('#myModal').modal('show');
				return;
			}
		}


	});

	//비밀번호 확인 기능
	$('#re-pw').blur(function() {
		//1. 비밀번호 읽어오고
		var spw = $('#pw').val();
		//2. 확인번호 읽어오고
		var srepw = $(this).val();
		//3. 비교하고
		$('#pw').removeClass('border-danger');
		$('#re-pw').removeClass('border-danger');


		if (srepw == null || srepw == '') {

			return;
		} else {
			// 위아래 일치 확인
			if (spw == srepw) {
				return;
			} else {
				$('#pw').addClass('border-danger');
				$('#re-pw').addClass('border-danger');
				$('#re-pw').val('');
				$('.modal-body').text('비밀번호가 일치하지 않습니다.');
				$('#myModal').modal('show');
			}
		}
	});

	//출생년도 체크
	$('#inputYear').blur(function() {
		var birth_y = $('#inputYear').val();
		var pattern = /^[0-9]{4}$/;
		var min_y = 1900;
		var max_y = 2021;
		
		if (birth_y == null || birth_y == '') {
			$('#inputYear').val('');
			$('.modal-body').text('출생년도를 입력해 주세요.');
			$('#myModal').modal('show');
			return;
		} else {
			var result = pattern.test(birth_y);
			if(result){
				if(birth_y < max_y && birth_y > min_y){
					return;
				} else {
					$('#inputYear').val('');
					$('.modal-body').text('태어난 년도는 1900년도 부터 2021년도 까지 입니다.');
					$('#myModal').modal('show');
					return;
				}
			} else {
				$('#inputYear').val('');
				$('.modal-body').text('출생년도를 확인해 주세요.');
				$('#myModal').modal('show');
			}
		}
	});
	//날짜 체크 및 앞의 년도 재확인
	$('#inputDay').blur(function() {
		var val_d = $('#inputDay').val();
		var val_y = $('#inputYear').val();
		var min_y = 1900;
		var max_y = 2021;
		//alert(val > 31);
		if (val_d == null || val_d == '') {
			return;
		} else if (val_d > 31) {
			$('#inputDay').val('');
			$('.modal-body').text('정말이세요?');
			$('#myModal').modal('show');
		} else {
			if (val_y > min_y && val_y < max_y) {
				return;

			} else {
				$('#inputYear').val('');
				$('.modal-body').text('출생일을 다시 확인해주세요.');
				$('#myModal').modal('show');
			}

		}
	});
	//전화번호 입력체크
	$('#tel').blur(function() {
		var val = $(this).val();
		//하이픈 있을경우 제거
//		var chk_val = val.replace(/\-/g, '');
//		var pattern = /^([0-9]{7,8})$/;
		var pattern = /^([0-9]{3,4})-([0-9]{4})$/;
		var temp = $('#first_num option:selected').val();
		
		if (val == null || val == '') {
			return;
		}
		//입력값 정상여부 확인
		var res = pattern.test(val);
		
		if (res) {
			var tel = temp+'-'+val;
		//전화번호 체크 ajax
			$.ajax({
				url: '/project/member/telCheck.project',
				type: 'POST',
				dataType: 'json',
				data: {
					tel: tel
				},
				success: function(data) {
					if (data.result == 'OK') {
						// 사용가능한 전화번호인 경우
					} else {
						// 사용 불가능한 전화번호인 경우
						$('.modal-body').text('사용중인 연락처입니다. 비밀번호 찾기를 이용해주세요.');
						$('#myModal').modal('show');
						$('#email').val('');
					}
				},
				error: function() {
					alert(data);
					alert('### 에러 발생 : 관리자에게 문의해 주세요 errcode : 11003  ###');
				}
			})
			$('#tel').val(chk_val);
			return;
		} else {
			$('#tel').val('');
			$('.modal-body').text('잘못된 형식입니다.');
			$('#myModal').modal('show');
		}
		
		
		
		
	});

	//가입 value값 재확인
	$('#btn_join').click(function() {
		var email = $('#email').val();
		var pw = $('#pw').val();
		var gen = $('input[name=radioValue]:checked').val();
		var year = $('#inputYear').val();
		var month = $('#inputMonth option:selected').val();
		var day = $('#inputDay').val();
		var tel = $("#first_num option:selected").val() + $('#tel').val();

		// 생년월일 체크
		if(year == null || year == "") {
			$('.modal-body').text('입력되지 않은 부분이 있습니다.');
			$('#myModal').modal('show');
			return;
		}
		if(month == null || month == "") {
			$('.modal-body').text('입력되지 않은 부분이 있습니다.');
			$('#myModal').modal('show');
			return;
		}
		if(day == null || day == "") {
			$('.modal-body').text('입력되지 않은 부분이 있습니다.');
			$('#myModal').modal('show');
			return;
		}
		if(day.length > 2) {
			$('.modal-body').text('생년월일을 확인하세요.');
			$('#myModal').modal('show');
			return;
		}
		
		// 필수입력값 체크
		if ((email && pw && gen && tel) == '' || null) {
			$('.modal-body').text('입력되지 않은 부분이 있습니다.');
			$('#myModal').modal('show');
			return;
		}
		
		// 일자 자리수 세팅
		day = day.length == 1 ? ("0" + day) : day;
		
		$('#semail').val(email);
		$('#spw').val(pw);
		$('#sgen').val(gen)
		$('#sbirth').val(year + month + day);
		$('#stel').val(tel);

		$('#joinfrm').submit();


	});
});
	
	function enterkey() {
		if(event.keyCode == 13){
			//엔터키가 눌렸을 때 이벤트 처리
			//다른제품 검색하면 searchResult 다시 띄우도록
			var sval = $('#searchkeyword').val();
			$('#searchword').val(sval);
			$('#frm').attr('action', '/project/search/searchResult.project');
			$('#frm').submit();
			
			var formData = new FormData();
			formData.set('frm', sval);
		}	
	}
	
	$(document).ready(function(){
		$('#goSearch').click(function(){
			//다른제품 검색하면 searchResult 다시 띄우도록
			var sval = $('#searchkeyword').val();
			$('#searchword').val(sval);
			$('#frm').attr('action', '/project/search/searchResult.project');
			$('#frm').submit();

			var formData = new FormData();
			formData.set('frm', sval);
		});
		
		//좋아요, 가격높낮이순, 할인율 높낮이순 버튼 눌렀을 때
		$('.searchBtn').click(function(){
			//hidden태그에서 검색어 계속 읽어오고
			var sval = $('#searchword').val();
			// 어떤버튼이 클릭되었는지 알아내고
			var txt = $(this).attr('id');
			//검색어 담아주고
			$('#searchword').val(sval);
			//필터 담아주고
			$('#scode').val(txt);
			$('#frm').submit();
		});
		
		//소셜커머스 버튼 눌렀을 때
		$('.filterbtn').click(function(){
			//소셜커머스 이름 읽어오고
			var fval = $(this).attr('id');
			//검색어 계속 읽어오고
			var sval = $('#searchword').val();
			$('#searchword').val(sval);
			
			//필터 담아주고
			$('#filterbutton').val(fval);
			$('#frm').submit();
		});
		
		//카테고리 버튼 눌렀을 때
		$('.categbtn').click(function(){
			//소셜커머스 이름 읽어오고
			var fval = $(this).attr('id');
			//검색어 계속 읽어오고
			var sval = $('#searchword').val();
			$('#searchword').val(sval);
			
			//필터 담아주고
			$('#filterbutton').val(fval);
			$('#frm').submit();
		});
		

	});
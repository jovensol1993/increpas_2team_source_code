$(document).ready(function(){
	$('#goSearch').click(function(){
		//다른제품 검색하면 제품결과 다시 띄우도록
		var sval = $('#searchkeyword').val();
		$('#searchword').val(sval);
		$('#frm').attr('action', '/project/search/searchResult.project');
		$('#frm').submit();

		var formData = new FormData();
		formData.set('frm', sval);
	});
			
	$('.searchBtn').click(function(){
		// 어떤버튼이 클릭되었는지 알아내고
		var sval = $('#searchword').val();
		var txt = $(this).attr('id');
		var fbtn = $('#filterbutton').val();
		$('#searchword').val(sval);
		$('#scode').val(txt);
		$('#filterbutton').val(fbtn);
		$('#frm').submit(); 
		
		if(fbtn == ""){
		var formData = new FormData();
		formData.set('frm', sval, txt)
		} else if (fbtn !=""){
		var formData = new FormData();
		formData.set('frm', sval, txt, fbtn)
		}
		
	});
	
	$('.filterbtn').click(function(){
		// 어떤버튼이 클릭되었는지 알아내고
		var sval = $('#searchword').val();
		var scode = $('#scode').val();
		var temp = $(this).attr('id');
		$('#filterbutton').val(temp);
		$('#searchword').val(sval);
		$('#scode').val(scode);
		$('#frm').submit(); 
		
		if(scode == ""){
		var formData = new FormData();
		formData.set('frm', sval, temp)
		} else if (scode !=""){
		var formData = new FormData();
		formData.set('frm', sval, temp, scode)
		}
	});
	
	$('.categbtn').click(function(){
		// 어떤버튼이 클릭되었는지 알아내고
		var sval = $('#searchword').val();
		var scode = $('#scode').val();
		var temp = $(this).attr('id');
		$('#filterbutton').val(temp);
		$('#searchword').val(sval);
		$('#scode').val(scode);
		$('#frm').submit(); 
		
		if(scode == ""){
		var formData = new FormData();
		formData.set('frm', sval, temp)
		} else if (scode !=""){
		var formData = new FormData();
		formData.set('frm', sval, temp, scode)
		}
		
	});

});
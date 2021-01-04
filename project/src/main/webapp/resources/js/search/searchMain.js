function enterkey() {
	if(event.keyCode == 13){
		//엔터키가 눌렸을 때 이벤트 처리
		var sval = $('#searchkeyword').val();
		$('#searchword').val(sval);
		$('#frm').submit();
	}	
}
	
$(document).ready(function(){
	$('#goSearch').click(function(){
		//Search 버튼 직접 눌렀을 때 이벤트 처리
		var sval = $('#searchkeyword').val();
		$('#searchword').val(sval);
		$('#frm').submit();
	});
	 
	//메인화면에서 소셜커머스 필터 눌렀을 때 필터별로 정렬해준다.
	$('.filterbtn').click(function(){
		var temp = $(this).attr('id');
		$('#filterbutton').val(temp);
		$('#frm').attr('action', '/project/search/search.project');
		$('#frm').submit();
	});
	
	//메인화면에서 카테고리 필터 눌렀을 때 필터별로 정렬해준다.
	$('.categbtn').click(function(){
		var temp = $(this).attr('id');
		$('#filterbutton').val(temp);
		$('#frm').attr('action', '/project/search/search.project');
		$('#frm').submit();
	});
	 
});
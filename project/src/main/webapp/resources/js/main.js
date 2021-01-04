

function modalBoard() {
	var x = document.getElementById("modalBoard");
	if (x.style.display === "none") {
		x.style.display = "block";
	} else {
		x.style.display = "none";
	}
}

function categoryBoard() {
	var x = document.getElementById("categoryBoard");
	if (x.style.display === "none") {
		x.style.display = "block";
	}
}

function enterkey() {
    if (window.event.keyCode == 13) {
         // 엔터키가 눌렸을 때 실행할 내용
      var sval = $('#searchkeyword').val();
      if(sval == ""){
         $('#searchword').val(sval);
         $('#search').attr('action','/project/search/search.project');
      } else {
      	$('#searchword').val(sval);
         $('#search').submit();
      }
    }
}

function trim(s){ 
	  return ( s || '' ).replace(/\s/g,''); 
}


function plusDivs(slider, n) {
	slider.slideIndex = slider.slideIndex + n
	showDivs(slider);
}

function showDivs(slider) {
	var i;
	var slideDivs = $("div#" + slider.listClass).find("div."+slider.listClass + "_slides");
	if (slider.slideIndex > slideDivs.length) {
		slider.slideIndex = 1;
	}
	if (slider.slideIndex < 1) {
		slider.slideIndex = slideDivs.length;
	}
	for (i = 0; i < slideDivs.length; i++) {
		slideDivs.eq(i).css('display', 'none');  
	}
	slideDivs.eq(slider.slideIndex-1).css('display', 'block');
}


var infoSlider = { slideIndex : 1, listClass: "recommend_by_info" };
var similaritySlider = { slideIndex : 1, listClass: "recommend_by_similarity" };
var maxCntSlider = { slideIndex : 1, listClass: "recommend_by_max_like_cnt" };

$(document).ready(function(){
    
	$('input#search').keyup(enterkey);

	$(".loginbtn").click(function() {
		location.replace("/project/member/login.project");
	});

	$(".logoutbtn").click(function() {
		location.href = "/project/member/logoutProc.project";
	});

	$(".boardbtn").click(function() {
		location.href = "/project/notice/notice.project";
	});

	$(".faqbtn").click(function() {
		location.href = "/project/faqBoard.project";
	});

	$(".category").click(function() {
		var sval = $(this).attr('id');
		$('#searchword').val(sval);
		$('#searchForm').submit();
	
	});
	
	//---------------------------------------------------------------------

	var mno = $('#mno').html();
	var ageGroup = $('#ageGroup').html();
	var gender = $('#gender').html();
	var likeCnt = $('#likeCnt').html();
	
	if (mno) {
		
		$.ajax({
			url: '/project/main/getRecommendationByInfo.project',
				type: 'GET',
				dataType: 'json',
				data: {
					mno : mno,
					ageGroup : ageGroup,
					gender : gender
				},
				success: function(data){
					
					if(data){
					
						var outer = $('div.recommend_by_info').first();
						var html = ' <div class="w3-col w3-container"> ' +
										' <div class="w3-col w3-display-container w3-text-light-blue w3-padding" style="height:20px;"> ' +
											' <div class="w3-col w3-left-align w3-display-left list-title " style="font-size: 20px"> 오늘의 추천 </div> ' +
										' </div> ' + 
									' </div> ' + 
									' <div class="w3-col w3-container"> ' +
										' <div id="recommend_by_info" class="w3-col w3-display-container" style="height:250px;"> ' +
											' <button class="w3-col s1 w3-display-left w3-button w3-light-blue w3-text-white recommend_by_info_slider_button_left" style="height:50px;">&#10094;</button>';
							
							for (var i = 0; i < 20; i++) {
								if ( (i % 4 == 0) && (i == 0) ) {
									html += ' <div class="w3-col s10 recommend_by_info_slides w3-display-middle" style="display:none;"> ';
								}
								if ( (i % 4 == 0) && (i != 0) ) {
									html += ' </div> ' +
											' <div class="w3-col s10 recommend_by_info_slides w3-display-middle" style="display:none;"> ';
								}
								if ( i != 20 - 1 ) {
									html += 	' <div class="w3-col s3 w3-padding"> ' +
													' <a class="w3-col" style:"height: 235px; overflow: hidden;" href="' + data[i].url + '"> ' +
														' <img class="w3-col" src="resources/' + data[i].imagePath + '" style="height:auto;" title="' + data[i].name + '"> ' +
													' </a> ' +
													' <div> ';
									if 	(data[i].discountRate != 0) {
										html +=			' <span class="discount_rate w3-text-red w3-large">' + data[i].discountRate + '% </span> ';
									}
										html +=			' <span class="price">￦' + data[i].price + '</span> ' +
													' </div> ' +
												' </div> ';
								}
								if ( i == 20 - 1 ) {
									html += 	' <div class="w3-col s3 w3-padding"> ' +
													' <a class="w3-col" style:"height: 235px; overflow: hidden;" href="' + data[i].url + '"> ' +
														' <img class="w3-col" src="resources/' + data[i].imagePath + '" style="height:auto;" title="' + data[i].name + '"> ' +
													' </a> ' +
													' <div> ';
									if 	(data[i].discountRate != 0) {
										html +=			' <span class="discount_rate w3-text-red w3-large">' + data[i].discountRate + '% </span> ';
									}
										html +=			' <span class="price"> ￦ ' + data[i].price + '</span> ' +
													' </div> ' +
												' </div> ' +
											' </div> ';
											
								}
								
							}
							
							html += ' <button class="w3-col s1 w3-display-right w3-button w3-light-blue w3-text-white recommend_by_info_slider_button_right" style="height:50px;">&#10095;</button> ' +
								' </div> ';
								
						outer.html(html);
						
						showDivs(infoSlider);
			
						$(".recommend_by_info_slider_button_left").click(function() {
							plusDivs(infoSlider, -1);
						});
						$(".recommend_by_info_slider_button_right").click(function() {
							plusDivs(infoSlider, 1);
						});
		
					
					}
					
				},
				error: function(){
					alert('### 통신 에러 ###');
				}
		});
		
	}
	
 	if (likeCnt >= 4) {
	
		$.ajax({
			url: '/project/main/getRecommendedBySimilarity.project',
				type: 'GET',
				dataType: 'json',
				data: {
					mno : mno
				},
				success: function(data){
					
					if(data){
					
						var outer = $('div.recommend_by_similarity').first();
						var html = ' <div class="w3-col w3-container"> ' +
										' <div class="w3-col w3-display-container w3-text-light-blue w3-padding" style="height:20px;"> ' +
											' <div class="w3-col w3-left-align w3-display-left list-title " style="font-size: 20px"> 나와 유사한 사람이 구매한 상품 </div> ' +
										' </div> ' + 
									' </div> ' + 
									' <div class="w3-col w3-container"> ' +
										' <div id="recommend_by_similarity" class="w3-col w3-display-container" style="height:250px;"> ' +
											' <button class="w3-col s1 w3-display-left w3-button w3-light-blue w3-text-white recommend_by_similarity_slider_button_left" style="height:50px;">&#10094;</button>';
							
							for (var i = 0; i < 20; i++) {
								if ( (i % 4 == 0) && (i == 0) ) {
									html += ' <div class="w3-col s10 recommend_by_similarity_slides w3-display-middle" style="display:none;"> ';
								}
								if ( (i % 4 == 0) && (i != 0) ) {
									html += ' </div> ' +
											' <div class="w3-col s10 recommend_by_similarity_slides w3-display-middle" style="display:none;"> ';
								}
								if ( i != 20 - 1 ) {
									html += 	' <div class="w3-col s3 w3-padding"> ' +
													' <a class="w3-col" style:"height: 235px; overflow: hidden;" href="' + data[i].url + '"> ' +
														' <img class="w3-col" src="resources/' + data[i].imagePath + '" style="height:auto;" title="' + data[i].name + '"> ' +
													' </a> ' +
													' <div> ';
									if 	(data[i].discountRate != 0) {
										html +=			' <span class="discount_rate w3-text-red w3-large">' + data[i].discountRate + '% </span> ';
									}
										html +=			' <span class="price">￦' + data[i].price + '</span> ' +
													' </div> ' +
												' </div> ';
								}
								if ( i == 20 - 1 ) {
									html += 	' <div class="w3-col s3 w3-padding"> ' +
													' <a class="w3-col" style:"height: 235px; overflow: hidden;" href="' + data[i].url + '"> ' +
														' <img class="w3-col" src="resources/' + data[i].imagePath + '" style="height:auto;" title="' + data[i].name + '"> ' +
													' </a> ' +
													' <div> ';
									if 	(data[i].discountRate != 0) {
										html +=			' <span class="discount_rate w3-text-red w3-large">' + data[i].discountRate + '% </span> ';
									}
										html +=			' <span class="price"> ￦ ' + data[i].price + '</span> ' +
													' </div> ' +
												' </div> ' +
											' </div> ';
											
								}
								
							}
							
							html += ' <button class="w3-col s1 w3-display-right w3-button w3-light-blue w3-text-white recommend_by_similarity_slider_button_right" style="height:50px;">&#10095;</button> ' +
								' </div> ';
								
						outer.html(html);
						
						showDivs(similaritySlider);
			
						$(".recommend_by_similarity_slider_button_left").click(function() {
							plusDivs(similaritySlider, -1);
						});
						$(".recommend_by_similarity_slider_button_right").click(function() {
							plusDivs(similaritySlider, 1);
						});
					
					}
					
				},
				error: function(){
					alert('### 통신 에러 ###');
				}
		});
	
	}
	
	if (mno) {

		$.ajax({
			url: '/project/main/getRecommendationByMaxLikeCnt.project',
				type: 'GET',
				dataType: 'json',
				data: {
					mno : mno,
					ageGroup : ageGroup,
					gender : gender
				},
				success: function(data){
					if(data){
						var sGender = gender == 'F' ? '여' : '남';
						var outer = $('div.recommend_by_max_like_cnt').first();
						var html = ' <div class="w3-col w3-container"> ' +
										' <div class="w3-col w3-display-container w3-text-light-blue w3-padding" style="height:20px;"> ' +
											' <div class="w3-col w3-left-align w3-display-left list-title " style="font-size: 20px"> ' + ageGroup + '대 ' + sGender + '성이 추천하는 상품 </div> ' +
										' </div> ' + 
									' </div> ' + 
									' <div class="w3-col w3-container"> ' +
										' <div id="recommend_by_max_like_cnt" class="w3-col w3-display-container" style="height:250px;"> ' +
											' <button class="w3-col s1 w3-display-left w3-button w3-light-blue w3-text-white recommend_by_max_like_cnt_slider_button_left" style="height:50px;">&#10094;</button>';
							
							for (var i = 0; i < 20; i++) {
								if ( (i % 4 == 0) && (i == 0) ) {
									html += ' <div class="w3-col s10 recommend_by_max_like_cnt_slides w3-display-middle" style="display:none;"> ';
								}
								if ( (i % 4 == 0) && (i != 0) ) {
									html += ' </div> ' +
											' <div class="w3-col s10 recommend_by_max_like_cnt_slides w3-display-middle" style="display:none;"> ';
								}
								if ( i != 20 - 1 ) {
									html += 	' <div class="w3-col s3 w3-padding"> ' +
													' <a class="w3-col" style:"height: 235px; overflow: hidden;" href="' + data[i].url + '"> ' +
														' <img class="w3-col" src="resources/' + data[i].imagePath + '" style="height:auto;" title="' + data[i].name + '"> ' +
													' </a> ' +
													' <div> ';
									if 	(data[i].discountRate != 0) {
										html +=			' <span class="discount_rate w3-text-red w3-large">' + data[i].discountRate + '% </span> ';
									}
										html +=			' <span class="price">￦' + data[i].price + '</span> ' +
													' </div> ' +
												' </div> ';
								}
								if ( i == 20 - 1 ) {
									html += 	' <div class="w3-col s3 w3-padding"> ' +
													' <a class="w3-col" style:"height: 235px; overflow: hidden;" href="' + data[i].url + '"> ' +
														' <img class="w3-col" src="resources/' + data[i].imagePath + '" style="height:auto;" title="' + data[i].name + '"> ' +
													' </a> ' +
													' <div> ';
									if 	(data[i].discountRate != 0) {
										html +=			' <span class="discount_rate w3-text-red w3-large">' + data[i].discountRate + '% </span> ';
									}
										html +=			' <span class="price"> ￦ ' + data[i].price + '</span> ' +
													' </div> ' +
												' </div> ' +
											' </div> ';
											
								}
								
							}
							
							html += ' <button class="w3-col s1 w3-display-right w3-button w3-light-blue w3-text-white recommend_by_max_like_cnt_slider_button_right" style="height:50px;">&#10095;</button> ' +
								' </div> ';
								
						outer.html(html);
						
						showDivs(maxCntSlider);
			
						$(".recommend_by_max_like_cnt_slider_button_left").click(function() {
							plusDivs(maxCntSlider, -1);
						});
						$(".recommend_by_max_like_cnt_slider_button_right").click(function() {
							plusDivs(maxCntSlider, 1);
						});
		
					
					}
					
				},
				error: function(){
					alert('### 통신 에러 ###');
				}
		});
		
	}
	
	$.ajax({
		url: '/project/main/getTabData.project',
		type: 'GET',
		dataType: 'json',
		data: {	},
		success: function(map){
			$('div#tabList').text(JSON.stringify(map.cList));
			$('div#tabData').text(JSON.stringify(map.pList));
			map.pList.sort(function(a, b){ return a.parenCno - b.parentCno; });
			
			var outer = $('div.recommend_top_5_categories').first();
			
			var html = ' <div class="w3-col w3-display-container" style="margin-top:40px; margin-bottom: 30px"> ' +
						 ' <div class="w3-col s10 w3-display-middle"> ';
			for (var i = 0; i < 4; i++) {
				html += 	' <h4 id="tab' + map.cList[i].cno + '" class="w3-col s3 tab_btn w3-padding w3-light-blue w3-text-white w3-hover-text-black" >' + map.cList[i].name + '</h4> ';
			}
			html +=			' </div> ' +
						' </div> ' +
						' <div class="w3-col w3-container"> ';
			
			
			for (var j = 0; j < 4; j++) {
			
				html +=		' <div id="content' + map.cList[j].cno + '" class="tab_content">';
			
				for (var i = 0; i < 20; i++) {
					var temp = j * 20 + i;
					if (i % 4 == 0 && i == 0) {
						html +=		' <div class="w3-col w3-display-container" style="height:250px;"> ' +
										' <div class="w3-col s10 recommend_top_5_categories w3-display-middle" style="display:none;"> ';

					} else if (i % 4 == 0 && i != 0) {
						html +=			' </div> ' +
									' </div> ' +
									' <div class="w3-col w3-display-container" style="height:250px;"> ' +
										' <div class="w3-col s10 recommend_top_5_categories w3-display-middle" style="display:none;"> ';
					}
					
					if (i == 20 - 1) {
						html +=				' <div class="w3-col s3 w3-padding"> ' +
												' <a class="w3-col" style:"height: 235px; overflow: hidden;" href="' + map.pList[temp].url + '"> ' +
													' <img class="w3-col" src="resources/' + map.pList[temp].imagePath + '" style="height:auto;" title="' + map.pList[temp].name + '"> ' +
												' </a> ' +
												' <div> ';
						if 	(map.pList[temp].discountRate != 0) {
							html +=						' <span class="discount_rate w3-text-red w3-large">' + map.pList[temp].discountRate + '% </span> ';
						}
						html +=							' <span class="price">￦' + map.pList[temp].price + '</span> ' +
												' </div> ' +
											' </div> ' +
										' </div> ' +
									' </div> ' ;
					} else {
						html +=				' <div class="w3-col s3 w3-padding"> ' +
												' <a class="w3-col" style:"height: 235px; overflow: hidden;" href="' + map.pList[temp].url + '"> ' +
													' <img class="w3-col" src="resources/' + map.pList[temp].imagePath + '" style="height:auto;" title="' + map.pList[temp].name + '"> ' +
												' </a> ' +
												' <div> ';
						if 	(map.pList[temp].discountRate != 0) {
							html +=						' <span class="discount_rate w3-text-red w3-large">' + map.pList[temp].discountRate + '% </span> ';
						}
						html +=							' <span class="price">￦' + map.pList[temp].price + '</span> ' +
												' </div> ' +
											' </div> ';
					}
				}
				
				html +=		' </div>';
			
			}
			
			html +=		' </div> ';
			
			outer.html(html);
			
			$('h4.tab_btn').click(function() {
				var categList = eval($('div#tabList').html());
				var nid = Number($(this).attr('id').substring(3));
				for (var i = 0; i < 4; i++) {
					console.log(categList[i].cno == nid);
					if (categList[i].cno == nid){
						$('div#content' + categList[i].cno).find('div.recommend_top_5_categories').css('display', 'block');						
						$('div#content' + categList[i].cno).find('div.w3-display-container').css('display', 'block');						
					} else {
						$('div#content' + categList[i].cno).find('div.recommend_top_5_categories').css('display', 'none');						
						$('div#content' + categList[i].cno).find('div.w3-display-container').css('display', 'none');						
					}
				}
			});
			
			for (var i = 0; i < 4; i++) {
				if (i == 0){
					$('div#content' + map.cList[i].cno).find('div.recommend_top_5_categories').css('display', 'block');						
					$('div#content' + map.cList[i].cno).find('div.w3-display-container').css('display', 'block');						
				} else {
					$('div#content' + map.cList[i].cno).find('div.recommend_top_5_categories').css('display', 'none');						
					$('div#content' + map.cList[i].cno).find('div.w3-display-container').css('display', 'none');						
				}
			}
			
		},
		error :function(){
			alert('### 통신 에러 ###');
		}
	});

});
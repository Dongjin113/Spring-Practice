<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="../include/top.jsp" %>

<section>
<div align="center">
<br>	
	<div id="map" style="width:95%;height:650px;"></div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=${key}"></script>
	<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
	    mapOption = { 
	        center: new kakao.maps.LatLng(35.16920059144  , 128.32632851586 ), // 지도의 중심좌표
	        level: 9 // 지도의 확대 레벨
	    };
	
	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

	/*
	var title = ['한라한', '섭지코지','성산일출봉','비양도','서귀포시','차귀도']           
	var lat = [33.379855775783184, 33.43110070088868, 33.467529585445796,  33.40008575665509, 33.258222769268535 ,  33.31178531314658] 
	var lon = [126.52691599216999, 126.92781417796924, 126.93462584853633, 126.26375498609065, 126.51632575761015, 126.16965945165987]
	*/
	var title =new Array();
	var lat =new Array();
	var lon =new Array();
	var rdnmadr =new Array();
	// 마커를 표시할 위치와 내용을 가지고 있는 객체 배열입니다
	
	<c:forEach var="k" items="${li}">
	title.push("${k.entrprsNm}")
	lat.push("${k.latitude}")
	lon.push("${k.logitude}")
	rdnmadr.push("${k.rdnmadr}")
	</c:forEach>
	
	
	var positions = [];
	
	for (i=0 ; i <= title.length ; i++ ){
		positions[i] = {
				content : ' <div style="padding:5px;"> '+ title[i] +' <br> ' 
						+ ' '+ rdnmadr[i] + ' <br> '
						+ ' <a href=https://map.kakao.com/link/to/'+ title[i] +','+lat[i]+','+ lon[i] + ' style="color:blue" target="_blank">길찾기</a></div>',
				latlng : new kakao.maps.LatLng(lat[i], lon[i])
		};
	}
	
	for (var i = 0; i < positions.length; i ++) {
	    // 마커를 생성합니다
	    var marker = new kakao.maps.Marker({
	        map: map, // 마커를 표시할 지도
	        position: positions[i].latlng // 마커의 위치
	    });
	
	    // 마커에 표시할 인포윈도우를 생성합니다 
	    var infowindow = new kakao.maps.InfoWindow({
	        content: positions[i].content // 인포윈도우에 표시할 내용
	    });
	
	    // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
	    // 이벤트 리스너로는 클로저를 만들어 등록합니다 
	    // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
	    kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
//	    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
	}
	
	// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
	function makeOverListener(map, marker, infowindow) {
	    return function() {
	        infowindow.open(map, marker);
	    };
	}
	
	// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
	function makeOutListener(infowindow) {
	    return function() {
	        infowindow.close();
	    };
	}
	</script>
	

</div>

</div>

<br>
</section>
<%@ include file="../include/bottom.jsp" %>
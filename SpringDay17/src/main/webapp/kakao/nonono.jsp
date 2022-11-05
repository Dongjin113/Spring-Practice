<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>
<section>
<div align="center">
<br><br><br>

<h1> 여러개의 마크 위에 큰지도와 길찾기 추가 </h1>
<br><br>
<body  onload="onLoadOK()">


<p>
    <button onclick="hideMarkers()">마커 감추기</button>
    <button onclick="showMarkers()">마커 보이기</button>
</p> 
<div id="map" style="width:100%;height:750px;"></div>

<em>클릭한 위치에 마커가 표시됩니다!</em>
    
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=bf02fe9c128963727a9179a7e0661bba"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
    mapOption = { 
        center: new kakao.maps.LatLng(33.379855775783184, 126.52691599216999), // 지도의 중심좌표
        level: 9 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 지도에 표시된 마커 객체를 가지고 있을 배열입니다
var markers = [];
var infowindows =[];
// 마커 하나를 지도위에 표시합니다 

var title = ['섭지코지','성산일출봉','비양도','서귀포시','차귀도', '한라한']           
var lat = [33.43110070088868, 33.467529585445796,  33.40008575665509, 33.258222769268535 ,  33.31178531314658, 33.379855775783184] 
var lon = [126.92781417796924, 126.93462584853633, 126.26375498609065, 126.51632575761015, 126.16965945165987, 126.52691599216999]

for (i=0 ; i <= 5 ; i++ ){
  addMarker(new kakao.maps.LatLng(lat[i], lon[i]));
  
    //인포윈도우를 생성하고 지도에 표시합니다
	var iwContent = ' <div style="padding:5px;"> '+ title[i] +' <br> ' 
		iwContent =iwContent + ' <a href=https://map.kakao.com/link/map/'+ title[i] +','+lat[i]+','+ lon[i] + ' style="color:blue" target="_blank">큰지도보기</a> '
		iwContent =iwContent + ' <a href=https://map.kakao.com/link/to/'+ title[i] +','+lat[i]+','+ lon[i] + ' style="color:blue" target="_blank">길찾기</a></div>'
   	
 
		var infowindow = new kakao.maps.InfoWindow({
		      map: map, 
		      position : new kakao.maps.LatLng(lat[i]+0.02, lon[i]+0.01), 
		      content : iwContent,
		      removable : true
		     
		});

		 
		infowindows.push(infowindow); // 생성된 infowindow 를 배열에 담기
}


//배열에 추가된 infowindow 들을 지도에 표시하거나 삭제하는 함수입니다
function setInfowindows(map) {
    for (var i = 0; i < infowindows.length; i++) {
    	infowindows[i].setMap(map);
    }            
}

// 마커를 생성하고 지도위에 표시하는 함수입니다
function addMarker(position) {
    
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        position: position
        
    });    
    marker.setMap(map); // 마커가 지도 위에 표시되도록 설정합니다    
    markers.push(marker); // 생성된 마커를 배열에 추가합니다
  //마커에 마우스오버 이벤트를 등록합니다
    kakao.maps.event.addListener(marker, 'mouseover', function() {
    // 마커에 마우스오버 이벤트가 발생하면 인포윈도우를 마커위에 표시합니다
     infowindow.open(map, marker);

     
    });
    infowindow.close();
     /*
       마커에 마우스아웃 이벤트를 등록합니다
       kakao.maps.event.addListener(marker, 'mouseout', function() {
        마커에 마우스아웃 이벤트가 발생하면 인포윈도우를 제거합니다
       
      });
    */    
}

// 배열에 추가된 마커들을 지도에 표시하거나 삭제하는 함수입니다
function setMarkers(map) {
    for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(map);
        
    }            
}

// "마커 보이기" 버튼을 클릭하면 호출되어 배열에 추가된 마커를 지도에 표시하는 함수입니다
function showMarkers() {
    setMarkers(map)
    setInfowindows(map)
}

// "마커 감추기" 버튼을 클릭하면 호출되어 배열에 추가된 마커를 지도에서 삭제하는 함수입니다
function hideMarkers() {
    setMarkers(null);
    setInfowindows(null)
}

function onLoadOK(){
	setInfowindows(null)
}

</script>

</body>
</div>
</section>
<%@ include file="../include/bottom.jsp" %>

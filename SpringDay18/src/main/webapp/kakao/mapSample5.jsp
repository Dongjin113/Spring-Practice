<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>


<section>
<br>
<div align="center">
<body>
<div id="map" style="width:90%;height:550px;"></div>
<p>
    <button onclick="hideMarkers()">마커 감추기</button>
    <button onclick="showMarkers()">마커 보이기</button>
</p> 
<em>클릭한 위치에 마커가 표시됩니다!</em>
    
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2fb9031d27e12ecf3383c962c58416cd"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
    mapOption = { 
        center: new kakao.maps.LatLng(35.2382905, 128.692398), // 지도의 중심좌표
        level: 6 // 지도의 확대 레벨   35.2382905 128.692398(경남도청)
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 지도에 표시된 마커 객체를 가지고 있을 배열입니다
var markers = [];

// 마커 하나를 지도위에 표시합니다 

var title = ['경남도청','용지호수공원']           
var lat = [35.2382905,35.233151] 
var lon = [128.692398,128.679541]

for (i=0 ; i <= 1 ; i++ ){
  addMarker(new kakao.maps.LatLng(lat[i], lon[i]));
  
//인포윈도우를 생성하고 지도에 표시합니다
	var iwContent = ' <div style="padding:5px;"> '+ title[i] +' <br> ' 
		iwContent =iwContent + ' <a href=https://map.kakao.com/link/map/'+ title[i] +','+lat[i]+','+ lon[i] + ' style="color:blue" target="_blank">큰지도보기</a> , '
		iwContent =iwContent + ' <a href=https://map.kakao.com/link/to/'+ title[i] +','+lat[i]+','+ lon[i] + ' style="color:blue" target="_blank">길찾기</a></div>'
   
var infowindow = new kakao.maps.InfoWindow({

      map: map, 
      position : new kakao.maps.LatLng(lat[i]+0.002, lon[i]+0.001), 
      content : iwContent,
      removable : true
  });
  
}

// 마커를 생성하고 지도위에 표시하는 함수입니다
function addMarker(position) {
    
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        position: position

    });

    // 마커가 지도 위에 표시되도록 설정합니다
    marker.setMap(map);
    
    // 생성된 마커를 배열에 추가합니다
    markers.push(marker);
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

}

// "마커 감추기" 버튼을 클릭하면 호출되어 배열에 추가된 마커를 지도에서 삭제하는 함수입니다
function hideMarkers() {
    setMarkers(null);    

}
</script>


</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>
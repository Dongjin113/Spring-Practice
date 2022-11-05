<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>


<section>
<br>
<div align="center">
<h2> 카카오 지도 연습 1 </h2>

<!-- 지도를 표시할 div 입니다 -->
<div id="map" style="width:95%;height:450px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2fb9031d27e12ecf3383c962c58416cd"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(${m1}, ${m2}), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨  // 학원주소 :   37.48445671,126.93003738
    };

// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption); 
</script>

</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>
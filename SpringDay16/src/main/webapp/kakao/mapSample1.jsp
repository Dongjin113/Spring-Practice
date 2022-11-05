<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>
<section>
<div align="center">
<br>
<h2> 카카오 지도 연습1
</h2>

<div id="map" style="width:80%;height:450px;"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=	bf02fe9c128963727a9179a7e0661bba"></script>
	<script>
		var container = document.getElementById('map'); //지도를 표시할 div
		var options = {
			center: new kakao.maps.LatLng(${m1},${m2}), //지도의 중심좌표 학원주소37.484875, 126.929772
			level: 3 // 지도의 확대 레벨
		};

		var map = new kakao.maps.Map(container, options);
	</script>

</div>
</section>
<%@ include file="../include/bottom.jsp" %>

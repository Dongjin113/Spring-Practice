<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>

<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="http://code.highcharts.com/highcharts.js"></script> 
<script src="http://code.highcharts.com/modules/data.js"></script>     

<section>
<br>
<div align="center">
<h2> 과목별 중간, 기말 (평균성적)  </h2>

<table border=1 width=700>
<tr align="center"> 
 <th > 순번 </th> <th > 과목코드 </th> <th> 과목명 </th>
 <th> 중간평균 </th><th> 기말평균 </th>
</tr>
<c:forEach  items="${li}"  var="m"  varStatus="status" >

<tr align="center"> 
 <td> ${status.count} </td>
 <td> ${m.cno}</td>
 <td> ${m.cname} </td>
 <td> ${m.midtermdouble} </td>
 <td> ${m.finaldouble} </td>
 </tr>
</c:forEach>
</table>

</div>

    <div id=body1>
	 <div id = hidden style="display:none" > 
	 <!-- 표는 숨겨준다.!!  -->
		 <table border=1  width=700  id='datatable' >
		
		    <tr><td> 과목명 </td>  <td> 중간평균 </td> <td> 기말평균 </td></tr> 
           <c:forEach  items="${li}"  var="m"   >
		    <tr><td> ${m.cname}</td> <td> ${m.midtermdouble} </td> <td> ${m.finaldouble}</td> </tr>
		  </c:forEach>
		</table>
	</div>
</div>
<br>
<div id="container" style="width: 700px; height: 350px; margin: 0 auto;"></div>
<script language="JavaScript">
$(document).ready(function() { 
   var data = {
      table: 'datatable'
   };
   var chart = {
      type: 'column'
   };
   var title = {
      text: '과목별 평균점수'   
   };      
   var yAxis = {
      allowDecimals: false,
      title: {
         text: '과목별점수'
      }
   };
   var tooltip = {
      formatter: function () {
         return '<b>' + this.series.name + '</b><br/>' +
            this.point.y + ' ' + this.point.name.toLowerCase();
      }
   };
   var credits = {
      enabled: false
   };  
      
   var json = {};   
   json.chart = chart; 
   json.title = title; 
   json.data = data;
   json.yAxis = yAxis;
   json.credits = credits;  
   json.tooltip = tooltip;  
   $('#container').highcharts(json);
});
</script>

<br>
</section>
<%@ include file="../include/bottom.jsp" %>
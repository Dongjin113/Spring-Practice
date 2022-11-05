<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>
<section>
<br>
<div align="center">
<h2> 과목별 평균성적  </h2>

<table border=1 width=700>
<tr align="center"> 
<th > 순번</th> <th > 과목명</th> <th > 과목번호 </th> <th > 과목학점 </th> <th> 중간평균</th><th> 기말평균 </th>
</tr>
<c:forEach  items="${li}"  var="m"  varStatus="status" >


<tr align="center"> 
 <td> ${status.count} </td>
 <td> ${m.cname}</a> </td>
 <td> ${m.cno}</a> </td>
 <td> ${m.credit}</a> </td>
 <td> ${m.midavg} </td>
 <td> ${m.finalavg}</td>
 </tr>
</c:forEach>



</table>

</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>
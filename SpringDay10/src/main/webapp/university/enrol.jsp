<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>
<section>
<br>
<div align="center">
<h2> 과목목록보기  </h2>

<table border=1 width=700>
<tr align="center"> 
 <th > 순번 </th> <th > 학번 </th> <th> 과목명 </th>
  <th> 학점 </th> <th> 중간점수</th><th> 기말점수 </th>
</tr>
<c:forEach  items="${li}"  var="m"  varStatus="status" >


<tr align="center"> 
 <td> <a href="delete.do?sno=${m.sno}&cno=${m.cno}">${status.count}</a> </td>
 <td> <a href="enroledit.do?sno=${m.sno}&cno=${m.cno}">${m.sno}</a> </td>
 <td> ${m.cno} </td>
 <td> ${m.grade}</td>
 <td> ${m.midterm} </td>
 <td> ${m.finalstr} </td>
 </tr>
</c:forEach>



</table>

</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>
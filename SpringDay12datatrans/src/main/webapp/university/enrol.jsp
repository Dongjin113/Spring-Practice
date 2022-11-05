<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>
<section>
<br>
<div align="center">
<h2> 학생성적목록  </h2>

<table border=1 width=700>
<tr align="center"> 
 <th > 순번 </th> <th > 학번 </th> <th> 과목코드 </th>
  <th> 학점 </th> <th> 중간성적 </th><th> 기말성적 </th>
</tr>
<c:forEach  items="${li}"  var="m"  varStatus="status" >

<tr align="center"> 
 <td> ${status.count} </td>
 <td> <a href=enrolEdit.do?sno=${m.sno}&cno=${m.cno}>${m.sno}</a> </td>
 <td> ${m.cno}</td>
 <td> ${m.grade} </td>
 <td> ${m.midterm} </td>
 <td> ${m.finalstr} </td>
 </tr>
</c:forEach>
</table>

</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>
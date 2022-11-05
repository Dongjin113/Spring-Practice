<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>
<section>
<br>
<div align="center">
<h2> 학생목록보기  </h2>

<table border=1 width=700>
<tr align="center"> 
 <th > 순번 </th> <th > 학번 </th> <th> 이름 </th>
  <th> 학년 </th> <th> 학과 </th>
</tr>
<c:forEach  items="${li}"  var="m"  varStatus="status" >


<tr align="center"> 
 <td> ${status.count} </td>
 <td> ${m.sno} </td>
 <td> <a href="getstudent.do?sno=${m.sno}">${m.sname}</a></td>
 <td> ${m.year} </td>
 <td> ${m.dept} </td>
 </tr>
</c:forEach>



</table>

</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>
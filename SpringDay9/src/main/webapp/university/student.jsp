<%@ page language="java"      contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>

<section>
<br><br>
<h2 align=center>학생 목록보기</h2>
<div align=center>
<table border=1 width=500>
<tr align="center"> 
<th > 학번 </th>
 <th > 이름</th> <th> 학년</th> <th> 학과</th>
 
</tr>
<c:forEach  items="${li}"  var="m"  varStatus="status">

<tr align="center"> 
 <td> ${m.sno}</td>
 <td> ${m.sname} </td>
 <td> ${m.year} </td>
 <td> ${m.dept} </td>
 
</tr>
</c:forEach>

</table>
</div>
</section>
<%@ include file="../include/bottom.jsp" %>
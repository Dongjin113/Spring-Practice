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
 <th > 순번 </th> <th > 과목번호 </th> <th> 과목명 </th>
  <th> 학점 </th> <th> 개설학과 </th><th> 담당교수 </th>
</tr>
<c:forEach  items="${li}"  var="m"  varStatus="status" >


<tr align="center"> 
 <td> ${status.count} </td>
 <td> <a href="courseedit.do?cno=${m.cno}">${m.cno}</a> </td>
 <td> ${m.cname}</td>
 <td> ${m.credit} </td>
 <td> ${m.dept} </td>
 <td> ${m.prname} </td>
 </tr>
</c:forEach>

</table>

</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>
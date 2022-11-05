<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>

<section>
<br>
<div align="center">
<h2> 회원목록보기  <A href="<%=path%>/login/form.jsp" > (회원등록) </A> </h2>
 
<table border=1 width=500>
<tr align="center"> 
 <th > 번호 </th> <th> 아이디 </th> <th> 이름 </th>
 <th> 권한 </th> 
</tr>
<c:forEach  items="${li}"  var="m"  varStatus="status">

<tr align="center"> 
 
 <td> ${status.count} </td>
 <td> <a href="<%=path%>/editUser.do?id=${m.id}">${m.id}</a> </td>
 <td> ${m.name} </td>
 <td> ${m.role} </td>
 
</tr>
</c:forEach>

</table>

</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>
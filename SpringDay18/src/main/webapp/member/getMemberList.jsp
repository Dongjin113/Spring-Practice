<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/top.jsp" %>
<section>
<br>
<div align="center">
<h2> 회원목록보기 (<a href="<%=path%>/member/MemberForm.jsp">회원가입</a>)  </h2>

<table border=1 width=700>
<tr align="center"> 
 <th > 아이디 </th> <th> 암호 </th> <th> 이름 </th>
 <th> 권한 </th> <th> 전화 </th> 
 
</tr>
<c:forEach  items="${li}"  var="m"   >

<tr align="center"> 
 
 <td><a href="<%=path %>/MemberEdit.do?id=${m.id}" > ${m.id} </a> </td>
 <td> ${m.pwd}  </td>
 <td> ${m.name}  </td>
 <td> ${m.role}  </td>
 <td> ${m.tel} </td>
 </tr>
 
</c:forEach>


</table>

</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/top.jsp" %>
<section>
<br>
<div align="center">
<h2>자료실 목록보기 <a href="<%=path%>/member/MemberForm.jsp">(회원가입)</a> </h2>

<table border=1 width=700>
<tr align="center"> 
 <th > 아이디 </th> <th> 암호 </th> <th> 이름 </th>
 <th> 권한 </th> <th> 전화 </th> <th> 삭제 </th>
 
</tr>
<c:forEach  items="${li}"  var="m"   >

<tr align="center"> 
 
 <td> <a href="edit.do?id=${m.id}">${m.id}</a> </td>
 <td> ${m.pwd}</td>
 <td> ${m.name} </td>
 <td> ${m.role}  </td>
 <td> ${m.tel} </td>
 <td><button>삭제</button></td>
 </tr>
 
</c:forEach>
</table>

<form action="<%=path %>/MemberList.do">
<select name="searchkey">
<option value="name">이름</option>
<option value="role">권한</option>
</select>
<input type=text name=search>
<input type=submit value="검색하기">
</form>

</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>
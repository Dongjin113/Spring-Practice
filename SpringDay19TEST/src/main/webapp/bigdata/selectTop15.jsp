<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>
<section>
<br>
<div align="center">
<h2> 빅데이터 상위15 목록보기  </h2>

<table border=1 width=700>
<tr align="center"> 
 <th> 순번 </th><th > 번호 </th> <th > 생일 </th> <th> 성씨 </th> <th> 이름 </th>
 <th> 성별 </th> <th> 입사일 </th> 
</tr>
<c:forEach  items="${li}"  var="m"  varStatus="status" >

<tr align="center"> 
 <td> ${status.count} </td>
 <td> ${m.emp_no} </td>
 <td> ${m.birth_date} </td>
 <td> ${m.first_name} </td>
 <td> ${m.last_name} </td>
 <td> ${m.gender} </td>
 <td> ${m.hire_date} </td>
 </tr>
</c:forEach>

</table>
<form action="<%=path %>/selectTop15.do">
 <select name=searchCondition >
   <option value="birth_date" >생년월일</option>
   <option value="first_name" >성씨</option>
   <option value="last_name"  >이름</option>
 </select>
 <input  type=text  name="searchKeyword">
 <input  type=submit  value="검색하기">
</form>

</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>
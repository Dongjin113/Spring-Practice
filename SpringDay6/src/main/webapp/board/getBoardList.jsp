<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>

<section>
<br>
<div align="center">
<h2>  목록보기 </h2>
 
<table border=1 width=700>
<tr align="center"> 
 <th > 번호 </th> <th> 제목 </th> <th> 작성자 </th>
 <th> 등록일 </th> <th> 조회수(D) </th>
</tr>
<c:forEach  items="${li}"  var="m">

<tr align="center"> 
 <td> ${m.seq} </td>
 <td align="left"> <a href="<%=path%>/getBoard.do?seq=${m.seq}" >
       &nbsp;<font color=#000000> ${m.title}</font>
      </a> 
 </td>
 <td>  ${m.writer} </td>
 <td>  ${m.regDate} </td>
 <td> <a href="<%=path%>/deleteBoard.do?seq=${m.seq}" ><font color=#000000> ${m.cnt}</font> </a> </td>
</tr>
</c:forEach>

</table>
<form action="<%=path%>/getBoardList.do">
 <select name=searchCondition>
   <c:forEach  items="${conditionMap}"  var="option">
   <option value="${option.value}"> ${option.key} </option>
   </c:forEach>
 </select>
 <input  type=text name=searchKeyword >
 <input  type=submit  value="검색하기" >
</form>

</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>
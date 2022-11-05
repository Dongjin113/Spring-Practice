<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/top.jsp" %>
<section>
<br>
<div align="center">
<h2>자료실 목록보기 <a href="<%=path%>/psdBoard/psdForm.jsp">(자료저장)</a> </h2>

<table border=1 width=700>
<tr align="center"> 
 <th > 번호 </th> <th> 이미지</th> <th> 제목 </th>
 <th> 작성자(삭제) </th> <th> 날짜 </th> <th> 조회수 </th>
 
</tr>
<c:forEach  items="${li}"  var="m"   >

<tr align="center"> 
 
 <td> ${m.seq} </td>
 <td> <img src="<%=path %>/psdBoard/files/${m.updateFilestr}" width=50  height=50 /> </td>
 <td> <a href="psdBoard.do?seq=${m.seq}"> ${m.title}</a>  </td>
 <td>
  <a href="deletePsd.do?seq=${m.seq}"> ${m.writer}</a> 
  </td>
 <td> ${fn:substring(m.regdatestr,0,10)}  </td>
 <td> ${m.cnt} </td>
 </tr>
 
</c:forEach>


</table>

</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>
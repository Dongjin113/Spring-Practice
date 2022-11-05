<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>
<section>
<br>
<div align="center">
<h2> 학생성적목록  </h2>

<table border=1 width=900>

<tr align="center"> 
 <th > 순번 </th> <th > 학번 </th> <th> 이름 </th>
 <th> 학년 </th> <th> 학과 </th> <th> 과목코드 </th> 
 <th> 과목이름 </th><th> 개설학과 </th> <th> 담당교수 </th>
 <th> 과목학점 </th> <th> 평점 </th><th> 중간성적 </th><th> 기말성적 </th>
</tr>

<c:forEach  items="${li}"  var="m"  varStatus="status" >

<tr align="center"> 
 <td> ${status.count} </td>
 <td> ${m.sno} </td>
 <td> ${m.sname} </td>
 <td> ${m.year} </td>
 <td> ${m.sdept} </td>
 <td> ${m.cno}</td>
 <td> ${m.cname}</td>
 <td> ${m.cdept}</td>
 <td> ${m.prname}</td>
 <td> ${m.credit}</td>
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
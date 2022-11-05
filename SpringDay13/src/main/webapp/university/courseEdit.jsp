<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>

<section>
<br>
<div align="center">
<h2> 학생등록하기  </h2>
<form action=""  method=get>
<table border=1>
<tr> <td>과목번호 </td> <td> <input  type=text  name=sno    value="${m.cno}" > </td> </tr>
<tr> <td>과목명 </td> <td> <input  type=text  name=sname  value="${m.cname}" > </td> </tr>
<tr> <td>학점 </td> <td> <input  type=text  name=year   value="${m.credit}" > </td> </tr>
<tr> <td>개설학과 </td> <td> <input  type=text  name=dept   value="${m.dept}" > </td> </tr>
<tr> <td>담당교수 </td> <td> <input  type=text  name=dept   value="${m.prname}" > </td> </tr>
</table>
</form>

<hr>
  
</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>
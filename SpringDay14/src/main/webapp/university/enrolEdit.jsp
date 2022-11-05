<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>
<section>
<br>
<div align="center">
<h2> 학생성적 수정하기  </h2>
<form action="<%=path%>/enrolUpdate.do"  method=post>
<table border=1>
<tr> <td>학번 </td> <td> <input  type=text  name=sno    value="${m.sno}" > </td> </tr>
<tr> <td>과목코드 </td> <td> <input  type=text  name=cno  value="${m.cno}" > </td> </tr>
<tr> <td>평점 </td> <td> <input  type=text  name=grade   value="${m.grade}" > </td> </tr>
<tr> <td>중간성적 </td> <td> <input  type=text  name=midterm   value="${m.midterm}" > </td> </tr>
<tr> <td>기말성적 </td> <td> <input  type=text  name=finalstr   value="${m.finalstr}" > </td> </tr>
<tr>  <td colspan=2  align="center"> <input type=submit  value="학생성적수정"> </td> </tr>
</table>

</form>

  
</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>
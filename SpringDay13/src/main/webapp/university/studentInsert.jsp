<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>
<section>
<br>
<div align="center">
<h2> 학생등록하기  </h2>
<form action="<%=path%>/studentInsert.do"  method=post>
<table border=1>
<tr> <td>학번 </td> <td> <input  type=text  name=sno> </td> </tr>
<tr> <td>이름 </td> <td> <input  type=text  name=sname> </td> </tr>
<tr> <td>학년 </td> <td> <input  type=text  name=year> </td> </tr>
<tr> <td>학과 </td> <td> <input  type=text  name=dept> </td> </tr>
<tr>  <td colspan=2  align="center"> <input type=submit  value="학생등록"> </td> </tr>
</table>

</form>

  
</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>
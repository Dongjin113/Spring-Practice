<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>
<section>
<br>
<div align="center">
<h2> 학생성적등록하기  </h2>
<form action="<%=path%>/enrolInsert.do"  method=post>
<table border=1>

<tr> <td>학번 </td> <td> <input  type=text  name=sno  value="${sno}"> </td> </tr>
<tr> <td>과목코드 </td>
     <td>
      <select name=cno> 
        <c:forEach items="${li}"  var="c"  >
        <option value="${c.cno}" > ${c.cname}  </option>
        </c:forEach> 
      </select>
     </td>
</tr>
<tr> <td>학점 </td> <td> <input  type=text  name=grade> </td> </tr>
<tr> <td>중간성적 </td> <td> <input  type=text  name=midterm> </td> </tr>
<tr> <td>기말성적 </td> <td> <input  type=text  name=finalstr> </td> </tr>
<tr>  <td colspan=2  align="center"> <input type=submit  value="학생등록"> </td> </tr>
</table>

</form>

  
</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>
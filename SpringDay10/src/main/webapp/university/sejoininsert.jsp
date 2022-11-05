<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>
<section>
<br>
<div align="center">
<h2> 학생 성적 입력하기</h2>

<form action="<%=path%>/editstudent.do">
<table border=1 >
<tr> <td > 학번 </td><td > <input type=text name=sno value=${m.sno}>  </td> </tr>
<tr> <td> 이름 </td> <td > <input type=text name=sname value=${m.sname}></td> </tr>
<tr> <td> 학년 </td><td > <input type=text  name=year value=${m.year}>  </td> </tr>
<tr> <td> 학과 </td> <td > <input type=text name=dept value=${m.dept}>  </td> </tr>
<tr> <td> 과목코드 </td> 
<td > 
 <select name=cno>
   <c:forEach  items="${li}"  var="li">
   <option value="${li.cno}"> ${li.cno} </option>
   </c:forEach>
 </select>
</td> 
</tr>`
<tr> <td> 성적 </td> <td > <input type=text name=grade>  </td> </tr>
<tr> <td> 중간성적 </td> <td > <input type=text name=midterm>  </td> </tr>
<tr> <td> 기말성적 </td> <td > <input type=text name=finalstr >  </td> </tr>
<tr> <td colspan=2  align="center"> <input type=submit value="성적입력하기"  > </td> </tr>

</table>
</form>
</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>
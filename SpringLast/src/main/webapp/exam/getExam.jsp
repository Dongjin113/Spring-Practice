<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>
<section>
<br>
<div align="center">
<h2> 학생성적 상세보기 </h2>

<form action="<%=path%>/updateExam.do">
<table border=1 >
<tr> <td > 번호 </td><td > <input type=text name="sno"  value="${m.sno}" >  </td> </tr>
<tr> <td> 이름 </td> <td > <input type=text name=sname  value="${m.sname}"  ></td> </tr>
<tr> <td> 국어 </td><td > <input type=text  name=kor  value="${m.kor}" >  </td> </tr>
<tr> <td> 영어 </td> <td > <input type=text name=eng  value="${m.eng}" >  </td> </tr>
<tr> <td> 수학 </td><td > <input type=text  name=math  value="${m.math}" > </td> </tr>
<tr> <td> 역사 </td><td > <input type=text  name=hist  value="${m.hist}" > </td> </tr>
<tr> <td colspan=2  align="center"> <input type=submit value="저장하기"  > </td> </tr>

</table>
</form>
</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>
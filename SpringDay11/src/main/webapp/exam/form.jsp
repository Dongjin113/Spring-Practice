<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>
<section>
<br>
<div align="center">
<h2> 학생성적 목록보기 </h2>

<form action="<%=path%>/insertExam.do">
<table border=1 >
<tr> <td > 번호 </td><td > <input type=text name="sno" >  </td> </tr>
<tr> <td> 이름 </td> <td > <input type=text name=sname ></td> </tr>
<tr> <td> 국어 </td><td > <input type=text  name=kor >  </td> </tr>
<tr> <td> 영어 </td> <td > <input type=text name=eng >  </td> </tr>
<tr> <td> 수학 </td><td > <input type=text  name=math > </td> </tr>
<tr> <td> 역사 </td><td > <input type=text  name=hist > </td> </tr>
<tr> <td colspan=2  align="center"> <input type=submit value="저장하기"  > </td> </tr>

</table>
</form>
</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>
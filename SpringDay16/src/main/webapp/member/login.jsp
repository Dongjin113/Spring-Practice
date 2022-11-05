<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>

<% String str = (String) session.getAttribute("F");%>


<script>


if(str == "F"){
 alert("로그인 실패");	
}


function idck(){
	if(f1.id.value==""){
	alert("아이디를 입력해주세요!!");
	f1.id.focus();
	return false;
	}
}


</script>
<section>
<br>
<div align="center">
<h2> 로그인하기 </h2>

<form name=f1 action="<%=path%>/login.do" 
method=post onSubmit="return idck()">
<table border=1 >
<tr> <td > 아이디 </td><td > <input type=text name=id >  </td> </tr>
<tr> <td> 이름 </td> <td > <input type=text name=pwd ></td> </tr>
<tr> <td colspan=2  align="center"> <input type=submit value="저장하기"  > </td> </tr>

</table>
</form>
</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>
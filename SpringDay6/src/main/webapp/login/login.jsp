<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>

<Script>
 function  ck(){
   if(f1.id.value==""){
	   alert("아이디를 입력해 주세요");
	   f1.id.focus();
	   return  false;
   }	 
 }
 
</Script>

<section>
<br>
<div align="center">
<h2> 회원 로그인 </h2>
 
<form name="f1" action="<%=path%>/login.do" 
onSubmit="return ck()"   method=post  >
<table border=1 >

<tr> <td> 아이디</td><td> <input  type=text  name=id>  </td> </tr>
<tr> <td> 암호 </td> <td><input  type=text  name=password>  </td> </tr>
<tr> <td colspan=2 align="center" >
     <input  type=submit  value="로그인" >  </td> 
</tr>

</table>
</form>
</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>
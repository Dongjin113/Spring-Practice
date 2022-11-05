<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>

<style>
 a:link, a:visited{
    color: #000000; text-decoration:none;
 } 
       
 table {
    width:500px;  
    height:300px;  
 }

</style>

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
<h2> 회원상세보기 </h2>
 
<form name="f1" action="<%=path%>/updateUser.do" onSubmit="return ck()"  >

<table border=1  >

<tr> <td> 아이디 </td> <td> <input  type=text  name=id value="${m.id}" >  </td> </tr>
<tr> <td> 암호 </td> <td> <input  type=text  name=password value="${m.password}" > </td> </tr>
<tr> <td> 이름 </td> <td> <input  type=text  name=name value="${m.name}" >  </td> </tr>
<tr> <td> 권한 </td> <td> <input  type=text  name=role value="${m.role}" > </td> </tr>
<tr> <td colspan=2 align="center" > <input  type=submit  value="수정하기" >  </td> </tr>

</table>
</form>

<hr  width=80%>
&emsp; <a href="<%=path %>/login/form.jsp">회원등록</a>
&emsp; <a href="<%=path %>/selectUser.do">회원목록</a>
&emsp; <a href="<%=path %>/deleteUser.do?id=${m.id}">삭제하기</a>

</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>
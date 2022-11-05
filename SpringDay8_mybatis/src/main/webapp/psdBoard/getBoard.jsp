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
   if(f1.title.value==""){
	   alert("제목을 입력해 주세요");
	   f1.title.focus();
	   return  false;
   }	 
 }
 
</Script>

<section>
<br>
<div align="center">
<h2> 게시글 상세보기 </h2>
 
<form name="f1" action="<%=path%>/updatePsd.do" 
      method=post  enctype="multipart/form-data"
      onSubmit="return ck()"  >

<input  type=hidden  name=seq  value="${m.seq}">

<table border=1  >

<tr> <td> 제목 </td> <td> <input  type=text  name=title value="${m.title}" >  </td> </tr>
<tr> <td> 글쓴이 </td> <td> ${m.writer} </td> </tr>
<tr> <td> 내용 </td> <td>
 <textarea cols=35  rows=8 name=content>${m.content}</textarea> 
 <img  src="<%=path %>/psdBoard/files/${m.updateFileStr}" width=100  height=120  />
 </td> </tr>
<tr> <td> 날짜 </td> <td> ${m.regDate} </td> </tr>
<tr> <td> 조회수 </td> <td> ${m.cnt} </td> </tr>
<tr> <td> 업로드 </td> <td><input  type=file  name=updateFile>  </td> </tr>
<tr> <td colspan=2 align="center" > <input  type=submit  value="수정하기" >  </td> </tr>

</table>
</form>

<hr  width=80%>
&emsp; <a href="<%=path %>/psdBoard/form.jsp">자료등록</a>
&emsp; <a href="<%=path %>/getPsdList.do">자료목록</a>
&emsp; <a href="<%=path %>/deletePsd.do?seq=${m.seq}">자료삭제</a>

</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>
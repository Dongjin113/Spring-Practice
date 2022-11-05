<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>

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
<h2> 게시판 글 등록하기 </h2>
 
<form name="f1" action="<%=path%>/insertBoard.do" onSubmit="return ck()"  >
<table border=1 >

<tr> <td> 제목 </td> <td> <input  type=text  name=title>  </td> </tr>
<tr> <td> 글쓴이 </td> <td><input  type=text  name=writer>  </td> </tr>
<tr> <td> 내용 </td> <td> <textarea cols=40  rows=5 name=content></textarea>  </td> </tr>
<tr> <td colspan=2 align="center" > <input  type=submit  value="저장하기" >  </td> </tr>

</table>
</form>
</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>
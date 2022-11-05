<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<br><br>
<h1> 글 상세  </h1>
<a href=logout.do> Log-out </a>
<hr />

<form action=updateBoard.do  method=get>
  <input type="hidden"  name="seq"  value="${m.seq}" > 
  <table border=1>
  <tr><td>제목  </td><td><input type="text"  name="title"  value="${m.title}" >   </td></tr> 
  <tr><td>작성자</td> <td> ${m.writer} </td></tr> 
  <tr><td>내용 </td> <td><textarea name=content cols=40 rows=10>${m.content}</textarea> </td></tr> 
  <tr><td>등록일 </td><td>${m.regdate} </td></tr> 
  <tr><td>조회수 </td><td>${m.cnt} </td></tr> 


  <tr><td colspan=2  align="center">
    <input type="submit"  value="글수정" > 
  
   </td></tr> 
  </table>

</form>
<hr />
<a href=insertBoard.jsp>글등록</a> &emsp;
<a href=deleteBoard.do?seq=${m.seq} >글삭제</a> &emsp;
<a href=getBoardList.do>글목록</a> &emsp;

</div>
</body>
</html>
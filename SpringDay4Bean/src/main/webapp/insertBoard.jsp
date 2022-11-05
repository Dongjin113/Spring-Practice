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
<h1> 글 등록  </h1>
<a href=logout.do> Log-out </a>
<hr />

<form action=insertBoard.do  method=get>
  <table border=1>
  <tr><td>제목  </td><td><input type="text"  name="title"  >   </td></tr> 
  <tr><td>작성자</td> <td><input type="text"  name="writer"  > </td></tr> 
  <tr><td>내용 </td> <td><textarea name=content cols=40 rows=10></textarea> </td></tr> 

  <tr><td colspan=2  align="center">
    <input type="submit"  value="새글등록" > 
  
   </td></tr> 
  </table>

</form>
<hr />

<a href=getBoardList.do>글목록</a> &emsp;

</div>
</body>
</html>
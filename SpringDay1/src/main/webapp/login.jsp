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
<h1>로그인</h1>
<hr />
<form action=Login_proc.jsp method=post>
<table border=1>
<tr><td>아이디</td><td><input type=text name="id" value="Test"></td></tr>
<tr><td>비밀번호</td><td><input type=text name="password" value="Test123"></td></tr>
<tr>
<td colspan=2 align="center"> 
<input type=submit value="로그인">
</td></tr>
</table>
</form>
<hr/>
</div>
</body>
</html>
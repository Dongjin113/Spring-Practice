<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<br><br>
<h1> 글목록 </h1>
<h3> 테스트님 환영합니다. <a href=logout.do>Log-out</a> </h3>

<!-- 검색 시작 -->
<table border=1 width=700>
<tr><td align="right">
<form action=getBoardList.do >
<select name="searchCondition">
<option value="title"> 제목 </option>
<option value="content"> 내용 </option>
</select>
<input  type=text  name="searchKeyword" >
<input  type=submit value="검색하기" >
</form>
</td></tr>
</table>
<table border=1 width=700>
<tr> 
 <th> 번호 </th> <th> 제목 </th> <th> 작성자 </th>
 <th> 등록일 </th> <th> 조회수 </th>
</tr>

<c:forEach items="${li} " var="m"> <!-- 배열값을 받아봄 -->
<tr> 
 <td> ${m.seq} </td>
 <td> <a href=getBoard.do?seq=${m.seq}>
        ${m.title}
      </a> 
 </td>
 <td>  ${m.writer} </td>
 <td>  ${m.regDate}</td> <td>  <${m.cnt} </td>
</tr>
</c:forEach>

</table>
<br>
<a href=insertBoard.jsp> 새글등록 </a>

</div>
</body>
</html>
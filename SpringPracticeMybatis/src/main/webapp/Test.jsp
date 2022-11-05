<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=1 width=500>
<tr align="center"> 
 <th > 번호 </th> <th> 이름 </th> <th> 국</th>
 <th> 영 </th> <th> 수 </th> <th> 사 </th> <th> 조회수 </th> 
</tr>
<c:forEach  items="${li}"  var="m"  varStatus="status">

<tr align="center"> 
 
 <td> ${m.sno} </td>
 <td> ${m.sname}</td>
 <td> ${m.kor} </td>
 <td> ${m.eng} </td>
 <td> ${m.math} </td>
 <td> ${m.hist} </td>
 <td> ${m.cnt} </td>
 
</tr>
</c:forEach>

</table>
</body>
</html>
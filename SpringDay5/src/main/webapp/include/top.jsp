<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c" %>
    
<%
  String path = request.getContextPath();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
header{
  height:70px;  line-height:70px ; background:blue; text-align:center ;
  color:#ffffff;
}
nav{
  height:40px;  line-height:40px; background:#00AAFF; color:#ffffff;

}
section{
    min-height:500px;  background:#CCCCCC;

}
footer{
  height:50px;  line-height:50px; background:#0077ff;   text-align:center; color:#ffffff;
}

a:link, a:visited{
  color: #ffffff; text-decoration:none;
}

</style>
</head>
<body>
<header> 
 <h2> Spring MVC 프레임워크 ver1.0 </h2>
</header>
<nav>
&emsp;
&emsp; <a href="<%=path %>/getBoardList.do">게시판</a>  


&emsp; <a href="<%=path %>/index.jsp">홈으로.</a>
</nav>
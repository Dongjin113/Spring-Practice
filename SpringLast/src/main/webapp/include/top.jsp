<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>    
<%@taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %> 
<%
  String path = request.getContextPath();
  String name = (String) session.getAttribute("name");
  String role = (String) session.getAttribute("role");

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
  height:50px;  line-height:50px; background:#0077ff;  
  text-align:center; color:#ffffff;
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
&emsp; <a href="<%=path %>/ajax/form.jsp">AJAX저장</a> 
&emsp; <a href="<%=path %>/getAjaxList.do">AJAX목록보기</a> 
&emsp; <a href="<%=path %>/getExamList.do">Exam</a>  
&emsp; <a href="<%=path %>/university.do">University</a> 
&emsp; <a href="<%=path %>/psdBoardList.do">자료실</a> 
&emsp; <a href="<%=path %>/kakao/index.jsp">카카오지도연습</a> 

&emsp; <a href="<%=path %>/MemberList.do">회원목록보기</a> 

&emsp; <a href="<%=path %>/ListPage.do">페이지나누기</a> 

<% if (name != null ) { %>
&emsp;&emsp;  <a href="<%=path %>/logout.do">로그아웃</a> 
<% } else {  %>
&emsp;&emsp;  <a href="<%=path %>/member/login.jsp">로그인</a> 
<% } %>


&emsp; <a href="<%=path %>/index.jsp">홈으로.</a>&emsp;&emsp;

<% if (name != null) { %>
  <b><%=name %></b>님 환영합니다.
<% }	%>

</nav>
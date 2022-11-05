<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>
<style>
a:link, a:visited{
  color: #000000; text-decoration:none;
}
</style>

<section>
<div align="center">
<br><br><br>

<h1> University 목록보기 </h1>
<br>
<a href=student.do> student목록보기 </a> <br><br>
<a href=course.do> course목록보기 </a> <br><br>
<a href=enrol.do> enrol목록보기 </a> <br><br>

<a href=join2.do> student&enrol목록보기 </a> <br><br>
<a href=join3.do> 전체 JOIN 목록보기 </a> <br><br>
</div>
</section>
<%@ include file="../include/bottom.jsp" %>
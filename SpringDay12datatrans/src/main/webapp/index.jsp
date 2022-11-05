<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="./include/top.jsp" %>
<section>
<div align="center">
<br><br><br>

<h1> 처음으로 ... </h1>
<br><br>
<a href=getExamList.do> Exam목록보기 </a> <br><br>

<a href=./psdBoard/psdForm.jsp> 자료저장하기 </a> <br><br>

<a href=selectTop15.do>빅데이터 상위 15</a> <br><br>

<hr>

<a href=dataTransList.do>JSON 변환 1-1</a> <br><br>
<a href=dataTransExam.do?sno=10103>JSON 변환 1-2</a> <br><br>


<hr>

<a href=dataTransList2.do>JSON 변환 2-1</a> <br><br>
<a href=dataTransExam2.do?sno=10103>JSON 변환 2-2</a> <br><br>

<hr>

<a href=apiEvinsert.do> XML 공공데이터 가져오기</a> <br><br>

<a href=apiEvinsert2.do> XML2 공공데이터 가져오기</a> <br><br>

<a href=apiEvinsert3.do> XML3 공공데이터 가져오기</a> <br><br>


<a href=apiEvinsert14.do> JSON 공공데이터 가져오기</a> <br><br>

<a href=apiEvinsert44.do> JSON 공공데이터 가져오기2</a> <br><br>




</div>
</section>
<%@ include file="./include/bottom.jsp" %>

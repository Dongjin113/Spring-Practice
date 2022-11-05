<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="./include/top.jsp" %>
<section>
<div align="center">
<br>
<h1> 처음으로 ... </h1>
<br>
<a href=getExamList.do> Exam목록보기 </a> <br>

<a href=./psdBoard/psdForm.jsp> 자료저장하기 </a> <br>

<a href=selectTop15.do> 빅데이터 상위15 </a> <br>

<hr>

<a href=dataTransList.do> JSON 변환 1-1 </a> <br>
<a href=dataTransExam.do?sno=10101> JSON 변환 1-2 </a> <br>

<hr>

<a href=dataTransList2.do> JSON 변환 2-1 </a> <br>
<a href=dataTransExam2.do?sno=10101> JSON 변환 2-2 </a> <br>

<hr>

<a href=apiEvinsert1.do> XML 공공데이터 가져오기1 </a> <br>
<a href=apiEvinsert2.do> XML 공공데이터 가져오기2 </a> <br>
<a href=apiEvinsert12.do> XML 공공데이터 가져오기12 </a> <br><br>

<a href=apiEvinsert14.do> JSON 공공데이터 가져오기 14(24시간 이내만 지원) </a><br>
<a href=apiEvinsert45.do> JSON 공공데이터 가져오기 45 </a><br>


</div>
</section>
<%@ include file="./include/bottom.jsp" %>
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
<br>
<div align="center">
<h2> 빅데이터 페이지나누기 목록보기  </h2>

전체레코드: ${totalCount} // 현재페이지${nowPage} / ${totalPage}  전체페이지 

<table border=1 width=700>
<tr align="center"> 
 <th> 순번 </th><th > 번호 </th> <th > 생일 </th> <th> 성씨 </th> <th> 이름 </th>
 <th> 성별 </th> <th> 입사일 </th> 
</tr>
<c:forEach  items="${li}"  var="m"  varStatus="status" >

<tr align="center"> 
 <td> ${status.count} </td>
 <td> ${m.emp_no} </td>
 <td> ${m.birth_date} </td>
 <td> ${m.first_name} </td>
 <td> ${m.last_name} </td>
 <td> ${m.gender} </td>
 <td> ${m.hire_date} </td>
 </tr>
</c:forEach>

</table>
<br>

  <c:url  value="ListPage.do"  var="url">
    <c:param name="startIdx"  value="1"   />
    <c:param name="searchCondition"  value="${searchCondition}"   />
    <c:param name="searchKeyword"  value="${searchKeyword}"   />
  </c:url>
 
  <a href="${url}" >처음으로</a>

   
  <c:if test="${startIdx > 1 }">
   <c:url  value="ListPage.do"  var="url">
    <c:param name="startIdx"  value="${startIdx-10} "   />
    <c:param name="searchCondition"  value="${searchCondition}"   />
    <c:param name="searchKeyword"  value="${searchKeyword}"   />
  </c:url>
  
   <a href="${url}"> 이전 </a> &emsp;
  </c:if>
  
  <c:if test="${startIdx == 1 }">
  이전 &emsp;
  </c:if>
  
 <c:if test="${nowPage < totalPage }">
  <a href="<%=path%>/ListPage.do?startIdx=${startIdx+10}&searchCondition=${searchCondition}&searchKeyword=${searchKeyword}"> 다음 </a> &emsp;
 </c:if>
 
 <c:if test="${nowPage == totalPage }">
 다음 &emsp;
 </c:if>
 
  <a href="<%=path%>/ListPage.do?startIdx=${endPage}&searchCondition=${searchCondition}&searchKeyword=${searchKeyword}">마지막</a>
 
</div>
<br>

<div align="center">
<form action="<%=path%>/ListPage.do">
<select  name= searchCondition>
  <option value="last_name" >이름 </option>
  <option value="gender" >성별 </option>
</select>
<input  type=text  name="searchKeyword" >
<input  type=submit value="검색하기"  >
</form>
</div>

</section>
<%@ include file="../include/bottom.jsp" %>
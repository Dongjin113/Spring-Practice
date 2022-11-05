<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>
<section>
<br>
<div align="center">
<h2> 학생성적 목록보기 <a href="<%=path%>/exam/form.jsp">(저장하기)</a> </h2>

<table border=1 width=700>
<tr align="center"> 
 <th > 순번 </th> <th > 번호 </th> <th> 이름 </th> <th> 국어 </th>
 <th> 영어 </th> <th> 수학 </th> <th> 역사 </th>
 <th> 합계 </th><th> 평균 </th><th> 평균1 </th>
 <th> 조회수 </th>
</tr>
<c:forEach  items="${li}"  var="m"  varStatus="status" >

<c:set var="sum"  value="${m.kor + m.eng + m.math + m.hist}" />
<c:set var="avg"  value="${sum / 4}" />
<c:set var="ksum"  value="${ksum + m.kor}" />
<c:set var="esum"  value="${esum + m.eng}" />
<c:set var="msum"  value="${msum + m.math}" />
<c:set var="hsum"  value="${hsum + m.hist}" />
<c:set var="ssum"  value="${ssum + sum}" />
<c:set var="asum"  value="${asum + avg}" />

<tr align="center"> 
 <td> ${status.count} </td>
 <td> ${m.sno} </td>
 <td> <a href=getExam.do?sno=${m.sno}>${m.sname}</a> </td>
 <td> ${m.kor} </td>
 <td> ${m.eng} </td>
 <td> ${m.math} </td>
 <td> ${m.hist} </td>
 <td> ${sum} </td>
 <td> ${avg} </td>
 <td> <fmt:formatNumber value="${avg}" pattern=".0" />  </td>
 <td><a href=deleteExam.do?sno=${m.sno}>${m.cnt}</a> </td>
 </tr>
</c:forEach>

<tr align="center"> 
 <td colspan=3 > 누적합 </td>

 <td> ${ksum} </td>
 <td> ${esum}  </td>
 <td> ${msum}  </td>
 <td> ${hsum}  </td>
 <td> ${ssum} </td>
 <td> ${asum} </td>
 <td> ${asum} </td>

 <td>
  </td>
 </tr>

</table>

</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>
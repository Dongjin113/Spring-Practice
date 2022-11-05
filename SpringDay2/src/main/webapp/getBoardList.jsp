<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.springbook.biz.board.impl.*"  %>
<%@ page import="com.springbook.biz.board.*"  %>
<%@ page import="java.util.*"  %>

<%
 String searchCondition=request.getParameter("searchCondition");
 String searchKeyword=request.getParameter("searchKeyword");

  BoardVo vo = new BoardVo();
  vo.setSearchCondition(searchCondition);
  vo.setSearchKeyword(searchKeyword);
  
  BoardDao   dao = new BoardDaoImpl();
  List<BoardVo> li = dao.getBoardList(vo);
%>
    
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
<h3> 테스트님 환영합니다. <a href=logout_proc.jsp>Log-out</a> </h3>

<!-- 검색 시작 -->
<table border=1 width=700>
<tr><td align="right">
<form action=getBoardList.jsp >
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

<% for(BoardVo m : li) {%>
<tr> 
 <td> <%=m.getSeq() %> </td> <td>  <%=m.getTitle() %> </td>
 <td>  <%=m.getWriter() %> </td>
 <td>  <%=m.getRegDate() %> </td> <td>  <%=m.getCnt() %> </td>
</tr>
<% } %>

</table>


</div>
</body>
</html>
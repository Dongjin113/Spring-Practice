<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.springbook.biz.*"  %>
<%@ page import="com.springbook.biz.board.impl.*"  %>
<%@ page import="com.springbook.biz.board.*"  %>

<%

   request.setCharacterEncoding("UTF-8");
   String title=request.getParameter("title");
   String writer=request.getParameter("writer");
   String content=request.getParameter("content");
  

   BoardVo vo = new BoardVo();
   vo.setTitle(title);
   vo.setWriter(writer);
   vo.setContent(content);
   
   BoardDao dao= new BoardDaoImpl();
   dao.insert(vo);

	   response.sendRedirect("getBoardList.jsp");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.springbook.biz.*"  %>
<%@ page import="com.springbook.biz.board.impl.*"  %>
<%@ page import="com.springbook.biz.board.*"  %>

<%

   request.setCharacterEncoding("UTF-8");
   int seq=Integer.parseInt(request.getParameter("seq"));
  

   BoardDao dao= new BoardDaoImpl();
   dao.delete(seq);

	   response.sendRedirect("getBoardList.jsp");
%>
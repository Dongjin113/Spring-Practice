<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.springbook.biz.user.impl.*"  %>
<%@ page import="com.springbook.biz.user.*"  %>

<%
   

session.invalidate();
response.sendRedirect("login.jsp");
%>
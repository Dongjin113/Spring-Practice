<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.springbook.biz.user.impl.*"%>
<%@ page import="com.springbook.biz.user.*"%>

<%
String id = request.getParameter("id");
String password = request.getParameter("password");
UserVo vo = new UserVo();
vo.setId(id);
vo.setPassword(password);

UserService service=new UserServiceImpl();
UserVo user = service.getUser(vo);
if(user != null){
	response.sendRedirect("getBoardList.jsp");
}else{
	response.sendRedirect("login.jsp");
}
%>
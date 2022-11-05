package com.springbook.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller{
	
	public LogoutController(){
		System.out.println("===>LogoutController");
	}

	@Override
	public String handRequest(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		
		System.out.println("로그아웃 처리"); 
		 session.invalidate();
		 
		return "login.jsp";
	}

}

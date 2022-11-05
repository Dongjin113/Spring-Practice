package com.springbook.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.user.UserVo;
import com.springbook.biz.user.impl.UserDao3;

public class LoginController implements Controller{
	
	public LoginController(){
		System.out.println("===>LoginController");
	}
	

	@Override
	public String handRequest(HttpServletRequest request, HttpServletResponse response) {
		
		 System.out.println("로그인 처리"); 
		 
		  String id=request.getParameter("id");
		  String password=request.getParameter("password");
		  

		   UserVo vo = new UserVo();
		   vo.setId(id);
		   vo.setPassword(password);
		   
		   UserDao3 service = new UserDao3();
		   UserVo user = service.getUser(vo);
		   
		   if(user != null){
				  return  "getBoardList.do";
			   }else{
				   return  "login.jsp";
			   }
		   
	}
	}
	



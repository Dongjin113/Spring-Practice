package com.springbook.view;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVo;


@Controller
public class LoginController {
	
	@Autowired 
	UserService  userService;  
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVo vo,  HttpSession session ) {
		System.out.println("로그인 화면으로 이동"); 	
				  		
		vo.setId("test");
		vo.setPassword("test123");
		
		/*
		session.setAttribute("id", "test");
		session.setAttribute("password", "test123");
		*/
		
		return"login.jsp" ;
		  	 
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVo vo ,  HttpSession session) {
		System.out.println("로그인 처리"); 
		
		   UserVo   user = userService.getUser(vo);
		  
		   if(user != null){
			  System.out.println("===> user.getName(): "  +user); 
			  session.setAttribute("userName", user.getName()) ;
			  return "getBoardList.do" ;
		   }else{
			  return"login.jsp" ;
		   }		 
	}


	@RequestMapping(value="/logout.do")
	public String logout( HttpSession session) {
		
		 System.out.println("로그아웃 처리");		 
		 session.invalidate();		 
				 
		return "login.jsp";
	}

}

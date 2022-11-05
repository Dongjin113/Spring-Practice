package com.springbook.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
// springframework 에서 사용하는 Controller
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.user.UserVo;
import com.springbook.biz.user.impl.UserDao3;

// 1.  Controller  변경
public class LoginController implements Controller  {
	public LoginController(){
		System.out.println("===>LoginController");
	}
	@Override   // 2. 리턴형을 ModelAndView 로 변경 
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인 처리"); 
		 
		  String id=request.getParameter("id");
		  String password=request.getParameter("password");
		  

		   UserVo vo = new UserVo();
		   vo.setId(id);
		   vo.setPassword(password);
		   
		   UserDao3 service = new UserDao3();
		   UserVo user = service.getUser(vo);

		   // 3. ModelAndView 로 변경하기 
		   ModelAndView  mav = new ModelAndView();
		   if(user != null){
			   mav.setViewName("redirect:getBoardList.do") ;
		   }else{
			   mav.setViewName("login") ;
		   }
		   return  mav ;
		   		
	}

}

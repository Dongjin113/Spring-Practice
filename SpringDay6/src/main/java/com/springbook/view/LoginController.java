package com.springbook.view;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.login.UserService;
import com.springbook.biz.login.UserVo;

@Controller
public class LoginController {

	@Autowired
	private UserService  service;
	
	@RequestMapping(value="/insertUser.do")
	String insert(UserVo vo ) {
		service.insert(vo);
		return "selectUser.do";
	}
	
	@RequestMapping(value="/updateUser.do")
	String update(UserVo vo ) {
		service.update(vo);
		return "selectUser.do";
	}
	
	@RequestMapping(value="/deleteUser.do")
	String delete(UserVo vo ) {
		service.delete(vo);
		return "selectUser.do";
	}
	
	@RequestMapping(value="/editUser.do")
	String edit(UserVo vo, Model  model ) {		
		model.addAttribute("m", service.getEdit(vo));
		return "/login/getUser.jsp";
	}
	
	@RequestMapping(value="/selectUser.do")
	String select(UserVo vo, Model  model ) {
		model.addAttribute("li", service.getSelect(vo));
		return "/login/getUserList.jsp";
	}
	
	@RequestMapping(value="/login.do")
	String login(UserVo vo, Model  model ,  HttpSession session ) {
		UserVo user = service.login(vo);
		
		if (user == null) {
			
			System.out.println("F확인");
			return "/login/login.jsp";	
			
		}else {
			
			System.out.println("T확인");
			session.setAttribute("name", user.getName());
			session.setAttribute("role", user.getRole());
			return "/index.jsp";
			
		}			
		
	}
	
	@RequestMapping(value="/logout.do")
	public String logout( HttpSession session) {
		
		 System.out.println("로그아웃 처리");		 
		 session.invalidate();		 
				 
		 return "/index.jsp";
	}
	
}

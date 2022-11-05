package com.springbook.view;


import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.member.BCrypt;
import com.springbook.biz.member.MemberService;
import com.springbook.biz.member.MemberVo;


@Controller
public class MemberController {

	@Autowired  
	private MemberService  service;
	
	@RequestMapping(value="/Memberinsert.do")
	public String Memberinsert( MemberVo vo ) {
			
		Date  today = new Date();
			
		String addr = vo.getPostcode() + " : " + vo.getRoadAddress() + " " + vo.getDetailAddress(); 
		
		String BC = BCrypt.hashpw(vo.getPwd(), BCrypt.gensalt());
		System.out.println("암호화" +BC);
		System.out.println("길이:" +BC.length());
		
		vo.setDate(today);
		vo.setAddr(addr) ;
		vo.setBcrypt(BC);
	
		vo.setRole("일반회원");
		
		service.insert(vo);
		
		return "MemberList.do";
	}
	
	@RequestMapping(value="/idChcek.do")
	public void idChcek( MemberVo vo, HttpServletResponse  response )
			throws Exception {
		
		MemberVo m =service.edit(vo);
		int str ; 
		if (m==null) {
			str=0;  // 사용가능 id
		}else {
			str=1;  // 중복 id
		}
		
		PrintWriter out = response.getWriter();
		out.println(str);			
	}
	
	@RequestMapping(value="/MemberList.do")
	public String MemberList( MemberVo vo, Model model ) 
			throws Exception {
		
		model.addAttribute("li", service.selectAll(vo));
		
		return "member/getMemberList.jsp";
		
		
	}
	
	@RequestMapping(value="/login.do")
	public String login( MemberVo vo, Model model, HttpSession session )
		throws Exception {
		
		MemberVo  m = service.login(vo);
		if (m==null) {
			session.setAttribute("sw", "F");
			return "member/login.jsp";
		}else {
			if (BCrypt.checkpw(vo.getPwd(), m.getBcrypt())) {
				session.setAttribute("sw", "T");
				session.setAttribute("name", m.getName());
				session.setAttribute("role", m.getRole());
				
				return "index.jsp" ;
				
			}else {
				session.setAttribute("sw", "F");
				return "member/login.jsp";
			}
		}
		
	}
	
	
	
	@RequestMapping(value="/logout.do")
	public String logout( HttpSession session) {
		
		 System.out.println("로그아웃 처리");		 
		 session.invalidate();		 
				 
		 return "member/login.jsp";
	}
	
	
	@RequestMapping(value="/MemberEdit.do")
	public String MemberEdit( MemberVo vo , Model  model )
			throws Exception {
		
		MemberVo m = service.edit(vo);  // 10107 : 우리집 
		String [] str = m.getAddr().split(":");
		m.setAddress1(str[0]);
		m.setAddress2(str[1]);
		model.addAttribute("m", m);
			
		return "member/MemberEdit.jsp";
				
	}
	
	@RequestMapping(value="/MemberUpdate.do")
	public String MemberUpdate( MemberVo vo , Model  model )
			throws Exception {
		
		Date  today = new Date();
		
		String addr = vo.getPostcode() + " : " + vo.getRoadAddress() + " " + vo.getDetailAddress(); 
		
		String BC = BCrypt.hashpw(vo.getPwd(), BCrypt.gensalt());
		
		vo.setDate(today);
		vo.setAddr(addr) ;
		vo.setBcrypt(BC);	
		vo.setRole("일반회원");
				
		service.update(vo);		
			
		return "MemberList.do";
				
	}
	
	
}

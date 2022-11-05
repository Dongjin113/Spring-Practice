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
		
		String BC= BCrypt.hashpw(vo.getPwd(), BCrypt.gensalt());
		System.out.println("암호화 : " + BC);
		System.out.println("길이 : "+BC.length());
		
		Date today = new Date();
		
		String addr = vo.getPostcode() + " , "+vo.getRoadAddress() + " , " +vo.getDetailAddress();
		
		
		vo.setBcrypt(BC);
		vo.setDate(today);
		vo.setAddr(addr);
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
	public String MemberList(Model model, MemberVo vo,HttpServletResponse response )
    throws Exception {
		System.out.println(vo.getSearchkey() +vo.getSearch());
		model.addAttribute("li", service.selectAll(vo));
	return "/member/getMemberList.jsp";
	}	
	
	
	@RequestMapping(value="/login.do")
	public String login(Model model, MemberVo vo, HttpSession session)
    throws Exception {

		MemberVo m = service.login(vo);
		if(m==null) { //존재하지않으면
			session.setAttribute("F", "F");
			return "/member/login.jsp";
		}else { //존재하면
			
			System.out.println("암호확인:" +m.getBcrypt() ); 
			
			if(BCrypt.checkpw(vo.getPwd(), m.getBcrypt())) {
				
				session.setAttribute("name", m.getName());
				session.setAttribute("role", m.getRole());
				return "index.jsp";
				
			}else {
				session.setAttribute("F", "F");
				return "member/login.jsp";
			}
			
		}
		
	}	
	
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session){
		session.invalidate();
	return "member/login.jsp";
	}	
	
	@RequestMapping(value="/edit.do")
	public String MemberEdit(Model model, MemberVo vo )
    throws Exception {
		
		MemberVo m = service.edit(vo);
		String [] str = m.getAddr().split(",");
		m.setAddress1(str[0]);
		m.setAddress2(str[1]);
		model.addAttribute("m", m);
		
	return "/member/getMember.jsp";
	}	

	
}
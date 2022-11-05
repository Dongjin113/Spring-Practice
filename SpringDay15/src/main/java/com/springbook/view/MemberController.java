package com.springbook.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.member.MemberService;
import com.springbook.biz.member.MemberVo;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@RequestMapping(value="/Memberinsert.do")
	public String list( MemberVo vo  ) {
		
		service.insert(vo);
		
		return "exam/getExamList.jsp";		
	}
	
	
}
package com.springbook.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.examtbl.ExamtblVo;
import com.springbook.biz.service.ExamtblService;



@Controller
public class ExamtblController {
	
	@Autowired
	private ExamtblService  service;
	
	@RequestMapping(value="/getBoardList.do")
	public String getselect( ExamtblVo vo , Model  model ) {
		 model.addAttribute("li", service. getselect(vo));
		return "Test.jsp";
}
}

package com.springbook.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.examtbl.ExamService;
import com.springbook.biz.examtbl.ExamtblVo;


@Controller
public class ExamController {
	
	@Autowired
	private ExamService  service;
	
	@RequestMapping(value="getExamList.do")
	public String list( Model  model, ExamtblVo vo  ) {
		
		model.addAttribute("li", service.getExamList(vo));
		
		return "exam/getExamList.jsp";		
	}
	
	@RequestMapping(value="getExam.do")
	public String getExam( Model  model, ExamtblVo vo  ) {
		service.cntExam(vo);
		model.addAttribute("m", service.getExam(vo));
		return "exam/getExam.jsp";		
	}
	
	
	@RequestMapping(value="insertExam.do")
	public String insertExam( ExamtblVo vo ) {				
		service.insertExam(vo);		
		return "getExamList.do";		
	}

	@RequestMapping(value="updateExam.do")
	public String updateExam( ExamtblVo vo ) {				
		service.updateExam(vo);		
		return "getExamList.do";		
	}
	@RequestMapping(value="deleteExam.do")
	public String deleteExam( ExamtblVo vo ) {				
		service.deleteExam(vo);		
		return "getExamList.do";		
	}

}

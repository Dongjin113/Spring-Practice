package com.springbook.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.examtbl.ExamtblVo;
import com.springbook.biz.university.CourseVo;
import com.springbook.biz.university.UniversityService;

@Controller
public class UniversityController {

	@Autowired
	private UniversityService  service;
	
	
	@RequestMapping(value="university.do")
	public String university() {		
		return "university/university.jsp";		
	}
	
	@RequestMapping(value="student.do")
	public String student( Model  model, ExamtblVo vo  ) {
		model.addAttribute("li", service.student());
		return "university/student.jsp";		
	}
	
	@RequestMapping(value="course.do")
	public String course( Model  model, CourseVo vo  ) {
		model.addAttribute("li", service.course());
		return "university/course.jsp";		
	}
}

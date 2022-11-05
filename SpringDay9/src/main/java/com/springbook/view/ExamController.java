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
	private ExamService service;
	
	@RequestMapping(value="getExamList.do")
	public String list(Model model, ExamtblVo vo) {
		model.addAttribute("li", service.getExamList(vo));
		
		return "exam/getExamList.jsp";
	}
	
	
	@RequestMapping(value="insertExam.do")
	public String insertExam(ExamtblVo vo) {
		service.insert(vo);
		return "getExamList.do";
	}
	
	@RequestMapping(value="editExam.do")
	public String getExam(Model model, ExamtblVo vo) {
		
		model.addAttribute("m", service.getExam(vo));
		
		return "exam/getExam.jsp";
	}
	
	@RequestMapping(value="updateExam.do")
	public String updateExam(ExamtblVo vo) {
		service.update(vo);
		return "getExamList.do";
	}
	@RequestMapping(value="delete.do")
	public String deleteExam(ExamtblVo vo) {
		service.delete(vo);
		return "getExamList.do";
	}
	
}

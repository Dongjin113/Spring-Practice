package com.springbook.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springbook.biz.examtbl.ExamService;
import com.springbook.biz.examtbl.ExamtblVo;


@Controller
public class ExamController1 {
	
	@Autowired
	private ExamService  service;
	
	@RequestMapping(value="dataTransList.do")
	@ResponseBody
	public List<ExamtblVo> dataTranslist( Model  model, ExamtblVo vo  ) {
		
		List<ExamtblVo> ExamList = service.getExamList(vo);
		
		return ExamList;		
	}
	
	@RequestMapping(value="dataTransExam.do")
	@ResponseBody
	public ExamtblVo dataTransgetExam( Model  model, ExamtblVo vo  ) {
		service.cntExam(vo);
		ExamtblVo	Exam = service.getExam(vo);
		return Exam;		
	}
		

}

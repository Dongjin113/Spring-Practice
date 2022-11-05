package com.springbook.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbook.biz.examtbl.ExamService;
import com.springbook.biz.examtbl.ExamtblVo;


@RestController
public class ExamController2 {
	
	@Autowired
	private ExamService  service;
	
	@RequestMapping(value="dataTransList2.do")
	public List<ExamtblVo> dataTranslist2( ExamtblVo vo  ) {		
		List<ExamtblVo> ExamList = service.getExamList(vo);		
		return ExamList;		
	}
	
	@RequestMapping(value="dataTransExam2.do")
	public ExamtblVo dataTransgetExam2( ExamtblVo vo  ) {		
		ExamtblVo	Exam = service.getExam(vo);
		return Exam;		
	}	

}

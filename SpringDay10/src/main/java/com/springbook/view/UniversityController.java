package com.springbook.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.examtbl.ExamtblVo;
import com.springbook.biz.university.AvgVo;
import com.springbook.biz.university.CourseVo;
import com.springbook.biz.university.EnrolVo;
import com.springbook.biz.university.SECJoinVo;
import com.springbook.biz.university.SEJoinVo;
import com.springbook.biz.university.StudentVo;
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
	
	@RequestMapping(value="enrol.do")
	public String enrol( Model  model, EnrolVo vo  ) {
		model.addAttribute("li", service.enrol());
		return "university/enrol.jsp";		
	}
	
	@RequestMapping(value="sejoin.do")
	public String enrol( Model  model, SEJoinVo vo  ) {
		model.addAttribute("li", service.SEJoin());
		return "university/sejoin.jsp";		
	}
	
	@RequestMapping(value="secjoin.do")
	public String enrol( Model  model, SECJoinVo vo  ) {
		model.addAttribute("li", service.SECJoin());
		return "university/secjoin.jsp";		
	}
	@RequestMapping(value="insertstudent.do")
	public String insertStudent(StudentVo vo) {
		service.insert(vo);
		return "student.do";		
	}
	@RequestMapping(value="studentInsert.do")
	public String studentinsert() {		
		return "university/studentInsert.jsp";		
	}
	@RequestMapping(value="getstudent.do")
	public String getstudent(Model model,StudentVo vo) {
		model.addAttribute("m", service.getstudent(vo));
		return "university/studentEdit.jsp";		
	}
	
	@RequestMapping(value="editstudent.do")
	public String edit(StudentVo vo) {
		service.edit(vo);
		return "student.do";		
	}
	
	@RequestMapping(value="getsejoin.do")
	public String getsejoin(Model model,StudentVo vo) {
		model.addAttribute("li", service.SECJoin());
		model.addAttribute("m", service.getstudent(vo));
		return "university/sejoininsert.jsp";		
	}
	
	@RequestMapping(value="enroledit.do", method=RequestMethod.GET)
	public String getenrol(Model model,EnrolVo vo) {
		model.addAttribute("m", service.getEnrol(vo));
		return "university/enroledit.jsp";			
	}
	@RequestMapping(value="editenrol.do")
	public String enroledit(EnrolVo vo) {
		service.enroledit(vo);
		return "enrol.do";		
	}
	
	@RequestMapping(value="enrolavg.do")
	public String enrolavg( Model  model, AvgVo vo  ) {
		model.addAttribute("li", service.enrolavg());
		return "university/enrolavg.jsp";		
	}
	
	@RequestMapping(value="delete.do")
	public String delete(EnrolVo vo) {
		service.delete(vo);
		return "enrol.do";		
	}
}

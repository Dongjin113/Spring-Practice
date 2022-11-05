package com.springbook.view;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.coursereply.CourseReplyService;
import com.springbook.biz.coursereply.CourseReplyVo;
import com.springbook.biz.reply.ReplyService;
import com.springbook.biz.reply.ReplyVo;
import com.springbook.biz.university.CourseGroupVo;
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
	
	@Autowired
	private ReplyService replyService;
	
	@Autowired 
	private  CourseReplyService  courseReplyService;
	

	@RequestMapping(value="studentEdit.do")
	public String studentEdit( Model  model, StudentVo vo, ReplyVo rvo    ) {
		model.addAttribute("m", service.studentEdit(vo));
		
		model.addAttribute("li", replyService.selectAll(rvo));
		
		return "university/studentEdit.jsp";		
	}
	
	@RequestMapping(value="ReplyInsert.do",method=RequestMethod.GET)
	public void ReplyInsert( ReplyVo rvo , HttpServletResponse  response)
		throws Exception {	
		replyService.insert(rvo);
		PrintWriter out = response.getWriter();
		out.println("success");	
	}
	
	@RequestMapping(value="ReplyDelete.do",method=RequestMethod.GET)
	public void ReplyDelete( ReplyVo rvo , HttpServletResponse  response)
		throws Exception {	
		replyService.delete(rvo);
		PrintWriter out = response.getWriter();
		out.println("success");	
	}
	
	
	@RequestMapping(value="studentInsert.do",method=RequestMethod.GET)
	public String studentView() {		
		return "university/studentInsert.jsp";		
	}
	
	@RequestMapping(value="studentInsert.do",method=RequestMethod.POST)
	public String studentInsert(StudentVo vo ) {	
		service.studentInsert(vo);
		return "student.do";		
	}
	
	@RequestMapping(value="university.do")
	public String university() {		
		return "university/university.jsp";		
	}
	
	@RequestMapping(value="student.do")
	public String student( Model  model, StudentVo vo  ) {
		model.addAttribute("li", service.student());
		return "university/student.jsp";		
	}
	
	@RequestMapping(value="course.do")
	public String course( Model  model, CourseVo vo  ) {
		model.addAttribute("li", service.course());
		return "university/course.jsp";		
	}
	
	@RequestMapping(value="courseEdit.do")
	public String courseEdit( Model  model, CourseVo vo , CourseReplyVo  vor  ) {
		
		model.addAttribute("m", service.courseEdit(vo));
		
		model.addAttribute("li", courseReplyService.selectAll(vor));
		
		return "university/courseEdit.jsp";		
	}
	
	
	@RequestMapping(value="CourseReplyInsert.do")
	public void CourseReplyInsert(HttpServletResponse response,  Model  model, CourseVo vo , CourseReplyVo  vor  ) throws Exception {
		
		courseReplyService.insert(vor);
		PrintWriter out = response.getWriter();
		out.println("success");	
			
	}
	
	@RequestMapping(value="CourseReplyDelete.do")
	public void CourseReplyDelete(HttpServletResponse response, CourseVo vo , CourseReplyVo  vor  ) throws Exception {

		courseReplyService.delete(vor);
		PrintWriter out = response.getWriter();
		out.println("success"); 	
			
	}
	
	
	
	@RequestMapping(value="enrol.do")
	public String enrol( Model  model, EnrolVo vo  ) {
		model.addAttribute("li", service.enrol());
		return "university/enrol.jsp";		
	}
	
	@RequestMapping(value="sejoin.do")
	public String sejoin( Model  model, SEJoinVo vo  ) {
		model.addAttribute("li", service.SEJoin());
		return "university/sejoin.jsp";		
	}
	
	@RequestMapping(value="secjoin.do")
	public String sejoin( Model  model, SECJoinVo vo  ) {
		model.addAttribute("li", service.SECJoin());
		return "university/secjoin.jsp";		
	}
	

	@RequestMapping(value="studentUpdate.do")
	public String studentUpdate( Model  model, StudentVo vo  ) {
		service.studentUpdate(vo);
		return "student.do";		
	}
	
	
		@RequestMapping(value="enrolInsert.do", method=RequestMethod.GET)
		public String enrolInsertView( Model  model, StudentVo vo  ) {
			model.addAttribute("li",service.course());
			model.addAttribute("sno", vo.getSno());
			return "university/enrolInsert.jsp";		
		}
		
		@RequestMapping(value="enrolInsert.do", method=RequestMethod.POST)
		public String enrolInsert( EnrolVo vo  ) {
			service.entroInsert(vo);
			return "sejoin.do";		
		}
		
		@RequestMapping(value="enrolEdit.do", method=RequestMethod.GET)
		public String enrolEdit( Model  model, EnrolVo vo  ) {
			model.addAttribute("m",service.enrolEdit(vo));
			return "university/enrolEdit.jsp";	
		}
		
		@RequestMapping(value="enrolUpdate.do")
		public String enrolUpdate( EnrolVo vo  ) {
			service.enrolUpdate(vo);
			return "enrol.do";		
		}
		
		@RequestMapping(value="courseGroup.do")
		public String courseGroup( Model  model, CourseGroupVo vo  ) {
			model.addAttribute("li", service.courseGroup());
			return "university/courseGroup.jsp";		
		}
		
		
}

package com.springbook.view;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.ajax.AjaxService;
import com.springbook.biz.ajax.AjaxVo;
import com.springbook.biz.ajax.ExamReplyService;
import com.springbook.biz.ajax.ExamReplyVo;

@Controller
public class AjaxController {

	@Autowired
	private AjaxService  service;
	
	@Autowired
	private  ExamReplyService service2;
	
	@RequestMapping("/insertExamAjax.do")
	public  void insert(AjaxVo vo, HttpServletResponse  response ) throws Exception {
	
		service.insert(vo);
		PrintWriter out = response.getWriter();
		out.print("T");
		
	}
	
	@RequestMapping("/updateExamAjax.do")
	public  void updateExamAjax(AjaxVo vo, HttpServletResponse  response ) throws Exception {
	
		service.update(vo);
		PrintWriter out = response.getWriter();
		out.print("T");
		
	}
	
	
	@RequestMapping("/ExamReplaySave.do")
	public  void ExamReplaySave(ExamReplyVo vo, HttpServletResponse  response ) throws Exception {
		
		service2.insert(vo);
		PrintWriter out = response.getWriter();
		out.print("T");
		
	}
			
	
	
	@RequestMapping	("/deleteExamAjax.do")
	public  void deleteExamAjax(AjaxVo vo, HttpServletResponse  response, HttpServletRequest  request  ) throws Exception {
	    System.out.println("sno확인:" + vo.getSno());
	    service.delete(vo);
		PrintWriter out = response.getWriter();
		out.print("T");
	}	
		
	@RequestMapping	("/ExamReplayDelete.do")
	public  void examReplayDelete(ExamReplyVo vo  , HttpServletResponse  response, HttpServletRequest  request  ) throws Exception {
	    service2.delete(vo);
		PrintWriter out = response.getWriter();
		out.print("T");
	}	
		
	
	@RequestMapping("/getAjaxList.do")
	public  String selectAll(AjaxVo vo, Model model  ,HttpServletResponse  response ) throws Exception {
	
		model.addAttribute("li", service.getBoardList(vo));
		
		return "ajax/list.jsp";
		
	}
	
	@RequestMapping("/getAjax.do")
	public  String selectOne(ExamReplyVo vo2, AjaxVo vo, Model model ) throws Exception {
	
		
		System.out.println("SNO 확인:" + vo2.getSno());

		
		model.addAttribute("m", service.getBoard(vo));		
		model.addAttribute ("li", service2.select(vo2));
		
		return "ajax/getExamAjax.jsp";
		
	}
	
	
}

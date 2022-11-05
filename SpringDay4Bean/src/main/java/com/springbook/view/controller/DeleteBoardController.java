package com.springbook.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardDao;
import com.springbook.biz.board.impl.BoardDaoImpl;

public class DeleteBoardController implements  Controller {
	public DeleteBoardController(){
		System.out.println("===>DeleteBoardController");
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {

		   System.out.println("글 삭제 처리"); 
		   
		   int seq= Integer.parseInt(request.getParameter("seq")) ;
		   BoardDao dao = new BoardDaoImpl();
		   dao.delete(seq);
		  
		   ModelAndView  mav = new ModelAndView();
		   mav.setViewName("redirect:getBoardList.do");
		   
		return mav;
	}

}

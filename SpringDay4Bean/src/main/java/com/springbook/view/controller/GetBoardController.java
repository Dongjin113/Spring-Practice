package com.springbook.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardDao;
import com.springbook.biz.board.BoardVo;
import com.springbook.biz.board.impl.BoardDaoImpl;

public class GetBoardController implements Controller {
	public GetBoardController(){
		System.out.println("===>GetBoardController");
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		 System.out.println("글 상세 조회 처리"); 
		  int seq= Integer.parseInt(request.getParameter("seq")) ;
		  
		  BoardDao   dao = new BoardDaoImpl();
		  dao.cnt(seq);
		  BoardVo m = dao.getBoard(seq);
		 
		  // HttpSession session = request.getSession();	  
		  // session.setAttribute("m", m);
		  
		  ModelAndView mav=new ModelAndView();
		  mav.addObject("m", m);
		  mav.setViewName("getBoard"); //presentation-layer.xml에 확장자를 잡아둬서 지움
		  
		  
		return mav;
	}

}

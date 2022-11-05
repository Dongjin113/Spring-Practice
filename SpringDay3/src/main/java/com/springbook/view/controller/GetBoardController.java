package com.springbook.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardDao;
import com.springbook.biz.board.BoardVo;
import com.springbook.biz.board.impl.BoardDaoImpl;

public class GetBoardController implements Controller{
	
	public GetBoardController(){
		System.out.println("===>GetBoardController");
	}

	@Override
	public String handRequest(HttpServletRequest request, HttpServletResponse response) {


		 System.out.println("글 상세 조회 처리"); 
		  int seq= Integer.parseInt(request.getParameter("seq")) ;
		  
		  BoardDao   dao = new BoardDaoImpl();
		  BoardVo m = dao.getBoard(seq);
		  HttpSession session = request.getSession();
		  session.setAttribute("m", m);
		  
		return "getBoard";
	}

}

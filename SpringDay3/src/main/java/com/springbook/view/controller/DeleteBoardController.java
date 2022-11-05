package com.springbook.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.board.BoardDao;
import com.springbook.biz.board.impl.BoardDaoImpl;

public class DeleteBoardController implements Controller{
	
	public DeleteBoardController(){
		System.out.println("===>DeleteBoardController");
	}

	@Override
	public String handRequest(HttpServletRequest request, HttpServletResponse response) {

		 System.out.println("글 삭제 처리"); 

		   //request.setCharacterEncoding("UTF-8");
		   int seq= Integer.parseInt(request.getParameter("seq")) ;
		   BoardDao dao = new BoardDaoImpl();
		   dao.delete(seq);
		return "getBoardList.do";
	}

}

package com.springbook.view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardDao;
import com.springbook.biz.board.BoardVo;
import com.springbook.biz.board.impl.BoardDaoImpl;

public class GetBoardListController implements Controller{
	
	public GetBoardListController(){
		System.out.println("===>GetBoardListController");
	}

	@Override
	public String handRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 목록 검색 처리"); 
		 String searchCondition=request.getParameter("searchCondition");
		 String searchKeyword=request.getParameter("searchKeyword");

		  BoardVo vo = new BoardVo();
		  vo.setSearchCondition(searchCondition);
		  vo.setSearchKeyword(searchKeyword);
		  
		  BoardDao   dao = new BoardDaoImpl();
		  List<BoardVo> li = dao.getBoardList(vo);
		  HttpSession session = request.getSession();
		  session.setAttribute("li", li);
		 
		return "getBoardList";
	}

}

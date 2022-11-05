package com.springbook.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.board.BoardDao;
import com.springbook.biz.board.BoardVo;
import com.springbook.biz.board.impl.BoardDaoImpl;

public class InsertBoardController implements Controller{
	
	public InsertBoardController(){
		System.out.println("===>InsertBoardController");
	}

	@Override
	public String handRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 등록 처리"); 
		 
		   // 1. 사용자 입력 정보 추출
		   //request.setCharacterEncoding("UTF-8");
		   String title=request.getParameter("title");
		   String writer=request.getParameter("writer");
		   String content=request.getParameter("content");

		   // 2. DB연동 처리
		   BoardVo vo = new BoardVo();
		   vo.setTitle(title);
		   vo.setWriter(writer);
		   vo.setContent(content);
		   
		   BoardDao dao = new BoardDaoImpl();
		   dao.insert(vo);
		  
		
		return "getBoardList.do";
	}

}

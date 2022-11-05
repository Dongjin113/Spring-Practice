package com.springbook.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.board.BoardDao;
import com.springbook.biz.board.BoardVo;
import com.springbook.biz.board.impl.BoardDaoImpl;

public class UpdateBoardController implements Controller{
	
	public UpdateBoardController(){
		System.out.println("===> UpdateBoardController");
	}

	@Override
	public String handRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("글 수정 처리"); 
		   // 1. 사용자 입력 정보 추출
		   //request.setCharacterEncoding("UTF-8");
		   int seq= Integer.parseInt(request.getParameter("seq")) ;
		   String title=request.getParameter("title");
		   String content=request.getParameter("content");

		   // 2. DB연동 처리
		   BoardVo vo = new BoardVo();
		   vo.setSeq(seq);
		   vo.setTitle(title);
		   vo.setContent(content);
		   
		   BoardDao dao = new BoardDaoImpl();
		   dao.update(vo);
		return "getBoardList.do";
	}

}

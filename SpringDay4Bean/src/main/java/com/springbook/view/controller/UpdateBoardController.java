package com.springbook.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardDao;
import com.springbook.biz.board.BoardVo;
import com.springbook.biz.board.impl.BoardDaoImpl;

public class UpdateBoardController implements Controller{
	public UpdateBoardController(){
		System.out.println("===>UpdateBoardController");
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		   // request.setCharacterEncoding("UTF-8");
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
		   
		   ModelAndView  mav = new ModelAndView();
		   mav.setViewName("redirect:getBoardList.do");
		   
		return mav;
	}

}

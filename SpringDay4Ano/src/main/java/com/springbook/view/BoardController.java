package com.springbook.view;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVo;


@Controller
public class BoardController  {

	@Autowired
	private  BoardService  boardService;
	
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(HttpServletRequest request) {

		 int seq= Integer.parseInt(request.getParameter("seq")) ;
		 boardService.delete(seq);
		  		 
		return "getBoardList.do";
	}
	
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVo vo) {
		 		  
		boardService.insert(vo);		  	
		 
		return "getBoardList.do";
		   
		
	}
	
	
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(BoardVo vo) {	
		
		boardService.update(vo);	
		   
		return "getBoardList.do";
	}
	
	@RequestMapping(value="/getBoard.do")
	public String getBoard(HttpServletRequest request, Model model) {
		  
		  int seq= Integer.parseInt(request.getParameter("seq")) ;
		  boardService.cnt(seq);  		  
		  model.addAttribute("m", boardService.getBoard(seq));
		 		  
		return "getBoard.jsp";
	}
	
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList(BoardVo vo ,  Model model) {
	  		  		 
		 model.addAttribute("li", boardService.getBoardList(vo));		 
		  		  
		return "getBoardList.jsp";
	}
	

}

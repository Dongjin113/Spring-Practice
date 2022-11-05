package com.springbook.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVo;
import com.springbook.biz.board.service.BoardService;

@Controller
public class BoardController {
    
	@Autowired
	private BoardService  service;
	
	
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard( BoardVo vo ) {		
		 service.delete(vo);		  		 
		return "getBoardList.do";
	}
	
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard( BoardVo vo ) {		
		 service.insert(vo)	;	  		 
		return "getBoardList.do";
	}
	
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard( BoardVo vo ) {		
		 service.update(vo)	;	  		 
		return "getBoardList.do";
	}
	
	@RequestMapping(value="/getBoard.do")
	public String getBoard( BoardVo vo , Model  model ) {
		 service.cnt(vo);
		 model.addAttribute("m", service.getBoard(vo));
		return "/board/getBoard.jsp";
	}
	
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList( BoardVo vo , Model  model ) {
		 model.addAttribute("li", service.getBoardList(vo));
		return "/board/getBoardList.jsp";
	}
	
}

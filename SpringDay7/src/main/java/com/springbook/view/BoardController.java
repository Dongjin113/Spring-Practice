package com.springbook.view;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.board.BoardVo;
import com.springbook.biz.board.service.BoardService;

@Controller
@SessionAttributes("m") // 1) 추가 
public class BoardController {
    
	@Autowired
	private BoardService  service;
	
	@ModelAttribute("conditionMap") // conditionMap 는 Model의 이름과 같은 역할을 한다.
	public  Map<String, String> searchConditionMap(){
		
		Map<String, String> conditionMap = new HashMap<String, String>(); 
		conditionMap.put("제목", "title");  // 키 , 값
		conditionMap.put("글쓴이", "writer");
		return conditionMap;
		
	}
	
	
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
	public String updateBoard( @ModelAttribute("m") BoardVo vo ) {		
		// 추가2. -  @ModelAttribute("board")
		System.out.println("글쓴이 확인:" + vo.getWriter());
		
		service.update(vo)	;	  		 
		return "getBoardList.do";
	}
	
	@RequestMapping(value="/getBoard.do")
	public String getBoard( BoardVo vo , Model  model ) {
		 service.cnt(vo);
		 // 3. 확인 "board"
		 model.addAttribute("m", service.getBoard(vo));
		return "/board/getBoard.jsp";
	}
	
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList( BoardVo vo , Model  model ) {
		 if(vo.getSearchCondition()==null) vo.setSearchCondition("title");	
		 if(vo.getSearchKeyword()==null) vo.setSearchKeyword("");	
		 model.addAttribute("li", service.getBoardList(vo));
		return "/board/getBoardList.jsp";
	}
	
}

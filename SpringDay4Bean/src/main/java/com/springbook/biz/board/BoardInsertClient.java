package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardInsertClient {

	public static void main(String[] args) {
		AbstractApplicationContext container=
				new GenericXmlApplicationContext("applicationContext.xml");

		BoardService service =(BoardService) container.getBean("boardService");
		BoardVo vo =new BoardVo();
		vo.setTitle("임시 제목1");
		vo.setWriter("홍길동1");
		vo.setContent("임시내용1 ....");		
		service.insert(vo);
				
		List<BoardVo> li =service.getBoardList(vo);
		for(BoardVo m :li) {
		  System.out.println("===> " +m.toString());	
		}
				
		container.close();
	}

}

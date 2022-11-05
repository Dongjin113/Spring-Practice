package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardUpdateClient {

	public static void main(String[] args) {
		AbstractApplicationContext container=
				new GenericXmlApplicationContext("applicationContext.xml");

		BoardService service =(BoardService) container.getBean("boardService");
		
		List<BoardVo> li =null;
		li =service.selectAll();
		for(BoardVo m :li) {
		  System.out.println("===> " +m.toString());	
		}
		
		BoardVo vo =new BoardVo();
		vo.setTitle("수정 임시 제목1");
		vo.setWriter("수정 홍길동1");
		vo.setContent("수정 임시내용1 ....");	
		vo.setSeq(5);
		service.update(vo);
		
		li =service.selectAll();
		for(BoardVo m :li) {
		  System.out.println("===> " +m.toString());	
		}
		container.close();
	}

}

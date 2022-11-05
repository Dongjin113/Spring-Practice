package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardDeleteClient {

	public static void main(String[] args) {
		AbstractApplicationContext container=
				new GenericXmlApplicationContext("applicationContext.xml");

		BoardService service =(BoardService) container.getBean("boardService");
		
		List<BoardVo> li =null;
		li =service.selectAll();
		for(BoardVo m :li) {
		  System.out.println("===> " +m.toString());	
		}
		

		service.delete(2);
		System.out.println("========[  삭 제 결 과 ] =========");
		
		li =service.selectAll();
		for(BoardVo m :li) {
		  System.out.println("===> " +m.toString());	
		}
		
		container.close();
	}

}

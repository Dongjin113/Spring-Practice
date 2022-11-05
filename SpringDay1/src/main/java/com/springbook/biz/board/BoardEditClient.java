package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardEditClient {

	public static void main(String[] args) {
		AbstractApplicationContext container=
				new GenericXmlApplicationContext("applicationContext.xml");

		BoardService service =(BoardService) container.getBean("boardService");
		
		List<BoardVo> li =service.selectAll();
		for(BoardVo m :li) {
		  System.out.println("===> " +m.toString());	
		}
		
		BoardVo m=service.edit(7);
		System.out.println("번호:" +m.getSeq());
		System.out.println("제목:" +m.getTitle());
		System.out.println("이름:" +m.getWriter());
		System.out.println("내용:" +m.getContent());
		
		container.close();
	}

}

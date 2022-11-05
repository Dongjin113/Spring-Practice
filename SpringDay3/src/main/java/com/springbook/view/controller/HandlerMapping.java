package com.springbook.view.controller;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/getBoardList.do", new GetBoardListController());
	}
	//deleteBoard.do가넘어온다면 mapping에 있는 /deleteBoard.do를 찾아 DeleteBoardController객체가 path로들어와실행됌 
	public Controller getController(String path) {
		
		return mappings.get(path);
	}
}

package com.springbook.view.controller;

public class ViewResolver {
	
	public String prefix; //접두사 ./
	public String suffix; //접미사 .jsp
	
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public String getView(String viewName) {
		// 예) vieName = getBoard ==> ./getBoard.jsp 가되겠다는 뜻
		return prefix + viewName + suffix;
	}

	
}

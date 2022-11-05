package com.springbook.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	
	String handRequest(HttpServletRequest request, HttpServletResponse response);

}

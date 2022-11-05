package com.springbook.view;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.bigdata.BigdataService;
import com.springbook.biz.bigdata.BigdataVo;

@Controller
public class BigdataController {
	
	@Autowired
	private BigdataService service;
	
	@RequestMapping(value="selectTop15.do")
	public String list( Model  model, BigdataVo vo) {
		
		model.addAttribute("li", service.selectTop15(vo));
		
		return "bigdata/selectTop15.jsp";		
	}
	


}

package com.springbook.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MapController {

	@RequestMapping(value="mapSample1.do")
	public String list( Model  model) {
		
		model.addAttribute("m1",37.48445671);
		model.addAttribute("m2",126.93003738);
		
		return "kakao/mapSample1.jsp";		
	}
	
}

package com.springbook.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.university.StudentVo;
import com.springbook.biz.university.UniverService;
@Controller
public class UniversityController {


		@Autowired
		private UniverService service;
		
		@RequestMapping(value="student.do")
		public String list(Model model, StudentVo vo) {
			model.addAttribute("li", service.getUniverseList(vo));
			
			return "university/student.jsp";
		}
}

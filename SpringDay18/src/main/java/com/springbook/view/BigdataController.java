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
	private BigdataService  service;
	
	@RequestMapping(value="selectTop15.do")
	public String selectTop15( Model  model, BigdataVo vo  ) {
		
		model.addAttribute("li", service.selectTop15(vo));
		
		return "bigdata/selectTop15.jsp";		
	}
	
	
	@RequestMapping(value="ListPage.do")
	public String ListPage( Model  model, BigdataVo vo  ) {
		
		if (vo.getStartIdx() ==0) {
		  vo.setStartIdx(1);
		} else {
		  vo.setStartIdx(vo.getStartIdx());
		}
		vo.setEndIdx(vo.getStartIdx()+9);	
		
		int k = service.totalCount(vo);
		int pageSize= 10;
		int totlaPage =(int) Math.ceil( k / (double)pageSize);
		int nowPage =  ( vo.getStartIdx() / pageSize ) +  1 ;
		
		int endPage = ( totlaPage - 1 ) * pageSize + 1 ;
		
		model.addAttribute("startIdx",vo.getStartIdx());
		model.addAttribute("totalPage",totlaPage); // 전체페이지
		model.addAttribute("nowPage",nowPage);  // 현재페이지
		model.addAttribute("endPage",endPage);  // 현재페이지

		// 검색추가
		model.addAttribute("searchCondition",vo.getSearchCondition());
		model.addAttribute("searchKeyword",vo.getSearchKeyword());
		
		model.addAttribute("totalCount",service.totalCount(vo)); // 전체레코드 수 
		model.addAttribute("li", service.selectList(vo));
		
		
		return "bigdata/ListPage.jsp";		
	}	
		
}

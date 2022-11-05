package com.springbook.view;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.company.CompanyService;
import com.springbook.biz.kakao.KakaoVo;


@Controller
public class MapController {
	
	@Autowired
	private CompanyService service;

	@RequestMapping(value="mapSample1.do")
	public String list( Model  model) {
		
		model.addAttribute("m1",37.48445671);
		model.addAttribute("m2",126.93003738);
		
		return "kakao/mapSample1.jsp";		
	}
	
	@RequestMapping(value="mapSample2.do")
	public String mapSample2( Model  model) {
		
		model.addAttribute("m1",37.48445671);
		model.addAttribute("m2",126.93003738);
		
		return "kakao/mapSample2.jsp";		
	}
	@RequestMapping(value="mapSample3.do")
	public String mapSample3( Model  model) {
		
		model.addAttribute("m1",37.48445671);
		model.addAttribute("m2",126.93003738);
		
		return "kakao/mapSample3.jsp";		
	}
	@RequestMapping(value="mapSample4.do")
	public String mapSample4( Model  model) {
		
		model.addAttribute("m1",37.48445671);
		model.addAttribute("m2",126.93003738);
		
		return "kakao/mapSample4.jsp";		
	}
	@RequestMapping(value="mapSample5.do")
	public String mapSample5( Model  model) {
		
		model.addAttribute("m1",37.48445671);
		model.addAttribute("m2",126.93003738);
		
		return "kakao/mapSample5.jsp";		
	}
	@RequestMapping(value="mapSample6.do")
	public String mapSample6( Model  model) {
		/*
		double k1= 33.379855775783184;
		double k2 = 126.52691599216999;
		List<KakaoVo> li= new ArrayList<KakaoVo>();
		for(int i=0 ; i<5 ; i++) {
			KakaoVo v = new KakaoVo();
			v.setTitle("지도"+(i+1));
			v.setLat(k1 + i* 0.03);
			v.setLon(k2 + i* 0.2);
			li.add(v);
		}
		model.addAttribute("li",li);

		model.addAttribute("key","bf02fe9c128963727a9179a7e0661bba");
		*/

		model.addAttribute("key","bf02fe9c128963727a9179a7e0661bba");
		model.addAttribute("li",service.select());
		
		return "kakao/mapSample6.jsp";		
	}
}

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
	private CompanyService  service;
	
	
	@RequestMapping(value="mapSample1.do")
	public String selectTop15( Model  model ) {
				
		model.addAttribute("m1",37.48445671);
		model.addAttribute("m2",126.93003738);
		
		return "kakao/mapSample1.jsp";		
	}
	
	@RequestMapping(value="mapSample8.do")
	public String mapSample8( Model  model ) {
		
	   // 제주기준 좌표 찍기  
	   /*	
	   double	k1 = 33.379855775783184;
	   double   k2 = 126.1 ;
	   List<KakaoVo>	li = new ArrayList<KakaoVo>();
	   
		for(int i=0 ; i < 5 ; i++ ) {
			
			KakaoVo v = new KakaoVo();
			v.setTitle("지도" +(i+1));
			v.setLat(k1 + i * 0.03 );
			v.setLon(k2 + i * 0.2);
			
			li.add(v);
			
		}
		
		model.addAttribute("li",li);
		
		*/
		
		model.addAttribute("key","2fb9031d27e12ecf3383c962c58416cd");		
		model.addAttribute("li",service.select());
		
		return "kakao/mapSample8.jsp";		
	}
	
	
}

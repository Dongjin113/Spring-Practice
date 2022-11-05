package com.springbook.view;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.psdBoard.BoardPsdService;
import com.springbook.biz.psdBoard.BoardPsdVo;

@Controller
public class PsdBoardController {
	
	@Autowired
	private BoardPsdService service;
	
	@Autowired
	private HttpServletRequest request;
	
	String path="";
	String timeStr ="";
	
	@RequestMapping(value="/insertPsd.do")
	String insert(BoardPsdVo vo) throws Exception{
		
		path=request.getSession().getServletContext().getRealPath("/psdBoard/files/");
		System.out.println("확인 path:" + path);
		
		MultipartFile updateFile =vo.getUpdateFile(); // 실제파일
		String fileName = updateFile.getOriginalFilename(); // 넘어온 파일명
		
		File f = new File(path+fileName);
		
		if(!updateFile.isEmpty()) {  // 파일이 있으면
			
			if (f.exists()) {  // 중복파일이 있으면 처리
				String onlyFileName= fileName.substring(0, fileName.lastIndexOf("."));
				String extension = fileName.substring(fileName.lastIndexOf("."));
				System.out.println("확장자 확인" + extension);
				fileName = onlyFileName+"_"+timeStr+extension;
				updateFile.transferTo(new File(path + fileName));
			} else { // 중복 파일이 없으면 처리하는 영역
				updateFile.transferTo(new File(path + fileName));
			}
		}else {
			fileName = "space.jpg";
		} 
		
		vo.setUpdateFilestr(fileName);
		service.insert(vo);
		
		return "psdBoardList.do";
	}
	
}

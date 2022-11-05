package com.springbook.view;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.board.BoardVo;
import com.springbook.biz.psd.PsdService;
import com.springbook.biz.psd.PsdVo;

@Controller
public class PsdController {

	String path ="";	
	String timeStr ="";
	
	public PsdController(){		
		long time = System.currentTimeMillis();
		SimpleDateFormat daytime =new SimpleDateFormat("HHmmss");
		timeStr=daytime.format(time);
	}
	
	@Autowired
	private HttpServletRequest  request;

	@Autowired
	private PsdService  service;

	@RequestMapping(value="/insertPsd.do")
	String insert(PsdVo vo) throws IOException {

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
		
		vo.setUpdateFileStr(fileName);
		service.insert(vo);
		
		return "getPsdList.do";
	}
	
	@RequestMapping(value="/getPsdList.do")
	public String getBoardList( PsdVo vo , Model  model ) {
		path=request.getSession().getServletContext().getRealPath("/psdBoard/files/");
		System.out.println("확인 path:" + path);
		 if(vo.getSearchCondition()==null) vo.setSearchCondition("title");	
		 if(vo.getSearchKeyword()==null) vo.setSearchKeyword("");	
		 model.addAttribute("li", service.getPsdList(vo));
		return "/psdBoard/getBoardList.jsp";
	}
	
	@RequestMapping(value="/getPsd.do")
	public String getPsd( PsdVo vo , Model  model ) {
		 model.addAttribute("m", service.getPsd(vo));
		return "/psdBoard/getBoard.jsp";
	}
	
	@RequestMapping(value="/deletePsd.do")
	public String deletePsd( PsdVo vo , Model  model ) {

		 path=request.getSession().getServletContext().getRealPath("/psdBoard/files/");

		 vo = service.getPsd(vo);
		 String delFile = vo.getUpdateFileStr();
		 
		 File f = new File(path + delFile);
		 if (!delFile.equals("space.jpg")) {
			 if(f.exists()) {
				f.delete() ;
			 }
		 }
		 
		service.delete(vo);
		 		
		return "getPsdList.do";
	}
	
	@RequestMapping(value="/updatePsd.do")
	public String updatePsd( PsdVo vo , Model  model ) throws IOException {
		
		path=request.getSession().getServletContext().getRealPath("/psdBoard/files/");

		
		MultipartFile updateFile =vo.getUpdateFile(); // 실제파일
		String fileName = updateFile.getOriginalFilename(); // 넘어온 파일명
		
		File f = new File(path+fileName);
		
		if(!updateFile.isEmpty()) { // 첨부파일이 넘어 왔으면 실행
				
			 // 기존 레코드의 파일을 체크 : Start 
			 PsdVo m = service.getPsd(vo);
			 File fileDel = new File(path + m.getUpdateFileStr());
			 if (!m.getUpdateFileStr().equals("space.jpg")) {
			   if(fileDel.exists()) {
				  fileDel.delete() ;
			   }
			 }
			  // 기존 레코드의 파일을 체크 : End
			 
			   if (f.exists()) {  // 중복파일이 있으면 처리
				 
					String onlyFileName= fileName.substring(0, fileName.lastIndexOf("."));
					String extension = fileName.substring(fileName.lastIndexOf("."));
					fileName = onlyFileName+"_"+timeStr+extension;
					updateFile.transferTo(new File(path + fileName));
					
				} else { // 중복 파일이 없으면 처리하는 영역

					updateFile.transferTo(new File(path + fileName));
				}			 
			
		}
		
		vo.setUpdateFileStr(fileName);
		service.update(vo);
		
		return "getPsdList.do";
	}
	

	
}

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

import com.springbook.biz.psdBoard.BoardPsdService;
import com.springbook.biz.psdBoard.BoardPsdVo;

@Controller
public class PsdBoardController {

	String path ="";	
	String timeStr ="";
	
	public PsdBoardController(){		
		long time = System.currentTimeMillis();
		SimpleDateFormat daytime =new SimpleDateFormat("HHmmss");
		timeStr=daytime.format(time);
	}
	
	@Autowired
	private BoardPsdService  service;
	
	@Autowired
	private HttpServletRequest  request;
	
	
	@RequestMapping(value="/insertPsdBoard.do")
	String  insert(BoardPsdVo vo )  throws IOException  {
		
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
		return "psdBoardList.do" ;		
	}
	
	@RequestMapping(value="/psdBoardList.do")
	public String getBoardList( BoardPsdVo vo , Model  model ) {
		path=request.getSession().getServletContext().getRealPath("/psdBoard/files/");
		model.addAttribute("li", service.getBoardList(vo));
		return "/psdBoard/psdBoardList.jsp";
	}
	
	@RequestMapping(value="/deletePsd.do")
	public String deletePsd( BoardPsdVo vo , Model  model )  throws IOException  {

		 path=request.getSession().getServletContext().getRealPath("/psdBoard/files/");

		 vo = service.getBoard(vo);  // 삭제할 파일찾기 
		 String delFile = vo.getUpdateFilestr();
		 
		 File f = new File(path + delFile);
		 if (!delFile.equals("space.jpg")) {
			 if(f.exists()) {
				f.delete() ;
			 }
		 }
		 
		service.delete(vo);
		 		
		return "psdBoardList.do";
	}
	
	
	@RequestMapping(value="/psdBoard.do")
	public String getBoard( BoardPsdVo vo , Model  model ) {
		path=request.getSession().getServletContext().getRealPath("/psdBoard/files/");
		model.addAttribute("m", service.getBoard(vo));
		return "/psdBoard/psdBoard.jsp";
	}
	
	
	@RequestMapping(value="/updatePsd.do")
	public String updatePsd( BoardPsdVo vo , Model  model )  throws IOException  {

		path=request.getSession().getServletContext().getRealPath("/psdBoard/files/");

		
		MultipartFile updateFile =vo.getUpdateFile(); // 실제파일
		String fileName = updateFile.getOriginalFilename(); // 넘어온 파일명
		
		File f = new File(path+fileName);
		
		if(!updateFile.isEmpty()) { // 첨부파일이 넘어 왔으면 실행
				
			 // 기존 레코드의 파일을 체크 : Start 
			BoardPsdVo m = service.getBoard(vo);
			System.out.println("===> 확인 :" + m);
			 File fileDel = new File(path + m.getUpdateFilestr());
			 if (!m.getUpdateFilestr().equals("space.jpg")) {
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
		
		vo.setUpdateFilestr(fileName);
		service.update(vo);
		
		return "psdBoardList.do";
	}
	
	
}

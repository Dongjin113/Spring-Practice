package com.springbook.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.springbook.biz.board.BoardDao;
import com.springbook.biz.board.BoardVo;
import com.springbook.biz.board.impl.BoardDaoImpl;
import com.springbook.biz.user.UserVo;
import com.springbook.biz.user.impl.UserDao3;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	
	public void init() throws ServletException{
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp"); //setter로 넘기면 ViewResolver에 대입이된다는 소리
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	/*
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("UTF-8");
		try {
			process(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		try {
			process(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void process(HttpServletRequest request, HttpServletResponse response) throws Exception {

	      request.setCharacterEncoding("UTF-8");
		  
	      //1. 클라이언트 요청 path정보를 추출한다.
		  String uri=request.getRequestURI();              // 결과 :  /BoardWeb/delete.do
		  String path=uri.substring(uri.lastIndexOf("/")); // 결과 :  /delete.do
		  System.out.println("경로확인:" +path);
		  
		  
		  //2. handlerMapping 을 통해 path에 해당되는 controller을 검색한다
		  Controller ctrl = handlerMapping.getController(path);
		  
		  //3.검색된 컨트롤을 실행한다
		  String viewName = ctrl.handRequest(request, response);
		  
		  //4.viewResolver 를 통해 viewName에 대한 화면을 검색한다.
		  String view = null;
		  if(!viewName.contains(".do")) {
			  viewResolver.getView(viewName);
		  }else {
			  view = viewName;
		  }
		  // 5. 검색된 화면으로 이동
		  response.sendRedirect(view);
		  
		  /*
		  if (path.equals("/login.do")) {
			 System.out.println("로그인 처리"); 
			 
			  String id=request.getParameter("id");
			  String password=request.getParameter("password");
			  

			   UserVo vo = new UserVo();
			   vo.setId(id);
			   vo.setPassword(password);
			   
			   UserDao3 service = new UserDao3();
			   UserVo user = service.getUser(vo);

			   if(user != null){
				   response.sendRedirect("getBoardList.do");
			   }else{
				   response.sendRedirect("login.jsp");
			   }
			   
			 
		  } else if (path.equals("/logout.do")) {
			 System.out.println("로그아웃 처리"); 
			 session.invalidate();
			 response.sendRedirect("login.jsp");
			 
		  } else if (path.equals("/insertBoard.do")) {
			 System.out.println("글 등록 처리"); 
			 
			   // 1. 사용자 입력 정보 추출
			   request.setCharacterEncoding("UTF-8");
			   String title=request.getParameter("title");
			   String writer=request.getParameter("writer");
			   String content=request.getParameter("content");

			   // 2. DB연동 처리
			   BoardVo vo = new BoardVo();
			   vo.setTitle(title);
			   vo.setWriter(writer);
			   vo.setContent(content);
			   
			   BoardDao dao = new BoardDaoImpl();
			   dao.insert(vo);
			  
			   // 3. 
			   response.sendRedirect("getBoardList.do");
			  
			 
		  } else if (path.equals("/updateBoard.do")) {
			 System.out.println("글 수정 처리"); 
			   // 1. 사용자 입력 정보 추출
			   request.setCharacterEncoding("UTF-8");
			   int seq= Integer.parseInt(request.getParameter("seq")) ;
			   String title=request.getParameter("title");
			   String content=request.getParameter("content");

			   // 2. DB연동 처리
			   BoardVo vo = new BoardVo();
			   vo.setSeq(seq);
			   vo.setTitle(title);
			   vo.setContent(content);
			   
			   BoardDao dao = new BoardDaoImpl();
			   dao.update(vo);
			  
			   // 3. 
			   response.sendRedirect("getBoardList.do");
			  
		  } else if (path.equals("/deleteBoard.do")) {
			 System.out.println("글 삭제 처리"); 

			   request.setCharacterEncoding("UTF-8");
			   int seq= Integer.parseInt(request.getParameter("seq")) ;
	 		   BoardDao dao = new BoardDaoImpl();
			   dao.delete(seq);
			   response.sendRedirect("getBoardList.do");
			   
		  } else if (path.equals("/getBoard.do")) {
			 System.out.println("글 상세 조회 처리"); 
			  int seq= Integer.parseInt(request.getParameter("seq")) ;
			  
			  BoardDao   dao = new BoardDaoImpl();
			  BoardVo m = dao.getBoard(seq);
			  session.setAttribute("m", m);
			  response.sendRedirect("getBoard.jsp");
			  
		  } else if (path.equals("/getBoardList.do")) {
			 System.out.println("글 목록 검색 처리"); 
			 String searchCondition=request.getParameter("searchCondition");
			 String searchKeyword=request.getParameter("searchKeyword");

			  BoardVo vo = new BoardVo();
			  vo.setSearchCondition(searchCondition);
			  vo.setSearchKeyword(searchKeyword);
			  
			  BoardDao   dao = new BoardDaoImpl();
			  List<BoardVo> li = dao.getBoardList(vo);
			  
			  session.setAttribute("li", li);
			  response.sendRedirect("getBoardList.jsp");
			 
		  } else if (path.equals("/index.do")) {
			 System.out.println("시작페이지 이동처리"); 
			 response.sendRedirect("index.jsp"); 
		}
		*/
		
	}

}

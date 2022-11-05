package com.springbook.biz.board.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardDao;
import com.springbook.biz.board.BoardVo;
import com.springbook.biz.common.JDBCUtil;

// @Repository
public class BoardDaoImpl implements BoardDao {
	
	public	BoardDaoImpl(){
		dbConn = JDBCUtil.getInstance();
	}
	
	private JDBCUtil dbConn =null;
	private Connection conn =null;
	private PreparedStatement pstmt =null;
	private ResultSet rs=null;
	
	String BOARD_INSERT="insert into board(seq, title, writer, content)"
			+ " values((select nvl(max(seq),0)+1 from board), ?,?,?)";

	String BOARD_SELECT=" select seq, title, writer, content , regDate, cnt from board order by seq  desc " ;

	String BOARD_SELECT_TITLE = " select * from board where title like ?  order by seq  desc " ;
	String BOARD_SELECT_CONTENT = " select * from board where content like ?  order by seq  desc " ;
	
	String BOARD_EDIT="select seq, title, writer, content,  regDate, cnt "
			+ " from board where seq = ? " ;

	String BOARD_DELETE=" delete from board where seq = ? " ;
	
	String BOARD_UPDATE="update board set title=?, writer=?, content=? where seq=?";

	String BOARD_CNT="update board set cnt=cnt+1 where seq=?";

	
	@Override
	public void insert(BoardVo vo) {
		try {
		System.out.println("===> insert(BoardVo vo) 실행 ");	
		conn =dbConn.getConnection();
		pstmt=conn.prepareStatement(BOARD_INSERT);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getWriter());
		pstmt.setString(3, vo.getContent());		
		pstmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbConn.close(pstmt, conn);
		}
	}

	@Override
	public void update(BoardVo vo) {
		try {
			System.out.println("===> void update(BoardVo vo) 실행 ");	
		conn =dbConn.getConnection();
		pstmt=conn.prepareStatement(BOARD_UPDATE);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getWriter());
		pstmt.setString(3, vo.getContent());	
		pstmt.setInt(4, vo.getSeq());
		pstmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbConn.close(pstmt, conn);
		}
		
	}

	@Override
	public void delete(int seq) {
		try {
			System.out.println("===> void delete(int seq) 실행 ");	
		conn =dbConn.getConnection();
		pstmt=conn.prepareStatement(BOARD_DELETE);
		pstmt.setInt(1, seq);		
		pstmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbConn.close(pstmt, conn);
		}
		
	}

	@Override
	public BoardVo getBoard(int seq) {
		BoardVo vo = new BoardVo();
		try {
			System.out.println("===> BoardVo edit(int seq) 실행 ");	
		conn =dbConn.getConnection();
		pstmt=conn.prepareStatement(BOARD_EDIT);
		pstmt.setInt(1, seq);
		rs=pstmt.executeQuery();
		rs.next();			
			vo.setSeq(rs.getInt("seq"));
			vo.setTitle(rs.getString("title"));
			vo.setWriter(rs.getString("writer"));
			vo.setContent(rs.getString("content"));
			vo.setRegDate(rs.getDate("regdate"));
			vo.setCnt(rs.getInt("cnt"));

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbConn.close(rs, pstmt, conn);
		}
		return vo;
	}

	@Override
	public List<BoardVo> getBoardList(BoardVo v) {
		List<BoardVo> li = new ArrayList<BoardVo>();
		try {
			System.out.println("===> List<BoardVo> selectAll() 실행 ");	
			System.out.println("===> v 확인 : " + v );	
		conn =dbConn.getConnection();
		
		if (v.getSearchCondition() == null || v.getSearchKeyword() == "") {
			pstmt=conn.prepareStatement(BOARD_SELECT);	
		}else if(v.getSearchCondition().equals("title")) {
			pstmt=conn.prepareStatement(BOARD_SELECT_TITLE);
			pstmt.setString(1,"%" +v.getSearchKeyword()+ "%");
		}else if(v.getSearchCondition().equals("content")) {
			pstmt=conn.prepareStatement(BOARD_SELECT_CONTENT);
			pstmt.setString(1,"%" +v.getSearchKeyword()+ "%");
		}		
		
		rs=pstmt.executeQuery();
		while(rs.next()) {
			BoardVo vo=new BoardVo();
			vo.setSeq(rs.getInt("seq"));
			vo.setTitle(rs.getString("title"));
			vo.setWriter(rs.getString("writer"));
			vo.setContent(rs.getString("content"));
			vo.setRegDate(rs.getDate("regdate"));
			vo.setCnt(rs.getInt("cnt"));
			li.add(vo);
		}		
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbConn.close(rs, pstmt, conn);
		}
		return li;
	}

	@Override
	public int cnt(int seq) {
		try {
			System.out.println("===> int cnt(int seq) 실행 ");	
		conn =dbConn.getConnection();
		pstmt=conn.prepareStatement(BOARD_CNT);
		pstmt.setInt(1, seq);
		pstmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbConn.close(pstmt, conn);
		}
		return 0;
	}

}

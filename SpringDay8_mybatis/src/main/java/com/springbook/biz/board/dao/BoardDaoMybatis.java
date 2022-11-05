package com.springbook.biz.board.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVo;

@Repository
public class BoardDaoMybatis implements BoardDao {

	@Autowired
    private SqlSessionTemplate  jdbcTemplate;
		
	
	@Override
	public void insert(BoardVo vo) {	
		
		Date date=new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		String strNowDate = simpleDateFormat.format(date);
		vo.setRegDateStr(strNowDate);
		jdbcTemplate.insert("BoardDAO.insertBoard",vo);
	}

	@Override
	public void update(BoardVo vo) {
		jdbcTemplate.update("BoardDAO.updateBoard", vo);		
	}

	@Override
	public void delete(BoardVo vo) {		
		jdbcTemplate.delete("BoardDAO.deleteBoard", vo);
	}

	@Override
	public BoardVo getBoard(BoardVo vo) {		
		return (BoardVo )jdbcTemplate.selectOne("BoardDAO.getBoard", vo );
	}

	@Override
	public List<BoardVo> getBoardList(BoardVo vo) {
		
		
		/*
		if (vo.getSearchKeyword() == null || vo.getSearchKeyword().equals("") ) {
		    System.out.println("== >Mybatis : List<BoardVo> getBoardList ");
			return  jdbcTemplate.selectList("BoardDAO.getBoardList");
		} else if(vo.getSearchCondition().equals("title")) {
		    System.out.println("== >Mybatis : BoardDAO.GETBOARDTITLE ");
		    vo.setSearchKeyword("%" + vo.getSearchKeyword() + "%");
			return  jdbcTemplate.selectList("BoardDAO.GETBOARDTITLE", vo );
		} else if(vo.getSearchCondition().equals("writer")) {
		    System.out.println("== >Mybatis : BoardDAO.GETBOARDWRITER ");		  
		    vo.setSearchKeyword("%" + vo.getSearchKeyword() + "%");
		    return  jdbcTemplate.selectList("BoardDAO.GETBOARDWRITER", vo );
		}
		*/
		
		vo.setSearchKeyword("%" + vo.getSearchKeyword() + "%");
		return jdbcTemplate.selectList("BoardDAO.getBoardList", vo);
		
	}

	@Override
	public void cnt(BoardVo vo) {		
		jdbcTemplate.update("BoardDAO.cnt", vo);		
	}

}


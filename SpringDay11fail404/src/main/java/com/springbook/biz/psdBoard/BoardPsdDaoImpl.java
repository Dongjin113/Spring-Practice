package com.springbook.biz.psdBoard;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardPsdDaoImpl implements BoardPsdDao{
	
	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public void insert(BoardPsdVo vo) {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		String strNowDate = simpleDateFormat.format(date);
		vo.setRegdatestr(strNowDate);
		mybatis.insert("PSDBOARD.insert",vo);
		
	}

	@Override
	public void update(BoardPsdVo vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(BoardPsdVo vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BoardPsdVo getBoard(BoardPsdVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardPsdVo> getBoardList(BoardPsdVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

}

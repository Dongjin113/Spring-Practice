package com.springbook.biz.psdBoard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardPsdServiceImpl implements  BoardPsdService {

	@Autowired
	private BoardPsdDao  dao;
	
	@Override
	public void insert(BoardPsdVo vo) {
		dao.insert(vo);
		
	}

	@Override
	public void update(BoardPsdVo vo) {
		dao.update(vo);
		
	}

	@Override
	public void delete(BoardPsdVo vo) {
		dao.delete(vo);
		
	}

	@Override
	public BoardPsdVo getBoard(BoardPsdVo vo) {	
		
		return dao.getBoard(vo);
	}

	@Override
	public List<BoardPsdVo> getBoardList(BoardPsdVo vo) {
		return dao.getBoardList(vo);
	}

}

package com.springbook.biz.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardVo;
import com.springbook.biz.board.dao.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao dao;
	
	@Override
	public void insert(BoardVo vo) {
		dao.insert(vo);
		
	}

	@Override
	public void update(BoardVo vo) {
		dao.update(vo);
		
	}

	@Override
	public void delete(BoardVo vo) {
		dao.delete(vo);
		
	}

	@Override
	public BoardVo getBoard(BoardVo vo) {		
		return dao.getBoard(vo);
	}

	@Override
	public List<BoardVo> getBoardList(String str1, String str2) {		
		return dao.getBoardList(str1, str2);
	}

	@Override
	public void cnt(BoardVo vo) {
		dao.cnt(vo);
		
	}

}

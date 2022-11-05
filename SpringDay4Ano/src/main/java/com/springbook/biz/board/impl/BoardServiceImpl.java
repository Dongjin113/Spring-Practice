package com.springbook.biz.board.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardDao;
import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVo;

@Service("boardService")
public class BoardServiceImpl  implements BoardService {

	@Resource(name="BoardDaoSpring")	
	private BoardDao boardDao;	
	
	@Override
	public void insert(BoardVo vo) {	   
		boardDao.insert(vo);		
	}

	@Override
	public void update(BoardVo vo) {
	
		boardDao.update(vo);	

	}

	@Override
	public void delete(int seq) {

		boardDao.delete(seq);	

	}

	@Override
	public BoardVo getBoard(int seq) {	

		return boardDao.getBoard(seq);
	}

	@Override
	public List<BoardVo> getBoardList(BoardVo v) {

		return boardDao.getBoardList(v);
	}

	@Override
	public int cnt(int seq) {
		// TODO Auto-generated method stub
		return boardDao.cnt(seq);
	}

}

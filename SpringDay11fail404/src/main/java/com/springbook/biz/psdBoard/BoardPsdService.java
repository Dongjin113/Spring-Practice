package com.springbook.biz.psdBoard;

import java.util.List;

public interface BoardPsdService {

	void insert(BoardPsdVo vo);
	void update(BoardPsdVo vo);
	void delete(BoardPsdVo vo);

	BoardPsdVo getBoard(BoardPsdVo vo);
	List<BoardPsdVo> getBoardList(BoardPsdVo vo);
	
}

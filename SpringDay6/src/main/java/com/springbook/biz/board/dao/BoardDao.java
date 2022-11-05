package com.springbook.biz.board.dao;

import java.util.List;

import com.springbook.biz.board.BoardVo;

public interface BoardDao {
    void insert(BoardVo vo);
    void update(BoardVo vo);
    void delete(BoardVo vo);
    BoardVo getBoard(BoardVo vo);
    
    List<BoardVo> getBoardList(String str1, String str2);
    
    void cnt(BoardVo vo);
}

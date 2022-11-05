package com.springbook.biz.board;

import java.util.List;

public interface BoardService {
    void  insert(BoardVo vo);
    void  update(BoardVo vo);
    void  delete(int seq);
    BoardVo  getBoard(int seq);
    List<BoardVo>  getBoardList(BoardVo vo);
}

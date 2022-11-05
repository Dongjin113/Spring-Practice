package com.springbook.biz.ajax;

import java.util.List;

public interface AjaxDao {
    void  insert(AjaxVo  vo);
    void  update(AjaxVo  vo);
    void  delete(AjaxVo  vo);
    AjaxVo getBoard(AjaxVo  vo);
    List<AjaxVo> getBoardList(AjaxVo  vo);
}

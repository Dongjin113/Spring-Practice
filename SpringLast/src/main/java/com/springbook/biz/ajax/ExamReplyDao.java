package com.springbook.biz.ajax;

import java.util.List;

public interface ExamReplyDao {
    void  insert(ExamReplyVo vo);
    void  delete(ExamReplyVo vo);
    List<ExamReplyVo>  select(ExamReplyVo vo);
}

package com.springbook.biz.ajax;

import java.util.List;

public interface ExamReplyService {
    void  insert(ExamReplyVo vo);
    void  delete(ExamReplyVo vo);
    List<ExamReplyVo>  select(ExamReplyVo vo);
}

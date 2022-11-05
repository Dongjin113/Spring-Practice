package com.springbook.biz.reply;

import java.util.List;

public interface ReplyService {
     List<ReplyVo> selectAll(ReplyVo vo);
     
     void  insert(ReplyVo vo);
     
     void  delete(ReplyVo vo);
     
}

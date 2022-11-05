package com.springbook.biz.coursereply;

import java.util.List;

import com.springbook.biz.reply.ReplyVo;

public interface CourseReplyService {
	
    List<CourseReplyVo> selectAll(CourseReplyVo vo);
    
    void  insert(CourseReplyVo vo);
    
    void  delete(CourseReplyVo vo);
}

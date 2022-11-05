package com.springbook.biz.coursereply;

import java.util.List;

public interface CourseReplyDao {
	
	void insert(CourseReplyVo vo);
	void delete(CourseReplyVo vo);
	
	List<CourseReplyVo> SelectAll(CourseReplyVo vo);
	
}

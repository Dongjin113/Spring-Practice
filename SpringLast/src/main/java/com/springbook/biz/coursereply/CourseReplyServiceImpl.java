package com.springbook.biz.coursereply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.reply.ReplyVo;

@Service
public class CourseReplyServiceImpl 
               implements CourseReplyService  {

	
	@Autowired
	private CourseReplyDao dao;
	
	@Override
	public List<CourseReplyVo> selectAll(CourseReplyVo vo) {
		
		return dao.SelectAll(vo);
	}

	@Override
	public void insert(CourseReplyVo vo) {
		dao.insert(vo);
		
	}

	@Override
	public void delete(CourseReplyVo vo) {
		dao.delete(vo);
		
	}

}

package com.springbook.biz.coursereply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseReplyServiceImpl implements CourseReplyService{

	@Autowired
	private CourseReplyDao dao;
	
	@Override
	public void insert(CourseReplyVo vo) {

		dao.insert(vo);
		
	}

	@Override
	public void delete(CourseReplyVo vo) {

		dao.delete(vo);
		
	}

	@Override
	public List<CourseReplyVo> SelectAll(CourseReplyVo vo) {
		// TODO Auto-generated method stub
		return dao.SelectAll(vo);
	}
	
	

}

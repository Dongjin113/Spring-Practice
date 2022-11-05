package com.springbook.biz.coursereply;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseReplyDaoImpl implements CourseReplyDao{

	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	@Override
	public void insert(CourseReplyVo vo) {

		mybatis.insert("COURSEREPLY.insert",vo);
		
	}

	@Override
	public void delete(CourseReplyVo vo) {

		mybatis.delete("COURSEREPLY.delete", vo);
		
	}

	@Override
	public List<CourseReplyVo> SelectAll(CourseReplyVo vo) {
		
		return mybatis.selectList("COURSEREPLY.getBoardList", vo);
	}


}
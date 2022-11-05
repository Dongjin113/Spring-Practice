package com.springbook.biz.ajax;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExamReplyDaoImpl implements ExamReplyDao {
	
	@Autowired
	private  SqlSessionTemplate  mybatis;
	
	@Override
	public void insert(ExamReplyVo vo) {
		mybatis.insert("ExamReply.insert", vo);
		
	}

	@Override
	public void delete(ExamReplyVo vo) {
		mybatis.delete("ExamReply.delete", vo);
		
	}

	@Override
	public List<ExamReplyVo> select(ExamReplyVo vo) {
		return mybatis.selectList("ExamReply.select", vo);
	}

}

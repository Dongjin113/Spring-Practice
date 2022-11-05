package com.springbook.biz.reply;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDaoImpl implements ReplyDao{

	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	@Override
	public List<ReplyVo> selectAll(ReplyVo vo) {
		
		
		return mybatis.selectList("REPLY.getBoard", vo);
	}


	@Override
	public void insert(ReplyVo vo) {
		mybatis.insert("REPLY.insert", vo);
		
	}


	@Override
	public void delete(ReplyVo vo) {
		mybatis.delete("REPLY.delete",vo);
		
	}


	@Override
	public void insertEnrol(ReplyVo vo) {
		mybatis.insert("REPLY.insertEnrol", vo);
		
	}


	@Override
	public void deleteEnrol(ReplyVo vo) {
		mybatis.delete("REPLY.deleteEnrol", vo);
		
	}

}
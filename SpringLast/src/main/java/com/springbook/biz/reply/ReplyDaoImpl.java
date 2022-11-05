package com.springbook.biz.reply;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDaoImpl implements ReplyDao {

	@Autowired
	private  SqlSessionTemplate  mybatis;
	
	@Override
	public List<ReplyVo> selectAll(ReplyVo vo) {		
		return mybatis.selectList("REPLY.getBoardList", vo);
	}

	@Override
	public void insert(ReplyVo vo) {
		mybatis.insert("REPLY.insert", vo);
		
	}

	@Override
	public void delete(ReplyVo vo) {
		System.out.println("확인"+ vo);
		mybatis.delete("REPLY.delete", vo);
		
	}

}

package com.springbook.biz.reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService  {

	@Autowired
	private ReplyDao dao;
	
	@Override
	public List<ReplyVo> selectAll(ReplyVo vo) {
		return dao.selectAll(vo);
	}

	@Override
	public void insert(ReplyVo vo) {
		dao.insert(vo);
		
	}

	@Override
	public void delete(ReplyVo vo) {
		dao.delete(vo);
		
	}

}

package com.springbook.biz.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamReplyServiceImpl  implements  ExamReplyService {

	@Autowired
	private ExamReplyDao  dao;
	
	@Override
	public void insert(ExamReplyVo vo) {
		dao.insert(vo);
		
	}

	@Override
	public void delete(ExamReplyVo vo) {
		dao.delete(vo);
		
	}

	@Override
	public List<ExamReplyVo> select(ExamReplyVo vo) {		
		return dao.select(vo);
	}

}

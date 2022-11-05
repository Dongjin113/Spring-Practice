package com.springbook.biz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springbook.biz.dao.ExamtblDao;
import com.springbook.biz.examtbl.ExamtblVo;

@Service
public class ExamtblServiceImpl implements ExamtblService{

	private ExamtblDao dao;
	
	@Override
	public List<ExamtblVo> getselect(ExamtblVo vo) {
		// TODO Auto-generated method stub
		return dao.getselect(vo);
	}

}

package com.springbook.biz.examtbl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl implements ExamService{

	@Autowired
	ExamDao dao;
	
	@Override
	public void insert(ExamtblVo vo) {
		dao.insert(vo);
		
	}

	@Override
	public void update(ExamtblVo vo) {
		dao.update(vo);
		
	}

	@Override
	public void delete(ExamtblVo vo) {
		dao.delete(vo);
		
	}

	@Override
	public ExamtblVo getExam(ExamtblVo vo) {
		// TODO Auto-generated method stub
		return dao.getExam(vo);
	}

	@Override
	public List<ExamtblVo> getExamList(ExamtblVo vo) {
		// TODO Auto-generated method stub
		return dao.getExamList(vo);
	}

}

package com.springbook.biz.examtbl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamDao  dao;
	
	@Override
	public void insertExam(ExamtblVo vo) {
		dao.insertExam(vo);
		
	}

	@Override
	public void updateExam(ExamtblVo vo) {
		dao.updateExam(vo);
		
	}

	@Override
	public void deleteExam(ExamtblVo vo) {
		dao.deleteExam(vo);
		
	}

	@Override
	public ExamtblVo getExam(ExamtblVo vo) {
		
		return dao.getExam(vo);
	}

	@Override
	public List<ExamtblVo> getExamList(ExamtblVo vo) {		
		return dao.getExamList(vo);
	}

	@Override
	public void cntExam(ExamtblVo vo) {
		dao.cntExam(vo);
		
	}

}

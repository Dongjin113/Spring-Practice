package com.springbook.biz.examtbl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExamDaoImpl implements ExamDao{

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public void insert(ExamtblVo vo) {
		mybatis.insert("EXAMTBL.insert", vo);
	}

	@Override
	public void update(ExamtblVo vo) {
		mybatis.update("EXAMTBL.update", vo);
		
	}

	@Override
	public void delete(ExamtblVo vo) {
		mybatis.delete("EXAMTBL.delete", vo);
		
	}

	@Override
	public ExamtblVo getExam(ExamtblVo vo) {
		mybatis.update("EXAMTBL.cnt", vo);
		
		return mybatis.selectOne("EXAMTBL.getExam", vo);
	}

	@Override
	public List<ExamtblVo> getExamList(ExamtblVo vo) {
		return mybatis.selectList("EXAMTBL.getExamList");
	}

}

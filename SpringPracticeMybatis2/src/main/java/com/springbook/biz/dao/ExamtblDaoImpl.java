package com.springbook.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.examtbl.ExamtblVo;

@Repository
public class ExamtblDaoImpl implements ExamtblDao{

	private SqlSessionTemplate jdbTemplate;
	
	
	@Override
	public List<ExamtblVo> getselect(ExamtblVo vo) {
		// TODO Auto-generated method stub
		return jdbTemplate.selectList("EXAMTBL.getExamList",vo);
	}

}

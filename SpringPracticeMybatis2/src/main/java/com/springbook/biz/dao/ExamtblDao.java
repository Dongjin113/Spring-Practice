package com.springbook.biz.dao;

import java.util.List;

import com.springbook.biz.examtbl.ExamtblVo;

public interface ExamtblDao {
	
	List<ExamtblVo> getselect(ExamtblVo vo);

}

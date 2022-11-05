package com.springbook.biz.service;

import java.util.List;

import com.springbook.biz.examtbl.ExamtblVo;


public interface ExamtblService {

	List<ExamtblVo> getselect(ExamtblVo vo);
}

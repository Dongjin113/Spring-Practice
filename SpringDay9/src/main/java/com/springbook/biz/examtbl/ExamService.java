package com.springbook.biz.examtbl;

import java.util.List;

public interface ExamService {
	void insert(ExamtblVo vo);
	void update(ExamtblVo vo);
	void delete(ExamtblVo vo);
	ExamtblVo getExam(ExamtblVo vo);
	List<ExamtblVo> getExamList(ExamtblVo vo);

}

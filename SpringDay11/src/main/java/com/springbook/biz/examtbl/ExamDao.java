package com.springbook.biz.examtbl;

import java.util.List;

public interface ExamDao {
   void insertExam(ExamtblVo vo);
   void updateExam(ExamtblVo vo);
   void deleteExam(ExamtblVo vo);
   
   void cntExam(ExamtblVo vo);
   
   ExamtblVo getExam(ExamtblVo vo);
   List<ExamtblVo> getExamList(ExamtblVo vo);
}

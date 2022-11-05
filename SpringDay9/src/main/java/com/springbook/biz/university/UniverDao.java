package com.springbook.biz.university;

import java.util.List;

import com.springbook.biz.examtbl.ExamtblVo;

public interface UniverDao {

	List<StudentVo> getUniverseList(StudentVo vo);
	
}

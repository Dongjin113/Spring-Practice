package com.springbook.biz.university;

import java.util.List;

public interface UniversityDao {
	   List<StudentVo> student();
	   List<EnrolVo> enrol();
	   List<CourseVo> course();
	   List<SEJoinVo> SEJoin();
	   List<SECJoinVo> SECJoin();
	   
	   void  studentInsert(StudentVo vo);
	   void  studentUpdate(StudentVo vo);
	   StudentVo  studentEdit(StudentVo vo);
	   
	   void  entroInsert(EnrolVo vo);
	   
	   EnrolVo  enrolEdit(EnrolVo vo);
	   void  enrolUpdate(EnrolVo vo);
	   
	   List<CourseGroupVo> courseGroup();
	   
	   CourseVo courseEdit(CourseVo vo);
	   
}

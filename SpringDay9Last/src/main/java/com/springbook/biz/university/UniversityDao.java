package com.springbook.biz.university;

import java.util.List;

public interface UniversityDao {
	   List<StudentVo> student();
	   List<EnrolVo> enrol();
	   List<CourseVo> course();
	   List<SEJoinVo> SEJoin();
	   List<SECJoinVo> SECJoinVo();
}

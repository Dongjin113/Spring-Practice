package com.springbook.biz.university;

import java.util.List;

public interface UniversityService {
   List<StudentVo> student();
   List<EnrolVo> enrol();
   List<CourseVo> course();
   List<SEJoinVo> SEJoin();
   List<SECJoinVo> SECJoinVo();
}

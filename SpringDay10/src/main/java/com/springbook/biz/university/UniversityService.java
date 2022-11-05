package com.springbook.biz.university;

import java.util.List;

public interface UniversityService {
   List<StudentVo> student();
   List<EnrolVo> enrol();
   List<CourseVo> course();
   List<SEJoinVo> SEJoin();
   List<SECJoinVo> SECJoin();
   void insert(StudentVo vo);
   StudentVo getstudent(StudentVo vo);
   void edit(StudentVo vo);
   EnrolVo getEnrol(EnrolVo vo);
   void enroledit(EnrolVo vo);
   List<AvgVo> enrolavg();
   void delete(EnrolVo vo);
}

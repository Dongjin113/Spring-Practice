package com.springbook.biz.university;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniversityServiceImpl implements UniversityService {

	@Autowired
	private UniversityDao dao ;
	
	@Override
	public List<StudentVo> student() {
		
		return dao.student();
	}

	@Override
	public List<EnrolVo> enrol() {
		
		return dao.enrol();
	}

	@Override
	public List<CourseVo> course() {
		
		return dao.course();
	}

	@Override
	public List<SEJoinVo> SEJoin() {
		
		return dao.SEJoin();
	}

	@Override
	public List<SECJoinVo> SECJoinVo() {
		
		return dao.SECJoinVo();
	}

}

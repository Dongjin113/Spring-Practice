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
	public List<SECJoinVo> SECJoin() {		
		return dao.SECJoin();
	}

	@Override
	public void studentInsert(StudentVo vo) {
		dao.studentInsert(vo);		
	}

	@Override
	public void studentUpdate(StudentVo vo) {
		dao.studentUpdate(vo);		
	}

	@Override
	public StudentVo studentEdit(StudentVo vo) {
		return dao.studentEdit(vo);
	}

	@Override
	public void entroInsert(EnrolVo vo) {
		dao.entroInsert(vo);
		
	}

	@Override
	public EnrolVo enrolEdit(EnrolVo vo) {
		// TODO Auto-generated method stub
		return dao.enrolEdit(vo);
	}

	@Override
	public void enrolUpdate(EnrolVo vo) {
		dao.enrolUpdate(vo);
		
	}

	@Override
	public List<CourseGroupVo> courseGroup() {
		// TODO Auto-generated method stub
		return dao.courseGroup();
	}

	@Override
	public CourseVo courseEdit(CourseVo vo) {
		// TODO Auto-generated method stub
		return dao.courseEdit(vo);
	}

}

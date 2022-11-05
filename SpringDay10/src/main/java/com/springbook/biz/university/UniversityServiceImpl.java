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
	public void insert(StudentVo vo) {
		dao.insert(vo);
		
	}

	@Override
	public StudentVo getstudent(StudentVo vo) {
		// TODO Auto-generated method stub
		return dao.getstudent(vo);
	}

	@Override
	public void edit(StudentVo vo) {
		dao.edit(vo);
		
	}

	@Override
	public EnrolVo getEnrol(EnrolVo vo) {
		return dao.getEnrol(vo);
	}

	@Override
	public void enroledit(EnrolVo vo) {
		dao.enroledit(vo);
		
	}

	@Override
	public List<AvgVo> enrolavg() {
		// TODO Auto-generated method stub
		return dao.enrolavg();
	}

	@Override
	public void delete(EnrolVo vo) {

		dao.delete(vo);
		
	}

}

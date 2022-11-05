package com.springbook.biz.university;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UniversityDaoImpl implements UniversityDao {

	@Autowired
	private  SqlSessionTemplate  mybatis;
	
	@Override
	public List<StudentVo> student() {
		
		return mybatis.selectList("university.student");
	}

	@Override
	public List<EnrolVo> enrol() {
		// TODO Auto-generated method stub
		return mybatis.selectList("university.enrol");
	}

	@Override
	public List<CourseVo> course() {
		// TODO Auto-generated method stub
		return mybatis.selectList("university.course");
	}

	@Override
	public List<SEJoinVo> SEJoin() {
		// TODO Auto-generated method stub
		return mybatis.selectList("university.sejoin");
	}

	@Override
	public List<SECJoinVo> SECJoin() {
		// TODO Auto-generated method stub
		return mybatis.selectList("university.secjoin");
	}

	@Override
	public void studentInsert(StudentVo vo) {
		mybatis.insert("university.studentInsert", vo);
		
	}

	@Override
	public void studentUpdate(StudentVo vo) {
		mybatis.update("university.studentUpdate", vo);		
	}

	@Override
	public StudentVo studentEdit(StudentVo vo) {	
		System.out.println("===> "+ vo);
		return mybatis.selectOne("university.studentEdit", vo);
	}

	@Override
	public void entroInsert(EnrolVo vo) {
		mybatis.insert("university.enrolInsert", vo);
		
	}

	@Override
	public EnrolVo enrolEdit(EnrolVo vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("university.enrolEdit", vo);
	}

	@Override
	public void enrolUpdate(EnrolVo vo) {
		mybatis.update("university.enrolUpdate", vo);
		
	}

	@Override
	public List<CourseGroupVo> courseGroup() {
		// TODO Auto-generated method stub
		return mybatis.selectList("university.courseGroup");
	}

	@Override
	public CourseVo courseEdit(CourseVo vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("university.courseEdit", vo);
	}

}

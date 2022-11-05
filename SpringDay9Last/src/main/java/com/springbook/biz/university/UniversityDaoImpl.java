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
	public List<SECJoinVo> SECJoinVo() {
		// TODO Auto-generated method stub
		return mybatis.selectList("university.secjoin");
	}

}

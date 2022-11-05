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
	public void insert(StudentVo vo) {
		mybatis.insert("university.insert",vo);
		
	}

	@Override
	public StudentVo getstudent(StudentVo vo) {
		return mybatis.selectOne("university.getstudent",vo);
		
	}

	@Override
	public void edit(StudentVo vo) {
		
		mybatis.update("university.edit", vo);
		
	}

	@Override
	public EnrolVo getEnrol(EnrolVo vo) {
		
		return mybatis.selectOne("university.getenrol",vo);
	}

	@Override
	public void enroledit(EnrolVo vo) {

		mybatis.update("university.enroledit", vo);
		
	}

	@Override
	public List<AvgVo> enrolavg() {
		return mybatis.selectList("university.avg");
	}

	@Override
	public void delete(EnrolVo vo) {
		
		mybatis.delete("university.delete", vo);
		
	}

	

}

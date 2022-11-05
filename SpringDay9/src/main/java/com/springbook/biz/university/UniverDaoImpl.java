package com.springbook.biz.university;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UniverDaoImpl implements UniverDao{
	
		@Autowired
		private SqlSessionTemplate mybatis;
	
	
	@Override
	public List<StudentVo> getUniverseList(StudentVo vo) {
		return mybatis.selectList("EXAMTBL.studentList");
	}

}
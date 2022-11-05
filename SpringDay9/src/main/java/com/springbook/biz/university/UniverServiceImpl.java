package com.springbook.biz.university;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniverServiceImpl implements UniverService{

	@Autowired
	UniverDao dao;
	
	@Override
	public List<StudentVo> getUniverseList(StudentVo vo) {
		// TODO Auto-generated method stub
		return dao.getUniverseList(vo);
	}

}

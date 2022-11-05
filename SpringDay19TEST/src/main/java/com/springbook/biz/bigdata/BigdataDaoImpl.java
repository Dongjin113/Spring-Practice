package com.springbook.biz.bigdata;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BigdataDaoImpl implements BigdataDao  {
	
	@Autowired
	private  SqlSessionTemplate  mybatis;
	

	@Override
	public List<BigdataVo> selectTop15(BigdataVo vo) {
		System.out.println("확인:" + vo);
		return mybatis.selectList("BIGDATA.selectTop15", vo);
	}


	@Override
	public List<BigdataVo> selectList(BigdataVo vo) {
		System.out.println("selectList(BigdataVo vo) 확인:" + vo);
		return mybatis.selectList("BIGDATA.selectList", vo);
	}


	@Override
	public int totalCount(BigdataVo vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("BIGDATA.totalCount");
	}

	
}

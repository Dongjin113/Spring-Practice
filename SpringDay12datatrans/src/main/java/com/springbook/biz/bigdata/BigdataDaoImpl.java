package com.springbook.biz.bigdata;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BigdataDaoImpl implements BigdataDao{

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public List<BigdataVo> selectTop15(BigdataVo vo) {
		
		System.out.println(vo.toString());
		return mybatis.selectList("BIGDATA.selectTop15" , vo);
	
	}

	
	

}

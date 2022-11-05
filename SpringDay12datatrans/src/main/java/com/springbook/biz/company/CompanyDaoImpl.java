package com.springbook.biz.company;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDaoImpl implements CompanyDao{
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public void companyInsert(CompanyVo vo) {
		mybatis.insert("COMPANY.insert",vo);
		
	}

}

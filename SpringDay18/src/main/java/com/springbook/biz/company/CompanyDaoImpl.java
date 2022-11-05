package com.springbook.biz.company;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDaoImpl implements CompanyDao {

	@Autowired
	private  SqlSessionTemplate  mybatis;
	
	@Override
	public void companyInsert(CompanyVo vo) {
		mybatis.insert("COMPANY.insert" , vo);		
	}

	@Override
	public List<CompanyVo> select() {
		// TODO Auto-generated method stub
		return mybatis.selectList("COMPANY.select");
	}

}

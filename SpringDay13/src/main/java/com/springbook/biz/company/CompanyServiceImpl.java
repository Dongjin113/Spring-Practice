package com.springbook.biz.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyDao dao;
	
	@Override
	public void companyInsert(CompanyVo vo) {
		dao.companyInsert(vo);
		
	}

}

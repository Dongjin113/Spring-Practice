package com.springbook.biz.company;

import java.util.List;

public interface CompanyDao {

	void  companyInsert(CompanyVo vo); 
	
	List<CompanyVo> select();
}

package com.springbook.biz.company;

import java.util.List;

public interface CompanyService {

	void companyInsert(CompanyVo vo);
	
	List<CompanyVo> select();
}

package com.springbook.biz.bigdata;

import java.util.List;

public interface BigdataService {
	
	List<BigdataVo> selectTop15(BigdataVo vo);
}

package com.springbook.biz.bigdata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataServiceImpl implements  BigdataService {

	@Autowired
	private BigdataDao  dao;
	
	@Override
	public List<BigdataVo> selectTop15(BigdataVo vo) {
		return dao.selectTop15(vo);
	}

	@Override
	public List<BigdataVo> selectList(BigdataVo vo) {
		return dao.selectList(vo);
	}

	@Override
	public int totalCount(BigdataVo vo) {
		return dao.totalCount(vo);
	}

}

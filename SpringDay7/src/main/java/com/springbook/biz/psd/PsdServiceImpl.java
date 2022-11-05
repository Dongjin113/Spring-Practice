package com.springbook.biz.psd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PsdServiceImpl implements PsdService  {

	@Autowired
	private PsdDao dao;
	
	@Override
	public void insert(PsdVo vo) {
		dao.insert(vo);
		
	}

	@Override
	public void update(PsdVo vo) {
		dao.update(vo);
		
	}

	@Override
	public void delete(PsdVo vo) {
		dao.delete(vo);
		
	}

	@Override
	public PsdVo getPsd(PsdVo vo) {
		
		return dao.getPsd(vo);
	}

	@Override
	public List<PsdVo> getPsdList(PsdVo vo) {
		
		return dao.getPsdList(vo);
	}

}

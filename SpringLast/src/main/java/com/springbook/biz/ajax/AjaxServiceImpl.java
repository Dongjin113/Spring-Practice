package com.springbook.biz.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AjaxServiceImpl implements AjaxService  {

	@Autowired
	private  AjaxDao dao;
	
	
	@Override
	public void insert(AjaxVo vo) {
		dao.insert(vo);
	}

	@Override
	public void update(AjaxVo vo) {
		dao.update(vo);
	}

	@Override
	public void delete(AjaxVo vo) {
		dao.delete(vo);
	}

	@Override
	public AjaxVo getBoard(AjaxVo vo) {
		return dao.getBoard(vo);
	}

	@Override
	public List<AjaxVo> getBoardList(AjaxVo vo) {
		return dao.getBoardList(vo);
	}

}

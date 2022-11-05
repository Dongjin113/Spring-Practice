package com.springbook.biz.ajax;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AjaxDaoImpl  implements  AjaxDao  {
	
	@Autowired
	private  SqlSessionTemplate  mybatis;
	
	@Override
	public void insert(AjaxVo vo) {
		mybatis.insert("AJAX.insert", vo);	
		
	}

	@Override
	public void update(AjaxVo vo) {
		System.out.println("Update확인:" + vo.getSno());
		mybatis.update("AJAX.update", vo);
		
	}

	@Override
	public void delete(AjaxVo vo) {
		System.out.println("===> SNO : " +vo.getSno());
		mybatis.delete("AJAX.delete", vo);
		
	}

	@Override
	public AjaxVo getBoard(AjaxVo vo) {		
		return mybatis.selectOne("AJAX.getAjax", vo);
	}

	@Override
	public List<AjaxVo> getBoardList(AjaxVo vo) {
		return mybatis.selectList("AJAX.getAjaxList", vo);
	}

}

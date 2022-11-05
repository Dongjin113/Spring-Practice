package com.springbook.biz.psd;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PsdDaoMybatis implements PsdDao {

	@Autowired
	private SqlSessionTemplate  jdbcTemplate;
	
	@Override
	public void insert(PsdVo vo) {
		
		Date date=new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		String strNowDate = simpleDateFormat.format(date);
		vo.setRegDateStr(strNowDate);
		jdbcTemplate.insert("PSD.insertPsd", vo);		
		
	}

	@Override
	public void update(PsdVo vo) {
		
		Date date=new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		String strNowDate = simpleDateFormat.format(date);
		vo.setRegDateStr(strNowDate);
		
		if (vo.getUpdateFileStr() == null || vo.getUpdateFileStr().equals("") ) {
		  jdbcTemplate.update("PSD.UPDATE_SQL2", vo);	
		} else {
		  jdbcTemplate.update("PSD.UPDATE_SQL1", vo);		
		}
		
	}

	@Override
	public void delete(PsdVo vo) {
		jdbcTemplate.update("PSD.deletePsd", vo);			
	}

	@Override
	public PsdVo getPsd(PsdVo vo) {
		return jdbcTemplate.selectOne("PSD.getPsd", vo);
	}

	@Override
	public List<PsdVo> getPsdList(PsdVo vo) {
		return jdbcTemplate.selectList("PSD.getPsdList", vo);
	}

}


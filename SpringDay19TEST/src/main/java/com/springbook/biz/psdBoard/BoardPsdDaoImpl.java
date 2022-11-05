package com.springbook.biz.psdBoard;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardPsdDaoImpl implements  BoardPsdDao{

	@Autowired
    private  SqlSessionTemplate  mybatis;
	
	@Override
	public void insert(BoardPsdVo vo) {	
		Date date=new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		String strNowDate = simpleDateFormat.format(date);
		vo.setRegdatestr(strNowDate);
		mybatis.insert("PSDBOARD.insert", vo);		
	}

	@Override
	public void update(BoardPsdVo vo) {
		System.out.println("===> " + vo );
		if (vo.getUpdateFilestr()== null ||vo.getUpdateFilestr()=="") {
		  mybatis.update("PSDBOARD.update2", vo);
		  System.out.println(" 이미지 파일 없음!! " ); 
		} else {
		  mybatis.update("PSDBOARD.update1", vo);
		}
	}

	@Override
	public void delete(BoardPsdVo vo) {
		mybatis.delete("PSDBOARD.delete", vo);
		
	}

	@Override
	public BoardPsdVo getBoard(BoardPsdVo vo) {
		
		return mybatis.selectOne("PSDBOARD.getBorad", vo);
	}

	@Override
	public List<BoardPsdVo> getBoardList(BoardPsdVo vo) {
		
		return mybatis.selectList("PSDBOARD.getBoradList", vo);
	}

}

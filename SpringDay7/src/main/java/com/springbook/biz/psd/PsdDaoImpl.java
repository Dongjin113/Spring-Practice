package com.springbook.biz.psd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PsdDaoImpl implements PsdDao {

	@Autowired
    private  JdbcTemplate  jdbcTemplate;
	
	private final String INSERT_SQL="insert into  boardPsd (seq, title, writer, content, regdate, updatefile ) "
			+ " values ((select nvl(max(seq),1001)+1 from boardPsd ),?,?,?,?,?) ";
    private final  String SELECT_SQL="select  *  from  boardPsd order by seq  desc ";
	
    private final  String EDIT_SQL="select  *  from  boardPsd where seq=?";

    private final  String DELETE_SQL="delete from boardPsd where seq=?";
 
	private final String UPDATE_SQL1="update boardPsd set title=?, content=?, updatefile=? ,regdate=?  where seq=? ";
 
	private final String UPDATE_SQL2="update boardPsd set title=?, content=? , regdate=? where seq=? ";
    
	@Override
	public void insert(PsdVo vo) {

		
		Date date=new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		String strNowDate = simpleDateFormat.format(date);
		System.out.println("날짜확인:" + strNowDate);
	
		Object [] args = {vo.getTitle(), vo.getWriter() ,vo.getContent(), strNowDate, vo.getUpdateFileStr()};
		jdbcTemplate.update(INSERT_SQL, args);		

		
	}

	@Override
	public void update(PsdVo vo) {
		
		Date date=new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		String strNowDate = simpleDateFormat.format(date);
		System.out.println("날짜확인:" + strNowDate);
		
		if (vo.getUpdateFileStr() == null || vo.getUpdateFileStr().equals("") ) {
		  Object [] args = {vo.getTitle(), vo.getContent(), strNowDate, vo.getSeq() };
		  jdbcTemplate.update(UPDATE_SQL2, args);	
		} else {
		  Object [] args = {vo.getTitle(), vo.getContent(),vo.getUpdateFileStr(), strNowDate ,vo.getSeq() };
		  jdbcTemplate.update(UPDATE_SQL1, args);		
		}
		
	}

	@Override
	public void delete(PsdVo vo) {
		Object [] args = {vo.getSeq()};
		jdbcTemplate.update(DELETE_SQL, args);	
		
	}

	@Override
	public PsdVo getPsd(PsdVo vo) {
		Object [] args = {vo.getSeq()};
		System.out.println("확인:" + args);
		return jdbcTemplate.queryForObject(EDIT_SQL, new PsdRowMap(), args);
	}

	@Override
	public List<PsdVo> getPsdList(PsdVo vo) {
		return jdbcTemplate.query(SELECT_SQL, new PsdRowMap());
	}

}


class  PsdRowMap implements RowMapper<PsdVo> {

	@Override
	public PsdVo mapRow(ResultSet rs, int rowNum) throws SQLException {
		PsdVo vo =new PsdVo();
		vo.setSeq(rs.getInt("seq"));
		vo.setTitle(rs.getString("title"));
		vo.setWriter(rs.getString("writer"));;
		vo.setContent(rs.getString("content"));
		vo.setRegDate(rs.getDate("regdate"));
		vo.setCnt(rs.getInt("cnt"));		
		vo.setUpdateFileStr(rs.getString("updatefile"));
	
		return vo;
	}
	
}

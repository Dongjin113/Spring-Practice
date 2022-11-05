package com.springbook.biz.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVo;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
    private  JdbcTemplate  jdbcTemplate;
	
	private final String INSERT_SQL="insert into  board (seq, title, writer, content, regdate) "
			+ " values ((select max(nvl(seq,0))+1 from board ),?,?,?,?) ";
	
	private final String UPDATE_SQL="update board set  title=?, writer=? ,  content=? where seq=?   ";
	
	private final String DELETE_SQL="delete  from board where seq=?  ";
	
	private final String GETBOARD_SQL="select  *  from board  where seq=? ";
	
	private final String CNT_SQL="update board set  cnt=cnt+1 where seq=?   ";

	private final String GETBOARDLIST_SQL="select * from board  order by seq  desc";
	private final String GETBOARDTITLE_SQL="select * from board where title like ?  order by seq  desc";
	private final String GETBOARDWRITER_SQL="select * from board where writer like ?    order by seq  desc";

	// 참고 오라클, H2 사용가능
	//private final String GETBOARDWRITER_SQL="select * from board where writer like '%'||?||'%'  order by seq  desc";

	
	@Override
	public void insert(BoardVo vo) {	
		
		Date date=new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		String strNowDate = simpleDateFormat.format(date);
		System.out.println("날짜확인:" + strNowDate);
	
		Object [] args = {vo.getTitle(), vo.getWriter() ,vo.getContent(), strNowDate};
		jdbcTemplate.update(INSERT_SQL, args);		
	}

	@Override
	public void update(BoardVo vo) {
		Object [] args = { vo.getTitle(), vo.getWriter() ,vo.getContent(), vo.getSeq()};
		jdbcTemplate.update(UPDATE_SQL, args);
		
	}

	@Override
	public void delete(BoardVo vo) {
		Object [] args = {vo.getSeq()};
		jdbcTemplate.update(DELETE_SQL, args);
		
	}

	@Override
	public BoardVo getBoard(BoardVo vo) {
		Object [] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(GETBOARD_SQL, new BoardRowMapper(), args );
	}

	@Override
	public List<BoardVo> getBoardList(BoardVo vo) {
				
		if (vo.getSearchKeyword() == null || vo.getSearchKeyword().equals("") ) {
		  return  jdbcTemplate.query(GETBOARDLIST_SQL, new BoardRowMapper());
		} else if(vo.getSearchCondition().equals("title")) {
		  return  jdbcTemplate.query(GETBOARDTITLE_SQL, new BoardRowMapper(), "%" + vo.getSearchKeyword() + "%");
		} else if(vo.getSearchCondition().equals("writer")) {
		  return  jdbcTemplate.query(GETBOARDWRITER_SQL, new BoardRowMapper(), "%" + vo.getSearchKeyword() + "%");
		}
				
		return null;
		
	}

	@Override
	public void cnt(BoardVo vo) {
		Object [] args = { vo.getSeq() };
		jdbcTemplate.update(CNT_SQL, args);

		
	}

}

class BoardRowMapper implements RowMapper<BoardVo> {
	@Override
	public BoardVo mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVo vo = new BoardVo();
		vo.setSeq(rs.getInt("seq"));
		vo.setTitle(rs.getString("title"));
		vo.setWriter(rs.getString("writer"));
		vo.setContent(rs.getString("content"));
		vo.setCnt(rs.getInt("cnt"));
		vo.setRegDate(rs.getDate("regdate"));
		return vo;
	}	
}
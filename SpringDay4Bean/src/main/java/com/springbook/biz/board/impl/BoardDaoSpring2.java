package com.springbook.biz.board.impl;


import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import com.springbook.biz.board.BoardDao;
import com.springbook.biz.board.BoardVo;

@Repository
public class BoardDaoSpring2  implements BoardDao {
	
	
	private final String BOARD_INSERT="insert into board(seq, title, writer, content)"
			+ " values((select nvl(max(seq),0)+1 from board), ?,?,?)";

   /*
	private final String BOARD_INSERT="insert into board(seq, title, writer, content)"
			+ " values(? , ?,?,?)";
   */
	
	private final String BOARD_SELECT=" select * from board order by seq  desc" ;

	private final String BOARD_EDIT="select seq, title, writer, content, regdate, cnt"
			+ " from board where seq = ? " ;

	private final String BOARD_DELETE=" delete from board where seq = ? " ;
	
	private final String BOARD_UPDATE="update board set title=?, writer=?, content=? where seq=?";


	
	// applicationContext.xml 에서  JdbcTemplate 형 받아오기
	@Autowired
    private  JdbcTemplate  jdbcTemplate;

	
	@Override
	public void insert(BoardVo vo) {
		Object[] args = {vo.getTitle(), vo.getWriter(), vo.getContent()};
		jdbcTemplate.update(BOARD_INSERT, args );
	}

	@Override
	public void update(BoardVo vo) {
		Object[] args = {vo.getTitle(), vo.getWriter(), vo.getContent(),vo.getSeq() };
		jdbcTemplate.update(BOARD_UPDATE, args);
	}

	@Override
	public void delete(int seq) {
		jdbcTemplate.update(BOARD_DELETE, seq);
		
	}

	@Override
	public BoardVo getBoard(int seq) {		
		return jdbcTemplate.queryForObject(BOARD_EDIT, new BoardRowMapper(), seq);
	}

	@Override
	public List<BoardVo> getBoardList(BoardVo v) {
		
		return  jdbcTemplate.query(BOARD_SELECT, new BoardRowMapper());

	}

	@Override
	public int cnt(int seq) {
		// TODO Auto-generated method stub
		return 0;
	}

}




package com.springbook.biz.board.impl;


import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import com.springbook.biz.board.BoardDao;
import com.springbook.biz.board.BoardVo;

// @Repository
public class BoardDaoSpring1 
             extends JdbcDaoSupport implements BoardDao {
	
	private final String BOARD_INSERT="insert into board(seq, title, writer, content)"
			+ " values((select nvl(max(seq),0)+1 from board), ?,?,?)";

	private final String BOARD_SELECT=" select * from board " ;

	private final String BOARD_EDIT="select seq, title, writer, content, regdate, cnt"
			+ " from board where seq = ? " ;

	private final String BOARD_DELETE=" delete from board where seq = ? " ;
	
	private final String BOARD_UPDATE="update board set title=?, writer=?, content=? where seq=?";


	
	// applicationContext.xml 에서 dataSource 받아오기
	@Autowired
	public  void setSuperDataSource(DataSource dataSource ) {
		
		super.setDataSource(dataSource);
	}


	
	@Override
	public void insert(BoardVo vo) {
		Object[] args = {vo.getTitle(), vo.getWriter(), vo.getContent()};
		getJdbcTemplate().update(BOARD_INSERT, args );
	}

	@Override
	public void update(BoardVo vo) {
		Object[] args = {vo.getTitle(), vo.getWriter(), vo.getContent(),vo.getSeq() };
		getJdbcTemplate().update(BOARD_UPDATE, args);
	}

	@Override
	public void delete(int seq) {
		getJdbcTemplate().update(BOARD_DELETE, seq);
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public BoardVo getBoard(int seq) {
		Object[] args = {seq}; 
		// getJdbcTemplate().queryForObject(BOARD_EDIT, args, new BoardRowMapper());
		return getJdbcTemplate().queryForObject(BOARD_EDIT, args, new BoardRowMapper());
	}

	@Override
	public List<BoardVo> getBoardList(BoardVo v) {
		
		return  getJdbcTemplate().query(BOARD_SELECT, new BoardRowMapper());

	}

}




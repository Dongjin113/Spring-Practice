package com.springbook.biz.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springbook.biz.board.BoardVo;

public class BoardRowMapper  implements RowMapper<BoardVo>{

	@Override
	public BoardVo mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVo vo=new BoardVo();
		vo.setSeq(rs.getInt("seq"));
		vo.setTitle(rs.getString("title"));
		vo.setWriter(rs.getString("writer"));
		vo.setContent(rs.getString("content"));
		vo.setRegDate(rs.getDate("regdate"));
		vo.setCnt(rs.getInt("cnt"));
		return vo;
	}
}

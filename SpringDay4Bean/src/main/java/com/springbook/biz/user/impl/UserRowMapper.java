package com.springbook.biz.user.impl;

import java.sql.*;
import org.springframework.jdbc.core.RowMapper;
import com.springbook.biz.user.UserVo;

public class UserRowMapper implements RowMapper<UserVo> {

	@Override
	public UserVo mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserVo  user=new UserVo();
		 user.setId(rs.getString("id"));
		 user.setName(rs.getString("name"));
		 user.setPassword(rs.getString("password"));
		 user.setRole(rs.getString("role"));
		return user;
	}

}

package com.springbook.biz.login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

// @Repository
public class UserDaoImpl  implements   UserDao {

	@Autowired
    private  JdbcTemplate  jdbcTemplate;
	
	final String INSERT_USER ="insert  into users(id, password, name, role)"
			+ " values(?,?,?,?)";

	final String UPDATE_USER ="update users set password=?, name=?, role =? where id =? ";

	final String DELETE_USER ="delete from users where id = ? ";

	final String EDIT_USER ="select * from users where id=?";

	final String SELECT_USER ="select * from users";
	
	final String LOGIN_USER ="select * from users where id=? and password=?";
	
	@Override
	public void insert(UserVo vo) {		
		Object [] args = {vo.getId(), vo.getPassword(), vo.getName(), vo.getRole()};
		jdbcTemplate.update(INSERT_USER, args);		
	}

	@Override
	public void update(UserVo vo) {
		Object [] args = { vo.getPassword(), vo.getName(), vo.getRole(), vo.getId()};
		jdbcTemplate.update(UPDATE_USER, args);	
	}

	@Override
	public void delete(UserVo vo) {
		Object [] args = {  vo.getId()};
		jdbcTemplate.update(DELETE_USER, args);	
	}

	@Override
	public UserVo getEdit(UserVo vo) {
		Object [] args = {vo.getId()};
		return jdbcTemplate.queryForObject(EDIT_USER, new UserRowMapper(), args);
	}

	@Override
	public List<UserVo> getSelect(UserVo vo) {		
		return jdbcTemplate.query(SELECT_USER, new UserRowMapper());
	}

	@Override
	public UserVo login(UserVo vo) {
		Object [] args = {vo.getId(), vo.getPassword()};
		UserVo user =null;	
		try {
		   user =jdbcTemplate.queryForObject(LOGIN_USER, new UserRowMapper(), args);
		   return user;
		} catch(Exception e) {
		   return user;	
		}

	}

}

class  UserRowMapper  implements RowMapper<UserVo> {

	@Override
	public UserVo mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserVo user= new UserVo();
		user.setId(rs.getString("id"));
		user.setPassword(rs.getString("password"));
		user.setName(rs.getString("name"));
		user.setRole(rs.getString("role"));
		return user;
	}
	
}

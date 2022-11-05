package com.springbook.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserDao;
import com.springbook.biz.user.UserVo;

@Repository
public class UserDaoImpl implements UserDao {
	
    String SQL="select *  from  users where id=? and password=?";

	@Autowired
    private  JdbcTemplate  jdbcTemplate;
	
	@Override
	public UserVo getUser(UserVo vo) {
		 System.out.println("서비스 확인:" + vo);
		 System.out.println(" ===>  getUser(UserVo vo) 기능처리 " );
		return jdbcTemplate.queryForObject(SQL, new UserRowMapper(), vo.getId(), vo.getPassword());
				 
	}

}

package com.springbook.biz.login;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoMybatis  implements   UserDao {

	@Autowired
	private SqlSessionTemplate  jdbcTemplate;
	
	
	@Override
	public void insert(UserVo vo) {		
		jdbcTemplate.insert("USERS.insertUser", vo);		
	}

	@Override
	public void update(UserVo vo) {
		jdbcTemplate.update("USERS.updateUser", vo);	
	}

	@Override
	public void delete(UserVo vo) {
		jdbcTemplate.delete("USERS.deleteUser", vo);	
	}

	@Override
	public UserVo getEdit(UserVo vo) {
		return jdbcTemplate.selectOne("USERS.getUser",vo);
	}

	@Override
	public List<UserVo> getSelect(UserVo vo) {		
		return jdbcTemplate.selectList("USERS.getUserList", vo);
	}

	@Override
	public UserVo login(UserVo vo) {
		
		UserVo user =null;	
		try {
		   user =jdbcTemplate.selectOne("USERS.LOGIN_USER", vo);
		   return user;
		} catch(Exception e) {
		   return user;	
		}

	}

}



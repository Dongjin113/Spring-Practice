package com.springbook.biz.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService  {
  
	@Autowired 
  	private UserDao  dao;
	
	@Override
	public void insert(UserVo vo) {
		dao.insert(vo);		
	}

	@Override
	public void update(UserVo vo) {
		dao.update(vo);		
	}

	@Override
	public void delete(UserVo vo) {
		dao.delete(vo);		
	}

	@Override
	public UserVo getEdit(UserVo vo) {
		
		return dao.getEdit(vo);
	}

	@Override
	public List<UserVo> getSelect(UserVo vo) {
		
		return dao.getSelect(vo);
	}

	@Override
	public UserVo login(UserVo vo) {
		// TODO Auto-generated method stub
		return dao.login(vo);
	}

}

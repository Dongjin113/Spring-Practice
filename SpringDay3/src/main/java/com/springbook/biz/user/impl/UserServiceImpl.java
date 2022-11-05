package com.springbook.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserDao;
import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVo;

@Service("userService")
public class UserServiceImpl  implements UserService  {

	@Autowired
	private  UserDao userDao;

	@Override
	public UserVo getUser(UserVo vo) {
        System.out.println("서비스 확인:" + vo);
		return userDao.getUser(vo);
	}

}

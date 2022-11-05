package com.springbook.biz.login;

import java.util.List;

public interface UserDao {
	   void insert(UserVo vo);
	   void update(UserVo vo);
	   void delete(UserVo vo);
	   UserVo getEdit(UserVo vo);
	   List<UserVo> getSelect(UserVo vo);
	   UserVo login(UserVo vo);
}

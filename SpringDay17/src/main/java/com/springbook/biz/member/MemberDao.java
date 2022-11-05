package com.springbook.biz.member;

import java.util.List;

public interface MemberDao {
	
	void insert(MemberVo vo);
	void delete(MemberVo vo);
	

	MemberVo edit(MemberVo vo);
	List<MemberVo> selectAll(MemberVo vo);
	

	MemberVo login(MemberVo vo);
}

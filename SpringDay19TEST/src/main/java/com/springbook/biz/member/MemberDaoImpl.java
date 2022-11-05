package com.springbook.biz.member;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl  implements MemberDao  {
	
	@Autowired
    private  SqlSessionTemplate  mybatis;
	
	@Override
	public void insert(MemberVo vo) {
		System.out.println("insert(MemberVo vo) :" + vo);
		mybatis.insert("MEMBER.insert", vo);
		
	}

	@Override
	public void update(MemberVo vo) {
		System.out.println("update(MemberVo vo) :" + vo);
		mybatis.update("MEMBER.update", vo);
		
	}

	@Override
	public void delete(MemberVo vo) {
		mybatis.delete("MEMBER.delete", vo);
		
	}

	@Override
	public MemberVo edit(MemberVo vo) {
		
		return mybatis.selectOne("MEMBER.getBorad", vo);
	}

	@Override
	public List<MemberVo> selectAll(MemberVo vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("MEMBER.getBoradList", vo);
	}

	@Override
	public MemberVo login(MemberVo vo) {
		return mybatis.selectOne("MEMBER.login", vo);
	}

}

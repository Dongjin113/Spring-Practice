package com.springbook.biz.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao  dao;
	
	@Override
	public void insert(MemberVo vo) {
		dao.insert(vo);
		
	}

	@Override
	public void update(MemberVo vo) {
		dao.update(vo);
		
	}

	@Override
	public void delete(MemberVo vo) {
		dao.delete(vo);
		
	}

	@Override
	public MemberVo edit(MemberVo vo) {		
		return dao.edit(vo);
	}

	@Override
	public List<MemberVo> selectAll(MemberVo vo) {		
		return dao.selectAll(vo);
	}

	@Override
	public MemberVo login(MemberVo vo) {
		return dao.login(vo);
	}

}

package com.springbook.biz.member;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

	private MemberDao dao;
	
	@Override
	public void insert(MemberVo vo) {

		dao.insert(vo);
		
	}

	@Override
	public void delete(MemberVo vo) {

		dao.delete(vo);
		
	}

	@Override
	public MemberVo edit(MemberVo vo) {
		// TODO Auto-generated method stub
		return dao.edit(vo);
	}

	@Override
	public List<MemberVo> selectAll(MemberVo vo) {
		// TODO Auto-generated method stub
		return dao.selectAll(vo);
	}

}

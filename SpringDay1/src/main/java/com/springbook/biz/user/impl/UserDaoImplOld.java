package com.springbook.biz.user.impl;

import java.sql.*;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserDao;
import com.springbook.biz.user.UserVo;

//@Repository
public class UserDaoImplOld implements UserDao {
	
	private JDBCUtil dbConn =null;
	private Connection conn = null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	 
	UserDaoImplOld(){
		dbConn=JDBCUtil.getInstance();		
	}
	
	@Override
	public UserVo getUser(UserVo vo) {
		 System.out.println(" ===>  getUser(UserVo vo) 기능처리 " );
		 UserVo user = null;
		try {
			 conn = dbConn.getConnection();	
			 String SQL="select *  from  users where id=? and password=?";
			 pstmt=conn.prepareStatement(SQL);
			 pstmt.setString(1, vo.getId());
			 pstmt.setString(2, vo.getPassword());
			 rs=pstmt.executeQuery();
			 rs.next();
			 
			 user=new UserVo();
			 user.setId(rs.getString("id"));
			 user.setName(rs.getString("name"));
			 user.setPassword(rs.getString("password"));
			 user.setRole(rs.getString("role"));
			 
		}catch(Exception e) {
			e.printStackTrace();
		}		
		
		return user;
	}

}

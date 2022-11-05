package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

import com.springbook.biz.user.UserVo;

public class AfterReturningAdvice {
   void  afterLog(JoinPoint  jp, Object  returnObj) {
	   
	 String method=jp.getSignature().getName();
	 
	
	 if ( returnObj  instanceof  UserVo) {
		 System.out.println("===> returnObj  instanceof  UserVo  확인");
		 UserVo user =(UserVo) returnObj;
		 if(user.getRole().equals("User") ) {
			System.out.println(user.getName() + "로그인(Admin)");
		} 
	 }
	
	 
	 System.out.println("[ 사후처리 ]" + method +
			 "() 메소드 리턴값:" + returnObj.toString()  );
	   
   }
}

package com.springbook.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		AbstractApplicationContext container=
				new GenericXmlApplicationContext("applicationContext.xml");

		UserService service =(UserService) container.getBean("userService");
		UserVo vo =new UserVo();
		vo.setId("TEST");
		vo.setPassword("TEST123");
	
		UserVo  user=service.getUser(vo);
		
		if(user != null) {
			System.out.println(user.getName() + "님 환영합니다.");
			
		}else {
			System.out.println(" 로그인 실패 !!! ");
		}
		
		container.close();		
	}

}

package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect  //   포인트 컷 + 	어드바이스
public class LogAdvice {     
   
   // 포인트 컷	
   @Pointcut("execution(* com.springbook.biz..*ServiceImpl.*(..))")
   public  void  allPointcut() {}
   
   // 어드바이스
   @Before("allPointcut()")  
   public  void  printLog() {
	  System.out.println("[공통로그] 비즈니스 로직 수행 전 동작"); 
   }
   
   @Pointcut("execution(* com.springbook.biz..*ServiceImpl.get*(..))")
   public  void  getPointcut() {}
   
}

package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {
	
   // 포인트 컷	
   @Pointcut("execution(* com.springbook.biz..*ServiceImpl.*(..))")
   public  void  allPointcut() {}	
	
   // 어드바이스
   @Before("allPointcut()")     
   void  beforeLog(JoinPoint  jp) {
	   
	String  method = jp.getSignature().getName(); // 비즈니스 로직 메소드 이름 불러오기 
	Object[] args = jp.getArgs(); // 비즈니스 로직 메소드의 매개변수에 들어오는 args 값 읽어오기 
	
	   System.out.println("[사전처리]" + method + "()메소드 ARGS 정보: " + args[0].toString() );
	   
   }
}

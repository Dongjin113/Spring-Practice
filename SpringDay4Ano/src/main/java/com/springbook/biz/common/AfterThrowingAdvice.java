package com.springbook.biz.common;

public class AfterThrowingAdvice {
   void  exceptionLog() {
	   System.out.println("[예외처리] 비즈니스 로직 수행 중 예외발생");
   }
}

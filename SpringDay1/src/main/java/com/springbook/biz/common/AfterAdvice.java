package com.springbook.biz.common;

public class AfterAdvice {
   void  finallyLog() {
	   System.out.println("[사후처리] 비즈니스 로직 수행 후 무조건 동작");
   }
}

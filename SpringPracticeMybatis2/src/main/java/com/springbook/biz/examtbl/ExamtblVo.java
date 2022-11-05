package com.springbook.biz.examtbl;

import lombok.Data;

@Data
public class ExamtblVo {
	
	private int sno;
	private String sname;
	private int kor;
	private int eng;
	private int math;
	private int hist;
	private int cnt;

}

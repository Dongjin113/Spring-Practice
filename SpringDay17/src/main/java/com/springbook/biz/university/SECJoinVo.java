package com.springbook.biz.university;

import lombok.Data;

@Data
public class SECJoinVo {
	
	private String sno;   
	private String sname;
	private String year;
	private String sdept;  
	
	private String cno;
	private String cname;
	private String credit;
	private String cdept;
	private String prname;

	private  String grade;
	private  int midterm;
	private  int finalstr;
	
}

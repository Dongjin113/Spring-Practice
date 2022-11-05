package com.springbook.biz.bigdata;

import lombok.Data;

@Data
public class BigdataVo {
	
  private  String   emp_no;
  private  String   birth_date;
  private  String   first_name;
  private  String   last_name;
  private  String   gender;
  private  String   hire_date;  
  
  private  String   searchCondition; 
  private  String   searchKeyword; 
  
  private  int   totalCount;
  private  int   startIdx;
  private  int   endIdx;
  
}


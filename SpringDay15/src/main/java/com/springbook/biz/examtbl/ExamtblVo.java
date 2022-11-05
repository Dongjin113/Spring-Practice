package com.springbook.biz.examtbl;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class ExamtblVo {
  private  String sno;
  private  String sname;  
  
  @JsonIgnore
  private  int kor;
  @JsonIgnore
  private  int eng;
  @JsonIgnore
  private  int math;
  @JsonIgnore
  private  int hist;
  @JsonIgnore
  private  int cnt;	
}

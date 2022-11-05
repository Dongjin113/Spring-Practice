package com.springbook.biz.psd;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PsdVo {
	  private  int  seq;
	  private  String title;
	  private  String writer;
	  private  String content;
	  private  Date  regDate;
	  private  int   cnt;
	  private  String searchKeyword;
	  private  String searchCondition;
	  
	  private  MultipartFile  updateFile;
	  private  String  updateFileStr;
	  
}

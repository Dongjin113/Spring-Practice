package com.springbook.biz.board;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardVo {
	  private  int  seq;
	  private  String title;
	  private  String writer;
	  private  String content;
	  private  Date  regDate;
	  private  int   cnt;
	 // private  String searchKeyword;
	 // private  String searchCondition;
}

package com.springbook.biz.coursereply;

import java.util.Date;

import lombok.Data;

@Data
public class CourseReplyVo {
	  private  int  idx;
	  private  String  cno;
	  private  String reply;
	  private  String replayer;
	  private  Date  replyDate;
	  private  String  replyDateStr;
}

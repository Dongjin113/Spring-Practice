package com.springbook.biz.reply;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVo {
  private  int  idx;
  private  String  sno;
  private  String reply;
  private  String replayer;
  private  Date  replyDate;
  private  String  replyDateStr;
  
}

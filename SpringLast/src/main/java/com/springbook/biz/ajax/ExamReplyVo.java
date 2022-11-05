package com.springbook.biz.ajax;

import java.util.Date;

import lombok.Data;

@Data
public class ExamReplyVo {
  private int	 idx ; 
  private String	 sno ;
  private String reply ;
  private String replayer ;  
  private Date replyDate ; 
  private String replyDateStr ; 
}

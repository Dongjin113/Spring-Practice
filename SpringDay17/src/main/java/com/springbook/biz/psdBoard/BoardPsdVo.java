package com.springbook.biz.psdBoard;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardPsdVo {
   private  int seq ;
   private  String  title;
   private  String  writer;
   private  String  content;
   private  Date    regdate ;  
   private  String  regdatestr ;
   private  int     cnt;
   
   private  MultipartFile  updateFile;
   private  String  updateFilestr;
      
}

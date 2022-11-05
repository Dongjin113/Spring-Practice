package com.springbook.biz.member;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVo {
	
	private String id;
	private String pwd;
	private String bcrypt;
	private String name;
	private String role;
	private String addr;
	private String tel;
	private Date date;
	private String datestr;
	
	private String postcode;
	private String roadAddress;
	private String detailAddress;
	
	private String address1;
	private String address2;
	
	private String searchkey;
	private String search;
	
	

}

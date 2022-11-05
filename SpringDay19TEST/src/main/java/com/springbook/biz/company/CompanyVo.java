package com.springbook.biz.company;

import lombok.Data;

@Data
public class CompanyVo {
	private int      SEQ;
	private String   rdnmadr  ;  // 주소
	private String   logitude ;  // 경도
	private String   entrprsNm ; // 회사명
	private String   rprsntvNm;  // 대표
	private String   latitude  ; // 위도 
	private String   mainGoods ; // 주력상품
}


package com.springbook.biz.bigdata;

import java.util.List;

public interface BigdataService {
    List<BigdataVo> selectTop15(BigdataVo vo);
    
    List<BigdataVo> selectList(BigdataVo vo);
    
    int  totalCount(BigdataVo vo);
}

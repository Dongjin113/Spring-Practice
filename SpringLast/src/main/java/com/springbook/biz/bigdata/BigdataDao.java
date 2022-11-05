package com.springbook.biz.bigdata;

import java.util.List;

public interface BigdataDao {
    List<BigdataVo> selectTop15(BigdataVo vo);
    
    List<BigdataVo> selectList(BigdataVo vo);
    
    int  totalCount(BigdataVo vo);
}

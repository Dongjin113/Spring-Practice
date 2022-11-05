package com.springbook.biz.psd;

import java.util.List;

public interface PsdDao {
   void  insert(PsdVo vo);
   void  update(PsdVo vo);
   void  delete(PsdVo vo);
   
   PsdVo getPsd(PsdVo vo);
   List<PsdVo> getPsdList(PsdVo vo);
}

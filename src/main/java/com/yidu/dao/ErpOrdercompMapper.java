package com.yidu.dao;

import com.yidu.model.ErpOrdercomp;

public interface ErpOrdercompMapper {
    int deleteByPrimaryKey(String ordercompId);

    int insert(ErpOrdercomp record);

    int insertSelective(ErpOrdercomp record);

    ErpOrdercomp selectByPrimaryKey(String ordercompId);

    int updateByPrimaryKeySelective(ErpOrdercomp record);

    int updateByPrimaryKey(ErpOrdercomp record);
}
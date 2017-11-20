package com.yidu.dao;

import com.yidu.model.ErpSctockmp;

public interface ErpSctockmpMapper {
    int deleteByPrimaryKey(String saleId);

    int insert(ErpSctockmp record);

    int insertSelective(ErpSctockmp record);

    ErpSctockmp selectByPrimaryKey(String saleId);

    int updateByPrimaryKeySelective(ErpSctockmp record);

    int updateByPrimaryKey(ErpSctockmp record);
}
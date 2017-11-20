package com.yidu.dao;

import com.yidu.model.ErpLedgyr;

public interface ErpLedgyrMapper {
    int deleteByPrimaryKey(String gyrId);

    int insert(ErpLedgyr record);

    int insertSelective(ErpLedgyr record);

    ErpLedgyr selectByPrimaryKey(String gyrId);

    int updateByPrimaryKeySelective(ErpLedgyr record);

    int updateByPrimaryKey(ErpLedgyr record);
}
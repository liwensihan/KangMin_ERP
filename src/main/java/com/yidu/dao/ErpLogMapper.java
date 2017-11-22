package com.yidu.dao;

import com.yidu.model.ErpLog;

public interface ErpLogMapper {
    int deleteByPrimaryKey(String logId);

    //增加
    int insert(ErpLog record);

    int insertSelective(ErpLog record);

    ErpLog selectByPrimaryKey(String logId);

    int updateByPrimaryKeySelective(ErpLog record);

    int updateByPrimaryKey(ErpLog record);
}
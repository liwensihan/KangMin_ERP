package com.yidu.dao;

import com.yidu.model.ErpInvedet;

public interface ErpInvedetMapper {
    int deleteByPrimaryKey(String invedetId);

    int insert(ErpInvedet record);

    int insertSelective(ErpInvedet record);

    ErpInvedet selectByPrimaryKey(String invedetId);

    int updateByPrimaryKeySelective(ErpInvedet record);

    int updateByPrimaryKey(ErpInvedet record);
}
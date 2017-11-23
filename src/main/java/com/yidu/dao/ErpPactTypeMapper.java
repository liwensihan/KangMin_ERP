package com.yidu.dao;

import com.yidu.model.ErpPactType;

public interface ErpPactTypeMapper {
    int deleteByPrimaryKey(String patypeId);

    int insert(ErpPactType record);

    int insertSelective(ErpPactType record);

    ErpPactType selectByPrimaryKey(String patypeId);

    int updateByPrimaryKeySelective(ErpPactType record);

    int updateByPrimaryKey(ErpPactType record);
}
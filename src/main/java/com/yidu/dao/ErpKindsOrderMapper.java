package com.yidu.dao;

import com.yidu.model.ErpKindsOrder;

public interface ErpKindsOrderMapper {
    int deleteByPrimaryKey(String kinordId);

    int insert(ErpKindsOrder record);

    int insertSelective(ErpKindsOrder record);

    ErpKindsOrder selectByPrimaryKey(String kinordId);

    int updateByPrimaryKeySelective(ErpKindsOrder record);

    int updateByPrimaryKey(ErpKindsOrder record);
}
package com.yidu.dao;

import com.yidu.model.ErpKinordDetail;

public interface ErpKinordDetailMapper {
    int deleteByPrimaryKey(String ordDetId);

    int insert(ErpKinordDetail record);

    int insertSelective(ErpKinordDetail record);

    ErpKinordDetail selectByPrimaryKey(String ordDetId);

    int updateByPrimaryKeySelective(ErpKinordDetail record);

    int updateByPrimaryKey(ErpKinordDetail record);
}
package com.yidu.dao;

import com.yidu.model.ErpFdproform;

public interface ErpFdproformMapper {
    int deleteByPrimaryKey(String fdproId);

    int insert(ErpFdproform record);

    int insertSelective(ErpFdproform record);

    ErpFdproform selectByPrimaryKey(String fdproId);

    int updateByPrimaryKeySelective(ErpFdproform record);

    int updateByPrimaryKey(ErpFdproform record);
}
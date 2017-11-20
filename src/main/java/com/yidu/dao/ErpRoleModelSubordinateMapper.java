package com.yidu.dao;

import com.yidu.model.ErpRoleModelSubordinate;

public interface ErpRoleModelSubordinateMapper {
    int deleteByPrimaryKey(String subId);

    int insert(ErpRoleModelSubordinate record);

    int insertSelective(ErpRoleModelSubordinate record);

    ErpRoleModelSubordinate selectByPrimaryKey(String subId);

    int updateByPrimaryKeySelective(ErpRoleModelSubordinate record);

    int updateByPrimaryKey(ErpRoleModelSubordinate record);
}
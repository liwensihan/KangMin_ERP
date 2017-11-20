package com.yidu.dao;

import com.yidu.model.ErpPersonelRole;

public interface ErpPersonelRoleMapper {
    int deleteByPrimaryKey(String perRoleId);

    int insert(ErpPersonelRole record);

    int insertSelective(ErpPersonelRole record);

    ErpPersonelRole selectByPrimaryKey(String perRoleId);

    int updateByPrimaryKeySelective(ErpPersonelRole record);

    int updateByPrimaryKey(ErpPersonelRole record);
}
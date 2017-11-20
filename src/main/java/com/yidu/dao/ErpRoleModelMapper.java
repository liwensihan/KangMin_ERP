package com.yidu.dao;

import java.util.List;

import com.yidu.model.ErpRoleModel;

public interface ErpRoleModelMapper {
    int deleteByPrimaryKey(String roleModelId);

    int insert(ErpRoleModel record);

    int insertSelective(ErpRoleModel record);

    ErpRoleModel selectByPrimaryKey(String roleModelId);

    int updateByPrimaryKeySelective(ErpRoleModel record);

    int updateByPrimaryKey(ErpRoleModel record);
    
    List<ErpRoleModel> getMessage(String roleId);
}
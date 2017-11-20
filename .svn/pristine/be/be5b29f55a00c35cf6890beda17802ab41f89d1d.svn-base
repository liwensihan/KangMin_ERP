package com.yidu.dao;

import java.util.List;

import com.yidu.model.ErpRole;

public interface ErpRoleMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(ErpRole record);

    int insertSelective(ErpRole record);

    ErpRole selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(ErpRole record);

    int updateByPrimaryKey(ErpRole record);
    
    List<ErpRole>findAll();
    
    List<ErpRole>findAllRole(ErpRole record);
    
    int findRowCount(ErpRole record);
    
    int deleteRole(String roleId);
    
    List<ErpRole>getRoleValue(String roleId);
    
    int deleteModel(String roleId);
}
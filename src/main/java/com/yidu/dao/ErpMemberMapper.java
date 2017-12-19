package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpMember;

public interface ErpMemberMapper {
    int deleteByPrimaryKey(String memberId);

    //增加
    int insert(ErpMember record);

    int insertSelective(ErpMember record);
    
    //查询所有
    List<ErpMember>  selectByPrimaryKey(Map<String, Object> map);

    //根据ID查询
    ErpMember select(String memberId);
    //修改
    int updateByPrimaryKeySelective(ErpMember record);
    //总行数
    int findRowCount(Map<String, Object> map);

    int updateByPrimaryKey(ErpMember record);
}
package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpLog;

public interface ErpLogMapper {
    int deleteByPrimaryKey(String logId);

    //查询所有
    List<ErpLog> selectshow(Map<String, Object> map);
    
    //增加
    int insert(ErpLog record);
    
    //总行数
    int select(Map<String, Object> map);

    int insertSelective(ErpLog record);

    ErpLog selectByPrimaryKey(String logId);

    int updateByPrimaryKeySelective(ErpLog record);

    int updateByPrimaryKey(ErpLog record);
}
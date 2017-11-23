package com.yidu.dao;

import java.util.Map;

import com.yidu.model.ErpProindentDetail;

public interface ErpProindentDetailMapper {
    int deleteByPrimaryKey(String entdeId);

    //根据订单ID和商品ID修改已生产数量
    int updateId(Map<String, Object> map);
    
    //增加方法
    int insert(ErpProindentDetail record);

    int insertSelective(ErpProindentDetail record);

    ErpProindentDetail selectByPrimaryKey(String entdeId);

    //删除
    int updateByPrimaryKeySelective(ErpProindentDetail record);

    //修改
    int update(ErpProindentDetail record);
    
    
    int updateByPrimaryKey(ErpProindentDetail record);
}
package com.yidu.dao;


import java.util.Map;

import com.yidu.model.ErpLogDetail;

public interface ErpLogDetailMapper {
    int deleteByPrimaryKey(String detailId);
    
    //增加
    int insert(ErpLogDetail record);

    //根据商品ID和订单ID修改订单日志明细状态
    int update(Map<String, Object> map);
    
    int insertSelective(ErpLogDetail record);

    ErpLogDetail selectByPrimaryKey(String detailId);

    int updateByPrimaryKeySelective(ErpLogDetail record);

    int updateByPrimaryKey(ErpLogDetail record);
}
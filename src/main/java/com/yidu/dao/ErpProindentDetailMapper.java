package com.yidu.dao;

import java.util.List;
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
    /**
     * 查询该生产订单所有的详情
     * @param indentId 生产id
     * @return 详情集合
     */
    List<ErpProindentDetail> selectProKey(String indentId);
    
}
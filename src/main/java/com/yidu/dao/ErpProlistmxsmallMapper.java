package com.yidu.dao;

import java.util.List;

import com.yidu.model.ErpProlistmxsmall;

public interface ErpProlistmxsmallMapper {
    int deleteByPrimaryKey(String fdprolistmxId);

    int insert(ErpProlistmxsmall record);

    int insertSelective(ErpProlistmxsmall record);

    ErpProlistmxsmall selectByPrimaryKey(String fdprolistmxId);

    int updateByPrimaryKeySelective(ErpProlistmxsmall record);

    int updateByPrimaryKey(ErpProlistmxsmall record);
    
    List<ErpProlistmxsmall>getMallById(String fdformId);
    
    int updateIsva (String fdprolistmxId);
    /**
     * 查询分店采购订单的详情
     * @param fdproId 采购订单id
     * @return 返回详情list
     */
    List<ErpProlistmxsmall> selectBankNew(String fdproId);
    
    
    /**
     * 删除订单
     * @param fdformId
     * @return
     */
    int deleteFd(String fdformId);
}
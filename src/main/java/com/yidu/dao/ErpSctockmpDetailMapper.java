package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpSctockmpDetail;

public interface ErpSctockmpDetailMapper {
	
	/**
     * 批量增加销售订单明细
     * @param list 销售订单明细集合
     * @return 影响行数
     * @author ouyang
	 * @dateTime 2017年11月23日16:41:23
     */
    public int addSctockmpDetailList(List<ErpSctockmpDetail> list);
    
    /**
     * 根据订单ID查找订单明细
     * @param list 销售订单明细集合
     * @return 影响行数
     * @author ouyang
	 * @dateTime 2017年11月29日08:38:04
     */
    public List<Map<String,Object>> findBySaleId(String saleId);
    
    /**
     * 根据订单ID把详细订单设为无效
     * @param saleId 订单ID
     * @return 影响行数
     * @author ouyang
	 * @dateTime 2017年12月5日11:47:03
     */
    public int updateIsvaBySaleId(String saleId);
	
    int deleteByPrimaryKey(String kmpId);

    int insert(ErpSctockmpDetail record);

    int insertSelective(ErpSctockmpDetail record);

    ErpSctockmpDetail selectByPrimaryKey(String kmpId);

    int updateByPrimaryKeySelective(ErpSctockmpDetail record);

    int updateByPrimaryKey(ErpSctockmpDetail record);
}
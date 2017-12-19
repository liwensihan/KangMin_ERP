package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpSctockmp;
/**
 * 分店销售订单dao
 * @author ouyang
 * @dataTime 2017年12月11日16:24:53
 */
public interface ErpSctockmpMapper {
    int deleteByPrimaryKey(String saleId);

    int insert(ErpSctockmp record);

    int insertSelective(ErpSctockmp record);
    
    /**
     * 查询今天的订单数量
     * @return 订单数量
     * @author ouyang
	 * @dataTime 2017年12月11日16:24:53
     */
	public int findToDay();
    
    /**
   	 * 根据订单ID查询订单
   	 * @param saleId 订单ID
   	 * @return 订单对象
   	 * @author ouyang
   	 * @date 2017年12月1日09:54:36
   	 */
    public ErpSctockmp selectByPrimaryKey(String saleId);
    
    /**
   	 * 根据订单ID修改订单信息
   	 * @param saleId 订单ID
   	 * @return 影响行数
   	 * @author ouyang
   	 * @date 2017年12月1日13:56:17
   	 */
    public int updateByPrimaryKeySelective(ErpSctockmp sctockmp);

    int updateByPrimaryKey(ErpSctockmp record);
    
    /**
	 * 根据订单ID查询当前订单批发状态
	 * @param saleId 订单ID
	 * @return 订单状态
	 * @author ouyang
	 * @date 2017年12月1日09:54:36
	 */
    public int findWholesaleStateBySaleId(String saleId);
    
    /**
	 * 审核通过，增加批发状态
	 * @param saleId 订单ID
	 * @return 影响行数
	 * @author ouyang
	 * @date 2017年12月1日08:48:14
	 */
    public int updateWholesaleStateAdd(String saleId);
    
    /**
	 * 查询订单列表
	 * @param map 搜索的参数
	 * @return 订单集合
	 * @author ouyang
	 * @date 2017年11月27日15:29:49
	 */
    public List<Map<String,Object>> findAll(Map<String,Object> map);
    
    /**
	 * 查询订单列表数量
	 * @param map 搜索的参数
	 * @return 订单集合
	 * @author ouyang
	 * @date 2017年11月27日15:29:49
	 */
    public int findAllSize(Map<String,Object> map);
}
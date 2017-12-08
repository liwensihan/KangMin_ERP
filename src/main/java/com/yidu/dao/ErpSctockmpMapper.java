package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpSctockmp;

public interface ErpSctockmpMapper {
    int deleteByPrimaryKey(String saleId);

    int insert(ErpSctockmp record);

    int insertSelective(ErpSctockmp record);

    ErpSctockmp selectByPrimaryKey(String saleId);

    int updateByPrimaryKeySelective(ErpSctockmp record);

    int updateByPrimaryKey(ErpSctockmp record);
    
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
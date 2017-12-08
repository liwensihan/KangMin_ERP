package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpKinds;
import com.yidu.model.ErpSumstock;

/**
 * 分店库存表
 * @author ouyang
 * @dataTime 2017年11月24日11:13:13
 */
public interface ErpSumstockMapper {
	/**
	 * 根据条形码和分店ID查询药品
	 * @param kinBarcode 条形码
	 * @return 药品实体类
	 * @author ouyang
	 * @dateTime 2017年11月24日13:55:38
	 */
	public Map<String,Object> findByKinBarcode(String kinBarcode,String annexId);
	
	/**
	 * 批量减少库存(根据分店ID和商品ID减少)
	 * @param list 库存信息
	 * @return 影响行数
	 * @author ouyang
	 * @dataTime 2017年11月24日11:15:04
	 */
	public int updateStockSuount(List<Map<String, Object>> list);
	
    int deleteByPrimaryKey(String stockId);

    int insert(ErpSumstock record);

    int insertSelective(ErpSumstock record);

    ErpSumstock selectByPrimaryKey(String stockId);

    int updateByPrimaryKeySelective(ErpSumstock record);

    int updateByPrimaryKey(ErpSumstock record);
}
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
	


    ErpSumstock selectByPrimaryKey(String stockId);


    int deleteByPrimaryKey(String stockId);

    int insert(ErpSumstock record);

    int insertSelective(ErpSumstock record);
    /**
     * 根据id查询
     * @param stockId
     * @return
     */
    ErpSumstock selectshow(String stockId);
    /**
     * 查询所有
     * @param map
     * @return
     */
    List<Map<String, Object>> selectByPrimaryKey(Map<String, Object> map);
    
    /**
     * 总行数
     * @param map
     * @return
     */
    int findRowCount(Map<String, Object> map);

    /**
     * 修改或删除
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ErpSumstock record);

    int updateByPrimaryKey(ErpSumstock record);
    /**
     * 根据商品id 和分店id查询库存
     * @param kinId 商品id
     * @param annexId 分店id
     * @return 库存对象
     */
    ErpSumstock selectKindAnn(String kinId,String annexId);
    /**
     * 得到今天最大的编号
     * @param data 当前日期
     * @return 最后的一个编号
     */
    String selectSerial(String data);
}
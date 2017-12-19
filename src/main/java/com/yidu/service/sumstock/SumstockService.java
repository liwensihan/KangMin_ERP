/**
 * 
 */
package com.yidu.service.sumstock;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpKinds;
import com.yidu.model.ErpSumstock;

/**
 * 分店库存表service接口
 * @author ouyang
 * @dataTime 2017年11月24日13:59:33
 */
public interface SumstockService {
	/**
	 * 根据条形码和当前分店查询药品
	 * @param kinBarcode 条形码
	 * @param annexId 分店ID
	 * @return 药品实体类
	 * @author ouyang
	 * @dateTime 2017年11月24日13:55:38
	 */
	public Map<String,Object> findByKinBarcode(String kinBarcode,String annexId);

	  /**
     * 查询所有
     * @param map
     * @return
     */
    List<Map<String, Object>> selectByPrimaryKey(Map<String, Object> map);

    /**
     * 根据id查询
     * @param stockId
     * @return
     */
    ErpSumstock selectshow(String stockId);
    
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
    

    /**
     * 根据商品id 和分店id查询库存
     * @param kinId 商品id
     * @param annexId 分店id
     * @return 库存对象
     */
    ErpSumstock selectKindAnn(String kinId,String annexId);
    
    int insertSelective(ErpSumstock record);
    
    /**
     * 得到今天最大的编号
     * @param data 当前日期
     * @return 最后的一个编号
     */
    String selectSerial(String data);
}

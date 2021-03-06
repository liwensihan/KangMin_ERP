/**
 * 
 */
package com.yidu.service.ErpKinds;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpKinds;

/**
 * 药品的service
 * @author 大晶儿
 * 2017年10月31日
 */
public interface ErpKindsService {
	
	/**
	 * 根据条形码查询药品
	 * @param kinBarcode 条形码
	 * @author ouyang
	 * @dateTime 2017年11月6日11:23:48
	 * @return 药品实体类
	 */
	public ErpKinds findByKinBarcode(String kinBarcode);
	
	/**
	 * 删除
	 * @param record 对象
	 * @return
	 */
    int deleteByPrimaryKey(ErpKinds record);
    /**
     * 添加
     * @param record 药品对象
     * @return 返回int
     */
    int insert(ErpKinds record);
    /**
     * 选择添加
     * @param record 药品对象
     * @return 返回int
     */
    int insertSelective(ErpKinds record);
    /**
     * 查询单个对象
     * @param kinId 药品id
     * @return 返回对象
     */
    ErpKinds selectByPrimaryKey(String kinId);
    /**
     * 选择修改
     * @param record 药品对象
     * @return 返回int
     */
    int updateByPrimaryKeySelective(ErpKinds record);
    /**
     * 修改
     * @param record 药品对象
     * @return 返回int
     */
    int updateByPrimaryKey(ErpKinds record);
    /**
     * 查询所有的药品
     * @return 返回list
     */
    List<ErpKinds> findPrimaryKinds(Map<String,Object> map1);
  
   /**
    * 得到刚刚创建的id
    * @param dateStr
    * @return
    */
    String selectId(String dateStr);
    /**
     * 查询总行数
     * @param map 条件
     * @return 返回总行数
     */
    Integer selectConut(Map<String,Object> map);
    
    /**
     * 查询所有，下拉框
     * @return
     */
    List<ErpKinds> findStation();
    
    /**
     * 查询单个对象仓库使用方法
     * @param kinId 商品id
     * @return 返回商品单个对象
     */
    ErpKinds selectByPrimaryNewKinId(String kinId);
    
    /**
     * 查询返回函数
     * @param map
     * @return
     */
    int findByPrimaryKindsCount(Map<String,Object> map);
}

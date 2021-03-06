package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpKinds;
import com.yidu.model.ErpWarehouse;
/**
 * 药品表
 * @author 大晶儿
 * 2017年10月31日
 */
public interface ErpKindsMapper {
	
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
	 * @param kinId id
	 * @return
	 */
    int deleteByPrimaryKey(String kinId);
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
	 * 得到今天最大的编号
	 * @param dateStr
	 * @return 返回编号
	 */
	String selectSerial(String dateStr);
	/**
	 * 得到当前添加的药品id
	 * @param dateStr 今天的日期
	 * @return 返回药品id
	 */
	String selectId(String dateStr);
	/**
	 * 查询总行数
	 * @param map
	 * @return
	 */
    Integer selectConut(Map<String,Object> map);

    /**
     * 查询ID
     * @param wareId
     * @return
     */
    ErpKinds findKindsByKindsId(String wareId);

    
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
package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpKindsType;
import com.yidu.model.ErpRaw;

public interface ErpRawMapper {
	/**
	 * 删除
	 * @param rawId 原材料id
	 * @return 返回int
	 */
    int deleteByPrimaryKey(String rawId);
    /**
     * 添加
     * @param record 原材料对象 
     * @return 返回int
     */
    int insert(ErpRaw record);
    /**
     * 选择添加
     * @param record 原材料对象
     * @return 返回int
     */
    int insertSelective(ErpRaw record);
    /**
     * 查询单个对象
     * @param rawId
     * @return
     */
    List<ErpRaw> selectByPrimaryKey(String rawId);
    /**
     * 选择修改
     * @param record 原材料对象
     * @return 返回int
     */
    int updateByPrimaryKeySelective(ErpRaw record);
    /**
     * 修改全部
     * @param record 原材料对象
     * @return 返回int
     */
    int updateByPrimaryKey(ErpRaw record);
    
    /**
     * 得到所有原材料
     * @return
     */
	List<ErpRaw> findListRaw();
	/**
	 * 得到今天最大的编号
	 * @param dateStr
	 * @return
	 */
	String selectSerial(String dateStr);
	/**
	 * 得到新添加的id
	 * @param rawName 根据材料名
	 * @return 返回id
	 */
	String selectId(String rawName);
	/**
	 * 模糊查询
	 * @param price 值
	 * @return type对象的集合
	 */
	List<ErpRaw> findDimRaw(Map<String,Object> map);
	/**
	 * 查询原材料表
	 * @return
	 */
	List<ErpRaw> findRawList();
	/**
	 * 根据ID查询
	 * @param rawId
	 * @return
	 */
	ErpRaw findRawByRawId(String rawId);
	
	/**
	 * 查询总行数
	 * @param map 参数
	 * @return int
	 */
	int findDimRawCount(Map<String,Object> map);
}
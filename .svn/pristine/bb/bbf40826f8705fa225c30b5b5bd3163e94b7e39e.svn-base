package com.yidu.dao;

import java.util.List;

import com.yidu.model.ErpBurden;
/**
 * 配方表
 * @author 大晶儿
 * 2017年11月2日
 */
public interface ErpBurdenMapper {
	/**
	 * 删除
	 * @param burId 配方id
	 * @return 返回int
	 */
    int deleteByPrimaryKey(String burId);
    /**
     * 添加
     * @param record 配方对象
     * @return 返回int
     */
    int insert(ErpBurden record);
    /**
     * 选择添加
     * @param record 配方对象
     * @return int 
     */
    int insertSelective(ErpBurden record);
    /**
     * 查找的单个对象
     * @param burId 药品id
     * @return 返回配方集合
     */
    List<ErpBurden> selectByPrimaryKey(String kindId);
    /**
     * 修改
     * @param record 配方对象
     * @return 返回int
     */
    int updateByPrimaryKeySelective(ErpBurden record);
    /**
     * 选择修改
     * @param record 配方对象
     * @return int 
     */
    int updateByPrimaryKey(ErpBurden record);
    /**
	 * 得到今天最大的编号
	 * @param dateStr
	 * @return
	 */
	String selectSerial(String dateStr);
}
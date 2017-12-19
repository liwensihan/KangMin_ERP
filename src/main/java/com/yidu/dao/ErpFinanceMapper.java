package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpFinance;

public interface ErpFinanceMapper {
	/**
	 * 删除
	 * @param financeId 类型id
	 * @return int
	 */
    int deleteByPrimaryKey(String financeId);
    /**
     * 添加全部
     * @param record 类型数据
     * @return string
     */
    int insert(ErpFinance record);
    /**
     * 选择性添加
     * @param record 类型数据
     * @return string
     */
    int insertSelective(ErpFinance record);
    /**
     * 查找单个对象
     * @param financeId 类型id
     * @return int
     */
    ErpFinance selectByPrimaryKey(String financeId);
    /**
     * 选择性修改
     * @param record 类型数据
     * @return string
     */
    int updateByPrimaryKeySelective(ErpFinance record);
    /**
     * 修改全部
     * @param record 类型数据
     * @return string
     */
    int updateByPrimaryKey(ErpFinance record);
    /**
     * 得到所有类型
     * @return
     */
    ErpFinance findListFinance();
	/**
	 * 得到今天最大的编号
	 * @param dateStr
	 * @return
	 */
	String financeSerial(String dateStr);
	/**
	 * 模糊查询
	 * @param price 值
	 * @return type对象的集合
	 */
	List<ErpFinance> findDimFinance(Map<String,Object> map);
	
	
	List<ErpFinance> findAll();
}
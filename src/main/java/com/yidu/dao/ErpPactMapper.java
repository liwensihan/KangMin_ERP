package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpPact;

public interface ErpPactMapper {
	/**
	 * 删除
	 * @param financeId 类型id
	 * @return int
	 */
    int deleteByPrimaryKey(String pactId);
    /**
     * 添加全部
     * @param record 类型数据
     * @return string
     */
    int insert(ErpPact record);
    /**
     * 选择性添加
     * @param record 类型数据
     * @return string
     */
    int insertSelective(ErpPact record);
    /**
     * 查找单个对象
     * @param financeId 类型id
     * @return int
     */
    ErpPact selectByPrimaryKey(String pactId);
    /**
     * 选择性修改
     * @param record 类型数据
     * @return string
     */
    int updateByPrimaryKeySelective(ErpPact record);
    /**
     * 修改全部
     * @param record 类型数据
     * @return string
     */
    int updateByPrimaryKey(ErpPact record);
    /**
     * 得到所有类型
     * @return
     */
	List<ErpPact> findListPact();
	/**
	 * 得到今天最大的编号
	 * @param dateStr
	 * @return
	 */
	String pactNumbe(String dateStr);
	/**
	 * 模糊查询
	 * @param price 值
	 * @return type对象的集合
	 */
	List<ErpPact> findDimPact(Map<String,Object> map);
}
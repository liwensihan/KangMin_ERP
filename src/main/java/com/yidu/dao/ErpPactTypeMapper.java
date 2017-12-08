package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpPact;
import com.yidu.model.ErpPactType;

public interface ErpPactTypeMapper {
	
	/**
	 * 查询所有下拉框
	 * @return
	 */
	List<ErpPactType> select();
	
	/**
	 * 删除
	 * @param financeId 类型id
	 * @return int
	 */
    int deleteByPrimaryKey(String patypeId);
    /**
     * 添加全部
     * @param record 类型数据
     * @return string
     */
    int insert(ErpPactType record);
    /**
     * 选择性添加
     * @param record 类型数据
     * @return string
     */
    int insertSelective(ErpPactType record);
    /**
     * 查找单个对象
     * @param financeId 类型id
     * @return int
     */
    ErpPact selectByPrimaryKey(String patypeId);
    /**
     * 选择性修改
     * @param record 类型数据
     * @return string
     */
    int updateByPrimaryKeySelective(ErpPactType record);
    /**
     * 修改全部
     * @param record 类型数据
     * @return string
     */
    int updateByPrimaryKey(ErpPactType record);
    /**
     * 得到所有类型
     * @return
     */
	List<ErpPactType> findListPactType();
	/**
	 * 得到今天最大的编号
	 * @param dateStr
	 * @return
	 */
	String pacttypeNumbe(String dateStr);
	/**
	 * 模糊查询
	 * @param price 值
	 * @return type对象的集合
	 */
	List<ErpPactType> findDimPactType(Map<String,Object> map);
}
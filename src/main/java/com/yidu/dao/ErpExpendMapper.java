package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpExpend;
import com.yidu.model.ErpFinance;

public interface ErpExpendMapper {
	/**
	 * 删除
	 * @param expendId 类型id
	 * @return 返回类型
	 */
    int deleteByPrimaryKey(String expendId);
    /**
     * 添加全部
     * @param record 类型对象
     * @return 返回类型
     */
    int insert(ErpExpend record);
    /**
     * 选择性添加
     * @param record 类型对象
     * @return 返回类型
     */
    int insertSelective(ErpExpend record);
    /**
     * 查找单个对象
     * @param expendId 类型id
     * @return 返回类型
     */
    ErpExpend selectByPrimaryKey(String expendId);
    /**
     * 选择性修改
     * @param record 类型对象
     * @return 返回类型
     */
    int updateByPrimaryKeySelective(ErpExpend record);
    /**
     * 修改全部
     * @param record 类型对象
     * @return 返回类型
     */
    int updateByPrimaryKey(ErpExpend record);
    /**
     * 得到所有类型
     * @return
     */
	List<ErpExpend> findListExpend();
	/**
	 * 得到今天最大的编号
	 * @param dateStr
	 * @return
	 */
	String expendSerial(String dateStr);
	/**
	 * 模糊查询
	 * @param price 值
	 * @return type对象的集合
	 */
	List<ErpExpend> findDimExpend(Map<String,Object> map);
}
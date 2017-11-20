package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpExpend;
import com.yidu.model.ErpIncome;

public interface ErpIncomeMapper {
	/**
	 * 删除
	 * @param incomeId 类型id
	 * @return 返回类型
	 */
    int deleteByPrimaryKey(String incomeId);
    /**
     * 添加全部
     * @param record 类型对象
     * @return 返回类型
     */
    int insert(ErpIncome record);
    /**
     * 选择性添加
     * @param record 类型对象
     * @return 返回类型
     */
    int insertSelective(ErpIncome record);
    /**
     * 查找单个对象
     * @param incomeId 类型id
     * @return 返回类型
     */
    ErpIncome selectByPrimaryKey(String incomeId);
    /**
     * 选择性修改
     * @param record 类型对象
     * @return 返回类型
     */
    int updateByPrimaryKeySelective(ErpIncome record);
    /**
     * 修改全部
     * @param record 类型对象
     * @return 返回类型
     */
    int updateByPrimaryKey(ErpIncome record);
    /**
     * 得到所有类型
     * @return
     */
	List<ErpIncome> findListIncome();
	/**
	 * 得到今天最大的编号
	 * @param dateStr
	 * @return
	 */
	String incomeSerial(String dateStr);
	/**
	 * 模糊查询
	 * @param price 值
	 * @return type对象的集合
	 */
	List<ErpIncome> findDimIncome(Map<String,Object> map);
}
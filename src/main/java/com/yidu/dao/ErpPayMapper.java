package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpApplyasset;
import com.yidu.model.ErpPay;

public interface ErpPayMapper {
	/**
	 * 删除
	 * @param payId 类型id
	 * @return 返回类型
	 */
    int deleteByPrimaryKey(String payId);
    /**
     * 添加全部
     * @param record 类型对象
     * @return 返回类型
     */
    int insert(ErpPay record);
    /**
     * 选择性添加
     * @param record 类型对象
     * @return 返回类型
     */
    int insertSelective(ErpPay record);
    /**
     * 查找带个对象
     * @param payId 类型id
     * @return 返回类型
     */
    ErpPay selectByPrimaryKey(String payId);
    /**
     * 选择性修改
     * @param record 类型对象
     * @return 返回类型
     */
    int updateByPrimaryKeySelective(ErpPay record);
    /**
     * 修改全部
     * @param record
     * @return
     */
    int updateByPrimaryKey(ErpPay record);
    /**
     * 得到所有类型
     * @return
     */
	List<ErpPay> findListPay();
	/**
	 * 得到今天最大的编号
	 * @param dateStr
	 * @return
	 */
	String paySerial(String dateStr);
	/**
	 * 模糊查询
	 * @param price 值
	 * @return type对象的集合
	 */
	List<ErpPay> findDimPay(Map<String,Object> map);
	/**
	 * 初始化页面显示
	 * 根据选择的年份查询该年份1月-12月份 的收入
	 * @author 胡鑫
	 * @date 2017年11月8日10:37:34
	 * @param date 年份
	 * @return 返回收入集合
	 */
	public List<ErpPay>showListPrice(String date);
	
	/**
	 * 模糊 分页查询全部收入集合
	 * @author 胡鑫
	 * @date 2017年11月13日14:49:52
	 * @param map 分页参数 模糊查询参数
	 * @return 返回收入集合
	 */
	public List<ErpPay>showList(Map<String,Object> map);
	
	/**
	 * 模糊查询全部收入集合
	 * @author 胡鑫
	 * @date 2017年11月13日14:49:52
	 * @param map 模糊查询参数
	 * @return 返回收入集合行数
	 */
	public int findCount(Map<String,Object> map);
	
}
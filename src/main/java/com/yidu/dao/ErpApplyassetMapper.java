package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpApplyasset;
import com.yidu.model.ErpFinance;

public interface ErpApplyassetMapper {
	/**
	 * 删除
	 * @param appassId 类型id
	 * @return 返回类型
	 */
    int deleteByPrimaryKey(String appassId);
    /**
     *  添加全部
     * @param record 类型对象
     * @return 返回类型
     */
    int insert(ErpApplyasset record);
    /**
     * 选择性添加
     * @param record 类型对象
     * @return 返回类型
     */
    int insertSelective(ErpApplyasset record);
    /**
     * 查找单个对象
     * @param appassId 类型id
     * @return 返回类型
     */
    ErpApplyasset selectByPrimaryKey(String appassId);
    /**
     * 选择性修改
     * @param record 类型对象
     * @return 返回类型
     */
    int updateByPrimaryKeySelective(ErpApplyasset record);
    /**
     * 修改全部
     * @param record 类型对象
     * @return 返回类型
     */
    int updateByPrimaryKey(ErpApplyasset record);
    /**
     * 得到所有类型
     * @return
     */
	List<ErpApplyasset> findListApplyasset();
	/**
	 * 得到今天最大的编号
	 * @param dateStr
	 * @return
	 */
	String applyassetSerial(String dateStr);
	/**
	 * 模糊查询
	 * @param price 值
	 * @return type对象的集合
	 */
	List<ErpApplyasset> findDimApplyasset(Map<String,Object> map);
	/**
	 * 初始化页面显示
	 * 根据选择的年份查询该年份1月-12月份 的支出
	 * @author 胡鑫
	 * @date 2017年11月6日16:00:06
	 * @param date 年份
	 * @return 返回资金申请list
	 */
	public List<ErpApplyasset> showListPrice(String date);
	
	/**
	 * 模糊 分页查询全部支出集合
	 * @author 胡鑫
	 * @date 2017年11月9日09:37:15
	 * @param map 分页参数 模糊查询参数
	 * @return 返回支出集合
	 */
	public List<ErpApplyasset>showList(Map<String,Object> map);
	
	/**
	 * 模糊查询全部支出集合
	 * @author 胡鑫
	 * @date 2017年11月9日09:37:15
	 * @param map 模糊查询参数
	 * @return 返回支出集合行数
	 */
	public int findCount(Map<String,Object> map);
	/**
	 * 根据资金申请id 增加审核信息
	 * @author 胡鑫
	 * @date 2017年11月14日10:41:42
	 * @param map 存放的参数
	 * @return 返回执行的行数
	 */
	public int auditApplyasset(Map<String, Object> map);
}
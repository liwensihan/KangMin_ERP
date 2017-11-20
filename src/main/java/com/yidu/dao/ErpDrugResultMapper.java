package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpDrugResult;
/**
 * 药品药效的导
 * @author 大晶儿
 * 2017年10月23日
 */
public interface ErpDrugResultMapper {
	/**
	 * 删除
	 * @param drugResId 药品药效id
	 * @return 返回int
	 */
    int deleteByPrimaryKey(String drugResId);
	/**
	 * 添加
	 * @param record 对象
	 * @return 返回int
	 */
    int insert(ErpDrugResult record);
	/**
	 * 选择添加
	 * @param record 对象
	 * @return int
	 */
    int insertSelective(ErpDrugResult record);
	/**
	 * 查询单个对象
	 * @param drugResId
	 * @return
	 */
    List<ErpDrugResult> selectByPrimaryKey(String rawId);
	/**
	 * 选择修改
	 * @param record 对象
	 * @return 返回int
	 */
    int updateByPrimaryKeySelective(ErpDrugResult record);
	/**
	 * 修改
	 * @param record 对象
	 * @return 返回int 
	 */
    int updateByPrimaryKey(ErpDrugResult record);
    /**
     * 查询该药效id
     * @param rewId 药效id
     * @return 返回集合
     */
    List<ErpDrugResult> selectByPrimRes(String resId);
    /**
     * 查找单个药品的药效
     * @param kinId
     * @return 返回集合
     */
    List<ErpDrugResult> selectByPrimaryKind(String kinId);
    /**
     * 删除单个药品的药效
     * @param resId
     * @param kindsId
     * @return
     */
    int deleteKindsRes(String resId,String kindsId);
}
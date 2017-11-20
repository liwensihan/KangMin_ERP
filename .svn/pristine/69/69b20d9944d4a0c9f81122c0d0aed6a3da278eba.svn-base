/**
 * 
 */
package com.yidu.service.ErpDrugResult;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpDrugResult;
import com.yidu.util.BackException;

/**
 * 药品药效表
 * @author 大晶儿
 * 2017年10月23日
 */
public interface ErpDrugResultService {
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
     * 添加药品药效
     * @param record
     * @return
     */
    int insertSelectiveRuiKind(String kindId,String[] resId) throws BackException;
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
    int updateByPrimaryKeySelective(String kindId, Integer[] resId) throws BackException;
	/**
	 * 修改
	 * @param record 对象
	 * @return 返回int 
	 */
    int updateByPrimaryKey(ErpDrugResult record);
    /**
     * 查询所有的ras字段
     * @param resId resid
     * @return 返回list
     */
    List<ErpDrugResult> selectByPrimRew(String resId);
    /**
     * 删除单个药品的药效
     * @param resId
     * @param kindsId
     * @return
     */
    int deleteKindsRes(String resId,String kindsId);
    
}

package com.yidu.dao;

import com.yidu.model.ErpQuality;
/**
 * 质检表的导
 * @author 大晶儿
 * @Date 2017年11月10日
 */
public interface ErpQualityMapper {
	/**
	 *删除
	 * @param quaId 质检id
	 * @return 返回int
	 */
    int deleteByPrimaryKey(String quaId);
    /**
     * 添加
     * @param record 质检对象
     * @return int
     */
    int insert(ErpQuality record);
    /**
     * 选择添加
     * @param record
     * @return
     */
    int insertSelective(ErpQuality record);
    /**
     * 查询单个对象
     * @param quaId 质检id
     * @return 质检对象
     */
    ErpQuality selectByPrimaryKey(String quaId);
    /**
     * 修改
     * @param record 质检对象
     * @return int
     */
    int updateByPrimaryKeySelective(ErpQuality record);
    /**
     * 选择修改
     * @param record 质检对象
     * @return int
     */
    int updateByPrimaryKey(ErpQuality record);
}
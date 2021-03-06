package com.yidu.dao;

import com.yidu.model.ErpQualityDetail;
/**
 * 质检表
 * @author 大晶儿
 *
 */
public interface ErpQualityDetailMapper {
	/**
	 * 删除
	 * @param qdetId 明细id
	 * @return int 
	 */
    int deleteByPrimaryKey(String qdetId);
	/**
	 * 添加全部
	 * @param record 明细对象
	 * @return int
	 */
    int insert(ErpQualityDetail record);
	/**
	 * 选择添加
	 * @param record 明细对象
	 * @return int
	 */
    int insertSelective(ErpQualityDetail record);
	/**
	 * 查询单个明细对象
	 * @param qdetId 明细id
	 * @return 明细单个对象
	 */
    ErpQualityDetail selectByPrimaryKey(String qdetId);
    /**
     *选择修改
     * @param record 明细对象
     * @return int
     */
    int updateByPrimaryKeySelective(ErpQualityDetail record);
	/**
	 * 修改全部
	 * @param record 明细对象
	 * @return int
	 */
    int updateByPrimaryKey(ErpQualityDetail record);
}
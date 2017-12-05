package com.yidu.dao;

import com.yidu.model.ErpInvedet;

public interface ErpInvedetMapper {
	/**
	 * 删除
	 * @param invedetId 入库明细id
	 * @return int
	 */
    int deleteByPrimaryKey(String invedetId);
	/**
	 * 添加
	 * @param record 入库明细对象
	 * @return int
	 */
    int insert(ErpInvedet record);
	/**
	 * 添加
	 * @param record 入库明细对象
	 * @return int 
	 */
    int insertSelective(ErpInvedet record);
	/**
	 * 查询单个对象
	 * @param invedetId 入库明细id
	 * @return int
	 */
    ErpInvedet selectByPrimaryKey(String invedetId);
	/**
	 * 修改
	 * @param record 入库明细对象
	 * @return int
	 */
    int updateByPrimaryKeySelective(ErpInvedet record);
	/**
	 * 修改
	 * @param record 入库明细对象
	 * @return int
	 */
    int updateByPrimaryKey(ErpInvedet record);
}
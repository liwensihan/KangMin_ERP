package com.yidu.dao;

import java.util.List;

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
    List<ErpInvedet> selectByPrimaryKey(String obId);
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
    /**
     * 查询该入库单的所有明细
     * @param bankId 入库单号
     * @return 库存明细集合
     */
    List<ErpInvedet> selectByPrimaryNew(String bankId);
}
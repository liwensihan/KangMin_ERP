/**
 * 
 */
package com.yidu.service.ErpInvedet;

import java.util.List;

import com.yidu.model.ErpInvedet;

/**
 * @author 大晶儿
 * 2017年12月5日
 */
public interface ErpInvedetService {
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
    String selectByPrimaryKey(String obId,String staId,String AnnexId);
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
    int selectByPrimaryNew(String bankId,String staId);
}

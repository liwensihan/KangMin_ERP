package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpApply;
/**
 * 供货商导
 * @author 大晶儿
 * 2017年10月23日
 */
public interface ErpApplyMapper {
	/**
	 * 查询所有
	 * @param map
	 * @return
	 */
	List<ErpApply> selectAll(Map<String,Object> map);
	
	/**
	 * 删除 修改状态
	 * @param isva
	 * @return
	 */
	int delete(ErpApply isva);
	/**
	 * 根据ID查询
	 * @param applyId
	 * @return
	 */
	ErpApply selectByPrimaryKey(String applyId);
	/**
	 * 增加
	 * @param record
	 * @return
	 */
	int insert(ErpApply record);
	/**
	 * 根据ID修改信息
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(ErpApply applyId);
	/**
	 * 分页
	 * @param map
	 * @return
	 */
	public int applyFindRows(Map<String,Object> map);
    

	List<ErpApply> findErpApply();
	
}
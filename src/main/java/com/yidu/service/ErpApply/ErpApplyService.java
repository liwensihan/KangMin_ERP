/**
 * XLe1丶
 * 2017年10月19日 2017年8月1日16:02:52
 */
package com.yidu.service.ErpApply;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpApply;

/**
 * 供货商Service
 * @author Gjwen
 * 2017年10月30日-下午2:07:08
 */
public interface ErpApplyService {
	/**
	 * 查询所有供货商
	 * @return 返回list
	 */
	List<ErpApply> findErpApply();
	
	/**
	 * 查询所有供货商
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
	 * 根据ID修改信息
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(ErpApply record);
	/**
	 * 增加
	 * @param record
	 * @return
	 */
	int insert(ErpApply record);
	/**
	 * 分页查询
	 * @param map
	 * @return
	 */
	public int applyFindRows(Map<String,Object> map);
}

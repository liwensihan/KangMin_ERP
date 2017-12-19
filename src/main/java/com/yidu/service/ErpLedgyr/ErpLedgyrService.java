/**
 * 
 */
package com.yidu.service.ErpLedgyr;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpLedgyr;

/**
 * 分店（收入支出）明细接口
 * @author Gjwen
 * 上午8:50:29
 */
public interface ErpLedgyrService {
	/**
	 * 查询 收入
	 * @param map
	 * @return
	 */
	List<ErpLedgyr> selectAll(Map<String,Object> map); 
	/**
	 * 查询行数
	 * @param page
	 * @return
	 */
	public int findRows(Map<String,Object> map);
	/**
	 * 查询 支出
	 * @param map
	 * @return
	 */
	List<ErpLedgyr> selectAllzhichu(Map<String,Object> map); 
	/**
	 * 查询行数
	 * @param page
	 * @return
	 */
	public int findRowszhichu(Map<String,Object> map);
	/**
     * 根据ID查询
     * @param id
     * @return
     */
    List<Map<String,Object>> FindCheckDetails(String id);
    /**
     * 根据ID查询(收入)
     * @param id
     * @return
     */
    List<Map<String,Object>> FindCheckDetailss(String id);
    
    
    int insertSelective(ErpLedgyr record);
}

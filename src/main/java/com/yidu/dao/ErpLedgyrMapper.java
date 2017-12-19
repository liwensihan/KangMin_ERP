package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpLedgyr;
/**
 * 分店收入（支出）明细DAO
 * @author Gjwen
 * 上午8:43:21
 */
public interface ErpLedgyrMapper {
	/**
	 * 查询
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
     * 根据ID查询(支出)
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
	
    int deleteByPrimaryKey(String gyrId);

    int insert(ErpLedgyr record);

    int insertSelective(ErpLedgyr record);

    ErpLedgyr selectByPrimaryKey(String gyrId);

    int updateByPrimaryKeySelective(ErpLedgyr record);

    int updateByPrimaryKey(ErpLedgyr record);
}
/**
 * 
 */
package com.yidu.service.ErpFdproform;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpFdproform;

/**
 * 分店采购订单的service接口
 * @author Administrator
 *
 */
public interface ErpFdproformService {

	/**
	 * 根据分店id查询所有
	 * @param map
	 * @return
	 */
	List<ErpFdproform>findAll(Map<String, Object>map);
    
	
	/**
	 * 根据分店id查询所有的行数
	 * @param map
	 * @return
	 */
    int findRowCount (Map<String, Object>map);
    
    
    /**
     * 删除
     * @param id
     * @return
     */
    int deleteFdpro(String id);
    
    /**
     * 增加全部
     * @param record
     * @return
     */
    int insertSelective(ErpFdproform record);
    
    /**
     * 根据查询所有
     * @param map
     * @return
     */
    List<ErpFdproform>ratifyFindAll(Map<String, Object>map);
    
    /**
     * 根据查询所有的行数
     * @param map
     * @return
     */
    int ratifyFindAllCout (Map<String, Object>map);
    
    /**
     * 审核通过时修改状态
     * @param id
     * @return
     */
    int updateThrough(String id);
    
    /**
     * 修改全部
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ErpFdproform record);
    
    /**
     * 不通过时修改状态
     * @param id
     * @return
     */
    int noThrough(String id);
    
    /**
     * 取得修改时的值
     * @param record
     * @return
     */
    int updateValue(ErpFdproform record);
    ErpFdproform selectByPrimaryKey(String fdproId);
}

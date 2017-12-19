/**
 * 
 */
package com.yidu.service.ErpProlistmxsmall;

import java.util.List;

import com.yidu.model.ErpProlistmxsmall;

/**
 * @author Administrator
 *
 */

public interface ErpProlistmxsmallService {

	
	List<ErpProlistmxsmall>getMallById(String fdformId);
	
	int updateIsva (String fdprolistmxId);
	
	int insertSelective(ErpProlistmxsmall record);
	/**
     * 查询分店采购订单的详情
     * @param fdproId 采购订单id
     * @return 返回详情list
     */
    List<ErpProlistmxsmall> selectBankNew(String fdproId);
    
    /**
     * 编辑订单时删除
     * @param fdformId
     * @return
     */
    int deleteFd(String fdformId);
    
    
    int updateByPrimaryKeySelective(ErpProlistmxsmall record);
}

/**
 * 
 */
package com.yidu.service.ProindentDetail;

import com.yidu.model.ErpProindentDetail;

/**
 * 订单明细service
 * @author dong
 * @da2017年11月6日
 * @version 1.0
 */
public interface ProindentDetailService {
	
	/**
	 * 增加
	 * @param record
	 * @return
	 */
	int insert(ErpProindentDetail record);
	
	/**
	 * 删除或修改
	 * @param record
	 * @return
	 */
	 int updateByPrimaryKeySelective(ErpProindentDetail record);

	 /**
	  * 修改
	  * @param record
	  * @return
	  */
	 int update(ErpProindentDetail record);
}

/**
 * 
 */
package com.yidu.service.ErpPurchaseDetails;

import com.yidu.model.ErpPurchaseDetails;

/**
 * @author Gjwen
 * 2017年11月6日-下午3:57:16
 */
public interface ErpPurchaseDetailsService {
	/**
	 * 添加到订单详细表中
	 * @param record
	 * @return
	 */
	int insertSelective(ErpPurchaseDetails record);

}

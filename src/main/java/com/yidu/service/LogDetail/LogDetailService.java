/**
 * 
 */
package com.yidu.service.LogDetail;

import java.util.Map;

import com.yidu.model.ErpLogDetail;

/**
 * @author dong
 * @data 2017年11月20日
 */
public interface LogDetailService {
	/**
	 * 增加
	 * @param record
	 * @return
	 */
	 int insert(ErpLogDetail record);
	 
	 /**
	  * 根据商品ID和订单ID修改订单日志明细状态
	  * @param map
	  * @return
	  */
	 int update(Map<String, Object> map);
}

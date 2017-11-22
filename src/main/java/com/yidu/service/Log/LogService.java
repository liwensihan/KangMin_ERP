/**
 * 
 */
package com.yidu.service.Log;

import com.yidu.model.ErpLog;

/**
 * 生产日志表service
 * @author dong
 * @data 2017年11月20日
 */
public interface LogService {
	/**
	 * 增加
	 * @param record 生产日志模型
	 * @return
	 */
	 int insert(ErpLog record);
}

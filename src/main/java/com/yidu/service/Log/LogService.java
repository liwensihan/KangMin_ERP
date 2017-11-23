/**
 * 
 */
package com.yidu.service.Log;

import java.util.List;
import java.util.Map;

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
	 
	 /**
	  * 查询所有
	  * @param map
	  * @return
	  */
	 List<ErpLog> selectshow(Map<String, Object> map);
	 
	 /**
	  * 总行数
	  * @param map
	  * @return
	  */
	 int select(Map<String, Object> map);
}

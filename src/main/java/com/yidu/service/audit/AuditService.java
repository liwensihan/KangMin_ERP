package com.yidu.service.audit;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpAudit;

/**
 * 审核记录接口
 * @author 胡鑫
 * @date 2017年11月30日10:33:08
 */
public interface AuditService {

	/**
	 * 初始化显示审核记录
	 * @author 胡鑫
	 * @date 2017年11月30日10:38:31
	 * @param parMap map集合存放sql查询参数
	 * @return 返回审核记录集合
	 */
	List<ErpAudit> showList(Map<String, Object> parMap);
	
	/**
	 * 根据业务id查询该条业务审核记录
	 * @author 胡鑫
	 * @date 2017年11月30日13:57:46
	 * @param parMap map集合存放sql查询参数  业务id
	 * @return 返回记录集合
	 */
	List<ErpAudit> showListById(Map<String, Object> parMap);
	
}

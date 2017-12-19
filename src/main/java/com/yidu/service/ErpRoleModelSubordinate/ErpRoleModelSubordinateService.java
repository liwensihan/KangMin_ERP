/**
 * XLe1丶
 * 2017年11月14日 2017年8月1日16:02:52
 */
package com.yidu.service.ErpRoleModelSubordinate;

import com.yidu.model.ErpRoleModelSubordinate;

/**
 * @author XLe1丶
 * 2017年11月14日
 */
public interface ErpRoleModelSubordinateService {
	
	int insertSelective(ErpRoleModelSubordinate record);
	
	int deleteByPrimaryKey(String subId);
	
}

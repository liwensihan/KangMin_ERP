/**
 * XLe1丶
 * 2017年11月6日 2017年8月1日16:02:52
 */
package com.yidu.service.ErpRoleModel;

import java.util.List;

import com.yidu.model.ErpRoleModel;

/**
 * @author XLe1丶
 * 2017年11月6日
 */
public interface ErpRoleModelService {
	
	int insertSelective(ErpRoleModel record);
	
	List<ErpRoleModel> getMessage(String roleId);
	
}

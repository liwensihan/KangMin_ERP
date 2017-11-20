/**
 * XLe1丶
 * 2017年11月3日 2017年8月1日16:02:52
 */
package com.yidu.service.ErpPersonelRole;

import com.yidu.model.ErpPersonelRole;

/**
 * @author XLe1丶
 * 2017年11月3日
 */
public interface ErpPersonelRoleService {
		
	int updateByPrimaryKeySelective(ErpPersonelRole record);
	
	
	int insertSelective(ErpPersonelRole record);
	
}

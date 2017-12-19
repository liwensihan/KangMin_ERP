/**
 * XLe1丶
 * 2017年11月3日 2017年8月1日16:02:52
 */
package com.yidu.service.ErpPersonelRole;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpPersonelRoleMapper;
import com.yidu.model.ErpPersonelRole;

/**
 * @author XLe1丶
 * 2017年11月3日
 */
@Service
public class ErpPersonelRoleServiceImpl implements ErpPersonelRoleService{
	
	@Resource
	private ErpPersonelRoleMapper dao;

	@Override
	public int updateByPrimaryKeySelective(ErpPersonelRole record) {
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int insertSelective(ErpPersonelRole record) {
		return dao.insertSelective(record);
	}

}

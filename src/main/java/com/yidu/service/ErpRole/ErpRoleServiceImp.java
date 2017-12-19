/**
 * XLe1丶
 * 2017年11月2日 2017年8月1日16:02:52
 */
package com.yidu.service.ErpRole;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpRoleMapper;
import com.yidu.model.ErpRole;

/**
 * @author XLe1丶
 * 2017年11月2日
 */
@Service
public class ErpRoleServiceImp implements ErpRoleService{
	
	@Resource
	private ErpRoleMapper dao ;
	
	public List<ErpRole> findAll() {
		return dao.findAll();
	}

	@Override
	public List<ErpRole> findAllRole(ErpRole record) {
		return dao.findAllRole(record);
	}

	@Override
	public int findRowCount(ErpRole record) {
		return dao.findRowCount(record);
	}

	@Override
	public int deleteRole(String roleId) {
		return dao.deleteRole(roleId);
	}

	@Override
	public int insertSelective(ErpRole record) {
		return dao.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(ErpRole record) {
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<ErpRole> getRoleValue(String roleId) {
		return dao.getRoleValue(roleId);
	}

	@Override
	public int deleteModel(String roleId) {
		return dao.deleteModel(roleId);
	}

}

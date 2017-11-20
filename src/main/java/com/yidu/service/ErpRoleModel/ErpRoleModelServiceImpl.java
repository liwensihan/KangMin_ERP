/**
 * XLe1丶
 * 2017年11月6日 2017年8月1日16:02:52
 */
package com.yidu.service.ErpRoleModel;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpRoleModelMapper;
import com.yidu.model.ErpRoleModel;

/**
 * @author XLe1丶
 * 2017年11月6日
 */
@Service
public class ErpRoleModelServiceImpl implements ErpRoleModelService{
	
	@Resource
	private ErpRoleModelMapper dao;

	@Override
	public int insertSelective(ErpRoleModel record) {
		return dao.insertSelective(record);
	}

	@Override
	public List<ErpRoleModel> getMessage(String roleId) {
		return dao.getMessage(roleId);
	}

	
	
}

/**
 * XLe1丶
 * 2017年11月14日 2017年8月1日16:02:52
 */
package com.yidu.service.ErpRoleModelSubordinate;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpRoleModelSubordinateMapper;
import com.yidu.model.ErpRoleModelSubordinate;

/**
 * @author XLe1丶
 * 2017年11月14日
 */
@Service
public class ErpRoleModelSubordinateServiceImpl implements ErpRoleModelSubordinateService{

	@Resource
	private ErpRoleModelSubordinateMapper dao;
	
	@Override
	public int insertSelective(ErpRoleModelSubordinate record) {
		return dao.insertSelective(record);
	}

	@Override
	public int deleteByPrimaryKey(String subId) {
		return dao.deleteByPrimaryKey(subId);
	}
	
	
}

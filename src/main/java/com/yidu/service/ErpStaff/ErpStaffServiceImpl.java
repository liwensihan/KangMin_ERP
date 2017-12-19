/**
 * XLe1丶
 * 2017年10月19日 2017年8月1日16:02:52
 */
package com.yidu.service.ErpStaff;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpModelMapper;
import com.yidu.dao.ErpStaffMapper;
import com.yidu.model.ErpModel;
import com.yidu.model.ErpStaff;

/**
 * @author XLe1丶
 * 2017年10月19日
 */

@Service
public class ErpStaffServiceImpl implements ErpStaffService{
	
	@Resource
	private ErpStaffMapper dao;

	

	
	public int findRowCount(ErpStaff staff) {
		return dao.findRowCount(staff);
	}

	
	public List<ErpStaff> findAll(ErpStaff staff) {
		return dao.findAll(staff);
	}

	
	public List<ErpStaff> getStaff() {
		return dao.getStaff();
	}

	
	public ErpStaff getUser(ErpStaff staff) {
		return dao.getUser(staff);
	}

	
	public int updateById(String staId) {
		return dao.updateById(staId);
	}

	@Override
	public int insertSelective(ErpStaff record) {
		return dao.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(ErpStaff record) {
		return dao.updateByPrimaryKeySelective(record);
	}


	@Override
	public int updateEmpPhoto(ErpStaff record) {
		return dao.updateEmpPhoto(record);
	}


	@Override
	public int getPhone(String staEmail) {
		return dao.getPhone(staEmail);
	}


	@Override
	public int updateUser(ErpStaff record) {
		return dao.updateUser(record);
	}


	@Override
	public int getPwd(ErpStaff record) {
		return dao.getPwd(record);
	}


	@Override
	public int updatePwd(ErpStaff record) {
		return dao.updatePwd(record);
	}

	
	
}

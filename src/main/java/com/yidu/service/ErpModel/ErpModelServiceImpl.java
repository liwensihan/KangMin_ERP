/**
 * XLe1丶
 * 2017年10月20日 2017年8月1日16:02:52
 */
package com.yidu.service.ErpModel;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpModelMapper;
import com.yidu.model.ErpModel;

/**
 * @author XLe1丶
 * 2017年10月20日
 */
@Service
public class ErpModelServiceImpl implements ErpModelService{
	
	@Resource
	private ErpModelMapper dao;
	
	
	public List<ErpModel> findAllModel(String staName) {
		return dao.findAllModel(staName);
	}

	
	public List<ErpModel> getModel(String roleId) {
		return dao.getModel(roleId);
	}


	@Override
	public List<ErpModel> findAll(ErpModel record) {
		return dao.findAll(record);
	}


	@Override
	public int findRowCount(ErpModel record) {
		return dao.findRowCount(record);
	}


	@Override
	public List<ErpModel> getErpModel() {
		return dao.getErpModel();
	}


	@Override
	public int insertSelective(ErpModel record) {
		return dao.insertSelective(record);
	}


	@Override
	public int updateByPrimaryKeySelective(ErpModel record) {
		return dao.updateByPrimaryKeySelective(record);
	}


	@Override
	public int deleteModel(String modelId) {
		return dao.deleteModel(modelId);
	}


	@Override
	public List<ErpModel> addBelow(String modelId) {
		return dao.addBelow(modelId);
	}


	@Override
	public List<ErpModel> finModel() {
		return dao.finModel();
	}


	@Override
	public int updateSubordinate(String modelId) {
		return dao.updateSubordinate(modelId);
	}

}

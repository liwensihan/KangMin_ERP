/**
 * XLe1丶
 * 2017年10月20日 2017年8月1日16:02:52
 */
package com.yidu.service.ErpModel;

import java.util.List;

import com.yidu.model.ErpModel;

/**
 * @author XLe1丶
 * 2017年10月20日
 */
public interface ErpModelService {
	List<ErpModel> findAllModel (String staName);
	
	List<ErpModel> getModel (String roleId);
	
	List<ErpModel> findAll(ErpModel record);
	
	int findRowCount(ErpModel record);
	
	List<ErpModel> getErpModel();
	
	int insertSelective(ErpModel record);
	
	int updateByPrimaryKeySelective(ErpModel record);
	
	int deleteModel(String modelId);
	
	List<ErpModel>addBelow(String modelId);
	
	List<ErpModel> finModel();
	
	int updateSubordinate (String modelId);
}

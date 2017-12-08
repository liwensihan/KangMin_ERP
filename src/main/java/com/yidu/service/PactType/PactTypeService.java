/**
 * 
 */
package com.yidu.service.PactType;

import java.util.List;

import com.yidu.model.ErpPactType;

/**
 * @author dong
 * @dateTime 2017年12月1日
 */
public interface PactTypeService {
	/**
	 * 查询所有下拉框
	 * @return
	 */
	List<ErpPactType> select();
	
	
}

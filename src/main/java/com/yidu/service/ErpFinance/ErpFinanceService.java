/**
 * 
 */
package com.yidu.service.ErpFinance;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpExpend;
import com.yidu.model.ErpFinance;

/**
 * @author zhangwei
 * 2017年10月19日
 */
public interface ErpFinanceService {
	
	List<ErpFinance> findAll();
	
	
	 /**
     * 选择性修改
     * @param record 类型数据
     * @return string
     */
    int updateByPrimaryKeySelective(ErpFinance record);
	
}

package com.yidu.service.ErpBank;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpBank;

/**
 * 入库Service
 * @author Gjwen
 * 2017年11月13日-上午8:59:12
 */
public interface ErpBankService {
	/**
	 * 查询显示
	 * @param map
	 * @return
	 */
	List<ErpBank> selectAll(Map<String,Object> map);
}

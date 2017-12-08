/**
 * 
 */
package com.yidu.service.sumstock;

import java.util.Map;

import com.yidu.model.ErpKinds;

/**
 * 分店库存表service接口
 * @author ouyang
 * @dataTime 2017年11月24日13:59:33
 */
public interface SumstockService {
	/**
	 * 根据条形码和当前分店查询药品
	 * @param kinBarcode 条形码
	 * @param annexId 分店ID
	 * @return 药品实体类
	 * @author ouyang
	 * @dateTime 2017年11月24日13:55:38
	 */
	public Map<String,Object> findByKinBarcode(String kinBarcode,String annexId);
}

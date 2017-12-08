package com.yidu.service.sctockmpDetail;

import java.util.List;
import java.util.Map;

/**
 * 分店销售明细订单service接口
 * @author ouyang
 * @dataTime 2017年11月29日08:47:16
 */
public interface SctockmpDetailService {
	
	/**
     * 根据订单ID查找订单明细
     * @param list 销售订单明细集合
     * @return 影响行数
     * @author ouyang
	 * @dateTime 2017年11月29日08:38:04
     */
    public List<Map<String,Object>> findBySaleId(String saleId);
}

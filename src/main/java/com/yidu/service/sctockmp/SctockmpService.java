package com.yidu.service.sctockmp;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yidu.model.ErpSctockmp;
import com.yidu.model.ErpSctockmpDetail;

/**
 * 分店销售订单service接口
 * @author ouyang
 * @dataTime 2017年11月23日16:30:36
 */
public interface SctockmpService {
	
	/**
	 * 增加分店销售订单(同时增加订单明细)
	 * @param sctockmp 分店销售订单
	 * @param list	分店销售订单明细集合
	 * @return 影响行数
	 * @author ouyang
	 * @dataTime 2017年11月23日16:33:46
	 */
	public int addSctockmp(ErpSctockmp sctockmp,List<ErpSctockmpDetail> list);
	
	/**
	 * 查询订单列表
	 * @param map 搜索的参数
	 * @return 订单集合
	 * @author ouyang
	 * @date 2017年11月27日15:29:49
	 */
    public List<Map<String,Object>> findAll(Map<String,Object> map);
    
    /**
	 * 查询订单列表数量
	 * @param map 搜索的参数
	 * @return 订单集合
	 * @author ouyang
	 * @date 2017年11月27日15:29:49
	 */
    public int findAllSize(Map<String,Object> map);
	
}

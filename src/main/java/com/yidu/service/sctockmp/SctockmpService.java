package com.yidu.service.sctockmp;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
     * 查询今天的订单数量
     * @return 订单数量
     * @author ouyang
	 * @dataTime 2017年12月11日16:24:53
     */
	public int findToDay();
	
	/**
   	 * 审核失败，根据订单ID修改批发状态为0
   	 * @param saleId 订单ID
   	 * @param feedBack 打回原因
   	 * @return 影响行数
   	 * @author ouyang
   	 * @date 2017年12月1日13:56:17
   	 */
    public int updateWholesaleStateZero(String saleId,String feedBack,HttpSession session);
	
	/**
	 * 审核通过，增加批发状态
	 * @param saleId 订单ID
	 * @param session HttpSession
	 * @return 影响行数
	 * @author ouyang
	 * @date 2017年12月1日08:48:14
	 */
    public int updateWholesaleStateAdd(String saleId,HttpSession session);
	
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
	 * 修改分店销售订单(同时修改订单明细)
	 * @param sctockmp 分店销售订单
	 * @param list	分店销售订单明细集合
	 * @return 影响行数
	 * @author ouyang
	 * @dataTime 2017年12月5日08:51:58
	 */
	public int updateSctockmp(ErpSctockmp sctockmp,List<ErpSctockmpDetail> list);
	
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

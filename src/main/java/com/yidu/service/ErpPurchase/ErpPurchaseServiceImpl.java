/**
 * 
 */
package com.yidu.service.ErpPurchase;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpPurchaseDetailsMapper;
import com.yidu.dao.ErpPurchaseMapper;
import com.yidu.model.ErpPurchase;

/**
 * 实现采购订单类
 * @author Gjwen
 * 2017年10月19日-下午3:38:54
 */
@Service
public class ErpPurchaseServiceImpl implements ErpPurchaseService{
	/**
	 * 注入采购订单DAO
	 */
	@Resource
	private ErpPurchaseMapper erpPurchaseMapper;
	/**
	 * 注入订单详细DAO
	 */
	@Resource
	private ErpPurchaseDetailsMapper erpPurchaseDetailsMapper;
	
	/**
	 * List 查询所有
	 */
	public List<ErpPurchase> selectAll(Map<String, Object> map) {
		System.out.println("到达Service");
		return erpPurchaseMapper.selectAll(map);
	}

	/**
	 * 根据ID删除（修改状态为0）
	 */
	public int updateByPrimaryKeySelective(ErpPurchase state) {
		System.out.println("到达删除");
		return erpPurchaseMapper.updateByPrimaryKeySelective(state);
	}
	
	/**
	 * 根据ID查询信息
	 */
	public ErpPurchase selectByPrimaryKey(String record) {
		return erpPurchaseMapper.selectByPrimaryKey(record);
	}
	/**
	 * 根据ID修改
	 */
	public int update(ErpPurchase record) {
		return erpPurchaseMapper.update(record);
	}
	/**
	 * 增加订单
	 */
	public int insert(ErpPurchase record) {
		return erpPurchaseMapper.insert(record);
	}
	/**
	 * 分页
	 */
	@Override
	public int purchaseFindRows(Map<String, Object> map) {
		return erpPurchaseMapper.purchaseFindRows(map);
	}
}

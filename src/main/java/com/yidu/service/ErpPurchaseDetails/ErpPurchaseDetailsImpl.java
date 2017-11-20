/**
 * 
 */
package com.yidu.service.ErpPurchaseDetails;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpPurchaseDetailsMapper;
import com.yidu.model.ErpPurchaseDetails;
import com.yidu.model.ErpRaw;

/**
 * @author Gjwen
 * 2017年11月6日-下午3:58:36
 */
@Service
public class ErpPurchaseDetailsImpl implements ErpPurchaseDetailsService{
	/**
	 * 注入订单详细DAO
	 */
	@Resource
	private ErpPurchaseDetailsMapper mapper;



	@Override
	public int insertSelective(ErpPurchaseDetails record) {
		return mapper.insertSelective(record);
	}

	
}

/**
 * 
 */
package com.yidu.service.ProindentDetail;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpProindentDetailMapper;
import com.yidu.model.ErpProindentDetail;

/**
 * 订单明细service实现类
 * @author dong
 * @da2017年11月6日
 * @version 1.0
 */
@Service
public class ProindentDetailServiceImpl implements ProindentDetailService{

	@Resource
	private ErpProindentDetailMapper erpProindentDetailMapper;
	
	/**
	 * 增加
	 * @param record
	 * @return
	 */
	@Override
	public int insert(ErpProindentDetail record) {
		// TODO Auto-generated method stub
		return erpProindentDetailMapper.insert(record);
	}

	@Override
	public int updateByPrimaryKeySelective(ErpProindentDetail record) {
		// TODO Auto-generated method stub
		return erpProindentDetailMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 修改
	 */
	@Override
	public int update(ErpProindentDetail record) {
		// TODO Auto-generated method stub
		return erpProindentDetailMapper.update(record);
	}

}

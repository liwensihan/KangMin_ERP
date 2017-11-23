/**
 * 
 */
package com.yidu.service.LogDetail;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpLogDetailMapper;
import com.yidu.model.ErpLogDetail;

/**
 * @author dong
 * @data 2017年11月20日
 */
@Service
public class LogDetailServiceImpl implements LogDetailService{

	@Resource
	public ErpLogDetailMapper erpLogDetailMapper;
	
	/**
	 * 增加
	 */
	@Override
	public int insert(ErpLogDetail record) {
		// TODO Auto-generated method stub
		return erpLogDetailMapper.insert(record);
	}

	/**
	 * 根据商品ID和订单ID修改订单日志明细状态
	 */
	@Override
	public int update(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return erpLogDetailMapper.update(map);
	}

}

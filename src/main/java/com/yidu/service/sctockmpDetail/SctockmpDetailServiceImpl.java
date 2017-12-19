/**
 * 
 */
package com.yidu.service.sctockmpDetail;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpSctockmpDetailMapper;

/**
 * 分店销售订单service实现接口
 * @author ouyang
 * @dataTime 2017年11月29日08:50:21
 */
@Service
public class SctockmpDetailServiceImpl implements SctockmpDetailService{
	
	@Resource
	ErpSctockmpDetailMapper detailDao;
	
	@Override
	public List<Map<String, Object>> findBySaleId(String saleId) {
		return detailDao.findBySaleId(saleId);
	}

}

/**
 * 
 */
package com.yidu.service.sumstock;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpSumstockMapper;
import com.yidu.model.ErpKinds;

/**
 * 分店库存表service实现接口
 * @author ouyang
 * @dataTime 2017年11月24日13:59:33
 */
@Service
public class SumstockServiceImpl implements SumstockService{
	@Resource
	ErpSumstockMapper sumstockDao;
	
	@Override
	public Map<String,Object> findByKinBarcode(String kinBarcode,String annexId) {
		return sumstockDao.findByKinBarcode(kinBarcode,annexId);
	}

}

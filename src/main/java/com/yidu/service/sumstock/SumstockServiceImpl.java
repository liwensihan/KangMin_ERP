/**
 * 
 */
package com.yidu.service.sumstock;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpSumstockMapper;
import com.yidu.model.ErpKinds;
import com.yidu.model.ErpSumstock;

/**
 * 分店库存表service实现接口
 * @author ouyang
 * @dataTime 2017年11月24日13:59:33
 */
@Service
public class SumstockServiceImpl implements SumstockService{
	@Resource
	private ErpSumstockMapper erpSumstockMapper;
	
	@Override
	public Map<String,Object> findByKinBarcode(String kinBarcode,String annexId) {
		return erpSumstockMapper.findByKinBarcode(kinBarcode,annexId);
	}
	@Override
	public List<Map<String, Object>> selectByPrimaryKey(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return erpSumstockMapper.selectByPrimaryKey(map);
	}

	@Override
	public int findRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return erpSumstockMapper.findRowCount(map);
	}

	@Override
	public int updateByPrimaryKeySelective(ErpSumstock record) {
		// TODO Auto-generated method stub
		return erpSumstockMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public ErpSumstock selectshow(String stockId) {
		// TODO Auto-generated method stub
		return erpSumstockMapper.selectshow(stockId);
	}
	@Override
	public ErpSumstock selectKindAnn(String kinId, String annexId) {
		return erpSumstockMapper.selectKindAnn(kinId, annexId);
	}
	@Override
	public int insertSelective(ErpSumstock record) {
		return erpSumstockMapper.insertSelective(record);
	}
	@Override
	public String selectSerial(String data) {
		return erpSumstockMapper.selectSerial(data);
	}
}

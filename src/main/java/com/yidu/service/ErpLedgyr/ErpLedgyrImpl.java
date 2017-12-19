/**
 * 
 */
package com.yidu.service.ErpLedgyr;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpLedgyrMapper;
import com.yidu.model.ErpLedgyr;

/**
 * 实现支出收入明细接口
 * @author Gjwen
 * 上午8:51:43
 */
@Service
public class ErpLedgyrImpl implements ErpLedgyrService{
	/**
	 * 注入分店收入（支出）明细DAO
	 */
	@Resource
	private ErpLedgyrMapper erpLedgyrMapper;

	@Override
	public List<ErpLedgyr> selectAll(Map<String, Object> map) {
		return erpLedgyrMapper.selectAll(map);
	}

	@Override
	public int findRows(Map<String, Object> map) {
		return erpLedgyrMapper.findRows(map);
	}

	@Override
	public List<ErpLedgyr> selectAllzhichu(Map<String, Object> map) {
		return erpLedgyrMapper.selectAllzhichu(map);
	}

	@Override
	public int findRowszhichu(Map<String, Object> map) {
		return erpLedgyrMapper.findRowszhichu(map);
	}

	@Override
	public List<Map<String, Object>> FindCheckDetails(String id) {
		return erpLedgyrMapper.FindCheckDetails(id);
	}

	@Override
	public List<Map<String, Object>> FindCheckDetailss(String id) {
		return erpLedgyrMapper.FindCheckDetailss(id);
	}

	@Override
	public int insertSelective(ErpLedgyr record) {
		return erpLedgyrMapper.insertSelective(record);
	}
}

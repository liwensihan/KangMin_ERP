/**
 * 
 */
package com.yidu.service.annex;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpAnnexMapper;
import com.yidu.model.ErpAnnex;

/**
 * 分店service实现接口
 * @author ouyang
 * @data 2017年11月16日10:39:49
 */
@Service
public class AnnexServiceImpl implements AnnexService{
	
	@Resource
	ErpAnnexMapper dao;

	@Override
	public List<ErpAnnex> findAll(Map<String, Object> map) {
		return dao.findAll(map);
	}

	@Override
	public int findAllSize(Map<String, Object> map) {
		return dao.findAllSize(map);
	}

	@Override
	public int insertSelective(ErpAnnex record) {
		return dao.insertSelective(record);
	}

	@Override
	public ErpAnnex findById(String annexId) {
		return dao.selectByPrimaryKey(annexId);
	}

	@Override
	public int updateByPrimaryKeySelective(ErpAnnex record) {
		return dao.updateByPrimaryKeySelective(record);
	}
	
}

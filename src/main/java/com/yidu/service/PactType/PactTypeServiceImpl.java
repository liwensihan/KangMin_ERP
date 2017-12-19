/**
 * 
 */
package com.yidu.service.PactType;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpPactTypeMapper;
import com.yidu.model.ErpPactType;

/**
 * @author dong
 * @dateTime 2017年12月1日
 */
@Service
public class PactTypeServiceImpl implements PactTypeService{

	@Resource
	private ErpPactTypeMapper erpPactTypeMapper;
	
	
	@Override
	public List<ErpPactType> select() {
		// TODO Auto-generated method stub
		return erpPactTypeMapper.select();
	}


	@Override
	public List<ErpPactType> selectshow(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return erpPactTypeMapper.selectshow(map);
	}


	@Override
	public int findRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return erpPactTypeMapper.findRowCount(map);
	}


	@Override
	public int insert(ErpPactType type) {
		// TODO Auto-generated method stub
		return erpPactTypeMapper.insert(type);
	}


	@Override
	public int updateByPrimaryKeySelective(ErpPactType record) {
		// TODO Auto-generated method stub
		return erpPactTypeMapper.updateByPrimaryKeySelective(record);
	}


	@Override
	public ErpPactType selectByPrimaryKey(String patypeId) {
		// TODO Auto-generated method stub
		return erpPactTypeMapper.selectByPrimaryKey(patypeId);
	}

	
}

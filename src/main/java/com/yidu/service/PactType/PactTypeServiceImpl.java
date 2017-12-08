/**
 * 
 */
package com.yidu.service.PactType;

import java.util.List;

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

	
}

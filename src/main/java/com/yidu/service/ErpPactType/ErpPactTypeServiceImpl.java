/**
 * 
 */
package com.yidu.service.ErpPactType;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpPactTypeMapper;
import com.yidu.model.ErpPact;
import com.yidu.model.ErpPactType;
import com.yidu.util.Tools;

/**
 * @author 张伟
 * 2017年11月24日
 */
@Service
public class ErpPactTypeServiceImpl implements ErpPactTypeService{
	@Resource
	private ErpPactTypeMapper erpPactTypeMapper;
	@Override
	public int deleteByPrimaryKey(String patypeId) {
		
		return erpPactTypeMapper.deleteByPrimaryKey(patypeId);
	}

	@Override
	public int insert(ErpPactType record) {
		
		return erpPactTypeMapper.insert(record);
	}

	@Override
	public int insertSelective(ErpPactType record) {
		
		String data = erpPactTypeMapper.pacttypeNumbe(Tools.getDateStr(new Date()));//得到今天创建的最后一条数据
		record.setPatypeSreial(Tools.getSerial(data, "LX"));//类型编号
		Date date = new Date();
		record.setCreater(Tools.getDateStr(date));
		return erpPactTypeMapper.insertSelective(record);
	}

	
	@Override
	public int updateByPrimaryKeySelective(ErpPactType record) {
		
		return erpPactTypeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ErpPactType record) {
		
		return erpPactTypeMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<ErpPactType> showListPactType() {
		
		return erpPactTypeMapper.findListPactType();
	}

	@Override
	public List<ErpPactType> findDimPactType(Map<String, Object> map) {
		
		return erpPactTypeMapper.findDimPactType(map);
	}

}

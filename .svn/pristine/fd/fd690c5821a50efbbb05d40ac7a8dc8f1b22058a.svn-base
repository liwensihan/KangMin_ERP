/**
 * 
 */
package com.yidu.service.ErpPact;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpPactMapper;
import com.yidu.model.ErpIncome;
import com.yidu.model.ErpPact;
import com.yidu.util.Tools;

/**
 * @author zhangwei
 * 2017年11月3日
 */
@Service
public class ErpPactServiceImpl implements ErpPactService{
	@Resource
	private ErpPactMapper erpPactMapper;
	@Override
	public int deleteByPrimaryKey(String pactId) {
		
		return erpPactMapper.deleteByPrimaryKey(pactId);
	}

	@Override
	public int insert(ErpPact record) {
		
		return erpPactMapper.insert(record);
	}

	@Override
	public int insertSelective(ErpPact record) {
		String data = erpPactMapper.pactNumbe(Tools.getDateStr(new Date()));//得到今天创建的最后一条数据
		record.setPactNumber(Tools.getSerial(data, "LX"));//类型编号
		record.setIsva(0);//是否有效
		Date date = new Date();
		record.setCreatetime(Tools.getDateStr(date));
		return erpPactMapper.insertSelective(record);
	}

	@Override
	public ErpPact selectByPrimaryKey(String pactId) {
		
		return erpPactMapper.selectByPrimaryKey(pactId);
	}

	@Override
	public int updateByPrimaryKeySelective(ErpPact record) {
		
		return erpPactMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ErpPact record) {
		
		return erpPactMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<ErpPact> showListPact() {
		
		return erpPactMapper.findListPact();
	}

	@Override
	public List<ErpPact> findDimPact(Map<String, Object> map) {
		
		return erpPactMapper.findDimPact(map);
	}

}

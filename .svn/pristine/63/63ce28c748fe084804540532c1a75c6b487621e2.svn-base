/**
 * 
 */
package com.yidu.service.ErpBurden;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.yidu.dao.ErpBurdenMapper;
import com.yidu.model.ErpBurden;
import com.yidu.util.Tools;

/**
 * 配方的接口类
 * @author 大晶儿
 * 2017年11月2日
 */
@Service
public class ErpBurdenImple implements ErpBurdenService{
	@Resource
	private ErpBurdenMapper mapper;//配方的导
	@Override
	public int deleteByPrimaryKey(String burId) {
		return mapper.deleteByPrimaryKey(burId);
	}

	@Override
	public int insert(ErpBurden record) {
		return 0;
	}

	@Override
	public int insertSelective(ErpBurden record) {
		String date = mapper.selectSerial(Tools.getDateStr(new Date()));
		record.setBurSerial(Tools.getSerial(date, "PF"));
		record.setIsva(1);
		record.setCreatetime(Tools.getTimeStr(new Date()));
		return mapper.insertSelective(record);
	}

	@Override
	public List<ErpBurden> selectByPrimaryKey(String kindId) {
		return mapper.selectByPrimaryKey(kindId);
	}

	@Override
	public int updateByPrimaryKeySelective(ErpBurden record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ErpBurden record) {
		return 0;
	}

}

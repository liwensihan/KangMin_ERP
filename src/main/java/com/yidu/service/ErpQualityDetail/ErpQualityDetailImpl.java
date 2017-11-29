/**
 * 
 */
package com.yidu.service.ErpQualityDetail;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.common.Tools;
import com.yidu.dao.ErpQualityDetailMapper;
import com.yidu.model.ErpQualityDetail;

/**
 * service继承类
 * @author 大晶儿
 * 2017年11月24日
 */
@Service
public class ErpQualityDetailImpl implements ErpQualityDetailService{
	@Resource
	private ErpQualityDetailMapper mapper;
	
	@Override
	public int deleteByPrimaryKey(String qdetId) {
		return 0;
	}

	@Override
	public int insert(ErpQualityDetail record) {
		return 0;
	}

	@Override
	public int insertSelective(ErpQualityDetail record) {
		record.setCreatetime(Tools.getCurDateTime());
		return mapper.insertSelective(record);
	}

	@Override
	public ErpQualityDetail selectByPrimaryKey(String qdetId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(ErpQualityDetail record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ErpQualityDetail record) {
		// TODO Auto-generated method stub
		return 0;
	}

}

/**
 * 
 */
package com.yidu.service.ErpQuality;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpQualityMapper;
import com.yidu.model.ErpQuality;

/**
 * 质检表service接口
 * @author 大晶儿
 */
@Service
public class ErpQualityImpl implements ErpQualityService{
	@Resource
	private ErpQualityMapper mapper;//质检的导
	@Override
	public int deleteByPrimaryKey(String quaId) {
		
		return 0;
	}

	@Override
	public int insert(ErpQuality record) {
		
		return 0;
	}

	@Override
	public int insertSelective(ErpQuality record) {
		
		return 0;
	}

	@Override
	public ErpQuality selectByPrimaryKey(String quaId) {
		
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(ErpQuality record) {
		
		return 0;
	}

	@Override
	public int updateByPrimaryKey(ErpQuality record) {
		
		return 0;
	}

}

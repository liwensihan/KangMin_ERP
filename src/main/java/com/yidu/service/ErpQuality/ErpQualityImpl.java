/**
 * 
 */
package com.yidu.service.ErpQuality;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpQualityMapper;
import com.yidu.model.ErpQuality;
import com.yidu.model.ErpQualityDetail;
import com.yidu.service.ErpQualityDetail.ErpQualityDetailService;

/**
 * 质检表service接口
 * @author 大晶儿
 */
@Service
public class ErpQualityImpl implements ErpQualityService{
	@Resource
	private ErpQualityMapper mapper;//质检的导
	@Resource
	private ErpQualityDetailService service;//质检的service
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
	public int updateByPrimaryKeySelective(ErpQuality record,List<ErpQualityDetail> detlist) {
		for (Iterator iterator = detlist.iterator(); iterator.hasNext();) {
			ErpQualityDetail erpQualityDetail = (ErpQualityDetail) iterator.next();
			service.insertSelective(erpQualityDetail);
		}
		
		return 0;
	}

	@Override
	public int updateByPrimaryKey(ErpQuality record) {
		
		return 0;
	}

	@Override
	public List<ErpQuality> selectByPrimaryNew(Map<String, Object> map) {
		return mapper.selectByPrimaryNew(map);
	}

	@Override
	public int selectByPrimaryNewCount(Map<String, Object> map) {
		return mapper.selectByPrimaryNewCount(map);
	}

}

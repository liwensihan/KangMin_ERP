/**
 * 
 */
package com.yidu.service.ErpQuality;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpQualityMapper;
import com.yidu.model.ErpQuality;
import com.yidu.util.Tools;

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
		String data = mapper.selectSerial(Tools.getDateStr(new Date()));//得到当天最大的编号
		record.setQuaSreial(Tools.getSerial(data, "ZJ"));
		record.setIsva(1);
		record.setCreatetime(Tools.getTimeStr(new Date()));//得到现在的时间
		return mapper.insertSelective(record);
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

	@Override
	public List<ErpQuality> selectByPrimaryNew(Map<String, Object> map) {
		return mapper.selectByPrimaryNew(map);
	}

	@Override
	public int selectByPrimaryNewCount(Map<String, Object> map) {
		return mapper.selectByPrimaryNewCount(map);
	}

}

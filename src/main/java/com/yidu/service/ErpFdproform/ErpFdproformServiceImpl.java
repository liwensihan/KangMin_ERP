/**
 * 
 */
package com.yidu.service.ErpFdproform;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpFdproformMapper;
import com.yidu.model.ErpFdproform;

/**
 * @author Administrator
 *
 */
@Service
public class ErpFdproformServiceImpl implements ErpFdproformService{
	
	@Resource
	private ErpFdproformMapper dao ;

	@Override
	public List<ErpFdproform> findAll(Map<String, Object> map) {
		return dao.findAll(map);
	}

	@Override
	public int findRowCount(Map<String, Object> map) {
		return dao.findRowCount(map);
	}

	@Override
	public int deleteFdpro(String id) {
		return dao.deleteFdpro(id);
	}

	@Override
	public int insertSelective(ErpFdproform record) {
		return dao.insertSelective(record);
	}

	@Override
	public List<ErpFdproform> ratifyFindAll(Map<String, Object> map) {
		return dao.ratifyFindAll(map);
	}

	@Override
	public int ratifyFindAllCout(Map<String, Object> map) {
		return dao.ratifyFindAllCout(map);
	}

	@Override
	public int updateThrough(String id) {
		return dao.updateThrough(id);
	}

	@Override
	public int noThrough(String id) {
		return dao.noThrough(id);
	}

	@Override
	public int updateByPrimaryKeySelective(ErpFdproform record) {
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public int updateValue(ErpFdproform record) {
		return dao.updateValue(record);
	}

	@Override
	public ErpFdproform selectByPrimaryKey(String fdproId) {
		return dao.selectByPrimaryKey(fdproId);
	}
	
	
}

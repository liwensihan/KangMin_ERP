/**
 * 
 */
package com.yidu.service.ErpProlistmxsmall;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpProlistmxsmallMapper;
import com.yidu.model.ErpProlistmxsmall;

/**
 * @author Administrator
 *
 */
@Service
public class ErpProlistmxsmallServiceImpl implements ErpProlistmxsmallService{
	
	@Resource
	private ErpProlistmxsmallMapper dao;

	@Override
	public List<ErpProlistmxsmall> getMallById(String fdformId) {
		return dao.getMallById(fdformId);
	}

	@Override
	public int updateIsva(String fdprolistmxId) {
		return dao.updateIsva(fdprolistmxId);
	}

	@Override
	public int insertSelective(ErpProlistmxsmall record) {
		return dao.insertSelective(record);
	}

	@Override
	public List<ErpProlistmxsmall> selectBankNew(String fdproId) {
		return dao.selectBankNew(fdproId);
	}

	@Override
	public int deleteFd(String fdformId) {
		return dao.deleteFd(fdformId);
	}

	@Override
	public int updateByPrimaryKeySelective(ErpProlistmxsmall record) {
		return dao.updateByPrimaryKeySelective(record);
	}

}

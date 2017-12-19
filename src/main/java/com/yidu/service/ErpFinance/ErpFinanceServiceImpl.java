/**
 * 
 */
package com.yidu.service.ErpFinance;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpFinanceMapper;
import com.yidu.model.ErpFinance;
import com.yidu.util.Tools;

/**
 * @author zhangwei
 * 2017年10月19日
 */
@Service
public class ErpFinanceServiceImpl implements ErpFinanceService{
	
	@Resource
	private ErpFinanceMapper dao ;
	
	@Override
	public List<ErpFinance> findAll() {
		return dao.findAll();
	}

	@Override
	public int updateByPrimaryKeySelective(ErpFinance record) {
		return dao.updateByPrimaryKeySelective(record);
	}


	
}

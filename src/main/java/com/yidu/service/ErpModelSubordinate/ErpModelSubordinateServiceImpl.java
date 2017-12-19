/**
 * XLe1丶
 * 2017年10月20日 2017年8月1日16:02:52
 */
package com.yidu.service.ErpModelSubordinate;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpModelSubordinateMapper;
import com.yidu.model.ErpModelSubordinate;

/**
 * @author XLe1丶
 * 2017年10月20日
 */
@Service
public class ErpModelSubordinateServiceImpl implements ErpModelSubordinateService{
	
	@Resource
	private ErpModelSubordinateMapper dao ;

	
	public List<ErpModelSubordinate> findAllModelSub(String staName) {
		
		return dao.findAllModelSub(staName);
	}

	

}

package com.yidu.service.audit;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.yidu.dao.ErpAuditMapper;
import com.yidu.model.ErpAudit;

import org.springframework.stereotype.Service;

/**
 * 审核记录实现类
 * @author 胡鑫
 * @date 2017年11月30日10:34:05
 */
@Service
public class AuditServiceImpl implements AuditService{
	
	@Resource
	private ErpAuditMapper dao; //审核记录mapper
	/**
	 * 初始化显示审核记录
	 * @author 胡鑫
	 * @date 2017年11月30日10:38:31
	 * @param parMap map集合存放sql查询参数
	 * @return 返回审核记录集合
	 */
	@Override
	public List<ErpAudit> showList(Map<String, Object> parMap) {
		return null;
	}
	/**
	 * 根据业务id查询该条业务审核记录
	 * @author 胡鑫
	 * @date 2017年11月30日13:57:46
	 * @param parMap map集合存放sql查询参数  业务id
	 * @return 返回记录集合
	 */
	@Override
	public List<ErpAudit> showListById(Map<String, Object> parMap) {
		return dao.showListById(parMap);
	}
	
}

package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpAudit;

public interface ErpAuditMapper {
    int deleteByPrimaryKey(String audId);

    int insert(ErpAudit record);

    int insertSelective(ErpAudit record);

    ErpAudit selectByPrimaryKey(String audId);

    int updateByPrimaryKeySelective(ErpAudit record);

    int updateByPrimaryKey(ErpAudit record);
    /**
	 * 根据业务id查询该条业务审核记录
	 * @author 胡鑫
	 * @date 2017年11月30日13:57:46
	 * @param parMap map集合存放sql查询参数  业务id
	 * @return 返回记录集合
	 */
	List<ErpAudit> showListById(Map<String, Object> parMap);
}
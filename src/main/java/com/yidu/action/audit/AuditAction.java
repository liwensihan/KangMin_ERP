/**
 * 
 */
package com.yidu.action.audit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.model.ErpAudit;
import com.yidu.service.audit.AuditService;

/**
 * 审核记录action
 * @author 胡鑫
 * @date 2017年11月30日10:27:46
 */
@Controller
@RequestMapping("auditAction")
public class AuditAction {
	
	@Resource
	private AuditService auditService;//审核记录service接口
	
	/**
	 * 根据业务id查询该条业务审核记录
	 * @author 胡鑫
	 * @date 2017年11月30日13:48:32
	 * @param purcId 采购id
	 * @return 返回map集合
	 */
	@ResponseBody
	@RequestMapping("/showListById")
	public List<ErpAudit> showListById(String purcId){
		Map<String,Object>parMap = new HashMap<String,Object>();//定义一个map集合用于传入mapper查询
		parMap.put("businessId", purcId);//存入业务id
		List<ErpAudit>list = auditService.showListById(parMap);//执行查询方法
		return list;
	}
}

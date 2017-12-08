/**
 * 
 */
package com.yidu.action.sumstock;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.model.ErpKinds;
import com.yidu.service.sumstock.SumstockService;

/**
 * 分店销售订单action
 * @author ouyang
 * @data 2017年11月8日08:46:24
 */
@Controller
@RequestMapping("/sumstock")
public class SumstockAction {
	@Resource
	SumstockService sumstockService;
	
	/**
	 * 根据条形码和当前分店查询药品
	 * @param kinBarcode 条形码
	 * @author ouyang
	 * @dateTime 2017年11月24日14:03:58
	 * @return 药品实体类
	 */
	@RequestMapping("/findByKinBarcode")
	@ResponseBody
	public Map<String,Object> findByKinBarcode(String kinBarcode,String annexId){
		return sumstockService.findByKinBarcode(kinBarcode,annexId);
	}
}

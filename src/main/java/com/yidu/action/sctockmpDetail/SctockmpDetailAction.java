/**
 * 
 */
package com.yidu.action.sctockmpDetail;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.service.sctockmpDetail.SctockmpDetailService;

/**
 * 分店销售订单action
 * @author ouyang
 * @dataTime 2017年11月29日08:53:57
 */
@Controller
@RequestMapping("/sctovkmpDetail")
public class SctockmpDetailAction {
	@Resource
	SctockmpDetailService detailService;
	
	/**
	 * 根据订单ID查找订单明细
	 * @param saleId
	 * @return
	 */
	@RequestMapping("/findBySaleId")
	@ResponseBody  //ajax注解
	public List<Map<String,Object>> findBySaleId(String saleId){
		return detailService.findBySaleId(saleId);
	}
	
}

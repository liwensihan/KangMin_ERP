/**
 * 
 */
package com.yidu.action.ErpQuality;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.model.ErpQuality;
import com.yidu.service.ErpQuality.ErpQualityService;
import com.yidu.util.Pages;

/**
 * 质检表的action
 * @author 大晶儿
 * @Date 2017年11月10日
 */
@Controller
@RequestMapping("ErpQualityAction")
public class ErpQualityAction {
	@Resource
	private ErpQualityService service;
	/**
	 * 查询质检对象
	 * @param page 开始行数
	 * @param limit 总行数
	 * @param pricer 质检状态
	 * @param typePri 采购和生产订单查询
	 * @return 返回质检对象的map
	 */
	@RequestMapping("selectByPrimaryNew")
	@ResponseBody
	public Map<String,Object> selectByPrimaryNew(Integer page,Integer limit,String pricer,String typePri){
		Map<String,Object> map1 = new HashMap<String,Object>();
		Pages pa = new Pages();
		pa.setCurPage(page);
		pa.setMaxResult(limit);
		map1.put("page", pa.getFirstRows());
		map1.put("typePri",typePri);
		map1.put("limit", pa.getMaxResult());
		map1.put("pricer", pricer);
		List<ErpQuality> list = service.selectByPrimaryNew(map1);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count",service.selectByPrimaryNewCount(map));
		map.put("data", list);
		return map;
	};
}

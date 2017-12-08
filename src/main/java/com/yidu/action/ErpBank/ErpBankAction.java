/**
 * 
 */
package com.yidu.action.ErpBank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.model.ErpBank;
import com.yidu.service.ErpBank.ErpBankService;

/**
 * 入库单表
 * @author Gjwen
 * 2017年11月13日-上午8:44:46
 */
@Controller
@RequestMapping("Bank")
public class ErpBankAction {
	/**
	 * 注入入库Service
	 */
	@Resource
	private ErpBankService erpBankService; 
	/**
	 * 显示和查询
	 * @param page
	 * @param limit
	 * @param keywords
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/selectAll")
	public Map<String,Object> selectAll(String page,String limit,String keywords){
		
		Map<String,Object> map = new HashMap<String,Object>();
		if(keywords==null || "".equals(keywords)){
			map.put("keywords", "");
		}else{
			map.put("keywords", "%"+keywords+"%");
		}
		List<ErpBank> list = erpBankService.selectAll(map);//查询表数据
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", 10);//查询行数
		map.put("data", list);
		return map;
	}
//	<if test="keywords != ''">
//		ept.INDENT_NUMBER LIKE #{keywords} OR
//		ept.INDENT_MONEY LIKE #{keywords} OR
//		epe.PURC_SERIAL LIKE #{keywords} OR
//		epe.PURC_TITLE LIKE #{keywords} OR
//		epe.PURC_NAME LIKE #{keywords}
//		and
//		</if>
//	limit #{pages.firstRows},#{pages.maxResult}
}

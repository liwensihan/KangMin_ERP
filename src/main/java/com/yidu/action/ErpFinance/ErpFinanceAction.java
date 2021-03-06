/**
 * 
 */
package com.yidu.action.ErpFinance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.common.Tools;
import com.yidu.model.ErpApplyasset;
import com.yidu.model.ErpFinance;
import com.yidu.model.ErpPay;
import com.yidu.service.ErpApplyasset.ErpApplyassetService;
import com.yidu.service.ErpFinance.ErpFinanceService;
import com.yidu.service.ErpPay.ErpPayService;
import com.yidu.util.SsmMessage;



/**
 * @author zhangwei
 * 2017年10月23日
 */
@Controller
@RequestMapping("/finance")
public class ErpFinanceAction {

	@Resource
	private ErpFinanceService service;//财务接口
	
	@Resource
	private ErpApplyassetService applyAssetService;//资金申请接口
	@Resource
	private ErpPayService payService;//支付单(收入接口)
	
	
	/**
	 * 初始化页面显示
	 * @author 胡鑫
	 * @date 2017年11月6日15:42:59
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/showList")
	public Map<String,Object>showList(String date){
		if(Tools.isEmpty(date)){
			date="";
		}else{
			date="%"+date+"%";
		}
		
		List<ErpApplyasset>applyAssetList = applyAssetService.applyassetShowList(date);//得到资金申请集合分12月份
		List<ErpPay>payList = payService.showListPrice(date);//得到支付单集合 分12月份
		
		Map<String,Object> map = new HashMap<String,Object>();//定义一个map集合
		map.put("applyAssetList",applyAssetList);//map放入资金申请集合
		map.put("payList", payList);//map放入支付单集合
		return map;
	}
	
}

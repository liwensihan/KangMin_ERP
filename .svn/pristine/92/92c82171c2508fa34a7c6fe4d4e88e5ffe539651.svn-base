/**
 * 
 */
package com.yidu.action.ErpPay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.common.Tools;
import com.yidu.model.ErpApplyasset;
import com.yidu.model.ErpPay;
import com.yidu.service.ErpPay.ErpPayService;
import com.yidu.util.Pages;
import com.yidu.util.SsmMessage;

/**
 * @author zhangwei
 * 2017年10月23日
 */
@Controller
@RequestMapping("/ErpPay")
public class ErpPayAction {

	@Resource
	private ErpPayService service;//支付单接口
	
	/**
	 * 得到收入的集合
	 * @author 胡鑫
	 * @date 2017年11月13日14:36:56
	 * @param page 当前页数
	 * @param limit 每页显示的行数
	 * @param keyWord 模糊查询参数
	 * @param state 状态
	 * @param staTime 开始时间
	 * @param endTime 结束时间
	 * @return 返回map集合
	 */
	@ResponseBody
	@RequestMapping("showList")
	public Map<String,Object> showList(String page,String limit,String keyWord,String staEndTime,String state){
		System.out.println("123"+staEndTime);
		Map<String,Object> paraMap = new HashMap<String,Object>();//定义一个map集合 传入参数查询出集合
		Pages pages = new Pages();//定义一个分页实体类
		pages.setCurPage(Integer.valueOf(page));//设值 开始的行数
		pages.setMaxResult(Integer.valueOf(limit));//设值 每页显示的行数
		paraMap.put("pages", pages);//存入map
		if(keyWord!=null && keyWord!="")paraMap.put("keyWord", "%"+keyWord+"%");//模糊查询参数存入map
		paraMap.put("state", state);//状态查询参数
		if(Tools.isEmpty(staEndTime)){
			paraMap.put("staTime", "");//开始的时间
			paraMap.put("endTime", "");//结束时间
		}else{
			String[] sta = staEndTime.split(" ~ ");
			paraMap.put("staTime", sta[0]);//开始的时间
			paraMap.put("endTime", sta[1]);//结束时间
		}
		List<ErpPay>list = service.showList(paraMap);//得到支出集合 传入 paraMap集合
		Map<String,Object> map = new HashMap<String,Object>();//定义一个map集合对应返回jsp页面需要的参数
		map.put("data", list);//对应layui数据表格数据参数
		map.put("count", service.findCount(paraMap));//对应layui数据表格行数参数
		map.put("msg", "");
		map.put("code", 0);
		return map;
	}
	
}

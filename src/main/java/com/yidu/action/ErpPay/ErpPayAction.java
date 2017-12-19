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
 * 财务收入action
 * @author 胡鑫
 * @date 2017年11月13日14:27:36
 */
@Controller
@RequestMapping("/ErpPay")
public class ErpPayAction {
	//支付单接口
	@Resource
	private ErpPayService service;
	
	/**
	 * 得到收入的集合
	 * @author 胡鑫
	 * @date 2017年11月13日14:36:56
	 * @param page 当前页数
	 * @param limit 每页显示的行数
	 * @param keyWord 模糊查询参数
	 * @param state 状态
	 * @param staEndTime 开始时间结束时间
	 * @return 返回map集合
	 */
	@ResponseBody
	@RequestMapping("showList")
	public Map<String,Object> showList(String page,String limit,String keyWord,String staEndTime,String state){
		//定义一个map集合 
		Map<String,Object> paraMap = new HashMap<String,Object>();
		//定义一个分页实体类
		Pages pages = new Pages();
		//设值 开始的行数
		pages.setCurPage(Integer.valueOf(page));
		//设值 每页显示的行数
		pages.setMaxResult(Integer.valueOf(limit));
		//分页对象存入map
		paraMap.put("pages", pages);
		//模糊查询参数存入map
		if(keyWord!=null && keyWord!="")paraMap.put("keyWord", "%"+keyWord+"%");
		//状态查询参数
		paraMap.put("state", state);
		//判断开始结束时间是否为空 为空返回true
		if(Tools.isEmpty(staEndTime)){
			//开始的时间设值空
			paraMap.put("staTime", "");
			//结束时间设值空
			paraMap.put("endTime", "");
		}else{
			//将开始结束时间用~分割
			String[] sta = staEndTime.split(" ~ ");
			//开始的时间
			paraMap.put("staTime", sta[0]);
			//结束时间
			paraMap.put("endTime", sta[1]);
		}
		//模糊 分页查询全部收入集合
		List<ErpPay>list = service.showList(paraMap);
		//定义一个map集合对应返回jsp页面需要的参数
		Map<String,Object> map = new HashMap<String,Object>();
		//对应layui数据表格数据参数
		map.put("data", list);
		//对应layui数据表格行数参数
		map.put("count", service.findCount(paraMap));
		//暂无使用
		map.put("msg", "");
		map.put("code", 0);
		//返回map
		return map;
	}
	
}

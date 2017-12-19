/**
 * 
 */
package com.yidu.action.ErpApplyasset;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.common.Tools;
import com.yidu.model.ErpApplyasset;
import com.yidu.model.ErpStaff;
import com.yidu.service.ErpApplyasset.ErpApplyassetService;
import com.yidu.util.Pages;
import com.yidu.util.SsmMessage;

/**
 * 财务支出action
 * @author 胡鑫
 * @date 2017年11月9日08:34:53
 */
@Controller
@RequestMapping("/applyasset")
public class ErpApplyassetAction {
	
	//资金申请接口
	@Resource
	private ErpApplyassetService service;
	
	
	/**
	 * 得到支出的集合
	 * @author 胡鑫
	 * @date 2017年11月9日08:40:31
	 * @param page 当前页数
	 * @param limit 每页显示的行数
	 * @param keyWord 模糊查询参数
	 * @param state 状态
	 * @param staTime 开始时间
	 * @param endTime 结束时间
	 * @param maxState 用于判断状态
	 * @return 返回map集合
	 */
	@ResponseBody
	@RequestMapping("showList")
	public Map<String,Object> showList(String page,String limit,String keyWord,String staEndTime,String state,String maxState){
		//定义一个map集合 传入参数查询出集合
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
		if("1".equals(maxState))paraMap.put("maxState", 1);
		//状态查询参数
		paraMap.put("state", state);
		//判断开始结束时间是否为空 为空返回true
		if(Tools.isEmpty(staEndTime)){
			//开始的时间
			paraMap.put("staTime", "");
			//结束时间
			paraMap.put("endTime", "");
		}else{
			//将开始结束时间用~分割
			String[] sta = staEndTime.split(" ~ ");
			//开始的时间
			paraMap.put("staTime", sta[0]);
			//结束时间
			paraMap.put("endTime", sta[1]);
		}
		//模糊 分页查询全部支出集合
		List<ErpApplyasset>list = service.showList(paraMap);
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
	
	/**
	 * 财务审核申请
	 * @author 胡鑫
	 * @date 2017年11月14日10:34:24
	 * @param appassId 资金申请id
	 * @param feedback 审核反馈信息
	 * @return 返回消息类
	 */
	@ResponseBody
	@RequestMapping("auditFeedback")
	public SsmMessage auditFeedback(String appassId,String feedBack,String state,HttpSession session){
		//定义消息实体类
		SsmMessage mes = new SsmMessage();
		//定义一个map集合
		Map<String,Object>map = new HashMap<String,Object>();
		//判断字符串是否为空 为空返回true
		if(Tools.isEmpty(feedBack)){
			//为空设值
			map.put("feedBack", "暂无反馈信息");
		}else{
			//map集合中存入 反馈消息
			map.put("feedBack", feedBack);
		}
		//map集合中存入 资金申请id
		map.put("appassId", appassId);
		//map集合中存入 审核是否通过   state=2 通过 state=0 不通过
		map.put("state", state);
		//得到人员session
		ErpStaff staff = (ErpStaff) session.getAttribute("staff");
		//将人员类传入map
		map.put("staff", staff);
		//根据资金申请id 增加审核信息
		int rows = service.auditApplyasset(map);
		//返回参数==102进行方法
		if(rows == 102){
			//消息类设值内容
			mes.setMes("余额不足扣除当前资金申请!");
			//消息类设值状态102
			mes.setState(102);
		}
		//返回map集合
		return mes;
	}
}

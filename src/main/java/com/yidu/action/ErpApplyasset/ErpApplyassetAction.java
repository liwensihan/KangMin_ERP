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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.common.Tools;
import com.yidu.model.ErpApplyasset;
import com.yidu.model.ErpStaff;
import com.yidu.service.ErpApplyasset.ErpApplyassetService;
import com.yidu.util.Pages;
import com.yidu.util.SsmMessage;

/**
 * @author zhangwei
 * 2017年10月19日
 */
@Controller
@RequestMapping("/applyasset")
public class ErpApplyassetAction {

	@Resource
	private ErpApplyassetService service;//资金申请接口
	
	
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
		Map<String,Object> paraMap = new HashMap<String,Object>();//定义一个map集合 传入参数查询出集合
		Pages pages = new Pages();//定义一个分页实体类
		pages.setCurPage(Integer.valueOf(page));//设值 开始的行数
		pages.setMaxResult(Integer.valueOf(limit));//设值 每页显示的行数
		paraMap.put("pages", pages);//存入map
		if(keyWord!=null && keyWord!="")paraMap.put("keyWord", "%"+keyWord+"%");//模糊查询参数存入map
		if("1".equals(maxState))paraMap.put("maxState", 1);//状态查询参数
		paraMap.put("state", state);//状态查询参数
		if(Tools.isEmpty(staEndTime)){
			paraMap.put("staTime", "");//开始的时间
			paraMap.put("endTime", "");//结束时间
		}else{
			String[] sta = staEndTime.split(" ~ ");
			paraMap.put("staTime", sta[0]);//开始的时间
			paraMap.put("endTime", sta[1]);//结束时间
		}
		List<ErpApplyasset>list = service.showList(paraMap);//得到支出集合 传入 paraMap集合
		Map<String,Object> map = new HashMap<String,Object>();//定义一个map集合对应返回jsp页面需要的参数
		map.put("data", list);//对应layui数据表格数据参数
		map.put("count", service.findCount(paraMap));//对应layui数据表格行数参数
		map.put("msg", "");
		map.put("code", 0);
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
		SsmMessage mes = new SsmMessage();
		Map<String,Object>map = new HashMap<String,Object>();//定义一个map集合
		if(Tools.isEmpty(feedBack)){//判断字符串是否为空
			map.put("feedBack", "暂无反馈信息");
		}else{
			map.put("feedBack", feedBack);//map集合中存入 反馈消息
		}
		map.put("appassId", appassId);//map集合中存入 资金申请id
		map.put("state", state);//map集合中存入 审核是否通过   state=2 通过 state=0 不通过
		ErpStaff staff = (ErpStaff) session.getAttribute("staff");//得到人员session
		map.put("staff", staff);
		int rows = service.auditApplyasset(map);
		if(rows == 102){
			mes.setMes("余额不足扣除当前资金申请!");
			mes.setState(102);
		}
		return mes;
	}
}

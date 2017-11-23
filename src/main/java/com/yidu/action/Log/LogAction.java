/**
 * 
 */
package com.yidu.action.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.common.Tools;
import com.yidu.model.ErpLog;
import com.yidu.model.ErpLogDetail;
import com.yidu.model.ErpProindent;
import com.yidu.service.Log.LogService;
import com.yidu.service.LogDetail.LogDetailService;
import com.yidu.service.Proindent.ProindentService;
import com.yidu.service.ProindentDetail.ProindentDetailService;
import com.yidu.util.Pages;
import com.yidu.util.SsmMessage;

/**
 * @author dong
 * @da2017年11月16日
 * @version 1.0
 */
@Controller
@RequestMapping("log")
public class LogAction {
	
	@Resource
	public LogService logService;//生产日志
	
	@Resource
	public LogDetailService logDetailService;//生产日志明细
	
	@Resource
	public ProindentDetailService proindentDetailService;//订单明细
	
	@Resource
	public ProindentService proindentService;//订单
	
	@RequestMapping("/add")
	@ResponseBody
	
	
	public SsmMessage add(ErpLog log,ErpLogDetail logdeta,String str,String indentId){
		
		SsmMessage mes = new SsmMessage();
		
		String[] sourceStrArray = str.split("&");//字符串分割
		System.out.println(sourceStrArray.length);
		
		double num=0;//总数量
		double quantity=0;//以生成数量
			
		for(int i =0;i<sourceStrArray.length;i++){
			String[] str1= sourceStrArray[i].split("_");
			num=num+Integer.valueOf(str1[0]);//总数量相加 
			quantity=quantity+Integer.valueOf(str1[1]);//生成数量相加
		}
		int number=(int) (quantity/num*100);
		
		log.setIndentId(indentId);//生成订单ID
		log.setLogSerial("RZ-"+Tools.getCurDate()+Tools.getRandomNumber(1000));//编号，先加SZ在取当前时间，在取随机数1000
		log.setLogTitle(log.getLogTitle());//日志标题
		log.setLogContent(log.getLogContent());//生产内容
		log.setLogComplet(number);//百分比
		log.setCreatetime(Tools.getCurDate());//当前时间
		log.setIsva(1);//是否有效
		logService.insert(log);//增加
		
		Map<String, Object> m=new HashMap<String,Object>();
		
		//判断是否等于100%
		if(number==100.0){
			m.put("indentState", 3);
			m.put("indentId", indentId);
			proindentService.updateId(m);
		}else{
			m.put("indentState", 2);
			m.put("indentId", indentId);
			proindentService.updateId(m);
		}
		
		
		Map<String, Object> map=new HashMap<String,Object>();//定义map方便传值到订单明细
		
		//订单日志明细
		for(int i =0;i<sourceStrArray.length;i++){
			String[] str2= sourceStrArray[i].split("_");
			
			logdeta.setKinId(str2[3]);//商品ID
			logdeta.setLogId(log.getLogId());//生成日志ID
			logdeta.setNum(Integer.valueOf(str2[1]));//当前的总数量
			logdeta.setDetailNum(Integer.valueOf(str2[2]));//当前生产总数量
			logdeta.setCreatetime(Tools.getCurDate());//当前时间
			logdeta.setIsva(1);//是否有效
			logDetailService.insert(logdeta);//生成日志增加
			map.put("num", str2[1]);//生产数量
			map.put("kinId", str2[3]);//商品ID
			map.put("indentId", indentId);//订单ID
			proindentDetailService.updateId(map);//根据商品ID和订单ID修改已生产数量
			
		}
		mes.setMes("操作成功");
		mes.setState(1);
		
		
		return mes;
	}
	
	
	
	
	/**
	 * 查询所有方法
	 * @param page
	 * @param limit
	 * @param area
	 * @return
	 */
	@RequestMapping("/showList")
	@ResponseBody  //ajax注解
	public Map<String,Object> showList(int page ,int limit,ErpLog log,String key){
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String,Object> pagmap = new HashMap<String, Object>();
		Pages ps=new Pages();
		ps.setCurPage(page);
		ps.setMaxResult(limit);
		pagmap.put("page", ps.getFirstRows());//把页数传到map
		pagmap.put("limit", ps.getMaxResult());//把页数传到map
		pagmap.put("key", key);//关键字
		
		List<ErpLog> list=logService.selectshow(pagmap);//查询所有
		
		//layui数据表格需要返回的参数
		map.put("count",logService.select(pagmap));//总行数
		map.put("data", list);
		map.put("code",0);
		map.put("msg", "");
		return map;
	}
	
}

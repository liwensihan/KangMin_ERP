/**
 * 
 */
package com.yidu.action.Pact;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.common.Tools;
import com.yidu.model.ErpApply;
import com.yidu.model.ErpPact;
import com.yidu.model.ErpPactType;
import com.yidu.model.ErpProindent;
import com.yidu.model.ErpPurchase;
import com.yidu.service.ErpApply.ErpApplyService;
import com.yidu.service.ErpPact.ErpPactService;
import com.yidu.service.ErpPurchase.ErpPurchaseService;
import com.yidu.service.PactType.PactTypeService;
import com.yidu.util.Pages;
import com.yidu.util.SsmMessage;

/**
 * @author dong
 * @da2017年11月2日
 * @version 1.0
 */
@Controller
@RequestMapping("pact")
public class PactAction {
	
	@Resource
	private ErpApplyService erpApplyService;//供货商
	
	@Resource
	private ErpPurchaseService erpPurchaseServicel;//采购订单
	
	@Resource
	private PactTypeService pactTypeService;//合同类型
	
	@Resource
	private ErpPactService erpPactService;
	
	SsmMessage mes = new SsmMessage();//消息类
	/**
	 * 下拉框查询所有供货商
	 * @return 返回list
	 */
	@RequestMapping("/findByxl")
	@ResponseBody
	public List<ErpApply> findByxl(){
		List<ErpApply> list=erpApplyService.findErpApply();
		
		return list;
		
	}
	
	
	
	/**
	 * 下拉框查询所有采购订单
	 * @return 返回list
	 */
	@RequestMapping("/findBycg")
	@ResponseBody
	public List<ErpPurchase> findBycg(){
		List<ErpPurchase> list=erpPurchaseServicel.selectshow();
		
		return list;
		
	}
	
	/**
	 * 下拉框查询所有合同类型
	 * @return 返回list
	 */
	@RequestMapping("/findBylx")
	@ResponseBody
	public List<ErpPactType> findBylx(){
		List<ErpPactType> list=pactTypeService.select();
		
		return list;
		
	}
	
	
	/**
	 * 删除方法
	 * 
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public SsmMessage delete(ErpPact record){
		record.setIsva(0);
		record.setPactId(record.getPactId());
		int rows=erpPactService.updateByPrimaryKeySelective(record);
		if(rows>0){
			mes.setMes("操作成功");
			mes.setState(1);
		}else{
			mes.setMes("操作失败");
			mes.setState(0);
		}
		
		return mes;
		
		
	}
	
	/**
	 * 增加类型
	 * @param record 类型对象
	 * @return 返回信息类
	 */
	@RequestMapping("insertSelectivePact")
	@ResponseBody
	public SsmMessage insertSelectivePact(ErpPact record){
		
		record.setPurId(record.getPurId());
		record.setApplyId(record.getApplyId());
		record.setPatypeId(record.getPatypeId());
		record.setPactTitle(record.getPactTitle());
		record.setPactNumber("HT-"+Tools.getCurDate()+Tools.getRandomString(4));
		Date date=new Date();
		record.setPactSigntime(date);
		System.out.println(record.getPactText()+"-------------------------");
		record.setPactText(record.getPactText());
		record.setIsva(1);
		int rows = erpPactService.insert(record);
		if(rows>-1){
			mes.setMes("增加成功");
			mes.setState(1);
		}else{
			mes.setMes("增加失败");
			mes.setState(0);
		}
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
	public Map<String,Object> showList(int page ,int limit,ErpPact pact,String key){
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String,Object> pagmap = new HashMap<String, Object>();
		Pages ps=new Pages();
		ps.setCurPage(page);
		ps.setMaxResult(limit);
		pagmap.put("page", ps.getFirstRows());//把页数传到map
		pagmap.put("limit", ps.getMaxResult());//把页数传到map
		pagmap.put("key", key);//关键字
		
		
		List<ErpPact> list=erpPactService.selectshow(pagmap);
		
		//layui数据表格需要返回的参数
		map.put("count",erpPactService.findRowCount(pagmap));//总行数
		map.put("data", list);
		map.put("code",0);
		map.put("msg", "");
		return map;
	}
}

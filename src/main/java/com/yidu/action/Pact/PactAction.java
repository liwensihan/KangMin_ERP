/**
 * 
 */
package com.yidu.action.Pact;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.common.Tools;
import com.yidu.model.ErpApply;
import com.yidu.model.ErpPact;
import com.yidu.model.ErpPactType;
import com.yidu.model.ErpProindent;
import com.yidu.model.ErpPurchase;
import com.yidu.model.ErpStaff;
import com.yidu.service.ErpApply.ErpApplyService;
import com.yidu.service.ErpPact.ErpPactService;
import com.yidu.service.ErpPurchase.ErpPurchaseService;
import com.yidu.service.PactType.PactTypeService;
import com.yidu.util.Pages;
import com.yidu.util.SsmMessage;

/**
 * @author zhangwei
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
		//供货商的查询所有供货商方法 返回list
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
		//采购订单查询所有下拉框方法，返回list
		List<ErpPurchase> list = erpPurchaseServicel.selectshow();
		
		return list;
		
	}
	
	/**
	 * 下拉框查询所有合同类型
	 * @return 返回list
	 */
	@RequestMapping("/findBylx")
	@ResponseBody
	public List<ErpPactType> findBylx(){
		//合同类型查询所有下拉框方法，返回list
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
		//给合同是否有效赋值为0为无效
		record.setIsva(0);
		//给合同的id赋值为合同的id 
		record.setPactId(record.getPactId());
		//int型 合同选择性修改
		int rows=erpPactService.updateByPrimaryKeySelective(record);
		//判断定义的值大于0
		if(rows>0){
			//消息类的消息值赋值为成功
			mes.setMes("操作成功");
			//将消息类的状态赋值为1
			mes.setState(1);
		}else{
			//消息类的消息值赋值为失败
			mes.setMes("操作失败");
			//将消息类的状态赋值为0
			mes.setState(0);
		}
		//返回消息类
		return mes;
		
		
	}
	
	/**
	 * 增加类型
	 * @param record 类型对象
	 * @return 返回信息类
	 */
	@RequestMapping("insertSelectivePact")
	@ResponseBody
	public SsmMessage insertSelectivePact(ErpPact record,HttpSession session){
		
		
		
		//给订单采购的id赋值为订单采购的id 
		record.setPurId(record.getPurId());
		//给供货商的id赋值为供货商的id
		record.setApplyId(record.getApplyId());
		//给合同类型的id赋值为合同类型的id
		record.setPatypeId(record.getPatypeId());
		//给合同的标题赋值为合同的标题
		record.setPactTitle(record.getPactTitle());
		//给合同的编号赋值为工具类中的得到订单编码格式:日期格式如:20161222211800,分别代表的是年月日时分秒+5位随机字符串
		record.setPactNumber("HT-"+Tools.getDateOrderNo());
		//初始化时间对象
		Date date=new Date();
		//将合同的时间赋值为初始化的时间
		record.setPactSigntime(date);
		//给合同内容赋值为合同的内容
		record.setPactText(record.getPactText());
		//给合同id赋值为合同id
		record.setPactId(record.getPactId());
		//得到session中的人员对象staff
		ErpStaff staff = (ErpStaff) session.getAttribute("staff");
		//给名字赋值为人员staff的名字
		record.setPartaName(staff.getStaName());
		//给名字赋值为供货商id
		record.setPartbName(record.getApplyId());
		//给合同是否有效赋值为1为有效
		record.setIsva(1);
		//判断合同id等于null或者为空
		if(record.getPactId()==null || "".equals(record.getPactId())){
			//int型 合同方法添加全部
			int rows = erpPactService.insert(record);
			//判断值是否大于等于1
			if(rows>=1){
				//消息类的消息值赋值为成功
				mes.setMes("操作成功");
				//将消息类的状态赋值为1
				mes.setState(1);
			}else{
				//消息类的消息值赋值为失败
				mes.setMes("操作失败");
				//将消息类的状态赋值为0
				mes.setState(0);
			}
		}else{
			//int型 合同方法选择性修改
			int rows =erpPactService.updateByPrimaryKeySelective(record);
			//判断值是否大于等于1
			if(rows>=1){
				//消息类的消息值赋值为成功
				mes.setMes("修改成功");
				//将消息类的状态赋值为1
				mes.setState(1);
			}else{
				//消息类的消息值赋值为失败
				mes.setMes("修改失败");
				//将消息类的状态赋值为0
				mes.setState(0);
			}
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
		//定义一个map方法
		Map<String,Object> map = new HashMap<String, Object>();
		//定义一个map方法
		Map<String,Object> pagmap = new HashMap<String, Object>();
		//new一个分页工具类
		Pages ps=new Pages();
		//分页工具类的当前页数
		ps.setCurPage(page);
		//分页工具类的每页最大显示条数
		ps.setMaxResult(limit);
		//将分页工具类开始的行数传入给第二个map
		pagmap.put("page", ps.getFirstRows());//把页数传到map
		//将分页工具类每页最大显示条数传入给第二个map
		pagmap.put("limit", ps.getMaxResult());//把页数传到map
		//上面属性最后一个属性关键字查询
		pagmap.put("key", key);//关键字
		
		//合同方法查询所有方法 返回list
		List<ErpPact> list=erpPactService.selectshow(pagmap);
		
		//layui数据表格需要返回的参数 合同总行数
		map.put("count",erpPactService.findRowCount(pagmap));//总行数
		//将list传入map 取名为data
		map.put("data", list);
		//将0传入map，取名为code
		map.put("code",0);
		//将空传入map 取名为msg
		map.put("msg", "");
		//返回map
		return map;
	}
	
	
	
	
	/**
	 * 根据id查询
	 * @return 返回list
	 */
	@RequestMapping("/findByID")
	@ResponseBody
	public ErpPact findByID(String pactId){
		//合同表 合同方法查找单个对象 返回合同
		ErpPact pact=erpPactService.selectByPrimaryKey(pactId);
		//返回合同
		return pact;
		
	}
	
	
	/**
	 * 根据id查询
	 * @return 返回list
	 */
	@RequestMapping("/findByshowid")
	@ResponseBody
	public Map<String, Object> findByshowid(String pactId){
		//map 合同方法根据合同id查询供货商和合同详情 返回合同
		Map<String, Object> pact=erpPactService.selectshowid(pactId);
		//返回合同
		return pact;
	}
}

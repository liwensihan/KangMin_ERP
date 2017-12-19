/**
 * 
 */
package com.yidu.action.PactType;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.common.Tools;
import com.yidu.model.ErpPactType;
import com.yidu.service.PactType.PactTypeService;
import com.yidu.util.Pages;
import com.yidu.util.SsmMessage;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("pacttype")
public class PactTypeAction {
	@Resource
	private PactTypeService pactTypeService;//合同类型
	
	SsmMessage mes = new SsmMessage();
	
	/**
	 * 查询所有方法
	 * @param page 
	 * @param limit
	 * @param area
	 * @return
	 */
	@RequestMapping("/showList")
	@ResponseBody  //ajax注解
	public Map<String,Object> showList(int page ,int limit,ErpPactType type,String key){
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
		//将分页工具类开始的行数传入给第二个map page
		pagmap.put("page", ps.getFirstRows());//把页数传到map
		//将分页工具类每页最大显示条数传入给第二个map limit
		pagmap.put("limit", ps.getMaxResult());//把页数传到map
		//上面属性最后一个属性关键字查询
		pagmap.put("key", key);//关键字
		
		//合同类型的显示所有方法
		List<ErpPactType> list=pactTypeService.selectshow(pagmap);
		
		//layui数据表格需要返回的参数 合同类型的总行数方法
		map.put("count",pactTypeService.findRowCount(pagmap));//总行数
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
	 * 增加类型
	 * @param record 类型对象
	 * @return 返回信息类
	 */
	@RequestMapping("insertSelectivePactType")
	@ResponseBody
	public SsmMessage insertSelectivePactType(ErpPactType record){
		//给合同类型的编号赋值为工具类中的得到订单编码格式:日期格式如:20161222211800,分别代表的是年月日时分秒+5位随机字符串
		record.setPatypeSreial("LX-"+Tools.getDateOrderNo());
		//将合同类型名称赋值给合同类型名称
		record.setPatypeName(record.getPatypeName());
		//将合同类型备注赋值给合同类型备注
		record.setRemark(record.getRemark());
		//将合同类型时间为工具类中得到得到当前日期时间 yyyy-MM-dd HH:mm:ss
		record.setCreater(Tools.getCurDateTime());
		//给合同类型是否有效赋值为1为有效
		record.setIsva(1);
		//将合同类型id赋值为合同类型id
		record.setPatypeId(record.getPatypeId());
		//判断合同类型id等于null或者为空
		if(record.getPatypeId()==null || "".equals(record.getPatypeId())){
			//int型 合同类型的添加全部方法
			int rows = pactTypeService.insert(record);
			//判断值大于等于1
			if(rows>=1){
				//消息类的消息值赋值为成功
				mes.setMes("增加成功");
				//将消息类的状态赋值为1
				mes.setState(1);
			}else{
				//消息类的消息值赋值为失败
				mes.setMes("增加失败");
				//将消息类的状态赋值为0
				mes.setState(0);
			}
		}else{
			//int型合同类型的选择性修改方法
			int rows =pactTypeService.updateByPrimaryKeySelective(record);
			//判断值大于等于1
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
		//返回mes
		return mes;
	}
	
	
	
	/**
	 * 删除方法
	 * 
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public SsmMessage delete(ErpPactType type){
		//给合同类型是否有效赋值为0无效
		type.setIsva(0);
		//将合同类型id赋值为合同类型id
		type.setPatypeId(type.getPatypeId());
		//int型 合同类型的选择性修改方法
		int rows=pactTypeService.updateByPrimaryKeySelective(type);
		//判断值大于0
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
		//返回mes
		return mes;
		
		
	}
	
	
	/**
	 * 根据id查询
	 * @return 返回list
	 */
	@RequestMapping("/findByID")
	@ResponseBody
	public ErpPactType findByID(String patypeId){
		//合同类型的查找单个对象方法
		ErpPactType pact=pactTypeService.selectByPrimaryKey(patypeId);
		//返回pact
		return pact;
		
	}
}

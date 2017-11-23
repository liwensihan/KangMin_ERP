/**
 * 
 */
package com.yidu.action.proindent;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.model.ErpProindent;
import com.yidu.model.ErpProindentDetail;
import com.yidu.service.Proindent.ProindentService;
import com.yidu.service.ProindentDetail.ProindentDetailService;
import com.yidu.util.Pages;
import com.yidu.util.SsmMessage;

/**
 * 订单action
 * @author dong
 * @da2017年11月7日
 * @version 1.0
 */
@Controller
@RequestMapping("dent")
public class ProindentAction {
	@Resource
	private ProindentService proindentService;//订单
	
	@Resource
	private ProindentDetailService ProindentDetailService;//订单明细
	
	SsmMessage  mes=new SsmMessage();//消息类
	
	
	
	/**
	 * 下拉框查询所有订单
	 * @param express
	 * @return
	 */
	@RequestMapping("/findByxl")
	@ResponseBody
	public List<ErpProindent> findByxl(ErpProindent dent){
		List<ErpProindent> list=proindentService.findStation();
		
		return list;
		
	}
	
	
	/**
	 * 下拉框查询所有订单
	 * @param express
	 * @return
	 */
	@RequestMapping("/findByshowxl")
	@ResponseBody
	public List<Map<String, Object>> findByshowxl(ErpProindent dent){
		
		List<Map<String, Object>> map=proindentService.findStationid(dent.getIndentId());
		
		return map;
		
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
	public Map<String,Object> showList(int page ,int limit,ErpProindent dent,String key){
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String,Object> pagmap = new HashMap<String, Object>();
		Pages ps=new Pages();
		ps.setCurPage(page);
		ps.setMaxResult(limit);
		pagmap.put("page", ps.getFirstRows());//把页数传到map
		pagmap.put("limit", ps.getMaxResult());//把页数传到map
		pagmap.put("key", key);//关键字
		pagmap.put("indentUrgency", dent.getIndentUrgency());//是否紧急
		pagmap.put("state", dent.getState());//审核状态
		pagmap.put("indentState", dent.getIndentEmetime());//订单状态
		
		
		List<ErpProindent> list=proindentService.selectByPrimaryKey(pagmap);
		
		//layui数据表格需要返回的参数
		map.put("count",proindentService.findRowCount(pagmap));//总行数
		map.put("data", list);
		map.put("code",0);
		map.put("msg", "");
		return map;
	}
	
	
	
	
	
	
	@RequestMapping("/showPro")
	@ResponseBody  //ajax注解
	public Map<String,Object> showPro(int page ,int limit,ErpProindent dent,String key){
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String,Object> pagmap = new HashMap<String, Object>();
		Pages ps=new Pages();
		ps.setCurPage(page);
		ps.setMaxResult(limit);
		pagmap.put("page", ps.getFirstRows());//把页数传到map
		pagmap.put("limit", ps.getMaxResult());//把页数传到map
		List<ErpProindent> list=proindentService.showPro(pagmap);
		
		//layui数据表格需要返回的参数
		map.put("count",proindentService.findRowCount(pagmap));//总行数
		map.put("data", list);
		map.put("code",0);
		map.put("msg", "");
		return map;
	}
	
	/**
	 * 删除方法
	 * @param express
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public SsmMessage delete(ErpProindentDetail detail,ErpProindent dent){
		
		
		detail.setIsva("0");//订单明细
		detail.setIndentId(dent.getIndentId());
		
		
		dent.setIsva("0");//订单
		dent.setIndentId(dent.getIndentId());
		SsmMessage mes = new SsmMessage();
		int rows=0;
		rows = proindentService.updateByPrimaryKeySelective(dent);//删除方法
		rows=ProindentDetailService.updateByPrimaryKeySelective(detail);//删除方法
		
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
	 * 根据ID查询
	 * @param express
	 * @return
	 */
	@RequestMapping("/findById")
	@ResponseBody
	public List<Map<String, Object>> findById(ErpProindent dent){
		List<Map<String, Object>> map=proindentService.selectByPrimaryKeyid(dent.getIndentId());
		
		return map;
		
	}
	
	
	/**
	 * 根据ID查询所有，根据订单id查询明细，和商品表查看明细
	 * @param express
	 * @return
	 */
	@RequestMapping("/findByshowId")
	@ResponseBody
	public List<Map<String, Object>> findByshowId(ErpProindent dent){
		List<Map<String, Object>> map=proindentService.showid(dent.getIndentId());
		
		return map;
		
	}
	
	
	/**
	 * 查询产品，订单，订单明细，订单生产日志，订单生产日志明细，根据订单ID查询
	 * @param express
	 * @return
	 */
	@RequestMapping("/findByshow")
	@ResponseBody
	public List<Map<String, Object>> findByshow(ErpProindent dent){
		
		int num=proindentService.findcount(dent.getIndentId());//订单明细总行数
		
		Map<String, Object> m=new HashMap<String,Object>();
		
		m.put("indentId", dent.getIndentId());
		m.put("int", num);
		
		List<Map<String, Object>> map=proindentService.findByshow(m);//查询产品，订单，订单明细，订单生产日志，订单生产日志明细，根据订单ID查询和订单明细总行数查询
		
		return map;
		
	}
	
	/**
	 * 根据ID查询单个订单
	 * @param express
	 * @return
	 */
	@RequestMapping("/show")
	@ResponseBody
	public ErpProindent show(ErpProindent dent){
		ErpProindent map=proindentService.findById(dent.getIndentId());
		
		return map;
		
	}
	
	/**
	 * 修改订单明细和修改订单
	 * @param detail 订单明细表
	 * @param dent 订单表
	 * @return
	 */
	@RequestMapping("update")
	@ResponseBody
	public SsmMessage update(ErpProindentDetail detail,ErpProindent dent,String str){
		
		String[] sourceStrArray = str.split("&");//字符串分割
		System.out.println(sourceStrArray.length);
		
		
	//订单明细增加
	for(int i =0;i<sourceStrArray.length;i++){
		String[] str3 = sourceStrArray[i].split("_");
		detail.setEntdeNum(Integer.valueOf(str3[1]));//总数量
		BigDecimal a=new BigDecimal(str3[2]);//把double转换成BigDecimal
		detail.setEntdePrice(a);//总金额
		detail.setEntdeId(str3[3]);
		ProindentDetailService.update(detail);
	}
		
		
	
		int quantity=0;//定义一个需要相加的数值，数量相加
		double price=0;//价格相加
		
		for(int i =0;i<sourceStrArray.length;i++){
			String[] str1 = sourceStrArray[i].split("_");//分割
			
			quantity=quantity+Integer.parseInt(str1[1]);//数量相加
			price=price+Double.valueOf(str1[2]);//价格相加
		
			
		}

		BigDecimal a=new BigDecimal(price);//把double转换成BigDecimal
		dent.setIndentMoney(a);//生产订单金额
		dent.setIndentCount(quantity);//生产订单数量
		dent.setIndentId(dent.getIndentId());
		proindentService.updateByPrimaryKeySelective(dent);//修改方法
		
		mes.setState(1);//直接返回1
	
		return mes;
		
	}

	/**
	 * 根据ID查询
	 * @param express
	 * @return
	 */
	@RequestMapping("/selectByPrimaryProid")
	@ResponseBody
	private List<Map<String, Object>> selectByPrimaryProid(String indentId){
		List<Map<String, Object>> dent = proindentService.selectByPrimaryProid(indentId);
		return dent;
	}
}

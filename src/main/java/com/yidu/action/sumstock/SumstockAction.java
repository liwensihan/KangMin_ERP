/**
 * 
 */
package com.yidu.action.sumstock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.model.ErpKinds;
import com.yidu.model.ErpStaff;
import com.yidu.model.ErpSumstock;
import com.yidu.service.sumstock.SumstockService;
import com.yidu.util.Pages;
import com.yidu.util.SsmMessage;

/**
 * 分店销售订单action
 * @author ouyang
 * @data 2017年11月8日08:46:24
 */
@Controller
@RequestMapping("/sumstock")
public class SumstockAction {
	@Resource
	SumstockService sumstockService;

	SsmMessage mes ;//消息类
	/**
	 * 根据条形码和当前分店查询药品
	 * @param kinBarcode 条形码
	 * @author ouyang
	 * @dateTime 2017年11月24日14:03:58
	 * @return 药品实体类
	 */
	@RequestMapping("/findByKinBarcode")
	@ResponseBody
	public Map<String,Object> findByKinBarcode(String kinBarcode,String annexId){
		return sumstockService.findByKinBarcode(kinBarcode,annexId);
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
	public Map<String,Object> showList(int page ,int limit,ErpSumstock stock,HttpSession session,String key,String annexName,String kinName){
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String,Object> pagmap = new HashMap<String, Object>();
		ErpStaff staff = (ErpStaff) session.getAttribute("staff");
		Pages ps=new Pages();
		ps.setCurPage(page);
		ps.setMaxResult(limit);
		pagmap.put("page", ps.getFirstRows());//把页数传到map
		pagmap.put("limit", ps.getMaxResult());//把页数传到map

		if("管理员".equals(staff.getRoleName())){//判断是否=管理员
			pagmap.put("staff", "");//传空
			pagmap.put("annexName", annexName);//分店名称，如果等于管理员就可以查询分店
		}else{
			pagmap.put("staff", staff.getAnnexId());//从session中传分店id
		}
		pagmap.put("key", key);//关键字
		pagmap.put("kinName", kinName);//商品名称
		
		
		List<Map<String, Object>> list =sumstockService.selectByPrimaryKey(pagmap);
		
		//layui数据表格需要返回的参数
		map.put("count",sumstockService.findRowCount(pagmap));//总行数
		map.put("data", list);
		map.put("code",0);
		map.put("msg", "");
		return map;
	}
	
	/**
	 * 删除方法
	 * 
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public SsmMessage delete(ErpSumstock tock){
		tock.setIsva(0);
		tock.setStockId(tock.getStockId());
		int rows=sumstockService.updateByPrimaryKeySelective(tock);
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
	 * 根据id查询
	 * @return 返回list
	 */
	@RequestMapping("/findByID")
	@ResponseBody
	public ErpSumstock findByID(String stockId){
		ErpSumstock tock=sumstockService.selectshow(stockId);
		
		return tock;
		
	}
	
	
	/**
	 * 修改
	 * @param tock
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public SsmMessage update(ErpSumstock tock){
		int rows=sumstockService.updateByPrimaryKeySelective(tock);
		SsmMessage m = new SsmMessage();
		m.setMes("1");
		return m;
		
		
	}
}

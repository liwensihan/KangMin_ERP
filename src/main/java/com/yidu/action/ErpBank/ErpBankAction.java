/**
 * 
 */
package com.yidu.action.ErpBank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.model.ErpBank;
import com.yidu.model.ErpInvedet;
import com.yidu.model.ErpQuality;
import com.yidu.model.ErpStaff;
import com.yidu.service.ErpBank.ErpBankService;
import com.yidu.util.Pages;
import com.yidu.util.SsmMessage;

/**
 * 入库单表
 * @author Gjwen
 * 2017年11月13日-上午8:44:46
 */
@Controller
@RequestMapping("Bank")
public class ErpBankAction {
	/**
	 * 注入入库Service
	 */
	@Resource
	private ErpBankService erpBankService; 
	/**
	 * 显示和查询
	 * @param page
	 * @param limit
	 * @param keywords
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/selectAll")
	public Map<String,Object> selectAll(Integer page,Integer limit,String pricer){
		Map<String,Object> map1 = new HashMap<String,Object>();
		Pages pa = new Pages();
		pa.setCurPage(page);
		pa.setMaxResult(limit);
		map1.put("page", pa.getFirstRows());
		map1.put("limit", pa.getMaxResult());
		map1.put("pricer", pricer);
		List<ErpBank> list = erpBankService.selectAll(map1);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count",erpBankService.selectAllConut(map1));
		map.put("data", list);
		return map;
	}
	/**
	 * 添加入库的方法
	 * @param ErpBank 入库单的对象
	 * @return 消息类
	 */
	@ResponseBody
	@RequestMapping("/insertSelective")
	public SsmMessage insertSelective(ErpBank bank,String[] kinId,Integer[] invedetNum,HttpSession session,String[] rawId){
		SsmMessage mes = new SsmMessage();
		ErpStaff staff = (ErpStaff) session.getAttribute("staff");//得到一个session取出登录人信息
		List<ErpInvedet> list = new ArrayList<ErpInvedet>();//创建一个集合把从页面上得到的数组放入库存库明细集合里面
		for(int i=0;i<invedetNum.length;i++){//创建一个循环用于数组的取值
			ErpInvedet inv = new ErpInvedet();//new一个新的库存明细对象
			if(kinId[i]!=null || kinId[i]!=""){//判断商品id是否为空  不为空就添加商品不然就添加原材料id
				inv.setKinId(kinId[i]);//把商品id放入集合
			}else{
				inv.setRawId(rawId[i]);//把原材料id放入集合当中
			}
			inv.setInvedetNum(invedetNum[i]); //入库数量放入集合
			inv.setCreater(staff.getStaId());//把创建人id放入集合
			list.add(inv);
		}
		bank.setCreater(staff.getStaId());//把创建人放入入库对象
		int rows = erpBankService.insertSelective(bank,list);
		if(rows<1){
			mes.setMes("创建发生错误！");
			mes.setState(0);
		}else{
			mes.setMes("创建成功！");
			mes.setState(1);
		}
		return mes;
	}
}

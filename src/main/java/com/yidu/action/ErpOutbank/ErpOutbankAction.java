/**
 * 
 */
package com.yidu.action.ErpOutbank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.model.ErpBank;
import com.yidu.model.ErpInvedet;
import com.yidu.model.ErpOutbank;
import com.yidu.model.ErpStaff;
import com.yidu.service.ErpOutbank.ErpOutbankService;
import com.yidu.util.Pages;
import com.yidu.util.SsmMessage;

/**
 * @author 大晶儿
 * 2017年12月9日
 */
@Controller
@RequestMapping("ErpOutbankAction")
public class ErpOutbankAction {
	@Resource
	private ErpOutbankService service;
	@ResponseBody
	@RequestMapping("/selectAll")
	public Map<String,Object> selectAll(Integer page,Integer limit,String price,String prie){
		Map<String,Object> map1 = new HashMap<String,Object>();
		Pages pa = new Pages();
		pa.setCurPage(page);
		pa.setMaxResult(limit);
		map1.put("page", pa.getFirstRows());
		map1.put("prie", prie);
		map1.put("limit", pa.getMaxResult());
		map1.put("price", price);
		List<ErpOutbank> list = service.selectAll(map1);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count",service.selectAllConut(map1));
		map.put("data", list);
		return map;
	}
	/**
	 * 添加出库对象
	 * @param out 出库对象
	 * @param kinId 药品id 的数组
	 * @param invedetNum 数量的数组
	 * @param session 当前用户
	 * @param rawId 原材料的id
	 * @param quaId 质检的id
	 * @return 消息类
	 */
	@ResponseBody
	@RequestMapping("/insertSelective")
	public SsmMessage insertSelective(ErpOutbank out,String[] kinId,Integer[] invedetNum,HttpSession session,String fdproId){
		SsmMessage mes = new SsmMessage();
		ErpStaff staff = (ErpStaff) session.getAttribute("staff");//得到一个session取出登录人信息
		List<ErpInvedet> list = new ArrayList<ErpInvedet>();//创建一个集合把从页面上得到的数组放入库存库明细集合里面
		for(int i=0;i<invedetNum.length;i++){//创建一个循环用于数组的取值
			ErpInvedet inv = new ErpInvedet();//new一个新的库存明细对象
				inv.setKinId(kinId[i]);//把商品id放入集合
			inv.setInvedetNum(invedetNum[i]); //入库数量放入集合
			inv.setCreater(staff.getStaId());//把创建人id放入集合
			list.add(inv);
		}
		out.setCreater(staff.getStaId());//把创建人放入入库对象
		out.setObStaffid(staff.getStaName());
		int rows = service.insertSelective(out,list,fdproId);
		if(rows<1){
			mes.setMes("创建发生错误！");
			mes.setState(0);
		}else{
			mes.setMes("创建成功！");
			mes.setState(1);
		}
		return mes;
	}
	/**
	 * 查询单个对象
	 * @param obId 出库id
	 * @return 返回出库对象
	 */
	@ResponseBody
	@RequestMapping("/selectByPrimaryKey")
	public ErpOutbank selectByPrimaryKey(String obId){
		return service.selectByPrimaryKey(obId);
		
	}
}

/**
 * 
 */
package com.yidu.action.ErpQuality;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.model.ErpQuality;
import com.yidu.model.ErpQualityDetail;
import com.yidu.model.ErpStaff;
import com.yidu.service.ErpQuality.ErpQualityService;
import com.yidu.util.BackException;
import com.yidu.util.Pages;
import com.yidu.util.SsmMessage;

/**
 * 质检表的action
 * @author 大晶儿
 * @Date 2017年11月10日
 */
@Controller
@RequestMapping("ErpQualityAction")
public class ErpQualityAction {

	@Resource
	private ErpQualityService service;
	
	/**
	 * 查询质检对象
	 * @param page 开始行数
	 * @param limit 总行数
	 * @param pricer 质检状态
	 * @param typePri 采购和生产订单查询
	 * @return 返回质检对象的map
	 */
	@RequestMapping("selectByPrimaryNew")
	@ResponseBody
	public Map<String,Object> selectByPrimaryNew(Integer page,Integer limit,String pricer,String price){
		System.out.println("-------------------------------"+pricer);
		Map<String,Object> map1 = new HashMap<String,Object>();
		Pages pa = new Pages();
		pa.setCurPage(page);
		pa.setMaxResult(limit);
		map1.put("page", pa.getFirstRows());
		map1.put("price",price);
		map1.put("limit", pa.getMaxResult());
		map1.put("pricer", pricer);
		List<ErpQuality> list = service.selectByPrimaryNew(map1);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count",service.selectByPrimaryNewCount(map));
		map.put("data", list);
		return map;
	}

	/**
	 * 审批的方法
	 * @param session 取采购人
	 * @param qua 注释对象
	 * @return 信息类
	 */
	@RequestMapping("updateByPrimaryKeySelective")
	@ResponseBody
	public SsmMessage updateByPrimaryKeySelective(HttpSession session,ErpQuality qua,Integer[] qdetGood,Integer[] qdetBab,String[] rawId,String[] kinId){
		
		//新建一个质检明细的集合
		List<ErpQualityDetail> detlist = new ArrayList<ErpQualityDetail>();
		for(int i =0;i<qdetGood.length;i++){//循环一个数组因为两个数组的值对应只有循环一个就好了
			ErpQualityDetail det = new ErpQualityDetail();//创建一个质检对象
			det.setQdetGood(qdetGood[i]);//把数组里面的东西放入对象
			det.setQdetBab(qdetBab[i]);
			if(kinId!=null){
				det.setKinId(kinId[i]);
			}else{
				det.setRawId(rawId[i]);
			}
			det.setQuaId(qua.getQuaId());
			detlist.add(det);//把对象放入集合
		}
		SsmMessage mes = new SsmMessage();
		ErpStaff staff = (ErpStaff) session.getAttribute("staff");//得到用户对象
		qua.setQuaQc(staff.getStaName());//把当前用户名放入质检里
		int rows;
		try {
			rows = service.updateByPrimaryKeySelective(qua,detlist);
			if(rows>-1){ 
				mes.setMes("成功");
				mes.setState(1);
			}else{
				mes.setMes("失败");
				mes.setState(0);
			}
		} catch (BackException e) {
			e.printStackTrace();
		}
		
		return mes;
	}
	/**
	 * 查询单个对象
	 * @param quaId
	 * @param indentId
	 * @param purcId
	 * @return
	 */
	@RequestMapping("selectByPrimaryKey")
	@ResponseBody
	public ErpQuality selectByPrimaryKey(String quaId,String indentId, String purcId){
		//System.out.println(quaId+"--------------------------"+indentId+"------------------------------------"+purcId);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("quaId", quaId);
		map.put("indentId", indentId);
		map.put("purcId", purcId);
		return service.selectByPrimaryKey(map);
		
	}
	/**
	 * 查询单个采购或者生产详情
	 * @param price id
	 * @return 单个对象
	 */
	@RequestMapping("selectShowNew")
	@ResponseBody
	public SsmMessage selectShowNew(String indentId,String purcId,HttpSession session) {
		SsmMessage mes = new SsmMessage();
		ErpStaff staff = (ErpStaff) session.getAttribute("staff");//得到人员session
		int rows = service.selectShowNew(indentId, purcId,staff.getStaId());
		if(rows>-1){ 
			mes.setMes("提交成功");
			mes.setState(1);
		}else{
			mes.setMes("提交失败");
			mes.setState(0);
		}
		return mes;
	}
}

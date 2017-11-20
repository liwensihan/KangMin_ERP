/**
 * 
 */
package com.yidu.action.ErpKinds;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yidu.common.Tools;
import com.yidu.model.ErpKinds;
import com.yidu.service.ErpKinds.ErpKindsService;
import com.yidu.util.Pages;
import com.yidu.util.SsmMessage;

/**
 * 药品的action
 * @author 大晶儿
 * 2017年10月31日
 */
@Controller
@RequestMapping("ErpKindsAction")
public class ErpKindsAction {
	@Resource
	private ErpKindsService service;
	
	/**
	 * 根据条形码查询药品
	 * @param kinBarcode 条形码
	 * @author ouyang
	 * @dateTime 2017年11月6日11:23:48
	 * @return 药品实体类
	 */
	@RequestMapping("/findByKinBarcode")
	@ResponseBody
	public ErpKinds findByKinBarcode(String kinBarcode){
		return service.findByKinBarcode(kinBarcode);
	}
	
	/**
	 * 添加
	 * @param kinds 药品对象
	 * @return 返回消息类
	 */
	@RequestMapping("insertSelectiveKind")
	@ResponseBody
	public SsmMessage insertSelectiveKind(ErpKinds kinds){
		SsmMessage mes = new SsmMessage();
		int rows = service.insertSelective(kinds);
		if(rows>-1){ 
			mes.setMes("添加成功");
			mes.setState(1);
		}else{
			mes.setMes("添加失败");
			mes.setState(0);
		}
		return mes;
	}
	/**
	 * 删除
	 * @param kinId 药品id 
	 * @return 返回消息类
	 */
	@RequestMapping("deleteKind")
	@ResponseBody
	public SsmMessage deleteKind(String kinId){
		SsmMessage mes = new SsmMessage();
		ErpKinds kin = new ErpKinds();
		kin.setKinId(kinId);
		int rows = service.deleteByPrimaryKey(kin);
		if(rows>-1){ 
			mes.setMes("删除成功");
			mes.setState(1);
		}else{
			mes.setMes("删除失败");
			mes.setState(0);
		}
		return mes;
	}
	/**
	 * 修改
	 * @param kinds 药品对象
	 * @return 返回消息类
	 */
	@RequestMapping("updateKind")
	@ResponseBody
	public SsmMessage updateKind(ErpKinds kinds){
		SsmMessage mes = new SsmMessage();
		int rows = service.updateByPrimaryKeySelective(kinds);
		if(rows>-1){ 
			mes.setMes("修改成功");
			mes.setState(1);
		}else{
			mes.setMes("修改失败");
			mes.setState(0);
		}
		return mes;
	}
	/**
	 * 查询所有的药品
	 * @return 返回map
	 */
	@RequestMapping("findListKind")
	@ResponseBody
	public Map findListKind(Integer page,Integer limit,String pricer){
		Map<String,Object> map1 = new HashMap<String,Object>();
		Pages pa = new Pages();
		pa.setCurPage(page);
		pa.setMaxResult(limit);
		map1.put("page", pa.getFirstRows());
		map1.put("limit", pa.getMaxResult());
		map1.put("pricer", pricer);
		List<ErpKinds> list = service.findPrimaryKinds(map1);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count",service.selectConut(map1));
		map.put("data", list);
		return map;
	}
	/**
	 * 得到当前创建的id
	 * @param dateStr
	 * @return
	 */
	@RequestMapping("selectId")
	@ResponseBody
	public String selectId(String dateStr){
		return service.selectId(Tools.getDateStr(new Date()));
		
	}
	
	/**
	 * 查询所有商品，下拉框
	 * @param session
	 * @return
	 * @author 刘东
	 * @throws JsonProcessingException
	 */
	@RequestMapping("/showListAjax")
	@ResponseBody  //ajax的注解
	public List<ErpKinds> showListAjax(){
		
		List<ErpKinds> list = service.findStation();//查询所有商品
		return list;
	}
	
	

	/**
	 * 根据ID查询
	 * @param session
	 * @return
	 * @author 刘东
	 * @throws JsonProcessingException
	 */
	@RequestMapping("/findById")
	@ResponseBody  //ajax的注解
	public ErpKinds findById(ErpKinds kinds){
		
		ErpKinds list = service.selectByPrimaryKey(kinds.getKinId());//查询所有商品
		return list;
	}
	/**
	 * 查询单个对象仓库使用方法
	 * @param kinId 商品id
	 * @return 返回药品单个对象
	 */
	@RequestMapping("/selectByPrimaryNewKinId")
	@ResponseBody  //ajax的注解
	public ErpKinds selectByPrimaryNewKinId(String kinId){
		
		return service.selectByPrimaryNewKinId(kinId);
	}
	
	
	
}
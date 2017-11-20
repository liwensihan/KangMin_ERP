/**
 * 
 */
package com.yidu.action.ErpBurden;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.model.ErpBurden;
import com.yidu.service.ErpBurden.ErpBurdenService;
import com.yidu.util.SsmMessage;

/**
 * 配方表action
 * @author 大晶儿
 * 2017年11月2日
 */
@Controller
@RequestMapping("ErpBurdenAction")
public class ErpBurdenAction {
	@Resource
	private ErpBurdenService service;
	/**
	 * 删除
	 * @param burId 配方id
	 * @return 返回信息类
	 */
	@RequestMapping("deleteByPrimaryKey")
	@ResponseBody
	public SsmMessage deleteByPrimaryKey(String burId){
		SsmMessage mes = new SsmMessage();
		int rows = service.deleteByPrimaryKey(burId);
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
	 * 添加
	 * @param record 配方对象
	 * @return 返回消息类
	 */
	@RequestMapping("insertSelective")
	@ResponseBody
	public SsmMessage insertSelective(ErpBurden record){
		SsmMessage mes = new SsmMessage();
		int rows = service.insertSelective(record);
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
	 * 模糊查询
	 * @param price 值
	 * @return 返回对象的map
	 */
	@RequestMapping("findDimBurd")
	@ResponseBody
	public Map findDimBurd(String price){
		Map<String,Object> map = new HashMap<String,Object>();
		List<ErpBurden> list = service.selectByPrimaryKey(price);
		map.put("code", "");
		map.put("msg", "");
		map.put("count", "");
		map.put("data", list);
		return map;
	} 
	/**
	 * 修改
	 * @param record 配方对象
	 * @return 返回消息类
	 */
	@RequestMapping("updateBurden")
	@ResponseBody
	public SsmMessage updateBurden(ErpBurden record){
		SsmMessage mes = new SsmMessage();
		int rows = service.updateByPrimaryKeySelective(record);
		if(rows>-1){
			mes.setMes("修改成功");
			mes.setState(1);
		}else{
			mes.setMes("修改失败");
			mes.setState(0);
		}
		return mes;
	}
}

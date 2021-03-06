/**
 * 
 */
package com.yidu.action.ErpRaw;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.model.ErpDrugResult;
import com.yidu.model.ErpRaw;
import com.yidu.service.ErpRaw.ErpRawService;
import com.yidu.util.BackException;
import com.yidu.util.SsmMessage;
import com.yidu.util.Tools;

/**
 * 原材料类
 * @author 大晶儿
 * 2017年10月21日
 */
@Controller
@RequestMapping("ErpRawAction")
public class ErpRawAction {
	@Resource
	private ErpRawService service;
	/**
	 * 添加类型
	 * @param record 类型对象
	 * @return 返回消息类
	 * @throws BackException 
	 */
	@RequestMapping("insertSelectiveRaw")
	@ResponseBody
	public SsmMessage insertSelectiveRaw(ErpRaw record,String[] resId) throws BackException{
		System.out.println("进入添加的方法---------------------------------------------------");
		SsmMessage mes = new SsmMessage();
		List<ErpDrugResult> res = new ArrayList<ErpDrugResult>();
		for(int i=0;i<resId.length;i++){ //循环数组取出值
			ErpDrugResult erpDrugResult = new ErpDrugResult();
			erpDrugResult.setResId(resId[i]+""); //把数组取出的值放入药品药效类里面
			res.add(erpDrugResult);//添加药品药效类到药品药效类的集合
		}
		int rows = service.insertSelective(record,res);//执行添加类型字段
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
	 * 查询所有
	 * @return返回list
	 */
	@RequestMapping("showListRaw")
	@ResponseBody
	public Map showListRaw(){
		List<ErpRaw> list = service.findListRaw();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", "");
		map.put("msg", "");
		map.put("count", list.size());
		map.put("data", list);
		return map;
	}
	/**
	 * 删除
	 * @param rewId 原材料id
	 * @return 返回消息类
	 */
	@RequestMapping("deleteRaw")
	@ResponseBody
	public SsmMessage deleteRaw(String rawId){
		SsmMessage mes = new SsmMessage();
		ErpRaw raw = new ErpRaw();
		raw.setRawId(rawId);
		raw.setIsva(1);
		int rows = service.deleteByPrimaryKey(raw);
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
	 * @param record 原材料对象
	 * @return 返回消息类
	 */
	@RequestMapping("updateByPrimaryKeySelective")
	@ResponseBody
	public SsmMessage updateByPrimaryKeySelective(ErpRaw record,String[] resId){
		System.out.println("进入修改的方法---------------------------------------------------");
		SsmMessage mes = new SsmMessage();
		if(record.getApplyId()!=null){
			try {
				List<ErpDrugResult> res = new ArrayList<ErpDrugResult>();
				for(int i=0;i<resId.length;i++){ //循环数组取出值
					ErpDrugResult erpDrugResult = new ErpDrugResult();
					erpDrugResult.setResId(resId[i]+""); //把数组取出的值放入药品药效类里面
					res.add(erpDrugResult);//添加药品药效类到药品药效类的集合
				}
				int rows = service.updateByPrimaryKeySelective(record,res);
				if(rows>-1){
					mes.setMes("修改成功");
					mes.setState(1);
				}else{
					mes.setMes("修改失败");
					mes.setState(0);
				}
			} catch (BackException e) {
				e.printStackTrace();
			}
		}else{
			mes.setMes("类型id无效");
			mes.setState(0);
		}
		
		return mes;
	}
	/**
	 * 模糊查询
	 * @param price 值
	 * @return 返回对象的map
	 */
	@RequestMapping("findDimRew")
	@ResponseBody
	public Map findDimRaw(String price){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pricer", price);
		List<ErpRaw> list = service.findDimRaw(map);
		map.put("code", "");
		map.put("msg", "");
		map.put("count", "");
		map.put("data", list);
		return map;
	}
	/**
	 * 查询单个对象
	 * @param rawId 原材料id
	 * @return 返回对象
	 */
	@RequestMapping("selectByPrimaryKey")
	@ResponseBody
	public List<ErpRaw> selectByPrimaryKey(String rawId){
		if(rawId==null ||rawId==""){//判断id是否为空
			return null;
		}
		List<ErpRaw> list = service.selectByPrimaryKey(rawId); //调用方法执行语句
		return list;
	}
}

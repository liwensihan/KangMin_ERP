/**
 * 
 */
package com.yidu.action.ErpPactType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.model.ErpPactType;
import com.yidu.service.ErpPactType.ErpPactTypeService;
import com.yidu.util.SsmMessage;

/**
 * @author zhangwei
 * 2017年11月24日
 */
@Controller
@RequestMapping("ErpPactType")
public class ErpPactTypeAction {

	@Resource
	private ErpPactTypeService service;
	
	/**
	 * 增加类型
	 * @param record 类型对象
	 * @return 返回信息类
	 */
	@RequestMapping("insertSelectivePactType")
	@ResponseBody
	public SsmMessage insertSelectivePactType(ErpPactType record){
		SsmMessage mes = new SsmMessage();
		int rows = service.insertSelective(record);
		if(rows>-1){
			mes.setMes("增加成功");
			mes.setState(1);
		}else{
			mes.setMes("增加失败");
			mes.setState(0);
		}
		return mes;
	}
	/**
	 * 查询所有
	 * @return 返回信息类
	 */
	@RequestMapping("showListPactType")
	@ResponseBody
	public Map showListPactType(){
		List<ErpPactType> list = service.showListPactType();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("code", "");
		map.put("msg", "");
		map.put("count", list.size());
		map.put("data", list);
		return map;
	}
	/**
	 * 删除
	 * @param patypeId 类型id
	 * @return 返回信息类
	 */
	@RequestMapping("deletePactType")
	@ResponseBody
	public SsmMessage deletePactType(String patypeId){
		SsmMessage mes = new SsmMessage();
		ErpPactType pacttype = new ErpPactType();
		pacttype.setPatypeId(patypeId);
		int rows = service.updateByPrimaryKeySelective(pacttype);
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
	 * @param record 类型对象
	 * @return 返回信息类
	 */
	@RequestMapping("updateByPrimaryKeySelective")
	@ResponseBody
	public SsmMessage updateByPrimaryKeySelective(ErpPactType record){
		SsmMessage mes = new SsmMessage();
		if(record.getPatypeId()!=null){
			int rows = service.updateByPrimaryKeySelective(record);
			if(rows>-1){
				mes.setMes("修改成功");
				mes.setState(1);
			}else{
				mes.setMes("修改失败");
				mes.setState(0);
			}
		}else{
			mes.setMes("类型id无效");
			mes.setState(0);
		}
		return mes;
	}
	/**
	 * 模糊查询
	 * @param pricer 值
	 * @return 返回对象的map
	 */
	@RequestMapping("findDimPactType")
	@ResponseBody
	public Map findDimPactType(String pricer){
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("pricer", pricer);
		List<ErpPactType> list = service.findDimPactType(map);
		map.put("code", "");
		map.put("mes", "");
		map.put("count", list.size());
		map.put("data", list);
		return map;
	}
}

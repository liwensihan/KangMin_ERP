/**
 * 
 */
package com.yidu.action.ErpResuit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.model.ErpResuit;
import com.yidu.service.ErpResuit.ErpResuitService;
import com.yidu.util.BackException;
import com.yidu.util.Pages;
import com.yidu.util.SsmMessage;

/**
 * 药效表
 * @author 大晶儿
 * 2017年10月23日
 */
@Controller
@RequestMapping("ErpResuitAction")
public class ErpResuitAction {
	@Resource
	private ErpResuitService service;
	/**
	 * 添加
	 * @param record 对象
	 * @return 返回值
	 */
	
	@RequestMapping("insertSelective")
	@ResponseBody
	public SsmMessage insertSelective(ErpResuit record){
		SsmMessage mes = new SsmMessage();
		record.setCreater("1");
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
	 * 删除
	 * @param resId 药效id
 	 * @return 返回消息类
	 */
	@RequestMapping("deleteRes")
	@ResponseBody
	public SsmMessage deleteRes(String resId){
		SsmMessage mes = new SsmMessage();
		ErpResuit res = new ErpResuit();
		res.setResId(resId);
		try {
			int rows = service.deleteByPrimaryKey(res);
			if(rows>-1){
				mes.setMes("删除成功");
				mes.setState(1);
			}else{
				mes.setMes("删除失败");
				mes.setState(0);
			}
			
		} catch (BackException e) {
			e.printStackTrace();
		}
		
		return mes;
	}
	/**
	 * 修改的方法
	 * @param res 药效对象
	 * @return 返回消息类
	 */
	@RequestMapping("updateRes")
	@ResponseBody
	public SsmMessage updateRes(ErpResuit res){
		SsmMessage mes = new SsmMessage();
		int rows = service.updateByPrimaryKeySelective(res);
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
	 * @return
	 */
	@RequestMapping("findErpResuit")
	@ResponseBody
	public List<ErpResuit> findErpResuit(){
		return service.findErpResuit();
	}
	/**
	 * 查询所有
	 * @return 返回集合
	 */
	@RequestMapping("findErpResuitsow")
	@ResponseBody
	public Map findErpResuitsow(Integer page,Integer limit,String price){
		Map<String,Object> map1 = new HashMap<String,Object>();
		Pages pa = new Pages();
		pa.setCurPage(page);
		pa.setMaxResult(limit);
		map1.put("page", pa.getFirstRows());
		map1.put("limit", pa.getMaxResult());
		map1.put("price", price);
		List<ErpResuit> list = service.findDimRes(map1);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", "");
		map.put("msg", "");
		map.put("count", service.findDimResConut(map));
		map.put("data", list);
		return map;
	}
	
	/**
	 * 模糊查询
	 * @param price 值
	 * @return 返回对象的map
	 */
	@RequestMapping("findDimRew")
	@ResponseBody
	public Map findDimRew(String price,Integer page,Integer limit){
		Map<String,Object> map = new HashMap<String,Object>();
		Pages pa = new Pages();
		pa.setCurPage(page);
		pa.setMaxResult(limit);
		map.put("page", pa.getFirstRows());
		map.put("limit", pa.getMaxResult());
		map.put("price", price);
		List<ErpResuit> list = service.findDimRes(map);
		map.put("code", "");
		map.put("msg", "");
		map.put("count", service.findDimResConut(map));
		map.put("data", list);
		return map;
	}
	/**
	 * 查询药品药效
	 * @param kinId 药品id
	 * @return int
	 */
	@RequestMapping("findDimKinskRes")
	@ResponseBody
	public Map findDimKinskRes(String kinId){
		Map<String,Object> map = new HashMap<String,Object>();
		List<ErpResuit> list = service.findDimKinskRes(kinId);
		map.put("code", "");
		map.put("msg", "");
		map.put("count", service.findDimResConut(map));
		map.put("data", list);
		return map;
	}

}

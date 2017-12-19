/**
 * 
 */
package com.yidu.action.ErpWarehouse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yidu.model.ErpKinds;
import com.yidu.model.ErpWarehouse;
import com.yidu.service.ErpWarehouse.ErpWarehouseService;
import com.yidu.util.Pages;

/**
 * 仓库表Action
 * @author Gjwen
 * 2017年11月9日-下午1:46:32
 */
@Controller
@RequestMapping("Warehouse")
public class ErpWarehouseAction {
	
	/**
	 * 注入仓库表Service
	 */
	@Resource
	private ErpWarehouseService erpWarehouseService;
	/**
	 * 查询和显示
	 * @param page
	 * @param limit
	 * @param keywords
	 * @return map
	 */
	@RequestMapping("/showListKin")
	@ResponseBody
	public Map<String,Object> selectAll(String page,String limit,String keywords){
		Map<String,Object> maps = new HashMap<String,Object>();//Map对象
		Pages pages = new Pages();//分页对象
		pages.setCurPage(Integer.valueOf(page));//分页起始行
		pages.setMaxResult(Integer.valueOf(limit));//分页结束行
		maps.put("page", pages.getFirstRows());
		maps.put("limit", pages.getMaxResult());
		System.out.println("放入page之后的值------------------------------------"+pages.getCurPage());
		//判断是否为空
		if(keywords==null || "".equals(keywords)){
			maps.put("keywords", "");
		}else{
			maps.put("keywords", "%"+keywords+"%");
		}
		Map<String,Object> map = new HashMap<String,Object>();//Map对象，查询
		List<ErpWarehouse> list =erpWarehouseService.selectAllKind(maps);//查询表数据
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", erpWarehouseService.warehouseFindKindRows(maps));//查询行数
		map.put("data", list);
		return map;
	}
	/**
	 * 查询和显示
	 * @param page
	 * @param limit
	 * @param keywords
	 * @return map
	 */
	@RequestMapping("/selectAllRaw")
	@ResponseBody
	public Map<String,Object> selectAllRaw(String page,String limit,String keywords){
		Map<String,Object> maps = new HashMap<String,Object>();//Map对象
		Pages pages = new Pages();//分页对象
		pages.setCurPage(Integer.valueOf(page));//分页起始行
		pages.setMaxResult(Integer.valueOf(limit));//分页结束行
		maps.put("page", pages.getFirstRows());
		maps.put("limit", pages.getMaxResult());
		//判断是否为空
		if(keywords==null || "".equals(keywords)){
			maps.put("keywords", "");
		}else{
			maps.put("keywords", "%"+keywords+"%");
		}
		Map<String,Object> map = new HashMap<String,Object>();//Map对象，查询
		List<ErpWarehouse> list =erpWarehouseService.selectAllRaw(maps);//查询表数据
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", erpWarehouseService.warehouseFindRawRows(maps));//查询行数
		map.put("data", list);
		return map;
	}
	
	/**
	 * 查询单个对象
	 * @param wareId
	 * @return
	 */
	@RequestMapping("/selectNewKey")
	@ResponseBody
	public ErpWarehouse selectNewKey(String wareId){
		return erpWarehouseService.selectNewKey(wareId);
	}
	
	
	/**
	 * 查询库存大于0的商品
	 * @return
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public List<ErpWarehouse> findAll(String wareId){
		return erpWarehouseService.findAll();
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
	public Map<String,Object> findById(String kinId){
		Map<String,Object> list = erpWarehouseService.getByid(kinId);//查询所有商品
		return list;
	}
	
}

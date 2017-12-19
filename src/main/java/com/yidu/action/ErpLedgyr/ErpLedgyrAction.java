/**
 * 
 */
package com.yidu.action.ErpLedgyr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.model.ErpLedgyr;
import com.yidu.service.ErpLedgyr.ErpLedgyrService;
import com.yidu.util.Pages;

/**
 * 分店支出（收入）明细表
 * @author Gjwen
 * 下午4:25:17
 */
@Controller
@RequestMapping("ErpLedgyr")
public class ErpLedgyrAction {
	/**
	 * 注入 分店支出（收入）明细Service
	 */
	@Resource
	private ErpLedgyrService erpLedgyrService;
	/**
	 * 查询和显示(收入)
	 * @param keywords
	 * @param page
	 * @param limit
	 * @return map
	 */
	@RequestMapping("selectAll")
	@ResponseBody
	public Map<String,Object> selectAll(String keywords,String page,String limit){
		Map<String,Object> mapPage = new HashMap<String,Object>();//定义Map集合
		Pages pages = new Pages();//分页类
		pages.setCurPage(Integer.valueOf(page));//分页开始行数
		pages.setMaxResult(Integer.valueOf(limit));//分页结束行数
		mapPage.put("pages", pages);//传入pages参数
		//判断页面传过来的值是否为空
		if(keywords==null || "".equals(keywords)){
			mapPage.put("keywords", "");
		}else {
			mapPage.put("keywords", "%"+keywords+"%");
		}
		Map<String,Object> map = new HashMap<String,Object>();//定义map集合
		List<ErpLedgyr> list = erpLedgyrService.selectAll(mapPage);//查询所有
		
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", erpLedgyrService.findRows(mapPage));//查询行数   erpLedgyrService.findRows(mapPage)
		map.put("data", list);//将查询值传入页面
		return map;//返回map
	}
	/**
	 * 查询和显示(支出)
	 * @param keywords
	 * @param page
	 * @param limit
	 * @return map
	 */
	@RequestMapping("selectAllzhichu")
	@ResponseBody
	public Map<String,Object> selectAllzhichu(String keywords,String page,String limit){
		Map<String,Object> mapPage = new HashMap<String,Object>();//定义map集合
		Pages pages = new Pages();//分页类
		pages.setCurPage(Integer.valueOf(page));//分页开始行数
		pages.setMaxResult(Integer.valueOf(limit));//分页结束行数
		mapPage.put("pages", pages);//传入pages参数
		//判断页面传过来的值是否为空
		if(keywords==null || "".equals(keywords)){
			mapPage.put("keywords", "");
		}else {
			mapPage.put("keywords", "%"+keywords+"%");
		}
		Map<String,Object> map = new HashMap<String,Object>();
		List<ErpLedgyr> list = erpLedgyrService.selectAllzhichu(mapPage);//查询所有
		
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", erpLedgyrService.findRowszhichu(mapPage));//查询行数   erpLedgyrService.findRows(mapPage)
		map.put("data", list);//将查询值传入页面
		return map;//返回map
	}
	/**
	 * 根据ID查询详情（支出）
	 * @param id
	 * @return
	 */
	@RequestMapping("CheckDetails")
	@ResponseBody
	public List<Map<String,Object>> CheckDetails(String id){
		return erpLedgyrService.FindCheckDetails(id);//将前台传过来的id传入方法
	}
	/**
	 * 根据ID查询详情（收入）
	 * @param id
	 * @return
	 */
	@RequestMapping("CheckDetailss")
	@ResponseBody
	public List<Map<String,Object>> CheckDetailss(String id){
		return erpLedgyrService.FindCheckDetailss(id);//将前台传过来的id传入方法
	}
}
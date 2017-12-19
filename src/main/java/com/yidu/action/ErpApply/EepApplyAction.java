/**
 * 
 */
package com.yidu.action.ErpApply;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.common.Tools;
import com.yidu.model.ErpApply;
import com.yidu.service.ErpApply.ErpApplyService;
import com.yidu.util.Pages;
/**
 * 供货商
 * @author Gjwen
 * 2017年11月9日-下午2:47:00
 */
@Controller
@RequestMapping("EepApplyAction")
public class EepApplyAction {
	/**
	 * 注入供货商Service
	 */
	@Resource
	private  ErpApplyService service;
	/**
	 * 查询所有供应商
	 * @return 返回供应商list
	 */
	@RequestMapping("findErpApply")
	@ResponseBody
	public List<ErpApply> findErpApply(){
		List<ErpApply> list =service.findErpApply();//查询供货商方法
		return list;//返回list
	}
	/**
	 * 显示Or查询
	 * @param keywords
	 * @return map
	 */
	@RequestMapping("/showList")
	@ResponseBody
	public Map<String,Object> selectAll(String keywords,String page,String limit){
		Map<String,Object> mapPage = new HashMap<String,Object>();//创建一个Map集合
		Pages pages = new Pages();//得到分页工具类
		pages.setCurPage(Integer.valueOf(page));//起始页
		pages.setMaxResult(Integer.valueOf(limit));//结束页
		
		mapPage.put("pages", pages);//传入分页参数
		//判断前台传过来的值是否为空，否则进行模糊查询
		if(keywords==null || "".equals(keywords)){
			mapPage.put("keywords", "");
		}else{
			mapPage.put("keywords", "%"+keywords+"%");
		}
		Map<String,Object> map = new HashMap<String,Object>();//创建一个Map集合
		List<ErpApply> list = service.selectAll(mapPage);//查询所有供货商信息，传过去分页参数，放入list
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", service.applyFindRows(mapPage));//传入分页参数，规定分页
		map.put("data", list);//传入list
		return map;//返回map
	}
	/**
	 * 根据ID删除  修改状态
	 * @param isva
	 * @param applyId
	 * @return apply
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public ErpApply delete(ErpApply isva , String applyId){
		ErpApply apply = new ErpApply();//得到供货商模型
		isva.setIsva(1);//得到状态值
		isva.setApplyId(applyId);//传入状态值
		int updateIsva = service.delete(isva);//传入ID进行修改
		return apply;//返回apply
	}
	/**
	 * 根据ID查询数据
	 * @param applyId
	 * @return
	 */
	@RequestMapping("/showUpdate")
	@ResponseBody
	public ErpApply showUpdate(String applyId){
		return service.selectByPrimaryKey(applyId);//传入查询ID
	}
	/**
	 * 增加或修改
	 * @param record
	 * @return
	 */
	@RequestMapping("/addOrUpdate")
	@ResponseBody
	public int addOrUpdate(ErpApply record){
		int rows = 0;//定义参数rows为0
		//判断前台传过来的值是否为空，为空就进入增加，不为空则进入修改
		if(record.getApplyId()!=null && !"".equals(record.getApplyId())){
			rows = service.updateByPrimaryKeySelective(record);
		}else{
			String serial = Tools.getDateOrderNo();//得到订单编码格式:日期格式如:20161222211800,分别代表的是年月日时分秒+5位随机字符串
			record.setApplyNumber("GHS-"+serial);//编号
			rows = service.insert(record);//传入编码
		}
		return rows;//返回rows
	}
}

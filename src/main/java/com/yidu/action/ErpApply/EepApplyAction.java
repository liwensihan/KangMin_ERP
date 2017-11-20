/**
 * XLe1ؼ
 * 2017��10��19�� 2017��8��1��16:02:52
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
	@Resource
	private  ErpApplyService service;
	/**
	 * 查询所有供应商
	 * @return 返回供应商list
	 */
	@RequestMapping("findErpApply")
	@ResponseBody
	public List<ErpApply> findErpApply(){
		List<ErpApply> list =service.findErpApply();
		return list;
	}
	/**
	 * 显示Or查询
	 * @param keywords
	 * @return map
	 */
	@RequestMapping("/showList")
	@ResponseBody
	public Map<String,Object> selectAll(String keywords,String page,String limit){
		System.out.println("进入到了查询供货商sdfghjfdfghjk             keywords="+keywords);
		Map<String,Object> mapPage = new HashMap<String,Object>();
		Pages pages = new Pages();
		pages.setCurPage(Integer.valueOf(page));
		pages.setMaxResult(Integer.valueOf(limit));
		
		mapPage.put("pages", pages);
		if(keywords==null || "".equals(keywords)){
			mapPage.put("keywords", "");
		}else{
			mapPage.put("keywords", "%"+keywords+"%");
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		List<ErpApply> list = service.selectAll(mapPage);
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", service.applyFindRows(mapPage));
		System.out.println("得到page"+page+"得到limit"+limit);
		map.put("data", list);
		return map;
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
		System.out.println("进入删除，得到ID                      "+applyId);
		ErpApply apply = new ErpApply();
		isva.setIsva(1);
		isva.setApplyId(applyId);
		
		int updateIsva = service.delete(isva);//传入ID进行修改
		System.out.println(updateIsva);
		return apply;
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
		System.out.println("到了增加或修改");
		int rows = 0;
		if(record.getApplyId()!=null && !"".equals(record.getApplyId())){
			System.out.println("                 进入修改");
			rows = service.updateByPrimaryKeySelective(record);
		}else{
			System.out.println("                     进入增加");
			
			String serial = Tools.getDateOrderNo();
			//String number = Tools.getSerial("", "ABC");
			record.setApplyNumber("GHS-"+serial);//编号
			rows = service.insert(record);
		}
		return rows;
	}
}
/**
 * 
 */
package com.yidu.action.ErpKindsType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.model.ErpKindsType;
import com.yidu.service.ErpKindsType.ErpKindsTypeService;
import com.yidu.util.SsmMessage;


/**
 * @author 大晶儿
 * @date 2017年10月19日
*/
@Controller
@RequestMapping("/ErpKindsType")
public class ErpKindsTypeAction {
	@Resource
	private ErpKindsTypeService service; 
	/**
	 * 添加类型
	 * @param record 类型对象
	 * @return 返回消息类
	 */
	@RequestMapping("insertSelectiveType")
	@ResponseBody
	public SsmMessage insertSelectiveType(ErpKindsType record){
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
	 * 查询所有
	 * @return
	 */
	@RequestMapping("showListType")
	@ResponseBody
	public Map showListType(){
		List<ErpKindsType> list = service.showListType();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", "");
		map.put("msg", "");
		map.put("count", list.size());
		map.put("data", list);
		return map;
	}
	/**
	 * 查询所有
	 * @return
	 */
	@RequestMapping("showListTypetuo")
	@ResponseBody
	public List<ErpKindsType> showListTypetuo(){
		List<ErpKindsType> list = service.showListType();
		return list;
	}
	/**
	 * 删除
	 * @param typeId 类型id
	 * @return 返回消息类
	 */
	@RequestMapping("deleteType")
	@ResponseBody
	public SsmMessage deleteType(String typeId){
		SsmMessage mes = new SsmMessage();
		ErpKindsType type = new ErpKindsType();
		type.setTypeId(typeId);
		type.setCreater("1");
		int rows = service.updateByPrimaryKeySelective(type);
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
	 * @return 返回消息类
	 */
	@RequestMapping("updateByPrimaryKeySelective")
	@ResponseBody
	public SsmMessage updateByPrimaryKeySelective(ErpKindsType record){
		SsmMessage mes = new SsmMessage();
		if(record.getTypeId()!=null){
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
	 * @param price 值
	 * @return 返回对象的map
	 */
	@RequestMapping("findDimType")
	@ResponseBody
	public Map findDimType(String price){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pricer", price);
		List<ErpKindsType> list = service.findDimType(map);
		
		map.put("code", "");
		map.put("msg", "");
		map.put("count", list.size());
		map.put("data", list);
		return map;
	}
}

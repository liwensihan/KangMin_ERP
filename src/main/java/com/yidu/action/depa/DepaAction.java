package com.yidu.action.depa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.common.Tools;
import com.yidu.model.ErpDepa;
import com.yidu.service.ErpDepa.ErpDepaService;
import com.yidu.util.Pages;
import com.yidu.util.SsmMessage;

/**
 * 部门action
 * @author 胡鑫
 * @date 2017年10月27日
 */
@Controller
@RequestMapping("/depaAction")
public class DepaAction {
	@Resource
	private ErpDepaService service;//部门service
	
	/**
	 * 查询部门集合、模糊查询、分页查询
	 * @author 胡鑫
	 * @date 2017年10月27日11:41:26
	 * @param key 查询参数
	 * @param page 分页开始页数
	 * @param limit 每页最大显示的行数
	 * @return 返回map集合
	 */
	@RequestMapping("/depaFindList")
	@ResponseBody
	public Map<String,Object> depaFindList(String key,String page,String limit){
		Map<String,Object> parMap = new HashMap<String, Object>();//定义map 用于存放参数
		Pages pages = new Pages();//定义一个分页对象
		pages.setCurPage(Integer.valueOf(page));//设置开始的行数
		pages.setMaxResult(Integer.valueOf(limit));//设置每页显示的行数
		parMap.put("pages", pages);//将分页对象存入map集合
		if(Tools.isEmpty(key)){//判断查询参数是否为空
			parMap.put("key", "");
		}else{
			parMap.put("key", "%"+key+"%");
		}
		
		Map<String,Object> map = new HashMap<String, Object>();//定义map 用于返回至页面
		List<ErpDepa> list = service.depaFindList(parMap);//得到部门集合
		map.put("data", list);//存入参数
		map.put("count", service.depaFindListRows(parMap));
		map.put("msg", "");
		map.put("code", 0);
		return map;//返回map
	}
	
	/**
	 * 增加or修改
	 * @author 胡鑫
	 * @date 2017年10月30日15:31:45
	 * @param depa 部门实体类
	 * @return 返回消息类
	 */
	@RequestMapping("/addOrUpdate")
	@ResponseBody
	public SsmMessage addOrUpdate(ErpDepa depa){
		SsmMessage mes = new SsmMessage();//定义一个消息类
		depa.setCreatetime(Tools.getCurDateTime());//设置修改时间
		if(Tools.isEmpty(depa.getDepaId())){//判断部门ID是否为空 为空则进行增加 否则修改
			int rows = service.insertSelective(depa);//执行增加方法传入部门对象
			if(rows>0){
				mes.setMes("数据提交成功..");
				mes.setState(1);
			}else{
				mes.setMes("数据提交失败");
				mes.setState(0);
			}
		}else{
			int rows = service.updateByPrimaryKeySelective(depa);//修改修改方法 传入部门对象
			if(rows>0){
				mes.setMes("数据修改成功");
				mes.setState(1);
			}else{
				mes.setMes("数据修改失败");
				mes.setState(0);
			}
		}
		return mes;
	}
	
	/**
	 * 显示修改信息 根据部门id查询该部门信息
	 * @author 胡鑫
	 * @date 2017年10月31日09:29:56
	 * @param depaId 部门id
	 * @return 返回消息类
	 */
	@RequestMapping("/showUpdate")
	@ResponseBody
	public ErpDepa showUpdate(String depaId){
		return service.selectByPrimaryKey(depaId);
	}
	
	/**
	 * 根据部门id删除该部门(修改该部门的状态isva为1)
	 * @author 胡鑫
	 * @date 2017年10月31日15:46:49
	 * @param depaId  部门id
	 * @return 返回消息类
	 */
	@RequestMapping("/deleteByDepaId")
	@ResponseBody
	public SsmMessage deleteByDepaId(String depaId){
		SsmMessage mes = new SsmMessage();
		int rows = service.deleteByDepaId(depaId);//执行删除方法(修改isva)
		if(rows>0){
			mes.setMes("删除成功");
			mes.setState(1);
		}else{
			mes.setMes("删除失败");
			mes.setState(0);
		}
		return mes;
	}
}

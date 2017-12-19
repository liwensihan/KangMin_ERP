/**
 * 
 */
package com.yidu.action.annex;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.common.Tools;
import com.yidu.model.ErpAnnex;
import com.yidu.model.ErpStaff;
import com.yidu.service.annex.AnnexService;

/**
 * 分店action
 * @author ouyang
 * @dateTime 2017年11月16日10:39:49
 */
@Controller
@RequestMapping("/annex")
public class AnnexAction {
	@Resource
	AnnexService service;
	
	/**
	 * 查找所有分店的数量
	 * @return 分店数量
	 * @author ouyang
	 * @dateTime 2017年11月28日11:23:35
	 */
	@RequestMapping("/findAllSize")
	@ResponseBody
	public int findAllSize(){
		return service.findAllSize(new HashMap<String, Object>());
	}
	
	/**
	 * 查询所有分店
	 * @param page 当前页数
	 * @param limit 显示行数
	 * @param annexData 查询参数
	 * @param annexTime 查询创建时间
	 * @return 产品集合
	 * @author ouyang
	 * @dateTime 2017年11月28日11:23:35
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String,Object> findAll(int page,int limit,String annexData,String annexTime){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("firstRows", limit*(page-1));
		map.put("limit", limit);
		map.put("annexData", annexData);
		if(annexTime!=null && !"".equals(annexTime)){
			System.out.println("时间："+annexTime);
			String str[] = annexTime.split(" "+"-"+" ");
			map.put("annexTime_begin", str[0]);
			map.put("annexTime_end", str[1]);
		}
		
		List<ErpAnnex> data = service.findAll(map);
		int count = service.findAllSize(map);
		
		Map<String,Object> mapResult = new HashMap<String, Object>();
		//layui数据表格需要返回的参数
		map.put("count", count);
		map.put("data", data);
		map.put("code",0);
		map.put("msg", "");
		return map;
	}
	
	/**
	 * 增加或修改
	 * @param annex 分店实体类
	 * @param session HttpSession
	 * @return 影响行数
	 * @author ouyang
	 * @dateTime 2017年11月28日11:23:35
	 */
	@RequestMapping("/addOrUpdate")
	@ResponseBody
	public int addOrUpdate(ErpAnnex annex,HttpSession session){
		ErpStaff staff=(ErpStaff) session.getAttribute("staff");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(staff!=null){
			annex.setCreater(staff.getStaId());
			annex.setCreatetime(sdf.format(new Date()));
		}
		int row =0;
		if(annex.getAnnexId()!=null && !"".equals(annex.getAnnexId())){//修改
			row = service.updateByPrimaryKeySelective(annex);
		}else{//增加
			annex.setAnnexId(UUID.randomUUID()+"");
			annex.setAnnexNumber(UUID.randomUUID()+"");
			annex.setIsva(1);
			annex.setAnnexTime(sdf.format(new Date()));
			row = service.insertSelective(annex);
		}
		return row;
	}
	
	/**
	 * 查找所有分店集合
	 * @return 分店集合
	 * @author ouyang
	 * @dateTime 2017年11月28日11:23:35
	 */
	@RequestMapping("/showList")
	@ResponseBody
	public List<ErpAnnex> showList(){
		return service.getAnnex();
	}
	
	/**
	 * 初始化加载所有分店统计图
	 * @author 胡鑫
	 * @date 2017年12月7日10:25:27
	 * @return 返回map集合
	 */
	@RequestMapping("/showChar")
	@ResponseBody
	public Map<String,Object> showChar(String annexId,String year,String month){		
		Map<String,Object>parMap = new HashMap<String,Object>();//定义一个map集合用于sql查询参数
		parMap.put("annexId", annexId);//分店id主键
		
		if(Tools.isEmpty(year)){
			parMap.put("year", "");//年份
		}else{
			parMap.put("year", "%"+year+"%");//年份
		}
		if(Tools.isEmpty(month)){
			parMap.put("month", "");//月份
		}else{
			parMap.put("month", "%"+month+"%");//月份
		}
		Map<String,Object>map = new HashMap<String,Object>();//定义一个HashMap用于返回jsp调用参数
		Map<String,Object> shouru = service.showShouChar(parMap);//收入统计
		map.put("shouruMap", shouru);
		Map<String,Object> zhichu = service.showZhiChar(parMap);//支出统计
		map.put("zhichuMap", zhichu);
		return map;
	}
}

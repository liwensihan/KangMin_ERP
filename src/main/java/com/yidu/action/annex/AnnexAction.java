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

import com.yidu.model.ErpAnnex;
import com.yidu.model.ErpStaff;
import com.yidu.service.annex.AnnexService;

/**
 * 分店action
 * @author ouyang
 * @data 2017年11月16日10:39:49
 */
@Controller
@RequestMapping("/annex")
public class AnnexAction {
	@Resource
	AnnexService service;
	
	/**
	 * 查询所有分店
	 * @param page 当前页数
	 * @param limit 显示行数
	 * @param annexData 查询参数
	 * @param annexTime 查询创建时间
	 * @return 产品集合
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
	
}

/**
 * 
 */
package com.yidu.action.sctockmp;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yidu.model.ErpAnnex;
import com.yidu.model.ErpSctockmp;
import com.yidu.model.ErpSctockmpDetail;
import com.yidu.model.ErpStaff;
import com.yidu.service.ErpPersonelRole.ErpPersonelRoleService;
import com.yidu.service.annex.AnnexService;
import com.yidu.service.sctockmp.SctockmpService;

/**
 * 分店销售订单action
 * @author ouyang
 * @data 2017年11月8日08:46:24
 */
@Controller
@RequestMapping("/sctockmp")
public class SctockmpAction {
	@Resource
	AnnexService annexService;//分店表
	@Resource
	SctockmpService sctockmpService;//分店销售订单表
	@Resource
	ErpPersonelRoleService personelRoleService;//人员角色表
	
	/**
	 * 查询所有分店销售订单
	 * @param sctockData 混合数据
	 * @param saleDate 销售时间
	 * @param saleWholesaleState 批发状态
	 * @param annexId 分店ID
	 * @param page 当前页数
	 * @param limit 显示行数
	 * @param session HttpSession
	 * @return 订单集合
	 * @author ouyang
	 * @dataTime 2017年11月27日14:18:37
	 */
	@RequestMapping("/findAll")
	@ResponseBody  //ajax注解
	public Map<String,Object> findAll(String sctockmpData,String saleDate,Integer saleWholesaleState,String annexId,int page,int limit,HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("firstRows", limit*(page-1));
		map.put("limit", limit);
		map.put("sctockmpData", sctockmpData);
		if(saleDate!=null && !"".equals(saleDate)){
			String str[] = saleDate.split(" "+"-"+" ");
			map.put("saleDate_begin", str[0]);
			map.put("saleDate_end", str[1]);
		}
		if(saleWholesaleState!=null){
			System.out.println("批发状态不为空！");
			if(saleWholesaleState==0){
				System.out.println("进来了");
				map.put("SALE_if_wholesale",0);
			}else{
				map.put("SALE_if_wholesale",1);
				map.put("SALE_wholesale_state",saleWholesaleState);
			}
		}
		map.put("annexId", annexId);
		
		List<Map<String,Object>> data = sctockmpService.findAll(map);
		int count = sctockmpService.findAllSize(map);
		Map<String,Object> mapResult = new HashMap<String, Object>();
		//layui数据表格需要返回的参数
		map.put("count", count);
		map.put("data", data);
		map.put("code",0);
		map.put("msg", "");
		return map;
	}
	
	/**
	 * 进入销售页面
	 * @param session HttpSession
	 * @return 分店销售页面
	 * @author ouyang
	 * @dataTime 2017年11月23日15:06:39
	 */
	@RequestMapping("/sellEntrance")
	public ModelAndView sellEntrance(HttpSession session){
		ErpStaff staff = (ErpStaff) session.getAttribute("staff");
		ModelAndView view = new ModelAndView("sell");
		//当前日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String times = sdf.format(new Date());
		view.addObject("times", times);
		view.addObject("staName", staff.getStaName());
		
		ErpAnnex annex = annexService.findById(staff.getAnnexId());//查询当前登录人所在的分店信息
		view.addObject("annexId",staff.getAnnexId());
		view.addObject("annexName",annex.getAnnexName());
		return view;
	}
	
	/**
	 * 增加销售订单
	 * @param kind 商品信息
	 * @param annexId 分店ID
	 * @param memberId 会员ID
	 * @param memberZheko 折扣
	 * @param noOff 是否批发
	 * @param session HttpSession
	 * @return int
	 * @author ouyang
	 * @dataTime 2017年11月23日15:06:39
	 */
	@RequestMapping("/addSctockmp")
	@ResponseBody  //ajax注解
	public int addSctockmp(@RequestParam(value = "kind[]") String[] kind,String annexId,String memberId,BigDecimal memberZheko,BigDecimal sumPrice0,BigDecimal sumPrice1,BigDecimal sumPrice2,BigDecimal sumPrice3,boolean noOff,HttpSession session){
		ErpStaff staff = (ErpStaff) session.getAttribute("staff");
		String id = UUID.randomUUID()+"";
		//分店销售订单表表
		ErpSctockmp sctockmp = new ErpSctockmp();
		sctockmp.setSaleId(id);
		sctockmp.setStaffId(staff.getStaId());
		sctockmp.setAnnexId(annexId);
		sctockmp.setMemberId(memberId);
		int saleNum = 0;
		for(int i =0;i<kind.length;i++){
			saleNum+=Integer.valueOf(kind[i].split("@")[2]);
		}
		sctockmp.setSaleNum(saleNum);
		sctockmp.setSaleDate(new Date());
		sctockmp.setSaleMoney(sumPrice0);
		sctockmp.setSaleDiscount(memberZheko);
		sctockmp.setSaleMoney1(sumPrice1);
		sctockmp.setSaleMoney2(sumPrice2);
		sctockmp.setSaleMoney3(sumPrice3);
		if(noOff){//如果是批发
			sctockmp.setSaleIfWholesale(1);//1为批发
			sctockmp.setSaleWholesaleState(1);//1为未审核
		}else{
			sctockmp.setSaleIfWholesale(0);//0为零售
		}
		sctockmp.setCreater(staff.getStaId());
		sctockmp.setCreatetime(new Date());
		sctockmp.setRemark("");
		//分店销售订单明细表
		List<ErpSctockmpDetail> list = new ArrayList<ErpSctockmpDetail>();
		for(int i =0;i<kind.length;i++){
			ErpSctockmpDetail sctockDetail = new ErpSctockmpDetail();
			sctockDetail.setKmpId(UUID.randomUUID()+"");
			sctockDetail.setSaleId(id);
			sctockDetail.setKinId(kind[i].split("@")[0]);
			sctockDetail.setKmpNum(Integer.valueOf(kind[i].split("@")[2]));
			sctockDetail.setKmpPrice(new BigDecimal(kind[i].split("@")[2]).multiply(new BigDecimal(kind[i].split("@")[1])));
			if(kind[i].split("@").length==4){
				sctockDetail.setRemake(kind[i].split("@")[3]);
			}
			sctockDetail.setIsva("1");
			list.add(sctockDetail);
		}
		int row = sctockmpService.addSctockmp(sctockmp, list);
		if(row>1){
			return 1;
		}
		return 0;
	
	}
}

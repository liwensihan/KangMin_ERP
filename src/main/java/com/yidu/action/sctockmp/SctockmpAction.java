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
	
	/**
     * 查询今天的订单数量
     * @return 订单数量
     * @author ouyang
	 * @dataTime 2017年12月11日16:24:53
     */
	@RequestMapping("/findToDay")
	@ResponseBody  //ajax注解
	public int findToDay(){
		return sctockmpService.findToDay();//订单：查询今天的订单数量
	}
	
	/**
	 * 审核通过，增加批发状态
	 * @param saleId 订单ID
	 * @param session HttpSession
	 * @return 影响行数
	 * @author ouyang
	 * @dataTime 2017年12月1日08:43:55
	 */
	@RequestMapping("/updateWholesaleStateAdd")
	@ResponseBody  //ajax注解
	public int updateWholesaleStateAdd(String saleId,HttpSession session){
		return sctockmpService.updateWholesaleStateAdd(saleId,session);//订单：审核通过，增加批发状态
	}
	
	/**
	 * 审核打回，更改批发状态
	 * @param saleId 订单ID
	 * @param feedBack 打回原因
	 * @param session HttpSession
	 * @return 影响行数
	 * @author ouyang
	 * @dataTime 2017年12月1日14:04:01
	 */
	@RequestMapping("/updateWholesaleStateZero")
	@ResponseBody  //ajax注解
	public int updateWholesaleStateZero(String saleId,String feedBack,HttpSession session){
		return sctockmpService.updateWholesaleStateZero(saleId,feedBack,session);//订单：审核失败，根据订单ID修改批发状态为0
	}
	
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
		ErpStaff staff = (ErpStaff) session.getAttribute("staff");//得到Session中的员工对象
		String roleName = staff.getRoleName();//得到员工对象中的角色名称
		//权限判断
		if(!"管理员".equals(roleName)){//如果员工角色不是‘管理员’
			annexId = staff.getAnnexId();//给分店ID赋值-当前登录人的分店ID
		}
		
		//设置查询时的参数
		Map<String, Object> map = new HashMap<String, Object>();//实例化一个HashMap
		map.put("firstRows", limit*(page-1));//map赋值-开始行数
		map.put("limit", limit);//map赋值-显示条数
		map.put("sctockmpData", sctockmpData);//map赋值-查询的混合数据
		if(saleDate!=null && !"".equals(saleDate)){//如果销售时间不为空
			String str[] = saleDate.split(" "+"-"+" ");//则分割销售时间字符串，根据 - 分割
			map.put("saleDate_begin", str[0]);//map赋值-开始销售时间
			map.put("saleDate_end", str[1]);//map赋值-结束销售时间
		}
		if(saleWholesaleState!=null){//如果批发状态不为空
			if(saleWholesaleState==0){//如果批发状态等于0
				map.put("SALE_if_wholesale",0);//map赋值-是否批发(键为数据库字段名)为0
			}else{
				map.put("SALE_if_wholesale",1);//map赋值-是否批发(键为数据库字段名)为1
				map.put("SALE_wholesale_state",saleWholesaleState);//map赋值-批发状态(键为数据库字段名)
			}
		}
		map.put("annexId", annexId);//map赋值-分店ID
		
		//查询数据
		List<Map<String,Object>> data = sctockmpService.findAll(map);//订单：查询订单列表
		int count = sctockmpService.findAllSize(map);//订单：查询订单列表数量
		
		//设置方法返回参数
		Map<String,Object> mapResult = new HashMap<String, Object>();//实例化HashMap
		//layui数据表格需要返回的参数
		map.put("count", count);//map赋值-总条数
		map.put("data", data);//map赋值-数据
		map.put("code",0);//map赋值-状态code为0
		map.put("msg", "");//map赋值-消息msg为‘’
		return map;//返回map
	}
	
	/**
	 * 查询当前登录人员需要审核的订单
	 * @param sctockData 混合数据
	 * @param saleDate 销售时间
	 * @param page 当前页数
	 * @param limit 显示行数
	 * @param session HttpSession
	 * @return 订单集合
	 * @author ouyang
	 * @dataTime 2017年11月27日14:18:37
	 */
	@RequestMapping("/findAllAudit")
	@ResponseBody  //ajax注解
	public Map<String,Object> findAllAudit(String sctockmpData,String saleDate,int page,int limit,HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();//实例化HashMap
		ErpStaff staff = (ErpStaff) session.getAttribute("staff");//得到Session中的员工对象
		String roleName = staff.getRoleName();//得到员工对象中的角色名称
		//权限判断
		if(!"管理员".equals(roleName)){//如果员工角色不是‘管理员’
			map.put("annexId", staff.getAnnexId());//给分店ID赋值，赋值为当前登录人的分店ID
		}
		//权限判断
		if("分店批发审核员".equals(roleName)){//如果员工角色是‘分店批发审核员’
			map.put("SALE_if_wholesale",1);//map赋值-是否批发(键为数据库字段名)为1
			map.put("SALE_wholesale_state",1);//map赋值-批发状态(键为数据库字段名)为1
		}else if("分店财务员".equals(roleName)){//如果员工角色是‘分店财务员’
			map.put("SALE_if_wholesale",1);//map赋值-是否批发(键为数据库字段名)为1
			map.put("SALE_wholesale_state",2);//map赋值-批发状态(键为数据库字段名)为2
		}else if("分店经理".equals(roleName)){//如果员工角色是‘分店经理’
			map.put("SALE_if_wholesale",1);//map赋值-是否批发(键为数据库字段名)为1
			map.put("SALE_wholesale_state",3);//map赋值-批发状态(键为数据库字段名)为3
		}else{
			map.put("SALE_if_wholesale",1);//map赋值-是否批发(键为数据库字段名)为1
			map.put("noState","yes");////map赋值-noState为yes (设置不能查询0,4状态的订单)
		}
		
		map.put("firstRows", limit*(page-1));//map赋值-开始行数
		map.put("limit", limit);//map赋值-显示条数
		map.put("sctockmpData", sctockmpData);//map赋值-查询的混合数据
		if(saleDate!=null && !"".equals(saleDate)){//如果销售时间不为空
			String str[] = saleDate.split(" "+"-"+" ");//则分割销售时间字符串，根据 - 分割
			map.put("saleDate_begin", str[0]);//map赋值-开始销售时间
			map.put("saleDate_end", str[1]);//map赋值-结束销售时间
		}
		
		List<Map<String,Object>> data = sctockmpService.findAll(map);//订单：查询订单列表
		int count = sctockmpService.findAllSize(map);//订单：查询订单列表数量
		
		//设置方法返回参数
		Map<String,Object> mapResult = new HashMap<String, Object>();//实例化HashMap
		//layui数据表格需要返回的参数
		map.put("count", count);//map赋值-总条数
		map.put("data", data);//map赋值-数据
		map.put("code",0);//map赋值-状态code为0
		map.put("msg", "");//map赋值-消息msg为‘’
		return map;//返回map
	}
	
	/**
	 * 进入销售页面
	 * @param session HttpSession
	 * @param saleId 订单ID
	 * @return 分店销售页面sell.jsp(参数：times-当前时间，staName-员工姓名)
	 * @author ouyang
	 * @dataTime 2017年11月23日15:06:39
	 */
	@RequestMapping("/sellEntrance")
	public ModelAndView sellEntrance(String saleId,HttpSession session){
		ErpStaff staff = (ErpStaff) session.getAttribute("staff");//得到Session中的员工对象
		ModelAndView view = new ModelAndView("sell");//实例化模型视图-分店销售页面
		//当前日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//实例化时间格式化类(只需年月日)
		String times = sdf.format(new Date());//格式化当前时间
		view.addObject("times", times);//模型视图赋值-格式化后的时间
		view.addObject("staName", staff.getStaName());//模型视图赋值-员工姓名
		
		if(saleId!=null && !"".equals(saleId)){//如果订单ID不为空
			view.addObject("saleId", saleId);//模型视图赋值-订单ID
		}
		
		ErpAnnex annex = annexService.findById(staff.getAnnexId());//分店：根据分店ID查询分店
		view.addObject("annexId",staff.getAnnexId());//模型视图赋值-分店ID
		view.addObject("annexName",annex.getAnnexName());//模型视图赋值-分店名称
		return view;//返回模型视图
	}
	
	/**
	 * 增加销售订单
	 * @param kind 商品信息
	 * @param saleId 订单ID
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
	public int addSctockmp(@RequestParam(value = "kind[]") String[] kind,String saleId,String annexId,String memberId,BigDecimal memberZheko,BigDecimal sumPrice0,BigDecimal sumPrice1,BigDecimal sumPrice2,BigDecimal sumPrice3,boolean noOff,HttpSession session){
		ErpStaff staff = (ErpStaff) session.getAttribute("staff");//得到Session中的员工对象
		
		String id = UUID.randomUUID()+"";//得到一个字符串UUID
		ErpSctockmp sctockmp = new ErpSctockmp();//实例化分店销售订单模型
		//如果有订单ID
		if (saleId!=null && !"".equals(saleId)){//如果订单ID不为空
			sctockmp.setSaleId(saleId);//销售订单对象赋值-订单ID
		}else{
			sctockmp.setSaleId(id);//销售订单对象赋值-订单ID(随机生成的ID)
		}
		
		sctockmp.setStaffId(staff.getStaId());//销售订单对象赋值-人员ID
		sctockmp.setAnnexId(annexId);//销售订单对象赋值-分店ID
		sctockmp.setMemberId(memberId);//销售订单对象赋值-会员ID
		int saleNum = 0;//定义一个销售总数量，值为0
		for(int i =0;i<kind.length;i++){//循环 商品信息 
			saleNum+=Integer.valueOf(kind[i].split("@")[2]);//销售总数量加 商品信息字符串@分割2(转换整数型)
		}
		sctockmp.setSaleNum(saleNum);//销售订单对象赋值-销售总数量
		sctockmp.setSaleDate(new Date());//销售订单对象赋值-订单时间-当前时间
		sctockmp.setSaleMoney(sumPrice0);//销售订单对象赋值-原金额
		sctockmp.setSaleDiscount(memberZheko);//销售订单对象赋值-折扣
		sctockmp.setSaleMoney1(sumPrice1);//销售订单对象赋值-应付金额
		sctockmp.setSaleMoney2(sumPrice2);//销售订单对象赋值-实付金额
		sctockmp.setSaleMoney3(sumPrice3);//销售订单对象赋值-找零
		if(noOff){//如果是批发
			sctockmp.setSaleIfWholesale(1);//销售订单对象赋值-是否批发-是
			sctockmp.setSaleWholesaleState(1);//销售订单对象赋值-批发状态-批发审核员审核
		}else{
			sctockmp.setSaleIfWholesale(0);//销售订单对象赋值-是否批发-否
		}
		sctockmp.setCreater(staff.getStaId());//销售订单对象赋值-创建人
		sctockmp.setCreatetime(new Date());//销售订单对象赋值-创建时间-当前时间
		sctockmp.setRemark("");//销售订单对象赋值-备注-‘’
		//分店销售订单明细表
		List<ErpSctockmpDetail> list = new ArrayList<ErpSctockmpDetail>();//实例化一个订单明细集合
		for(int i =0;i<kind.length;i++){//循环商品信息 
			ErpSctockmpDetail sctockDetail = new ErpSctockmpDetail();//实例化一个订单明细对象
			sctockDetail.setKmpId(UUID.randomUUID()+"");//订单明细赋值-明细ID-随机生成UUID
			//如果有订单ID
			if (saleId!=null && !"".equals(saleId)){//如果订单ID不为空
				sctockDetail.setSaleId(saleId);//订单明细赋值-传过来的订单ID
			}else{
				sctockDetail.setSaleId(id);//订单明细赋值-随机生成的ID
			}
			
			sctockDetail.setKinId(kind[i].split("@")[0]);//订单明细赋值-商品ID-商品信息字符串@分割0
			sctockDetail.setKmpNum(Integer.valueOf(kind[i].split("@")[2]));//订单明细赋值 商品信息字符串@分割2(转换整数型)
			sctockDetail.setKmpPrice(new BigDecimal(kind[i].split("@")[2]).multiply(new BigDecimal(kind[i].split("@")[1])));//订单明细赋值-总价-实例化大数字(商品信息字符串@分割2)乘m实例化大数字(商品信息字符串@分割1)
			if(kind[i].split("@").length==4){//第i个商品信息字符串@分割的长度等于4
				sctockDetail.setRemake(kind[i].split("@")[3]);//订单明细赋值-备注-第i个商品信息字符串@分割3
			}
			sctockDetail.setIsva("1");//订单明细赋值-是否有效-是
			list.add(sctockDetail);//把订单明细对象加入到订单明细集合
		}
		int row =0;//定义一个行数为0
		if (saleId!=null && !"".equals(saleId)){//如果订单ID不为空
			row = sctockmpService.updateSctockmp(sctockmp, list);//订单:修改分店销售订单(同时修改订单明细)
		}else{
			row = sctockmpService.addSctockmp(sctockmp, list);//订单:增加分店销售订单(同时增加订单明细)
		}
		 
		if(row>1){//如果行数大于1
			return 1;
		}
		return 0;
	
	}
}

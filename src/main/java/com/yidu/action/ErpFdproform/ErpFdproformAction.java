/**
 * 
 */
package com.yidu.action.ErpFdproform;

import java.math.BigDecimal;
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
import org.springframework.web.servlet.ModelAndView;

import com.yidu.model.ErpAnnex;
import com.yidu.model.ErpFdproform;
import com.yidu.model.ErpFinance;
import com.yidu.model.ErpLedgyr;
import com.yidu.model.ErpPay;
import com.yidu.model.ErpStaff;
import com.yidu.service.ErpFdproform.ErpFdproformService;
import com.yidu.service.ErpFinance.ErpFinanceService;
import com.yidu.service.ErpLedgyr.ErpLedgyrService;
import com.yidu.service.ErpPay.ErpPayService;
import com.yidu.service.annex.AnnexService;
import com.yidu.util.Pages;
import com.yidu.util.SsmMessage;

@Controller
@RequestMapping("form")
public class ErpFdproformAction {
	
	/**
	 * 分店订单service
	 * fdproformService
	 */
	@Resource
	private ErpFdproformService fdproformService;
	
	/**
	 * 分店service
	 * annexService
	 */
	@Resource
	AnnexService annexService;
	
	/**
	 * 财务service
	 * financeService
	 */
	@Resource
	ErpFinanceService financeService;
	
	/**
	 * 分店收入支出service
	 * ledgyrService
	 */
	@Resource
	ErpLedgyrService ledgyrService;
	
	/**
	 * 总店收入支出service
	 * payService
	 */
	@Resource
	ErpPayService payService;
	
	
	
	/**
	 * 查询所有
	 * @param page
	 * @param limit
	 * @param keywords
	 * @param min
	 * @param max
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("findAll")
	private Map<String, Object>findAll(int page ,int limit,String keywords,String min,String max,HttpSession session){
		Map<String, Object> map = new HashMap<String,Object>();//new一个map集合
		Map<String,Object> pagmap = new HashMap<String, Object>();//new一个map集合
		ErpStaff staff = (ErpStaff) session.getAttribute("staff");//取得存入服务器中的session
		Pages ps=new Pages();//new一个pages对象
		ps.setCurPage(page);//当前页数
		ps.setMaxResult(limit);//最大显示行数
		pagmap.put("limit", ps.getMaxResult());//将每页最大行数存入pagmap集合
		pagmap.put("page", ps.getFirstRows());//将每页最大显示行数存入pagmap集合
		pagmap.put("keywords", keywords);//将关键字存入pagmap集合
		pagmap.put("min", min);//最小值
		pagmap.put("max", max);//最大值
		pagmap.put("annexId", staff.getAnnexId());//分店id
		List<ErpFdproform>list = fdproformService.findAll(pagmap);//取得方法对应的list集合
		int count = fdproformService.findRowCount(pagmap);//取得总行数
		System.out.println("++++++++++++++++++++++++++++++++++++++"+count);
		map.put("count", count);//count
		map.put("data", list);//list
		map.put("code",0);//code
		map.put("msg", "");//msg
		return map;
	}
	
	
	
	/**
	 * 查询采购审核所有数据
	 * @param page
	 * @param limit
	 * @param keywords
	 * @param min
	 * @param max
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("ratifyFindAll")
	private Map<String, Object>ratifyFindAll(int page ,int limit,String keywords,String min,String max,HttpSession session){
		Map<String, Object> map = new HashMap<String,Object>();//new一个map集合
		Map<String,Object> pagmap = new HashMap<String, Object>();//new一个map集合
		ErpStaff staff = (ErpStaff) session.getAttribute("staff");//取得存入服务器中的session
		Pages ps=new Pages();//new一个pages对象
		ps.setCurPage(page);//当前页数
		ps.setMaxResult(limit);//最大显示行数
		pagmap.put("limit", ps.getMaxResult());//将每页最大行数存入pagmap集合
		pagmap.put("page", ps.getFirstRows());//将每页最大显示行数存入pagmap集合
		pagmap.put("keywords", keywords);//将关键字存入pagmap集合
		pagmap.put("min", min);//最小值
		pagmap.put("max", max);//最大值
		pagmap.put("annexId", staff.getAnnexId());//分店Id
		List<ErpFdproform>list = fdproformService.ratifyFindAll(pagmap);//取得方法对应的list集合
		int count = fdproformService.ratifyFindAllCout(pagmap);//取得总行数
		System.out.println("++++++++++++++++++++++++++++++++++++++"+count);
		map.put("count", count);
		map.put("data", list);
		map.put("code",0);
		map.put("msg", "");
		return map;
	}
	
	
	/**
	 * 删除采购订单
	 * @param fdproId
	 */
	@ResponseBody
	@RequestMapping("deleteFdpro")
	private void deleteFdpro(String fdproId){
		fdproformService.deleteFdpro(fdproId);
	}
	
	
	
	/**
	 * 审核成功时修改状态
	 * @param fdproId
	 * @param session
	 * @param fdproSumprice
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updateThrough")
	private SsmMessage updateThrough(String fdproId,HttpSession session,String fdproSumprice){
		SsmMessage mes = new SsmMessage();//new一个SsmMessage对象
		ErpStaff staff = (ErpStaff) session.getAttribute("staff");//取得存入服务器中的session
		int rows = fdproformService.updateThrough(fdproId);//得到影响行数
		Date date = new Date();//new一个Date类
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//格式化时间
		if(rows>0){//大于0时
			ErpAnnex annex = annexService.findById(staff.getAnnexId());//根据session中的分店ID得到分店类
			BigDecimal b = annex.getAnnexPrice(); //将分店价格得到BigDecimal型
			BigDecimal price = new BigDecimal(fdproSumprice) ;//将页面传入的价格转换为BigDecimal型
			BigDecimal num = b.subtract(price);//用得到分店价格减去页面传入的价格
			ErpAnnex a = new ErpAnnex();//new一个分店类
			a.setAnnexId(annex.getAnnexId());//给分店Id设值
			a.setAnnexPrice(num);//给分店价格设值
			annexService.updateByPrimaryKeySelective(a);//执行修改分店修改方法
			List<ErpFinance> finance = financeService.findAll();//得到财务的list
			BigDecimal num2 = finance.get(0).getFinanceNum();//将财务资产转换为BigDecimal型
			BigDecimal num3 = num2.add(num);//用财务资产加上页面传入的价格
			ErpFinance f = new ErpFinance();//new一个财务表
			f.setFinanceNum(num3);//给财务资产设值
			f.setFinanceId(finance.get(0).getFinanceId());//给财务id赋值
			financeService.updateByPrimaryKeySelective(f);//执行修改财务的方法
			ErpPay pay = new ErpPay();//new一个财务支出收入表
			pay.setPayId(UUID.randomUUID().toString());//给支出收入表设值ID
			pay.setFinanceId(fdproId);//给支出收入表采购订单id设值
			pay.setPaySerial(sdf1.format(date));//给支出收入表编号设值
			pay.setPayAdd(sdf1.format(date));//给支出收入表添加时间设值
			pay.setPayName(staff.getStaName());//给支出收入表添加人设值
			BigDecimal p = new BigDecimal(fdproSumprice);//将页面传入的价格转换为BigDecimal型
			pay.setPayNum(p);//给支出收入表价格设值
			pay.setIsva(1);////给支出收入表是否存在设值
			pay.setFinanceId(finance.get(0).getFinanceId());//
			pay.setCreatetime(sdf1.format(date));//给支出收入表的创建时间设值
			pay.setKinordId(fdproId);
			payService.insertSelective(pay);//执行支出收入表的增加方法
			ErpLedgyr ledgyr = new ErpLedgyr();//new一个分店支出收入表
			ledgyr.setGyrId(UUID.randomUUID().toString());//给分店支出收入表ID设值
			ledgyr.setFdproId(fdproId);//给分店支出收入表采购订单设值
			ledgyr.setAnnexId(annex.getAnnexId());//给分店支出收入表分店id设值
			ledgyr.setGyrSreial(sdf1.format(date));//给分店支出收入表编号设值
			ledgyr.setGyrPrice(p);//给分店支出收入表价格设值
			ledgyr.setIsva(1);//给分店支出收入表是否存在设值
			ledgyrService.insertSelective(ledgyr);//执行分店支出收入表的增加方法
			
		}
		return mes;
	}
	
	
	/**
	 * 审核不通过时的状态
	 * @param fdproId
	 * @return
	 */
	@RequestMapping("noThrough")
	private SsmMessage noThrough(String fdproId){
		SsmMessage mes = new SsmMessage();//new一个SsmMessage对象
		fdproformService.noThrough(fdproId);//执行方法
		return mes;
	}
	
	
}

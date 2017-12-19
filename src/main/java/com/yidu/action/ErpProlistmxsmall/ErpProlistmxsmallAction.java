/**
 * 
 */
package com.yidu.action.ErpProlistmxsmall;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yidu.model.ErpFdproform;
import com.yidu.model.ErpProlistmxsmall;
import com.yidu.model.ErpStaff;
import com.yidu.service.ErpFdproform.ErpFdproformService;
import com.yidu.service.ErpProlistmxsmall.ErpProlistmxsmallService;
import com.yidu.util.SsmMessage;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("mall")
public class ErpProlistmxsmallAction {
	
	
	@Resource
	private ErpProlistmxsmallService prolistmxsmallService ;
	
	@Resource
	private ErpFdproformService fdproformService;
	
	
	@RequestMapping("prolistmxsmall")
	private ModelAndView prolistmxsmall(String fdproId){
		ModelAndView view = new ModelAndView("prolistmxsmall");
		List<ErpProlistmxsmall>list = prolistmxsmallService.getMallById(fdproId);
		view.addObject("mall", list);
		return view;
	}
	
	
	@RequestMapping("prolistmxsmall2")
	private ModelAndView prolistmxsmall2(String fdproId){
		ModelAndView view = new ModelAndView("addFdproform");
		List<ErpProlistmxsmall>list = prolistmxsmallService.getMallById(fdproId);
		view.addObject("mall", list);
		view.addObject("fdproId", fdproId);
		return view;
	}
	
	
	@ResponseBody
	@RequestMapping("updateIsva")
	private  SsmMessage updateIsva (String fdprolistmxId){
		SsmMessage mes = new SsmMessage();
		int rows = prolistmxsmallService.updateIsva(fdprolistmxId);
		if(rows>0){
			mes.setMes("ok");
		}
		return mes;
	}
	/**
	 * 查询单个采购的所有详情
	 * @param fdproId 采购id
	 * @return 采购详情的集合
	 */
	@ResponseBody
	@RequestMapping("selectBankNew")
	private  List<ErpProlistmxsmall> selectBankNew (String fdproId){
		List<ErpProlistmxsmall> list = prolistmxsmallService.selectBankNew(fdproId);
		return list;
	}
	
	@ResponseBody
	@RequestMapping("add")
	private  SsmMessage add (@RequestParam(value = "kinId[]") String[] kinId,String fdprolistmxCount,String kinPrice,String fdprolistmxMoney,String fdproId,HttpSession session,String zong){
		SsmMessage mes = new SsmMessage();
		ErpStaff staff = (ErpStaff) session.getAttribute("staff");
		String [] fdprolistmxCount1 = fdprolistmxCount.split(",");
		String [] fdprolistmxMoney1 = fdprolistmxMoney.split(",");
		int count = 0;
		for(int i =0;i<fdprolistmxCount1.length;i++){
			count += Integer.valueOf(fdprolistmxCount1[i]);
		}
		Date date = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Random random=new java.util.Random();
		String fdId = UUID.randomUUID().toString();
		if(fdproId==""){
			ErpFdproform fd = new ErpFdproform();
			String serial = sdf.format(date);
			serial+=random.nextInt(100);
			fd.setFdproId(fdId);
			fd.setFdproSerial(serial);
			fd.setAnnexId(staff.getAnnexId());
			fd.setStaId(staff.getStaId());
			fd.setFdproSumprice(Double.valueOf(zong));
			fd.setFdproTime(String.valueOf(sdf1.format(date)));
			fd.setIsva("1");
			fd.setFdproIsva(0);
			fd.setFdproWarecount(count);
			fdproformService.insertSelective(fd);
			for(int i = 0;i<fdprolistmxCount1.length;i++){
				String dateTime = sdf.format(date);
				dateTime+=random.nextInt(100);
				ErpProlistmxsmall mall = new ErpProlistmxsmall();
				mall.setFdprolistmxId(UUID.randomUUID().toString());
				mall.setFdproId(fdId);
				mall.setKinId(kinId[i]);
				mall.setFdprolistmxNumber(dateTime);
				mall.setFdprolistmxMoney(Double.valueOf(fdprolistmxMoney1[i]));
				mall.setFdprolistmxCount(Integer.valueOf(fdprolistmxCount1[i]));
				mall.setFdprolistmxTime(sdf1.format(date));
				mall.setIsva("1");
				prolistmxsmallService.insertSelective(mall);
			}
			mes.setMes("add");
		}else{
			int rows = prolistmxsmallService.deleteFd(fdproId);
			if(rows>0){
				ErpFdproform fd = new ErpFdproform();
				for(int i = 0;i<fdprolistmxCount1.length;i++){
					String dateTime = sdf.format(date);
					dateTime+=random.nextInt(100);
					ErpProlistmxsmall mall = new ErpProlistmxsmall();
					mall.setFdprolistmxId(UUID.randomUUID().toString());
					mall.setFdproId(fdproId);
					mall.setKinId(kinId[i]);
					mall.setFdprolistmxNumber(dateTime);
					mall.setFdprolistmxMoney(Double.valueOf(fdprolistmxMoney1[i]));
					mall.setFdprolistmxCount(Integer.valueOf(fdprolistmxCount1[i]));
					mall.setFdprolistmxTime(sdf1.format(date));
					mall.setIsva("1");
					System.out.println("count+++++++++++++++++++++++++++++++"+count);
					prolistmxsmallService.insertSelective(mall);
				}
				fd.setFdproSumprice(Double.valueOf(zong));
				fd.setFdproId(fdproId);
				fd.setFdproWarecount(count);
				fdproformService.updateValue(fd);
				mes.setMes("update");
			}
		}
		
		return mes;
	}
	
}

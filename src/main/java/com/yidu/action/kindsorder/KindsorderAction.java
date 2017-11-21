/**
 * 
 */
package com.yidu.action.kindsorder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yidu.model.ErpAnnex;
import com.yidu.model.ErpStaff;
import com.yidu.service.annex.AnnexService;

/**
 * 产品销售订单action
 * @author 欧阳丰
 * @data 2017年11月8日08:46:24
 */
@Controller
@RequestMapping("/kindsorder")
public class KindsorderAction {
	@Resource
	AnnexService service;
	
	/**
	 * 进入销售页面
	 * @return
	 */
	@RequestMapping("/sellEntrance")
	public ModelAndView sellEntrance(HttpSession session){
		ErpStaff staff = (ErpStaff) session.getAttribute("staff");
		ModelAndView view = new ModelAndView("sell");
		//当前日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String times = sdf.format(new Date());
		String kinordSerial = UUID.randomUUID()+"";//随机生成一个订单ID
		view.addObject("times", times);
		view.addObject("kinordSerial", kinordSerial);
		view.addObject("staName", staff.getStaName());
		
		ErpAnnex annex = service.findById(staff.getAnnexId());//查询当前登录人所在的分店信息
		view.addObject("annexName",annex.getAnnexName());
		return view;
	}
	
}

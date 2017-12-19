/**
 * 
 */
package com.yidu.action.ErpInvedet;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.model.ErpStaff;
import com.yidu.service.ErpInvedet.ErpInvedetService;
import com.yidu.util.SsmMessage;

/**
 * 库存明细表的action
 * @author 大晶儿
 * 2017年12月7日
 */
@Controller
@RequestMapping("ErpInvedetAction")
public class ErpInvedetAction {
	@Resource
	private ErpInvedetService service;//库存明细的service
	/**
	 * 入库的方法
	 * @param session 得到创建人
	 * @param bankId 入库id
	 * @return 信息类
	 */
	@ResponseBody
	@RequestMapping("/selectByPrimaryKey")
	public SsmMessage selectByPrimaryNew(HttpSession session,String bankId){
		SsmMessage mes = new SsmMessage();
		ErpStaff staff = (ErpStaff) session.getAttribute("staff");//得到一个session取出登录人信息
		int rows = service.selectByPrimaryNew(bankId,staff.getStaId());
		if(rows<1){
			mes.setMes("创建失败");
			mes.setState(0);
		}else{
			mes.setMes("创建成功");
			mes.setState(1);
		}
		return mes;
	}
	/**
	 * 入库的方法
	 * @param session 得到创建人
	 * @param bankId 入库id
	 * @return 信息类
	 */
	@ResponseBody
	@RequestMapping("/selectByPrimary")
	public String selectByPrimary(HttpSession session,String obId){
		SsmMessage mes = new SsmMessage();
		ErpStaff staff = (ErpStaff) session.getAttribute("staff");//得到一个session取出登录人信息
		String rows = service.selectByPrimaryKey(obId, staff.getStaId(),staff.getAnnexId());
		return rows;
	}
}

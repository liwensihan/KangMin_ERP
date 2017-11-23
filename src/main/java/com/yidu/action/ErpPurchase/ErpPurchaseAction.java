/**
 * 
 */
package com.yidu.action.ErpPurchase;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.common.Tools;
import com.yidu.model.ErpPurchase;
import com.yidu.model.ErpPurchaseDetails;
import com.yidu.model.ErpRaw;
import com.yidu.service.ErpPurchase.ErpPurchaseService;
import com.yidu.service.ErpPurchaseDetails.ErpPurchaseDetailsService;
import com.yidu.service.ErpRaw.ErpRawService;
import com.yidu.util.Pages;
import com.yidu.util.SsmMessage;


/**
 * 采购订单Action
 * @author Gjwen
 * 2017年10月19日-下午2:01:02
 */
@Controller
@RequestMapping("Purchase")
public class ErpPurchaseAction {
	/**
	 * 注入采购订单Service
	 */
	@Resource
	private ErpPurchaseService erpPurchaseService;
	/**
	 * 注入原材料Service
	 */
	@Resource
	private ErpRawService erpRawService;
	/**
	 * 注入订单详细Service
	 */
	@Resource
	private ErpPurchaseDetailsService erpPurchaseDetailsService;

	/**
	 * 显示和查询和分页
	 * @param purcId
	 * @param keywords
	 * @return map
	 */
	@RequestMapping("/showAll")
	@ResponseBody
	public Map<String,Object> showAll(String keywords,String page,String limit){
		Map<String,Object> mapPage = new HashMap<String,Object>();
		Pages pages = new Pages();
		pages.setCurPage(Integer.valueOf(page));
		pages.setMaxResult(Integer.valueOf(limit));
		mapPage.put("pages", pages);

		if(keywords==null || "".equals(keywords)){
			mapPage.put("keywords", "");
		}else {
			mapPage.put("keywords", "%"+keywords+"%");
		}
		Map<String,Object> map = new HashMap<String,Object>();
		List<ErpPurchase> list = erpPurchaseService.selectAll(mapPage);
		
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", erpPurchaseService.purchaseFindRows(mapPage));
		map.put("data", list);
		return map;
	}
	/**
	 * 删除（修改状态）
	 * @param state
	 * @param purcId
	 * @return eph
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public ErpPurchase delete(ErpPurchase isva , String purcId){
		System.out.println("进入删除——得到删除行ID           "+purcId);
		ErpPurchase eph = new ErpPurchase();
		isva.setIsva(0);
		isva.setPurcId(purcId);
		int d_purcId = erpPurchaseService.updateByPrimaryKeySelective(isva);
		System.out.println(d_purcId);
		return eph;
	}
//	/**
//	 * 根据ID显示修改信息
//	 * @param purcId
//	 * @return
//	 */
//	@RequestMapping("/showUpdate")
//	@ResponseBody
//	public ErpPurchase showUpdate(String purcId){
//		return erpPurchaseService.selectByPrimaryKey(purcId);
//	}
	/**
	 * 增加Or修改	
	 * @param purcId
	 * @return rows
	 */
	@RequestMapping("/addOrUpdate")
	@ResponseBody
	public int addOrUpdate(ErpPurchase record,String[] rawId,String[] number){
		System.out.println("到达增加Or修改这里");
		int rows =0;
		if(record.getPurcId()!=null && !"".equals(record.getPurcId())){
			rows = erpPurchaseService.update(record);
		}else{
			System.out.println("增加");
			String time = Tools.getCurDateTime();//获取当前时间
			record.setPurcTime(time);//采购时间   
			record.setPurcName("高吉文");//session,,
			record.setCreater("高吉文");//session
			record.setCreatetime(time);//创建时间
			Double a = 0.0;//定义一个空数值
			for(int i=0;i<rawId.length;i++){
				ErpPurchaseDetails details2 = new ErpPurchaseDetails();
				String [] arr = rawId[i].split("~");//分割符号~
				details2.setPurcTotalPrice(Double.valueOf(arr[1])*(Integer.valueOf(number[i])));
				a = a+Double.valueOf(arr[1])*(Integer.valueOf(number[i]));//累加
				record.setPurcTotalPrice(a);//添加总价格
				
				String serial = Tools.getDateOrderNo();
				
				record.setPurcSerial("CG-"+serial);
				System.out.println("增加编号为+"+serial);
			}
			rows = erpPurchaseService.insert(record);//添加到订单表中
			for(int i=0;i<rawId.length;i++){
				ErpPurchaseDetails details = new ErpPurchaseDetails();//订单详细
				String [] arr = rawId[i].split("~");//分割符号~
				details.setPurcTotalPrice(Double.valueOf(arr[1])*(Integer.valueOf(number[i])));//每件商品总价
				details.setPurcTotalNumber(Integer.valueOf(number[i]));//数量
				details.setPurcId(record.getPurcId());//订单ID
				details.setRowId(arr[0]);//原材料ID
				rows = erpPurchaseDetailsService.insertSelective(details);//添加到订单详细表中
			}
		}
		return rows;
	}
	/**
	 * 显示所有原材料 
	 * @return
	 */
	@RequestMapping("/showRawAll")
	@ResponseBody
	public List<ErpRaw> showRawAll(){
		return erpRawService.findRawList();
	}
	
	/**
	 * 用于审核采购
	 * @author 胡鑫
	 * @date 2017年11月20日16:02:49
	 * @param purcId 采购订单id
	 * @param state 状态信息
	 * @param feedBack 回馈信息
	 * @return 返回消息类
	 */
	@ResponseBody
	@RequestMapping("/auditPurchase")
	public SsmMessage auditPurchase(String purcId,String state,String feedBack){
		SsmMessage mes = new SsmMessage();//定义一个消息类用于返回jsp
		Map<String,Object>map = new HashMap<String,Object>();//定义一个map集合
		if(Tools.isEmpty(feedBack)){//判断字符串是否为空
			map.put("feedBack", "暂无反馈信息");
		}else{
			map.put("feedBack", feedBack);//map集合中存入 反馈消息
		}
		map.put("purcId", purcId);//map集合中存入财务id
		map.put("state", state);//map集合中存入 审核是否通过   state=2 通过 state=0 不通过
		int rows = erpPurchaseService.auditPurchase(map);
		return mes;
	}
}

/**
 * 
 */
package com.yidu.action.ErpPurchase;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.common.Tools;
import com.yidu.model.ErpKinds;
import com.yidu.model.ErpPact;
import com.yidu.model.ErpPurchase;
import com.yidu.model.ErpPurchaseDetails;
import com.yidu.model.ErpRaw;
import com.yidu.model.ErpStaff;
import com.yidu.service.ErpKinds.ErpKindsService;
import com.yidu.service.ErpPact.ErpPactService;
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
	 * 注入货品表Service
	 */
	@Resource
	private ErpKindsService erpKindsService;

	/**
	 * 注入合同Service
	 */
	@Resource
	private ErpPactService erpPactService;
	/**
	 * 显示和查询和分页（采购原材料）
	 * @param purcId
	 * @param keywords
	 * @return map
	 */
	@RequestMapping("/showAll")
	@ResponseBody
	public Map<String,Object> showAll(String keywords,String page,String limit){
		Map<String,Object> mapPage = new HashMap<String,Object>();//定义Map集合
		Pages pages = new Pages();//得到分页类
		pages.setCurPage(Integer.valueOf(page));//当前页数
		pages.setMaxResult(Integer.valueOf(limit));//每页显示最大条数
		mapPage.put("pages", pages);//传入分页参数
		//判断前台传值是否为空，如不为空则进行迷糊查询
		if(keywords==null || "".equals(keywords)){
			mapPage.put("keywords", "");//为空不传值
		}else {
			mapPage.put("keywords", "%"+keywords+"%");//不为空传值模糊查询
		}
		Map<String,Object> map = new HashMap<String,Object>();//定义Map集合用于将前台的值
		List<ErpPurchase> list = erpPurchaseService.selectAll(mapPage);//查询增加原材料数据

		map.put("code", 0);
		map.put("msg", "");
		map.put("count", erpPurchaseService.purchaseFindRows(mapPage));//规定分页信息
		map.put("data", list);//传入list
		return map;//返回map
	}
	/**
	 * 显示和查询和分页（采购成品）
	 * @param purcId
	 * @param keywords
	 * @return map
	 */
	@RequestMapping("/showAlls")
	@ResponseBody
	public Map<String,Object> showAlls(String keywords,String page,String limit){
		Map<String,Object> mapPage = new HashMap<String,Object>();//定义Map集合
		Pages pages = new Pages();//得到分页类
		pages.setCurPage(Integer.valueOf(page));//当前页数
		pages.setMaxResult(Integer.valueOf(limit));//每页显示最大条数
		mapPage.put("pages", pages);//传入分页参数
		//判断前台传值是否为空，如不为空则进行迷糊查询
		if(keywords==null || "".equals(keywords)){
			mapPage.put("keywords", "");//为空不传值
		}else {
			mapPage.put("keywords", "%"+keywords+"%");//不为空传值模糊查询
		}
		Map<String,Object> map = new HashMap<String,Object>();//定义Map集合用于将前台的值
		List<ErpPurchase> list = erpPurchaseService.selectAlls(mapPage);//查询增加成品数据

		map.put("code", 0);
		map.put("msg", "");
		map.put("count", erpPurchaseService.purchaseFindRow(mapPage));//规定分页信息
		map.put("data", list);//传入list
		return map;//返回map
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
		ErpPurchase eph = new ErpPurchase();//得到采购订单Model
		isva.setIsva(0);//得到状态值
		isva.setPurcId(purcId);//传入采购ID
		int d_purcId = erpPurchaseService.updateByPrimaryKeySelective(isva);//进行修改
		return eph;//返回eph
	}

	/**
	 * 查看详情(采购，采购详情，原材料)
	 * @param purcId
	 * @return
	 */
	@RequestMapping("/showNews")
	@ResponseBody
	public List<Map<String,Object>> showUpdate(String purcId){
		return erpPurchaseService.selectById(purcId);//根据前台传过来额采购ID进行查询
	}
	/**
	 * 查看详情（采购，采购详情，货品）
	 * @param purcId
	 * @return
	 */
	@RequestMapping("/showKinds")
	@ResponseBody
	public List<Map<String,Object>> showKinds(String purcId){
		return erpPurchaseService.selectKindsById(purcId);//根据前台传过来额采购ID进行查询
	}


	/**
	 * 增加Or修改（采购原材料）
	 * @param record
	 * @param rawId
	 * @param number
	 * @return rows
	 */
	@RequestMapping("/addOrUpdate")
	@ResponseBody
	public int addOrUpdate(ErpPurchase record,String[] rawId,String[] number,HttpSession session){
		int rows =0;//定义参数rows
		//判断前台传过来的值是否为空，为空就进入增加，不为空则进入修改
		if(record.getPurcId()!=null && !"".equals(record.getPurcId())){
			rows = erpPurchaseService.update(record);//修改
		}else{
			String time = Tools.getCurDateTime();//得到当前时间
			record.setPurcTime(time);//增加采购时间   
			ErpStaff staff = (ErpStaff) session.getAttribute("staff");//得到人员session
			record.setPurcName(staff.getStaName());//session得到用户信息
			record.setCreater("1");//设置采购原材料为1
			record.setCreatetime(time);//创建时间
			Double a = 0.0;//定义一个空数值
			//循环取得原材料ID
			for(int i=0;i<rawId.length;i++){
				ErpPurchaseDetails details2 = new ErpPurchaseDetails();//得到采购详细
				String [] arr = rawId[i].split("~");//分割符号~
				details2.setPurcTotalPrice(Double.valueOf(arr[1])*(Integer.valueOf(number[i])));//得到价格,数字转换
				a = a + Double.valueOf(arr[1])*(Integer.valueOf(number[i]));//累加
				record.setPurcTotalPrice(a);//增加加总价格
				String serial = Tools.getDateOrderNo();//得到工具类中的订单编码格式
				record.setPurcSerial("CG-"+serial);//增加订单编码格式
			}
			rows = erpPurchaseService.insert(record);//添加到采购表中
			for(int i=0;i<rawId.length;i++){
				ErpPurchaseDetails details = new ErpPurchaseDetails();//得到采购详细
				String [] arr = rawId[i].split("~");//分割符号~
				details.setPurcTotalPrice(Double.valueOf(arr[1])*(Integer.valueOf(number[i])));//增加总价格，进行数字转换
				details.setPurcTotalNumber(Integer.valueOf(number[i]));//增加总数量
				details.setPurcId(record.getPurcId());//增加订单ID
				details.setRowId(arr[0]);//增加原材料ID
				rows = erpPurchaseDetailsService.insertSelective(details);//添加到订单详细表中
			}
		}   
		return rows;//返回rows
	}

	/**
	 * 显示所有原材料（查询原材料表）
	 * @return
	 */
	@RequestMapping("/showRawAll")
	@ResponseBody
	public List<ErpRaw> showRawAll(){
		return erpRawService.findRawList();//查询所有原材料
	}

	/**
	 * 显示所有货品（查询货品表）
	 * @return
	 */
	@RequestMapping("/showKindsAll")
	@ResponseBody
	public List<ErpKinds> showKindsAll(){
		return erpKindsService.findStation();//查询货品表
	}

	/**
	 * 增加（成品）
	 * @param record
	 * @param kinId
	 * @param number
	 * @return rows
	 */
	@RequestMapping("/addKinds")
	@ResponseBody
	public int addKinds(ErpPurchase record,String[] kinId,String[] number,HttpSession session){
		int rows =0;//定义参数rows
		//判断前台是否传入ID，有则修改，无则增加
		if(record.getPurcId()!=null && !"".equals(record.getPurcId())){
			rows = erpPurchaseService.update(record);//修改
		}else{
			String time = Tools.getCurDateTime();//获取当前时间
			record.setPurcTime(time);//采购时间   
			ErpStaff staff = (ErpStaff) session.getAttribute("staff");//得到人员session
			record.setPurcName(staff.getStaName());//session
			record.setCreater("2");//采购成品为2
			record.setCreatetime(time);//创建时间
			Double a = 0.0;//定义一个空数值
				for(int i=0;i<kinId.length;i++){
					ErpPurchaseDetails eetails2 = new ErpPurchaseDetails();//得到订单详细
					String [] arr = kinId[i].split("~");//分割符号~
					eetails2.setPurcTotalPrice(Double.valueOf(arr[1])*Integer.valueOf(number[i]));
					a = a+Double.valueOf(arr[1])*Integer.valueOf(number[i]);//累加
					record.setPurcTotalPrice(a);;//添加总价格
					String sa = Tools.getDateOrderNo();//得到订单编码格式
					record.setPurcSerial(sa);;//增加订单
				}
				rows= erpPurchaseService.insert(record);//添加到订单表中
					for(int i=0;i<kinId.length;i++){
						ErpPurchaseDetails details = new ErpPurchaseDetails();//订单详细
						String [] arr = kinId[i].split("~");//分割符号~
						details.setPurcTotalPrice(Double.valueOf(arr[1])*(Integer.valueOf(number[i])));//增加总价格，进行数字转换
						details.setPurcTotalNumber(Integer.valueOf(number[i]));//增加数量
						details.setPurcId(record.getPurcId());//增加订单ID
						details.setRowId(arr[0]);//增加货品ID
						rows = erpPurchaseDetailsService.insertSelective(details);//增加到订单详细表中
				}
			}
		return rows;
	}
	/**
	 * 显示采购图
	 * @param date
	 * @return
	 */
	@RequestMapping("/showTuxing")
	@ResponseBody
	public Map<String,Object> showTuxing(String date){
		//判断前台传值是否为空
		if(Tools.isEmpty(date)){
			date="";
		}else{
			date="%"+date+"%";
		}
		List<ErpPurchase> erpPurchase = erpPurchaseService.findTuxing(date);//查询年月日
		Map<String,Object> map = new HashMap<String,Object>();//定义一个map集合
		map.put("erpPurchase",erpPurchase);//map放入资金申请集合
		return map;//返回map
	}

	/**
	 * 用于审核采购
	 * @author 胡鑫
	 * @date 2017年11月20日16:02:49
	 * @param purcId 采购订单id
	 * @param state 状态信息
	 * @param feedBack 回馈信息
	 * @param session 得到session
	 * @return 返回消息类
	 */
	@ResponseBody
	@RequestMapping("/auditPurchase")
	public SsmMessage auditPurchase(String purcId,String state,String feedBack,HttpSession session){
		SsmMessage mes = new SsmMessage();//定义一个消息类用于返回jsp
		Map<String,Object>map = new HashMap<String,Object>();//定义一个map集合
		if(Tools.isEmpty(feedBack)){//判断字符串是否为空
			map.put("feedBack", "暂无反馈信息");
		}else{
			map.put("feedBack", feedBack);//map集合中存入 反馈消息
		}
		map.put("purcId", purcId);//map集合中存入财务id
		map.put("state", state);//map集合中存入 审核是否通过   state=2 通过 state=0 不通过
		ErpStaff staff = (ErpStaff) session.getAttribute("staff");//得到人员session
		map.put("staff", staff);
		int rows = erpPurchaseService.auditPurchase(map);
		return mes;
	}
	/**
	 * 查询合同表
	 * @return map
	 */
	@ResponseBody
	@RequestMapping("/pact")
	public List<ErpPact> findPactText(){
		return erpPactService.findPactText();//查询合同表
	}
	/**
	 * 查询单个对象
	 * @param purcId 采购id
	 * @return 返回采购对象
	 */
	@ResponseBody
	@RequestMapping("/selectByPrimaryKey")
	public ErpPurchase selectByPrimaryKey(String purcId){
		return erpPurchaseService.selectByPrimaryKey(purcId);//根据ID查询
	}
	/**
	 * 查询采购信息（采购原材料）
	 * @param purcId
	 * @return
	 */
	@RequestMapping("/showErp")
	@ResponseBody
	public ErpPurchase updateRaw(String purcId){
		return erpPurchaseService.showErp(purcId);//查询修改信息（原材料）
	}
	/**
	 * 查询采购信息（采购成品）
	 * @param purcId
	 * @return
	 */
	@RequestMapping("/showKind")
	@ResponseBody
	public ErpPurchase updateKinds(String purcId){
		return erpPurchaseService.showKind(purcId);//查询修改信息（成品）
	}
}

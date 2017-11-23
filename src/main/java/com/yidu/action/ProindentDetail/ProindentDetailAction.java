/**
 * 
 */
package com.yidu.action.ProindentDetail;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.common.Tools;
import com.yidu.model.ErpProindent;
import com.yidu.model.ErpProindentDetail;
import com.yidu.service.Proindent.ProindentService;
import com.yidu.service.ProindentDetail.ProindentDetailService;
import com.yidu.util.SsmMessage;

/**
 * 订单明细action
 * @author dong
 * @da2017年11月5日
 * @version 1.0
 */
@Controller
@RequestMapping("detail")
public class ProindentDetailAction {
	
	@Resource
	private ProindentService proindentService;//订单
	
	@Resource
	private ProindentDetailService ProindentDetailService;//订单明细
	
	SsmMessage mes = new SsmMessage();//消息类
	
	/**
	 * 
	 * @param detail 订单明细表
	 * @param dent 订单表
	 * @return
	 */
	@RequestMapping("add")
	@ResponseBody
	public SsmMessage insertSelectiveKind(ErpProindentDetail detail,ErpProindent dent,String str){
		
		String[] sourceStrArray = str.split("&");//字符串分割
		System.out.println(sourceStrArray.length);
		
		int quantity=0;//定义一个需要相加的数值，数量相加
		double price=0;//价格相加
		
		for(int i =0;i<sourceStrArray.length;i++){
			String[] str1 = sourceStrArray[i].split("_");//分割
			
			quantity=quantity+Integer.parseInt(str1[5]);//数量相加
			price=price+Double.valueOf(str1[6]);//价格相加
		
			
		}

		BigDecimal a=new BigDecimal(price);//把double转换成BigDecimal
		dent.setIndentNumber("D-"+Tools.getCurDate()+"-"+Tools.getRandomString(4));//生产订单编号,取当前时间，在随机4为数
		dent.setIndentMoney(a);//生产订单金额
		dent.setIndentCount(quantity);//生产订单数量
		dent.setIndentUrgency(dent.getIndentUrgency());//是否紧急
		dent.setIndentEmetime(Tools.getCurDateTime());//生产订单生成时间
		String s = dent.getIndentWorktime();//取本次订单需要花费的时间
		String remark=dent.getRemark();//去备注
		try {
			String	ss = new String(s.getBytes("ISO-8859-1"),"utf-8");//转换成utf-8编码
			String Remark=new String(remark.getBytes("ISO-8859-1"),"utf-8");//转换成utf-8编码
			dent.setIndentWorktime(ss);//本次订单需要花费的时间
			dent.setRemark(Remark);//备注
			dent.setIndentEndtime(dent.getIndentEndtime());//预计完成时间
			dent.setState(0);//审核状态
			dent.setIsva("1");//是否显示
			dent.setIndentState("1");//生成状态
			proindentService.insert(dent);//增加
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		
		
		System.out.println(dent.getIndentId()+"-----------");
		//订单明细增加
		for(int i =0;i<sourceStrArray.length;i++){
			String[] str3 = sourceStrArray[i].split("_");
			detail.setKinId(str3[7]);//ID(货品表)
			detail.setIndentId(dent.getIndentId());//生产订单主键
			detail.setEntdeNum(Integer.valueOf(str3[5]));//总数量
			BigDecimal deprice=new BigDecimal(str3[6]);//把String转换成BigDecimal
			detail.setEntdePrice(deprice);//金额
			detail.setIsva("1");//是否显示
			detail.setNum(0);//已生产数量，默认0
			ProindentDetailService.insert(detail);//明细增加
		}
		
		mes.setState(1);//直接返回1
		
		return mes;
		
	}
}

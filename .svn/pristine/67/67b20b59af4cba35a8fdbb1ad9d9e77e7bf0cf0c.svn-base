/**
 * 
 */
package com.yidu.service.ErpPay;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpPayMapper;
import com.yidu.model.ErpApplyasset;
import com.yidu.model.ErpPay;
import com.yidu.util.Tools;

/**
 * @author zhangwei
 * 2017年10月19日
 */
@Service
public class ErpPayServiceImpl implements ErpPayService{

	@Resource
	private ErpPayMapper erpPayMapper;//支付单mapper
	
	
	/**
	 * 初始化页面显示
	 * 根据选择的年份查询该年份1月-12月份 的收入
	 * @author 胡鑫
	 * @date 2017年11月8日10:37:34
	 * @param date 年份
	 * @return 返回收入集合
	 */
	@Override
	public List<ErpPay> showListPrice(String date) {
		List<ErpPay> applyassetlist = erpPayMapper.showListPrice(date);//传入年份得到收入集合
		List<ErpPay> list = new ArrayList<ErpPay>();//定义一个ArrayList集合
		for(int i=1;i<=12;i++){//循环12月 用于判断取出的收入有无该月份
			ErpPay app = new ErpPay();
			for (Iterator iterator = applyassetlist.iterator(); iterator.hasNext();) {
				ErpPay erpApplyasset = (ErpPay) iterator.next();
				if(i<10){
					if(erpApplyasset.getCreatetime().equals("0"+i)){
						app.setCreatetime(erpApplyasset.getCreatetime());
						app.setPayNum(erpApplyasset.getPayNum());
						break;
					}else{
						app.setCreatetime("0"+i);
						app.setPayNum(new BigDecimal(0.0));
					}
				}else{
					if(erpApplyasset.getCreatetime().equals(""+i)){
						app.setCreatetime(erpApplyasset.getCreatetime());
						app.setPayNum(erpApplyasset.getPayNum());						
						break;
					}else{
						app.setCreatetime(""+i);
						app.setPayNum(new BigDecimal(0.0));
					}
				}
			}
			list.add(app);
		}
		return list;
	}

	/**
	 * 模糊 分页查询全部收入集合
	 * @author 胡鑫
	 * @date 2017年11月13日14:49:52
	 * @param map 分页参数 模糊查询参数
	 * @return 返回收入集合
	 */
	@Override
	public List<ErpPay> showList(Map<String, Object> map) {
		return erpPayMapper.showList(map);
	}

	/**
	 * 模糊查询全部收入集合
	 * @author 胡鑫
	 * @date 2017年11月13日14:49:52
	 * @param map 模糊查询参数
	 * @return 返回收入集合行数
	 */
	@Override
	public int findCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return erpPayMapper.findCount(map);
	}
	
	
	
}

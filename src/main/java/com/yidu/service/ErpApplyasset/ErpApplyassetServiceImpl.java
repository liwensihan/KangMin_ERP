/**
 * 
 */
package com.yidu.service.ErpApplyasset;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.common.Tools;
import com.yidu.dao.ErpApplyassetMapper;
import com.yidu.dao.ErpAuditMapper;
import com.yidu.dao.ErpFinanceMapper;
import com.yidu.dao.ErpPurchaseMapper;
import com.yidu.model.ErpApplyasset;
import com.yidu.model.ErpAudit;
import com.yidu.model.ErpFinance;
import com.yidu.model.ErpPurchase;
import com.yidu.model.ErpStaff;

/**
 * @author zhangwei
 * 2017年10月19日
 */
@Service
public class ErpApplyassetServiceImpl implements ErpApplyassetService{

	@Resource
	private ErpApplyassetMapper erpApplyassetMapper;//资金申请mapper
	@Resource
	private ErpAuditMapper auditMapper;//审核mapper
	@Resource
	private ErpFinanceMapper financeMapper;//财务mapper
	@Resource
	private ErpPurchaseMapper erpPurchaseMapper;//采购订单mapper
	
	/**
	 * 初始化页面显示
	 * 根据选择的年份查询该年份1月-12月份 的支出
	 * @author 胡鑫
	 * @date 2017年11月6日16:00:06
	 * @param date 年份
	 * @return 返回资金申请list
	 */
	@Override
	public List<ErpApplyasset> applyassetShowList(String date) {
		List<ErpApplyasset> applyassetlist = erpApplyassetMapper.showListPrice(date);//传入年份得到资金申请集合
		List<ErpApplyasset> list = new ArrayList<ErpApplyasset>();//定义一个ArrayList集合
		for(int i=1;i<=12;i++){//循环12月 用于判断取出的资金申请有无该月份
			ErpApplyasset app = new ErpApplyasset();
			for (Iterator iterator = applyassetlist.iterator(); iterator.hasNext();) {
				ErpApplyasset erpApplyasset = (ErpApplyasset) iterator.next();
				if(i<10){
					if(erpApplyasset.getAppassTime().equals("0"+i)){
						app.setAppassTime(erpApplyasset.getAppassTime());
						app.setAppassNum(erpApplyasset.getAppassNum());
						break;
					}else{
						app.setAppassTime("0"+i);
						app.setAppassNum(0.0);
					}
				}else{
					if(erpApplyasset.getAppassTime().equals(""+i)){
						app.setAppassTime(erpApplyasset.getAppassTime());
						app.setAppassNum(erpApplyasset.getAppassNum());						
						break;
					}else{
						app.setAppassTime(""+i);
						app.setAppassNum(0.0);
					}
				}
			}
			list.add(app);
		}
		return list;
	}

	/**
	 * 模糊 分页查询全部支出集合
	 * @author 胡鑫
	 * @date 2017年11月9日09:37:15
	 * @param map 分页参数 模糊查询参数
	 * @return 返回支出集合
	 */
	@Override
	public List<ErpApplyasset> showList(Map<String, Object> map) {
		return erpApplyassetMapper.showList(map);
	}
	
	/**
	 * 模糊查询全部支出集合
	 * @author 胡鑫
	 * @date 2017年11月9日09:37:15
	 * @param map 模糊查询参数
	 * @return 返回支出集合行数
	 */
	@Override
	public int findCount(Map<String, Object> map) {
		return erpApplyassetMapper.findCount(map);
	}
	/**
	 * 根据资金申请id 增加审核信息
	 * @author 胡鑫
	 * @date 2017年11月14日10:41:42
	 * @param map 存放的参数
	 * @return 返回执行的行数
	 */
	@Override
	public int auditApplyasset(Map<String, Object> map) {
		ErpFinance finance = financeMapper.findListFinance();//得到财务详细
		
		String appassId = (String) map.get("appassId");//得到资金申请id
		String feedBack = (String) map.get("feedBack");//得到反馈信息
		String state = (String) map.get("state");
		ErpStaff staff = (ErpStaff) map.get("staff");//得到人员类
		ErpApplyasset applyasset = erpApplyassetMapper.selectByPrimaryKey(appassId);//根据资金申请id查询该信息
		BigDecimal applyassetNum = new BigDecimal(applyasset.getAppassNum());
		if(Integer.valueOf(state)>=2){
			if(applyassetNum.doubleValue()>finance.getFinanceNum().doubleValue()){//判断申请的资金是否大于财务总金额
				return 102;//返回状态信息 102
			}
		}
		if(state.equals("2")){
			finance.setFinanceNum(finance.getFinanceNum().subtract(applyassetNum));//总经理审核成功后将财务总金额减去申请的金额
			financeMapper.updateByPrimaryKeySelective(finance);//执行修改
		}
		ErpAudit audit = new ErpAudit();//定义一个审核实体类
		audit.setBusinessId(applyasset.getPurcId());//设置采购id
		audit.setFeedBack(feedBack);//设置反馈信息
		audit.setAudTime(Tools.getCurDateTime());//设置审核时间
		audit.setState(Integer.valueOf(state));//设置审核状态  0未通过 2通过
		audit.setIsva(1);
		if(state.equals("0")){
			audit.setState(0);//设置审核状态  0未通过 2通过
		}else{
			audit.setState(2);//设置审核状态  0未通过 2通过
		}
		int rows = auditMapper.insertSelective(audit);//执行审核表修改
		ErpPurchase purchase = new ErpPurchase();//定义采购订单实体类
		purchase.setState(Integer.valueOf(state));//设置状态
		purchase.setPurcId(applyasset.getPurcId());//设置采购id
		erpPurchaseMapper.updateByPrimaryKeySelective(purchase);//执行采购订单修改状态
		return erpApplyassetMapper.auditApplyasset(map);   
	}
}

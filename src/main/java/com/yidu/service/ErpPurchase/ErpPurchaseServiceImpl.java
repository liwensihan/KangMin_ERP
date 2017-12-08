/**
 * 
 */
package com.yidu.service.ErpPurchase;


import java.util.ArrayList;
import java.util.Iterator;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Array;

import com.yidu.common.Tools;
import com.yidu.dao.ErpApplyassetMapper;
import com.yidu.dao.ErpAuditMapper;
import com.yidu.dao.ErpFinanceMapper;
import com.yidu.dao.ErpPurchaseDetailsMapper;
import com.yidu.dao.ErpPurchaseMapper;
import com.yidu.model.ErpApplyasset;
import com.yidu.model.ErpAudit;
import com.yidu.model.ErpFinance;
import com.yidu.model.ErpPurchase;
import com.yidu.model.ErpStaff;


/**
 * 实现采购订单类
 * @author Gjwen
 * 2017年10月19日-下午3:38:54
 */
@Service
public class ErpPurchaseServiceImpl implements ErpPurchaseService{
	/**
	 * 注入采购订单DAO
	 */
	@Resource
	private ErpPurchaseMapper erpPurchaseMapper;
	/**
	 * 注入订单详细DAO
	 */
	@Resource
	private ErpPurchaseDetailsMapper erpPurchaseDetailsMapper;
	
	@Resource
	private ErpAuditMapper auditMapper;//审核mapper
	@Resource
	private ErpFinanceMapper financeMapper;//财务mapper
	@Resource
	private ErpApplyassetMapper applyassetMapper;//资金申请mapper
	
	/**
	 * List 查询所有
	 */
	public List<ErpPurchase> selectAll(Map<String, Object> map) {
		System.out.println("到达Service");
		return erpPurchaseMapper.selectAll(map);
	}

	/**
	 * 根据ID删除（修改状态为0）
	 */
	public int updateByPrimaryKeySelective(ErpPurchase state) {
		System.out.println("到达删除");
		return erpPurchaseMapper.updateByPrimaryKeySelective(state);
	}
	/**
	 * 根据ID修改
	 */
	public int update(ErpPurchase record) {
		return erpPurchaseMapper.update(record);
	}
	/**
	 * 增加订单
	 */
	public int insert(ErpPurchase record) {
		return erpPurchaseMapper.insert(record);
	}
	/**
	 * 分页
	 */
	@Override
	public int purchaseFindRows(Map<String, Object> map) {
		return erpPurchaseMapper.purchaseFindRows(map);
	}

	/**
	 * 图形
	 */
	@Override
	public List<ErpPurchase> findTuxing(String date) {
		List<ErpPurchase> erpPurchase = erpPurchaseMapper.findTuxing(date);//查出月份，数量
		
		List<ErpPurchase> list = new ArrayList<ErpPurchase>();//定义一个ArrayList集合
		for(int i=1;i<=12;i++){//循环12月 用于判断取出的资金申请有无该月份0
			ErpPurchase app = new ErpPurchase();
			for (Iterator iterator = erpPurchase.iterator(); iterator.hasNext();) {
				ErpPurchase erpApplyasset = (ErpPurchase) iterator.next();
				if(i<10){
					if(erpApplyasset.getPurcTime().equals("0"+i)){
						app.setPurcTime(erpApplyasset.getPurcTime());
						app.setPurcTotalPrice(erpApplyasset.getPurcTotalPrice());
						break;
					}else{
						app.setPurcTime("0"+i);
						app.setPurcTotalPrice(0.0);
					}
				}else{
					if(erpApplyasset.getPurcTime().equals(""+i)){
						app.setPurcTime(erpApplyasset.getPurcTime());
						app.setPurcTotalPrice(erpApplyasset.getPurcTotalPrice());						
						break;
					}else{
						app.setPurcTime(""+i);
						app.setPurcTotalPrice(0.0);
					} 
				}
			}
			list.add(app);
		}
		return list;
	}

	@Override
	public List<Map<String,Object>> selectById(String purcId) {
		return erpPurchaseMapper.selectById(purcId);
	}
	
	/**
	 * 用于审核采购
	 * @author 胡鑫
	 * @date 2017年11月21日14:32:45
	 * @param map 存放的参数
	 * @return 返回执行的行数
	 */
	@Override
	public int auditPurchase(Map<String, Object> map) {
		String purcId = (String) map.get("purcId");//得到采购订单id
		String feedBack = (String) map.get("feedBack");//得到反馈信息
		String state = (String) map.get("state");//得到审核转台 0未通过 2通过 
		ErpStaff staff = (ErpStaff) map.get("staff");//得到人员对象
		System.out.println(staff);
		if(state.equals("3")){//当审核通过时将该条采购订单加入资金申请表
			ErpPurchase purchase = erpPurchaseMapper.selectByPrimaryKey(purcId);//得到采购订单详细
			ErpFinance finance = financeMapper.findListFinance();//得到财务详细
			if(finance == null){
				finance = new ErpFinance();
				finance.setFinanceSerial(Tools.getDateOrderNo());//设置财务编号
				BigDecimal num = new BigDecimal(1000000);
				finance.setFinanceNum(num);//设置财务总金额
				finance.setCreatetime(Tools.getCurDateTime());//创建时间
				finance.setIsva(1);//是否有效
				financeMapper.insertSelective(finance);//进行增加方法
			}
			ErpApplyasset applyasset = new ErpApplyasset();//定义资金申请实体类
			applyasset.setAppassApply(staff.getStaId());//设置人员id
			applyasset.setPurcId(purcId);//设置采购订单id
			applyasset.setFinanceId(finance.getFinanceId());//设置财务id
			applyasset.setAppassSerial(Tools.getDateOrderNo());//设置申请编号
			applyasset.setAppassType("采购");//设置申请类型为采购类型
			applyasset.setState(1);//设置申请状态  默认审核为1 审核中..
			applyasset.setAppassTime(Tools.getCurDate());//设置申请时间
			applyasset.setIsva(1);//设置是否有效
			applyasset.setAppassNum(purchase.getPurcTotalPrice());//设置申请价格
			int rows = applyassetMapper.insertSelective(applyasset);//资金申请增加
		}
		ErpAudit audit = new ErpAudit();//定义一个审核实体类
		audit.setBusinessId(purcId);//采购订单id
		audit.setFeedBack(feedBack);//设置反馈信息
		audit.setAudTime(Tools.getCurDateTime());//设置审核时间
		audit.setAudName(staff.getRoleName());//设置审核人名称
		if(state.equals("0")){
			audit.setState(0);//设置审核状态  0未通过 2通过
		}else{
			audit.setState(2);//设置审核状态  0未通过 2通过
		}
		audit.setIsva(1);
		auditMapper.insertSelective(audit);//执行审核表增加
		return erpPurchaseMapper.auditPurchase(map);
	}

	@Override
	public List<ErpPurchase> selectshow() {
		// TODO Auto-generated method stub
		return erpPurchaseMapper.selectshow();
	}
}

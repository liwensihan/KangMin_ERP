/**
 * 
 */
package com.yidu.service.ErpPurchase;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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
	 * 根据ID查询信息
	 */
	public ErpPurchase selectByPrimaryKey(String record) {
		return erpPurchaseMapper.selectByPrimaryKey(record);
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
		if(state.equals("0")){
			audit.setState(0);//设置审核状态  0未通过 2通过
		}else{
			audit.setState(1);//设置审核状态  0未通过 2通过
		}
		audit.setIsva(1);
		int rows = auditMapper.insertSelective(audit);//执行审核表增加
		return erpPurchaseMapper.auditPurchase(map);
	}
}

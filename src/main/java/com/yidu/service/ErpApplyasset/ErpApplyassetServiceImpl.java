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
 * 财务支出实现类
 * @author 胡鑫
 * @date 2017年11月6日13:58:26
 */
@Service
public class ErpApplyassetServiceImpl implements ErpApplyassetService{
	//资金申请mapper
	@Resource
	private ErpApplyassetMapper erpApplyassetMapper;
	@Resource
	//审核mapper
	private ErpAuditMapper auditMapper;
	@Resource
	//财务mapper
	private ErpFinanceMapper financeMapper;
	@Resource
	//采购订单mapper
	private ErpPurchaseMapper erpPurchaseMapper;
	
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
		//传入年份得到资金申请集合
		List<ErpApplyasset> applyassetlist = erpApplyassetMapper.showListPrice(date);
		//定义一个ArrayList集合
		List<ErpApplyasset> list = new ArrayList<ErpApplyasset>();
		//循环12月 用于判断取出的资金申请有无该月份
		for(int i=1;i<=12;i++){
			//定义一个财务支出实体类
			ErpApplyasset app = new ErpApplyasset();
			//循环遍历资金申请集合
			for (Iterator iterator = applyassetlist.iterator(); iterator.hasNext();) {
				//根据循环的索引得到资金申请类
				ErpApplyasset erpApplyasset = (ErpApplyasset) iterator.next();
				//循环的次数小于10次进行下列方法
				if(i<10){
					//资金申请时间等于0+循环的次数进行下列方法
					if(erpApplyasset.getAppassTime().equals("0"+i)){
						//将定义的资金申请时间赋值为遍历取到的资金申请时间
						app.setAppassTime(erpApplyasset.getAppassTime());
						//将定义的资金申请金额赋值为遍历取到的资金申请金额
						app.setAppassNum(erpApplyasset.getAppassNum());
						//跳过当前循环
						break;
					}else{
						//将定义的资金申请时间赋值为0+循环的次数
						app.setAppassTime("0"+i);
						//将定义的资金申请金额赋值为0
						app.setAppassNum(0.0);
					}
				}else{
					//资金申请时间等于循环的次数进行下列方法
					if(erpApplyasset.getAppassTime().equals(""+i)){
						//将定义的资金申请时间赋值为遍历取到的资金申请时间
						app.setAppassTime(erpApplyasset.getAppassTime());
						//将定义的资金申请金额赋值为遍历取到的资金申请金额
						app.setAppassNum(erpApplyasset.getAppassNum());	
						//跳过当前循环
						break;
					}else{
						//将定义的资金申请时间赋值为循环的次数
						app.setAppassTime(""+i);
						//将定义的资金申请金额赋值为0
						app.setAppassNum(0.0);
					}
				}
			}
			//将list增加定义的资金申请对象
			list.add(app);
		}
		//返回list集合
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
		//定义财务类 得到财务类
		ErpFinance finance = financeMapper.findListFinance();
		//得到资金申请id
		String appassId = (String) map.get("appassId");
		//得到反馈信息
		String feedBack = (String) map.get("feedBack");
		//得到状态
		String state = (String) map.get("state");
		//得到人员类
		ErpStaff staff = (ErpStaff) map.get("staff");
		//根据资金申请id查询该信息
		ErpApplyasset applyasset = erpApplyassetMapper.selectByPrimaryKey(appassId);
		//将资金申请金额传入
		BigDecimal applyassetNum = new BigDecimal(applyasset.getAppassNum());
		//判断状态信息是否大于等于2
		if(Integer.valueOf(state)>=2){
			//判断申请的资金是否大于财务总金额
			if(applyassetNum.doubleValue()>finance.getFinanceNum().doubleValue()){
				//返回状态信息 102
				return 102;
			}
		}
		//判断状态信息是否为2
		if(state.equals("2")){
			//将财务总金额减去资金申请金额
			finance.setFinanceNum(finance.getFinanceNum().subtract(applyassetNum));
			//执行财务总金额修改方法
			financeMapper.updateByPrimaryKeySelective(finance);
		}
		//定义一个审核实体类
		ErpAudit audit = new ErpAudit();
		//设值审核中业务id为采购id
		audit.setBusinessId(applyasset.getPurcId());
		//设置反馈信息
		audit.setFeedBack(feedBack);
		//设置审核时间
		audit.setAudTime(Tools.getCurDateTime());
		//设置审核状态
		audit.setState(Integer.valueOf(state));
		//设置审核人名称
		audit.setAudName(staff.getRoleName());
		//设值为有效
		audit.setIsva(1);
		//判断状态是否为0
		if(state.equals("0")){
			//设置审核状态  0未通过 2通过
			audit.setState(0);
		}else{
			//设置审核状态  0未通过 2通过
			audit.setState(2);
		}
		//执行审核表修改 得到执行的行数
		int rows = auditMapper.insertSelective(audit);
		//定义采购订单实体类
		ErpPurchase purchase = new ErpPurchase();
		//设置采购订单状态
		purchase.setState(Integer.valueOf(state));
		//设置采购id
		purchase.setPurcId(applyasset.getPurcId());
		//执行采购订单修改状态
		erpPurchaseMapper.updateByPrimaryKeySelective(purchase);
		//执行资金申请审核 返回执行的行数
		return erpApplyassetMapper.auditApplyasset(map);   
	}
}

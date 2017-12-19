/**
 * 
 */
package com.yidu.service.ErpBank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.common.Tools;
import com.yidu.dao.ErpAuditMapper;
import com.yidu.dao.ErpBankMapper;
import com.yidu.dao.ErpProindentMapper;
import com.yidu.dao.ErpPurchaseMapper;
import com.yidu.dao.ErpQualityMapper;
import com.yidu.model.ErpAudit;
import com.yidu.model.ErpBank;
import com.yidu.model.ErpInvedet;
import com.yidu.model.ErpQuality;
import com.yidu.model.ErpStaff;
import com.yidu.service.ErpInvedet.ErpInvedetService;
import com.yidu.util.BackException;

/**
 * 实现入库Service
 * @author 大晶儿
 * 2017年11月13日-上午8:59:39
 */
@Service
public class ErpBankServiceImpl implements ErpBankService{
	@Resource
	private ErpBankMapper erpBankMapper;//入库单的导
	@Resource
	private ErpProindentMapper erpProindentMapper;//市场的导
	@Resource
	private ErpAuditMapper auditMapper;//审核mapper
	@Resource
	private ErpPurchaseMapper erpPurchaseMapper;//采购的导
	@Resource
	private ErpInvedetService invService;//库存明细表service
	@Resource
	private ErpQualityMapper qualitMapper;//质检表mapper
	@Override
	public List<ErpBank> selectAll(Map<String, Object> map) {
		List<ErpBank> erp = erpBankMapper.selectAll(map);
		return erp;//返回list
	}

	@Override
	public int selectAllConut(Map<String, Object> map) {
		return erpBankMapper.selectAllConut(map);
	}

	@Override
	public int insertSelective(ErpBank record,List<ErpInvedet> list,String quaId) {
		String uuid = UUID.randomUUID()+"";//得到一个uuid
		String data = erpBankMapper.selectSerial(Tools.getDateStr(new Date()));//通过得到当前最大编号的方法同时使用工具类把该编号格式成日期
		record.setBankNumber(Tools.getSerial(data, "RK"));//使用工具类得到入库编号
		record.setBankId(uuid);
		record.setIsva(1);//是否有效
		record.setBankIsva(1);//入库状态
		record.setCreatetime(Tools.getCurDateTime());//创建时间
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			ErpInvedet erpInvedet = (ErpInvedet) iterator.next();
			erpInvedet.setBankId(uuid);
			int rows = invService.insertSelective(erpInvedet);
			if(rows<-1){//入库明细添加失败抛出异常事物回滚； 
				try {
					throw new BackException("添加库存明细的时候报错");
				} catch (BackException e) {
					e.printStackTrace();
				}//抛出异常 
			}
		}
		
		ErpQuality qua = new ErpQuality();//得到质检对象
		qua.setQuaId(quaId);//得到质检id
		qua.setQuaIsva(4);//修改质检状态为已经提交入库单
		int rows = qualitMapper.updateByPrimaryKeySelective(qua);//调用质检的修改方法
		if(rows<-1){// 修改状态失败全部回滚
			try {
				throw new BackException("修改质检状态的时候报错");
			} catch (BackException e) {
				e.printStackTrace();
			}//抛出异常 
		}
		return erpBankMapper.insertSelective(record);//得到导里面的添加方法
	}

	@Override
	public ErpBank selectByPrimaryKey(String bankId) {
		return erpBankMapper.selectByPrimaryKey(bankId);
	}
	@Override
	public int updateByPrimaryKeySelective(ErpBank record) {
		return erpBankMapper.updateByPrimaryKeySelective(record);
	}
	/**
	 * 仓库入库审核
	 * @author 胡鑫
	 * @date 2017年12月12日09:44:26
	 * @param bankId 申请id
	 * @param feedback 审核反馈信息
	 * @return 返回消息类
	 */
	@Override
	public int auditBank(Map<String, Object> map) {
		
		
		String bankId = (String) map.get("bankId");//得到资金申请id
		String feedBack = (String) map.get("feedBack");//得到反馈信息
		String state = (String) map.get("state");
		ErpStaff staff = (ErpStaff) map.get("staff");//得到人员类
		
		ErpAudit audit = new ErpAudit();//定义一个审核实体类
		audit.setBusinessId(bankId);//设置仓库入库id
		audit.setFeedBack(feedBack);//设置反馈信息
		audit.setAudTime(Tools.getCurDateTime());//设置审核时间
		audit.setState(Integer.valueOf(state));//设置审核状态  0未通过 2通过
		audit.setAudName(staff.getRoleName());//设置审核人名称
		audit.setIsva(1);
		
		int rows = auditMapper.insertSelective(audit);//执行审核表修改
		ErpBank bank = new ErpBank();//定义一个仓库实体类
		bank.setBankId(bankId);//设置仓库id
		bank.setBankIsva(Integer.valueOf(state));//设置审核状态
		return erpBankMapper.updateByPrimaryKeySelective(bank);//执行仓库审核修改该状态
	}
}

/**
 * 
 */
package com.yidu.service.ErpBank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Array;
import com.yidu.common.Tools;
import com.yidu.dao.ErpBankMapper;
import com.yidu.dao.ErpProindentMapper;
import com.yidu.dao.ErpPurchaseMapper;
import com.yidu.model.ErpBank;
import com.yidu.model.ErpKinds;
import com.yidu.model.ErpProindent;
import com.yidu.model.ErpPurchase;
import com.yidu.model.ErpRaw;

/**
 * 实现入库Service
 * @author Gjwen
 * 2017年11月13日-上午8:59:39
 */
@Service
public class ErpBankServiceImpl implements ErpBankService{
	/**
	 * 入库表DAO
	 */
	@Resource
	private ErpBankMapper erpBankMapper;
	/**
	 * 生产表DAO
	 */
	@Resource
	private ErpProindentMapper erpProindentMapper;
	/**
	 * 采购表DAO
	 */
	@Resource
	private ErpPurchaseMapper erpPurchaseMapper;
	@Resource
	private ErpInvedetService invService;//库存明细表service
	@Resource
	private ErpQualityMapper qualitMapper;//质检表mapper
	@Override
	public List<ErpBank> selectAll(Map<String, Object> map) {
		List<ErpBank> erp = erpBankMapper.selectAll(map);
		List<ErpBank> list = new ArrayList<ErpBank>();
		
		for (Iterator iterator = erp.iterator(); iterator.hasNext();) {
			ErpBank erpBank = (ErpBank) iterator.next();
			if(Tools.isEmpty(erpBank.getPurcId())){
				ErpProindent proindent = erpProindentMapper.findById(erpBank.getIndentId());//得到生产ID
				erpBank.setIndentMoney(proindent.getIndentMoney()+"");//生产金额
				erpBank.setIndentNumber(proindent.getIndentNumber());//生产数量
				//erpBank.setYaoPing(proindent.getIndentMoney()+"");0
				//erpBank.setYaoPing(proindent.getIndentNumber());  
			}else{
				ErpPurchase purchase = erpPurchaseMapper.findById(erpBank.getPurcId());//得到采购ID
//				erpBank.setPurcName(purchase.getPurcName());//采购名称
//				erpBank.setPurcTitle(purchase.getPurcTitle());//采购标题
//				erpBank.setPurcSerial(purchase.getPurcSerial());
				erpBank.setPurcTitle(purchase.getPurcTitle());
				//erpBank.setPurcTotalPrice(purchase.getPurcTotalPrice());
			}
			list.add(erpBank);//放入集合
		}
		
		return list;//返回list
	}
@Override
	public int selectAllConut(Map<String, Object> map) {
		return 0;
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
}

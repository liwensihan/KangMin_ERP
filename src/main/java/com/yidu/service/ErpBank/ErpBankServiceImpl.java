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

}

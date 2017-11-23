/**
 * 
 */
package com.yidu.service.ErpPurchase;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpPurchase;

/**
 * 采购订单Service
 * @author Gjwen
 * 2017年10月19日-下午3:09:23
 */
public interface ErpPurchaseService {
	/**
	 * 查询所有
	 * @param map
	 * @return
	 */
    List<ErpPurchase> selectAll(Map<String,Object> map);
    /**
     * 根据ID删除(修改状态为0)
     * @param purcId
     * @return
     */
    int updateByPrimaryKeySelective(ErpPurchase state);
    /**
     * 根据ID查询
     * @param purcId
     * @return
     */
    ErpPurchase selectByPrimaryKey(String purcId);
    /**
     * 根据ID修改 
     * @param purcId
     * @return
     */
    int update(ErpPurchase record);
    /**
     * 增加
     * @param record
     * @return
     */
    int insert(ErpPurchase record);
    /**
     * 分页
     * @param map
     * @return
     */
    public int purchaseFindRows(Map<String,Object> map);
    
    /**
	 * 用于审核采购
	 * @author 胡鑫
	 * @date 2017年11月21日14:32:45
	 * @param map 存放的参数
	 * @return 返回执行的行数
	 */
	public int auditPurchase(Map<String, Object> map) ;
}

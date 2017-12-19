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
	 * 查询所有下拉框
	 * @return
	 * @author 刘东
	 */
	List<ErpPurchase> selectshow();
	/**
	 * 根据ID查询
	 * @param purcId
	 * @return
	 */
	ErpPurchase selectByPrimaryKey(String purcId);
	/**
	 * 查询详情(采购原材料)
	 * @param purcId
	 * @return
	 */
	ErpPurchase showErp(String purcId);
	/**
	 * 根据ID查看详情(采购成品)
	 * @param purcId
	 * @return
	 */
	ErpPurchase showKind(String purcId);
	/**
	 * 查询所有(原材料)
	 * @param map
	 * @return
	 */
	List<ErpPurchase> selectAll(Map<String,Object> map);
	/**
	 * 查询所有(成品)
	 * @param map
	 * @return
	 */
	List<ErpPurchase> selectAlls(Map<String,Object> map);
	/**
	 * 根据ID删除(修改状态为0)
	 * @param purcId
	 * @return
	 */
	int updateByPrimaryKeySelective(ErpPurchase state);
	/**
	 * 根据ID查询(采购，采购详情，原材料)
	 * @param purcId
	 * @return
	 */
	List<Map<String,Object>> selectById(String purcId);
	/**
	 * 根据ID查询(采购，采购详情，货品)
	 * @param purcId
	 * @return
	 */
	List<Map<String,Object>> selectKindsById(String purcId);
	/**
	 * 根据ID修改 
	 * @param purcId
	 * @return
	 */
	int update(ErpPurchase record);
	/**
	 * 增加到采购表中
	 * @param record
	 * @return
	 */
	int insert(ErpPurchase record);
	/**
	 * 分页（采购，采购详情，原材料）
	 * @param map
	 * @return
	 */
	public int purchaseFindRows(Map<String,Object> map);
	/**
	 * 分页(采购，采购详情，货品)
	 * @param map
	 * @return
	 */
	public int purchaseFindRow(Map<String,Object> map);
	/**
	 * 查询年,月
	 * @param date
	 * @return
	 */
	public List<ErpPurchase> findTuxing(String date);


	/**
	 * 用于审核采购
	 * @author 胡鑫
	 * @date 2017年11月21日14:32:45
	 * @param map 存放的参数
	 * @return 返回执行的行数
	 */
	public int auditPurchase(Map<String, Object> map) ;
}

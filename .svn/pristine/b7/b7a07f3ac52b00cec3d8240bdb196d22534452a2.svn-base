/**
 * 
 */
package com.yidu.service.Proindent;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpProindent;

/**
 * @author dong
 * @da2017年11月6日
 * @version 1.0
 */
public interface ProindentService {
	/**
	 * 增加方法
	 * @param record
	 * @return
	 */
	 int insert(ErpProindent record);
	 
	 /**
	  * 查询所有
	  * @param map 
	  * @return
	  */
	 List<ErpProindent> selectByPrimaryKey(Map<String, Object> map);
	 /**
	  * 查询所有提交质检的订单
	  * @param map
	  * @return
	  */
	 List<ErpProindent> showPro(Map<String, Object> map);
	 
	 /**
	  * 总行数
	  * @param map
	  * @return
	  */
	 int findRowCount(Map<String, Object> map);
	 
	 
	 /**
	  * 修改或删除
	  * @param record
	  * @return
	  */
	 int updateByPrimaryKeySelective(ErpProindent record);

	 
	 /**
	  * 根据订单id查询明细，和商品表
	  * @param indentId
	  * @return
	  */
	 List<Map<String, Object>> selectByPrimaryKeyid(String indentId);

	 /**
	  * 根据订单id查询明细，和商品表查看明细
	  * @param indentId
	  * @return
	  */
	 List<Map<String, Object>> showid(String indentId);

	 
	 /**
	  * 下拉框查询
	  * @return
	  */
	 List<ErpProindent> findStation();
	 
	 /**
	  * 根据订单ID查询商品，下拉框 
	  * @return
	  */
	 List<Map<String, Object>> findStationid(String indentId);

	 /**
	  * 根据id查询单个对象
	  * @param indentId 订单id
	  * @return 返回订单对象
	  */ 
	 List<Map<String, Object>> selectByPrimaryProid(String indentId);
	 
	 /**
	  * 根据ID查询
	  * @param indentId
	  * @return
	  */
	 ErpProindent findById(String indentId);
	 
	 /**
	  * 查询产品，订单，订单明细，订单生产日志，订单生产日志明细，根据订单ID查询
	  * @param indentId
	  * @return
	  */
	 List<Map<String, Object>> findByshow(String indentId);

}

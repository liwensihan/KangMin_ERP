/**
 * 
 */
package com.yidu.service.ErpWarehouse;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpWarehouse;

/**
 * 仓库Service
 * @author Gjwen
 * 2017年11月9日-下午2:41:08
 */
public interface ErpWarehouseService {
	/**
	 * 查询商品
	 * @param map
	 * @return 返回创库的集合
	 */
	List<ErpWarehouse> selectAllKind(Map<String,Object> map);
	/**
	 * 查询原材料
	 * @param map
	 * @return 返回仓库的集合
	 */
	List<ErpWarehouse> selectAllRaw(Map<String,Object> map);
	/**
	 * 查询商品的总行数
	 * @param map
	 * @return
	 */
	public int warehouseFindKindRows(Map<String,Object> map);
	/**
	 * 查询原材料的总行数
	 * @param map
	 * @return
	 */
	public int warehouseFindRawRows(Map<String,Object> map);
}

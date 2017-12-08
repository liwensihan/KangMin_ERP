package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpWarehouse;
/**
 * 仓库DAO
 * @author Gjwen
 * 2017年11月9日-下午2:38:37
 */
public interface ErpWarehouseMapper {
	
	/**
	 * 根据配方ID修改仓库数量
	 * @author 刘东
	 * @param map
	 * @return
	 */
	int updateck(Map<String, Object> map);
	
	/**
	 * 查询是否大于0
	 * @param wareId
	 * @return
	 */
	int selectck(String wareId);
	
	/**
	 * 查询商品
	 * @param map
	 * @return
	 */
	List<ErpWarehouse> selectAllKind(Map<String,Object> map);
	/**
	 * 查询原材料
	 * @param map
	 * @return
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
	
	/**
	 * 商品的总行数
	 * @param map
	 * @return
	 */
	public int warehouseFindRows(Map<String,Object> map);
	
	
	
    int deleteByPrimaryKey(String wareId);

    int insert(ErpWarehouse record);
    
    int insertSelective(ErpWarehouse record);

    ErpWarehouse selectByPrimaryKey(String wareId);

    int updateByPrimaryKeySelective(ErpWarehouse record);

    int updateByPrimaryKey(ErpWarehouse record);
}
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
    /**
     * 添加方法
     * @param record 仓库对象
     * @return int 
     */
    int insertSelective(ErpWarehouse record);
    /**
     * 查询单个对象 用于入库查询该商品是否存在
     * @param peice 不知道什么id
     * @return 仓库对象
     */
    ErpWarehouse selectByPrimaryKey(String peice);
    /**
     * 查询单个对象
     * @param wareId 仓库id
     * @return 仓库对象
     */
    ErpWarehouse selectNewKey(String wareId);
    
    /**
     * 修改对象
     * @param record 仓库对象
     * @return int
     */
    int updateByPrimaryKeySelective(ErpWarehouse record);

    int updateByPrimaryKey(ErpWarehouse record);
    /**
	 * 鏍规嵁閰嶆柟ID淇敼浠撳簱鏁伴噺
	 * @author 鍒樹笢
	 * @param map
	 * @return
	 */
	int updateck(Map<String, Object> map);
	/**
	 * 鏌ヨ鏄惁澶т簬0
	 * @param wareId
	 * @return
	 */
	int selectck(String wareId);
	
	
	/**
	 * 查询库存大于0的商品
	 * @return
	 */
	List<ErpWarehouse>findAll();
	
	
	
	Map<String,Object> getByid(String kinId);
}
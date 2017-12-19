/**
 * 
 */
package com.yidu.service.ErpWarehouse;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.yidu.common.MyException;
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
	
	/**
     * 查询单个对象
     * @param peice 不知道什么id
     * @return int
     */
    ErpWarehouse selectByPrimaryKey(String peice);
    /**
     * 修改对象
     * @param record 仓库对象
     * @return int
     */
    int updateByPrimaryKeySelective(ErpWarehouse record);
    /**
     * 添加方法
     * @param record 仓库对象
     * @return int 
     */
    int insertSelective(ErpWarehouse record);
    /**
     * 查询单个对象
     * @param wareId 仓库id
     * @return 仓库对象
     */
    ErpWarehouse selectNewKey(String wareId);
    /**
	 * 鏍规嵁閰嶆柟ID淇敼浠撳簱鏁伴噺
	 * @author 鍒樹笢
	 * @param map
	 * @return
	 */
	int updateck(String[] str,HttpServletResponse response)throws MyException;
	
	/**
	 * 查询库存大于0的商品
	 * @return
	 */
	List<ErpWarehouse>findAll();
	
	Map<String,Object> getByid(String kinId);
}

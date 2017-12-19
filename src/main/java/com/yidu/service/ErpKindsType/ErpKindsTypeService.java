/**
 * 
 */
package com.yidu.service.ErpKindsType;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpKindsType;

/**
 * 药品类型id
 * @author 大晶儿
 * @date 2017年10月19日
*/

public interface ErpKindsTypeService {
	/**
	 * 删除
	 * @param typeId 类型id
	 * @return int
	 */
    int deleteByPrimaryKey(String typeId);
    /**
     * 添加全部
     * @param record 类型对象
     * @return int
     */
    int insert(ErpKindsType record);
    /**
     * 选择性添加
     * @param record 类型对象
     * @return 返回int
     */
    int insertSelective(ErpKindsType record);
    /**
     * 查找单个对象
     * @param typeId 类型id
     * @return 返回类型对象
     */
    ErpKindsType selectByPrimaryKey(String typeId);
    /**
     * 选择修改
     * @param record 类型对象
     * @return 返回数字
     */
    int updateByPrimaryKeySelective(ErpKindsType record);
    /**
     * 修改全部
     * @param record 类型对象
     * @returnss
     */
    int updateByPrimaryKey(ErpKindsType record);
    /**
     * 查询所有
     * @return 返回对象集合
     */
    List<ErpKindsType> showListType();
    /**
     * 模糊查询
     * @param price 值
     * @return 返回type对象的集合
     */
    public List<ErpKindsType> findDimType(Map<String,Object> map);
    /**
    * 查询总行数
	 * @param map
	 * @return
	 */
	int findDimTypeCount(Map<String,Object> map);
   
}

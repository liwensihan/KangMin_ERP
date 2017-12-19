/**
 * 
 */
package com.yidu.service.PactType;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpPactType;

/**
 * @author dong
 * @dateTime 2017年12月1日
 */
public interface PactTypeService {
	/**
	 * 查询所有下拉框
	 * @return
	 */
	List<ErpPactType> select();
	
	/**
	 * 显示所有
	 * @param map
	 * @return
	 */
	List<ErpPactType> selectshow(Map<String, Object> map);
	
	
	/**
	 * 总行数
	 * @param map
	 * @return
	 */
	int findRowCount(Map<String, Object> map);
	/**
	 * 添加全部
	 * @param record 类型对象
	 * @return 返回类型
	 */
	int insert(ErpPactType type);
	
	/**
     * 选择性修改
     * @param record 类型对象
     * @return 返回类型
     */
    int updateByPrimaryKeySelective(ErpPactType record);
    
    /**
     * 查找单个对象
     * @param incomeId 类型id
     * @return 返回类型
     */
    ErpPactType selectByPrimaryKey(String patypeId);
}

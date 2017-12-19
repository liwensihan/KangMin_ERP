/**
 * 
 */
package com.yidu.service.ErpPactType;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpPact;
import com.yidu.model.ErpPactType;

/**
 * @author zhangwei
 * 2017年11月24日
 */
public interface ErpPactTypeService {

	/**
	 * 删除
	 * @param incomeId 类型id
	 * @return 返回类型
	 */
	int deleteByPrimaryKey(String patypeId);
	/**
	 * 添加全部
	 * @param record 类型对象
	 * @return 返回类型
	 */
    int insert(ErpPactType record);
    /**
     * 选择性添加
     * @param record 类型对象
     * @return 返回类型
     */
    int insertSelective(ErpPactType record);
 
    /**
     * 选择性修改
     * @param record 类型对象
     * @return 返回类型
     */
    int updateByPrimaryKeySelective(ErpPactType record);
    /**
     * 修改全部
     * @param record 类型对象
     * @return 返回类型
     */
    int updateByPrimaryKey(ErpPactType record);
    /**
     * 查询所有
     * @return 返回对象集合
     */
    List<ErpPactType> showListPactType();
    /**
     * 模糊查询
     * @param price 值
     * @return 返回type对象的集合
     */
    public List<ErpPactType> findDimPactType(Map<String,Object> map);
}

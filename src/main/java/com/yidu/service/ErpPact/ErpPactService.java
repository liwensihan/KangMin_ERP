/**
 * 
 */
package com.yidu.service.ErpPact;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpPact;

/**
 * @author zhangwei
 * 2017年11月3日
 */
public interface ErpPactService {
	
	/**
	 * 总行数
	 * @param map
	 * @return
	 */
	int findRowCount(Map<String, Object> map);
	
	/**
	 * 查询所有
	 * @param map
	 * @return
	 */
	List<ErpPact> selectshow(Map<String, Object> map);
	
	/**
	 * 删除
	 * @param incomeId 类型id
	 * @return 返回类型
	 */
	int deleteByPrimaryKey(String pactId);
	/**
	 * 添加全部
	 * @param record 类型对象
	 * @return 返回类型
	 */
    int insert(ErpPact record);
    /**
     * 选择性添加
     * @param record 类型对象
     * @return 返回类型
     */
    int insertSelective(ErpPact record);
    /**
     * 查找单个对象
     * @param incomeId 类型id
     * @return 返回类型
     */
    ErpPact selectByPrimaryKey(String pactId);
    /**
     * 选择性修改
     * @param record 类型对象
     * @return 返回类型
     */
    int updateByPrimaryKeySelective(ErpPact record);
    /**
     * 修改全部
     * @param record 类型对象
     * @return 返回类型
     */
    int updateByPrimaryKey(ErpPact record);
    /**
     * 查询所有
     * @return 返回对象集合
     */
    List<ErpPact> showListPact();
    /**
     * 模糊查询
     * @param price 值
     * @return 返回type对象的集合
     */
    public List<ErpPact> findDimPact(Map<String,Object> map);
}

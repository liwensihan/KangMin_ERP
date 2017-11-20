/**
 * 
 */
package com.yidu.service.ErpResuit;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpResuit;
import com.yidu.util.BackException;

/**
 * 药效表
 * @author 大晶儿
 * 2017年10月23日
 */
public interface ErpResuitService {
	/**
	 * 删除
	 * @param resId id
	 * @return 返回int
	 */
    int deleteByPrimaryKey(ErpResuit record)throws BackException;
	/**
	 * 添加
	 * @param record 对象
	 * @return int
	 */
    int insert(ErpResuit record);
	/**
	 * 选择添加
	 * @param record 对象
	 * @return id
	 */
    int insertSelective(ErpResuit record);
	/**
	 * 查询单个对象
	 * @param resId id
	 * @return 对象
	 */
    ErpResuit selectByPrimaryKey(String resId);
	/**
	 * 选择修改
	 * @param record 对象
	 * @return int
	 */
    int updateByPrimaryKeySelective(ErpResuit record);
	/**
	 * 修改
	 * @param record 对象
	 * @return int
	 */
    int updateByPrimaryKey(ErpResuit record);
    
    /**
	 * 查询所有
	 * @return
	 */
	List<ErpResuit> findErpResuit();
	/**
	 * 模糊查询
	 * @param map map集合
	 * @return 返回list 
	 */
	List<ErpResuit> findDimRes(Map<String,Object> map);
}

package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpKindsType;
/**
 * 药品类型表
 * @author 大晶儿 
 * @date 2017年10月19日
 */
public interface ErpKindsTypeMapper {
	/**
	 * 删除
	 * @param typeId
	 * @return
	 */
    int deleteByPrimaryKey(String typeId);
    /**
     * 添加全部
     * @param record
     * @return
     */
    int insert(ErpKindsType record);
    /**
     * 选择性添加
     * @param record
     * @return
     */
    int insertSelective(ErpKindsType record);
    /**
     * 查找单个对象
     * @param typeId
     * @return
     */
    ErpKindsType selectByPrimaryKey(String typeId);
    /**
     * 选择修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ErpKindsType record);
    /**
     * 修改全部
     * @param record
     * @return
     */
    int updateByPrimaryKey(ErpKindsType record);
    /**
     * 得到所有类型
     * @return
     */
	List<ErpKindsType> findListType();
	/**
	 * 得到今天最大的编号
	 * @param dateStr
	 * @return
	 */
	String selectSerial(String dateStr);
	/**
	 * 模糊查询
	 * @param price 值
	 * @return type对象的集合
	 */
	List<ErpKindsType> findDimType(Map<String,Object> map);
	/**
	 * 查询总行数
	 * @param map
	 * @return
	 */
	int findDimTypeCount(Map<String,Object> map);
}
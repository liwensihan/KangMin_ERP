package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpResuit;

public interface ErpResuitMapper {
	/**
	 * 删除
	 * @param resId id
	 * @return 返回int
	 */
    int deleteByPrimaryKey(String resId);
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
	 * 得到今天最大的编号
	 * @param dateStr
	 * @return
	 */
	String selectSerial(String dateStr);
	/**
	 * 查询所有
	 * @return
	 */
	List<ErpResuit> findErpResuit();
	/**
	 * 模糊查询
	 * @param map
	 * @return
	 */
	List<ErpResuit> findDimRes(Map<String,Object> map);
	/**
	 * 查询总行数
	 * @param map
	 * @return
	 */
	int findDimResConut(Map<String,Object> map);
	/**
	 * 查询药品药效
	 * @param kinId 药品id
	 * @return 药效list
	 */
	List<ErpResuit> findDimKinskRes(String kinId);
}
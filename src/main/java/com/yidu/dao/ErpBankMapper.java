package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpBank;
/**
 * 生产dao
 * @author Gjwen
 * 2017年11月13日-上午10:30:29
 */
public interface ErpBankMapper {
	/**
	 * 查询显示
	 * @param map 分页和模糊查询的参数
	 * @return 入库对象的集合
	 */
	List<ErpBank> selectAll(Map<String,Object> map);
	/**
	 * 查询和显示的中行数
	 * @param map 分页和模糊查询的参数
	 * @return int
	 */
	int selectAllConut(Map<String,Object> map);
	int deleteByPrimaryKey(String bankId);

	int insert(ErpBank record);
	/**
	 * 添加
	 * @param record 入库对象
	 * @return int
	 */
	int insertSelective(ErpBank record);
	/**
	 * 查询单个对象
	 * @param bankId 入库id
	 * @return 入库对象
	 */ 
	ErpBank selectByPrimaryKey(String bankId);
	/**
	 * 修改入库
	 * @param record 入库id
	 * @return 入库对象
	 */
	int updateByPrimaryKeySelective(ErpBank record);

	int updateByPrimaryKey(ErpBank record);
	/**
	 * 查询编号
	 * @param data 当前时间
	 * @return 今天最大的编号
	 */
	String  selectSerial(String data);
}
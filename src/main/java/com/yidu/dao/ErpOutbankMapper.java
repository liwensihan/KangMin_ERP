package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpOutbank;

public interface ErpOutbankMapper {
    int deleteByPrimaryKey(String obId);

    int insert(ErpOutbank record);

    int insertSelective(ErpOutbank record);

    ErpOutbank selectByPrimaryKey(String obId);

    int updateByPrimaryKeySelective(ErpOutbank record);

    int updateByPrimaryKey(ErpOutbank record);
    /**
	 * 查询显示
	 * @param map 分页和模糊查询的参数
	 * @return 入库对象的集合
	 */
	List<ErpOutbank> selectAll(Map<String,Object> map);
	/**
	 * 查询和显示的中行数
	 * @param map 分页和模糊查询的参数
	 * @return int
	 */
	int selectAllConut(Map<String,Object> map);
	 /**
     * 查询编号
     * @param data 当前时间
     * @return 今天最大的编号
     */
   String  selectSerial(String data);
}
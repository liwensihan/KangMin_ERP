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
	 * @param map
	 * @return
	 */
	List<ErpBank> selectAll(Map<String,Object> map);
	
    int deleteByPrimaryKey(String bankId);

    int insert(ErpBank record);

    int insertSelective(ErpBank record);

    ErpBank selectByPrimaryKey(String bankId);

    int updateByPrimaryKeySelective(ErpBank record);

    int updateByPrimaryKey(ErpBank record);
}
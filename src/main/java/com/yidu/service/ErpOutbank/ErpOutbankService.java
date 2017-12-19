/**
 * 
 */
package com.yidu.service.ErpOutbank;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpInvedet;
import com.yidu.model.ErpOutbank;

/**
 * 出库
 * @author 大晶儿
 * 2017年12月8日
 */
public interface ErpOutbankService {
		int deleteByPrimaryKey(String obId);

	    int insert(ErpOutbank record);

	    int insertSelective(ErpOutbank record,List<ErpInvedet> list,String quaId);

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
}

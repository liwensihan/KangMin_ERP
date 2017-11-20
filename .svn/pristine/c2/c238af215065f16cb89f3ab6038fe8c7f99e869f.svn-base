/**
 * 
 */
package com.yidu.service.ErpWarehouse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.common.Tools;
import com.yidu.dao.ErpKindsMapper;
import com.yidu.dao.ErpRawMapper;
import com.yidu.dao.ErpWarehouseMapper;
import com.yidu.model.ErpKinds;
import com.yidu.model.ErpRaw;
import com.yidu.model.ErpWarehouse;

/**
 * 实现仓库Service
 * @author Gjwen
 * 2017年11月9日-下午2:41:36
 */
@Service
public class ErpWarehouseServiceImpl implements ErpWarehouseService{
	/**
	 * 注入仓库Dao
	 */
	@Resource
	private ErpWarehouseMapper mapper;

	@Override
	public List<ErpWarehouse> selectAllKind(Map<String, Object> map) {
		String p = (String) map.get(1);
		return mapper.selectAllKind(map);
	}

	@Override
	public List<ErpWarehouse> selectAllRaw(Map<String, Object> map) {
		return mapper.selectAllRaw(map);
	}

	@Override
	public int warehouseFindKindRows(Map<String, Object> map) {
		return mapper.warehouseFindKindRows(map);
	}

	@Override
	public int warehouseFindRawRows(Map<String, Object> map) {
		return mapper.warehouseFindRawRows(map);
	}
	
}

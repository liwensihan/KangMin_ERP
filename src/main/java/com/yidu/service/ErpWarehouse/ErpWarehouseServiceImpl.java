/**
 * 
 */
package com.yidu.service.ErpWarehouse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.yidu.common.ExceptionClass;
import com.yidu.common.MyException;
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

	/**
	 * 根据配方ID修改仓库数量
	 * @author 刘东
	 * @param map
	 * @return
	 * @throws MyException 
	 */
	@Override
	public int updateck(String[] str,HttpServletResponse response) throws MyException{
		int row=0;
		int rows=0;
		Map<String, Object> map=new HashMap<String,Object>();
		for(int i =0;i<str.length;i++){
			String[] str1 = str[i].split("_");//分割
			map.put("int", str1[3]);
			map.put("rawId", str1[4]);
			row=mapper.updateck(map);
			rows=mapper.selectck(str1[4]);
			//设置0-100范围数字
	        if(rows<=0){
	        	try {
					response.getWriter().print("0");
					response.getWriter().flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	
	        	throw new MyException("库存不足！");
	        }
	        
		}
		return row;
	}
	
}

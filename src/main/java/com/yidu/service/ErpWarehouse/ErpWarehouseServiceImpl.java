/**
 * 
 */
package com.yidu.service.ErpWarehouse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

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

	@Override
	public ErpWarehouse selectByPrimaryKey(String peice) {
		return mapper.selectByPrimaryKey(peice);
	}

	@Override
	public int updateByPrimaryKeySelective(ErpWarehouse record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int insertSelective(ErpWarehouse record) {
		record.setCreatetime(Tools.getCurDateTime());
		record.setIsva(1);
		return mapper.insertSelective(record);
	}

	@Override
	public ErpWarehouse selectNewKey(String wareId) {
		return mapper.selectNewKey(wareId);
	}
	/**
	 * 鏍规嵁閰嶆柟ID淇敼浠撳簱鏁伴噺
	 * @author 鍒樹笢
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
			String[] str1 = str[i].split("_");//鍒嗗壊
			map.put("int", str1[3]);
			map.put("rawId", str1[4]);
			row=mapper.updateck(map);
			rows=mapper.selectck(str1[4]);
			//璁剧疆0-100鑼冨洿鏁板瓧
	        if(rows<=0){
	        	try {
					response.getWriter().print("0");
					response.getWriter().flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        	throw new MyException("搴撳瓨涓嶈冻锛�");
	        }
		}
		return row;
	}

	@Override
	public List<ErpWarehouse> findAll() {
		return mapper.findAll();
	}

	@Override
	public Map<String,Object> getByid(String kinId) {
		return mapper.getByid(kinId);
	}
	
	
}

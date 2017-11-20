/**
 * 
 */
package com.yidu.service.ErpKinds;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpKindsMapper;
import com.yidu.model.ErpKinds;
import com.yidu.model.ErpResuit;
import com.yidu.service.ErpDrugResult.ErpDrugResultService;
import com.yidu.util.Tools;

/**
 * 药品service 的实现类
 * @author 大晶儿
 * 2017年10月31日
 */
@Service
public class ErpKindsServiceImpl implements ErpKindsService{
	@Resource
	private ErpKindsMapper mapper; //药品的导
	@Resource
	private ErpDrugResultService dresService; //药品药效service
	
	
	
	public int deleteByPrimaryKey(ErpKinds record) {
		record.setIsva(0);
		return mapper.updateByPrimaryKeySelective(record);
	}

	
	public int insert(ErpKinds record) {
		return 0;
	}

	
	public int insertSelective(ErpKinds record) {
		String data = mapper.selectSerial(Tools.getDateStr(new Date()));//得到当天最大的编号
		record.setKinSerial(Tools.getSerial(data, "YP"));//通过工具类得到编号
		record.setIsva(1);
		record.setCreatetime(Tools.getTimeStr(new Date()));//得到现在的时间
		return mapper.insertSelective(record);
	}



	
	public int updateByPrimaryKeySelective(ErpKinds record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	
	public int updateByPrimaryKey(ErpKinds record) {
		return 0;
	}
	
	public List<ErpKinds> findPrimaryKinds(Map<String,Object> map1) {
		List<ErpKinds> list = mapper.findPrimaryKinds(map1);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			ErpKinds erpKinds = (ErpKinds) iterator.next();
			System.out.println("--------------------------------"+erpKinds.getKinName()+"----------------------------------------------");
		}
		return list;
	}

	
	@Override
	public String selectId(String dateStr) {
		return mapper.selectId(dateStr);
	}

	@Override
	public Integer selectConut(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.selectConut(map);
	}


	@Override
	public ErpKinds findByKinBarcode(String kinBarcode) {
		return mapper.findByKinBarcode(kinBarcode);
	}

	/**
     * 查询所有，下拉框
     * @return
     */
	@Override
	public List<ErpKinds> findStation() {
		// TODO Auto-generated method stub
		return mapper.findStation();
	}

	
	/**
	 * 根据ID查询
	 */
	public ErpKinds selectByPrimaryKey(String kinId) {
		
		return mapper.selectByPrimaryKey(kinId);
	}


	@Override
	public ErpKinds selectByPrimaryNewKinId(String kinId) {
		return mapper.selectByPrimaryNewKinId(kinId);
	}
}

/**
 * 
 */
package com.yidu.service.ErpResuit;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpResuitMapper;
import com.yidu.model.ErpDrugResult;
import com.yidu.model.ErpResuit;
import com.yidu.service.ErpDrugResult.ErpDrugResultService;
import com.yidu.util.BackException;
import com.yidu.util.Tools;

/**
 * @author 大晶儿
 * 2017年10月23日
 */
@Service
public class ErpResuitServiceImpl implements ErpResuitService{
	@Resource
	private ErpResuitMapper mapper; //药效导
	@Resource
	private ErpDrugResultService dugresService;//药品药效的service
	public int deleteByPrimaryKey(ErpResuit record) throws BackException {
		record.setIsva(1);
		List<ErpDrugResult> redru = dugresService.selectByPrimRew(record.getResId());
		for (Iterator iterator = redru.iterator(); iterator.hasNext();) {
			System.out.println("哈哈哈--------------------------------------------");
			ErpDrugResult erpDrugResult = (ErpDrugResult) iterator.next();
			int rows = dugresService.deleteByPrimaryKey(erpDrugResult.getDrugResId());
			if(rows<-1){//药品药效添加失败抛出异常事物回滚
				throw new BackException("发生删除子项时了一个报错!");//抛出异常 
			}
		}
		return mapper.updateByPrimaryKeySelective(record);
	}

	public int insert(ErpResuit record) {
		return 0;
	}


	public ErpResuit selectByPrimaryKey(String resId) {
		return null;
	}


	public int updateByPrimaryKeySelective(ErpResuit record) {
		return mapper.updateByPrimaryKeySelective(record);
	}


	public int updateByPrimaryKey(ErpResuit record) {
		return 0;
	}

	public int insertSelective(ErpResuit record) {
		String data = mapper.selectSerial(Tools.getDateStr(new Date()));
		record.setResSerial(Tools.getSerial(data, "YX"));
		record.setIsva(0);
		record.setCreatetime(Tools.getTimeStr(new Date()));
		return mapper.insertSelective(record);
	}

	public List<ErpResuit> findErpResuit() {
		return mapper.findErpResuit();
	}

	
	public List<ErpResuit> findDimRes(Map<String, Object> map) {
		return mapper.findDimRes(map);
	}

}

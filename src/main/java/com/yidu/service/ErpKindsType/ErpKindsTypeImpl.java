/**
 * 
 */
package com.yidu.service.ErpKindsType;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpKindsTypeMapper;
import com.yidu.model.ErpKindsType;
import com.yidu.util.Tools;

/**
 *类型接口
 * @author 大晶儿
 * @date 2017年10月19日
*/
@Service
public class ErpKindsTypeImpl implements ErpKindsTypeService{
	@Resource
	private ErpKindsTypeMapper mapper;
	
	public int deleteByPrimaryKey(String typeId) {
		return mapper.deleteByPrimaryKey(typeId);
	}

	public int insert(ErpKindsType record) {
		
		return 0;
	}
	public int insertSelective(ErpKindsType record) {
		//编号 = yplx + 2017-10-18 +001
		//得到数据库的编号
		String data = mapper.selectSerial(Tools.getDateStr(new Date()));//得到今天创建的最后一条数据
		
		record.setTypeSerial(Tools.getSerial(data, "LX"));//类型编号
		record.setCreatetime(Tools.getTimeStr(new Date()));//创建时间
		record.setCreater("0");//是否有效
		return mapper.insertSelective(record);
	}
	public ErpKindsType selectByPrimaryKey(String typeId) {
		return null;
	}
	public int updateByPrimaryKeySelective(ErpKindsType record) {
		return mapper.updateByPrimaryKeySelective(record);
	}
	public int updateByPrimaryKey(ErpKindsType record) {
		return 0;
	}
	public List<ErpKindsType> showListType() {
		return mapper.findListType();
	}

	public List<ErpKindsType> findDimType(Map<String, Object> map) {
		return mapper.findDimType(map);
	}

	@Override
	public int findDimTypeCount(Map<String, Object> map) {
		return mapper.findDimTypeCount(map);
	}


}

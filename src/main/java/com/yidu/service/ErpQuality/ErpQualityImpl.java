/**
 * 
 */
package com.yidu.service.ErpQuality;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpQualityMapper;
import com.yidu.model.ErpQuality;
import com.yidu.model.ErpQualityDetail;
import com.yidu.service.ErpQualityDetail.ErpQualityDetailService;
import com.yidu.util.BackException;
import com.yidu.util.Tools;

/**
 * 质检表service接口
 * @author 大晶儿
 */
@Service
public class ErpQualityImpl implements ErpQualityService{
	@Resource
	private ErpQualityMapper mapper;//质检的导
	@Resource
	private ErpQualityDetailService service;//质检的service
	@Override
	public int deleteByPrimaryKey(String quaId) {
		
		return 0;
	}

	@Override
	public int insert(ErpQuality record) {
		return 0;
	}

	@Override
	public int insertSelective(ErpQuality record) {
		record.setCreatetime(Tools.getCurDateTime());
		String data = mapper.selectSerial(Tools.getDateStr(new Date()));
		record.setQuaSreial(Tools.getSerial(data, "ZJ"));
		record.setQuaIsva(1);
		return mapper.insertSelective(record);
	}

	@Override
	public ErpQuality selectByPrimaryKey(String quaId) {
		
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(ErpQuality record,List<ErpQualityDetail> detlist) throws BackException {
		for (Iterator iterator = detlist.iterator(); iterator.hasNext();) {
			ErpQualityDetail erpQualityDetail = (ErpQualityDetail) iterator.next();
			int row = service.insertSelective(erpQualityDetail);
			if(row<-1){//药品药效添加失败抛出异常事物回滚
				throw new BackException("添加质检明细的时候报错");//抛出异常 
			}
		}
		int rows =mapper.updateByPrimaryKeySelective(record);
		return rows;
	}

	@Override
	public int updateByPrimaryKey(ErpQuality record) {
		
		return 0;
	}

	@Override
	public List<ErpQuality> selectByPrimaryNew(Map<String, Object> map) {
		return mapper.selectByPrimaryNew(map);
	}

	@Override
	public int selectByPrimaryNewCount(Map<String, Object> map) {
		return mapper.selectByPrimaryNewCount(map);
	}

}

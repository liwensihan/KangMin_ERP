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

import com.yidu.dao.ErpProindentDetailMapper;
import com.yidu.dao.ErpQualityMapper;
import com.yidu.model.ErpProindent;
import com.yidu.model.ErpProindentDetail;
import com.yidu.model.ErpPurchase;
import com.yidu.model.ErpQuality;
import com.yidu.model.ErpQualityDetail;
import com.yidu.service.ErpPurchase.ErpPurchaseService;
import com.yidu.service.ErpQualityDetail.ErpQualityDetailService;
import com.yidu.service.Proindent.ProindentService;
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
	@Resource
	private ProindentService proService;//生产的servic
	@Resource
	private ErpPurchaseService purService;//采购的service
	@Resource
	private ErpProindentDetailMapper prodetMapper;//生产明细的mapper
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
		record.setIsva(1);
		return mapper.insertSelective(record);
	}

	@Override
	public ErpQuality selectByPrimaryKey(Map<String,Object> map) {
		
		return mapper.selectByPrimaryKey(map);
	}

	@Override
	public int updateByPrimaryKeySelective(ErpQuality record,List<ErpQualityDetail> detlist) throws BackException {
		//遍历detlist集合并添加到质检表明细里面
		for (Iterator iterator = detlist.iterator(); iterator.hasNext();) {
			ErpQualityDetail erpQualityDetail = (ErpQualityDetail) iterator.next();
			int row = service.insertSelective(erpQualityDetail);
			if(row<-1){//药品药效添加失败抛出异常事物回滚
				throw new BackException("添加质检明细的时候报错");//抛出异常 
			}
		}
		//判断质检状态为打回（3） 并且生产id为空 或者“” 把生产订单修改为质检不合格(5)
		if(record.getQuaIsva()==3 && record.getIndentId()!=null && record.getIndentId()!=""){
			ErpProindent pro = new ErpProindent();
			pro.setState(5);
			pro.setIndentId(record.getIndentId());
			pro.setRemark(record.getRemark());
			proService.updateByPrimaryKeySelective(pro);
		}
		//判断质检状态为三并且采购id不为空或者“” 把采购订单修改为质检不合格（5）
		if(record.getQuaIsva()==3 && record.getPurcId()!=null && record.getPurcId()!=""){
			ErpPurchase pur = new ErpPurchase();
			pur.setState(5);
			pur.setPurcId(record.getPurcId());
			pur.setRemark(record.getRemark());
			purService.updateByPrimaryKeySelective(pur);
		}
		//调用导里面的修改方法
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
	@Override
	public int selectShowNew(String indentId,String purcId,String sid) {
		ErpQuality qua = new ErpQuality();//得到一个质检对象
		if("".equals(purcId) || purcId == null){//判断采购id是否为空
			qua.setIndentId(indentId);//把生产id放入质检对象
			ErpProindent pro = new ErpProindent();//得到一个生产对象
			pro.setIndentId(indentId);//把生产id放生产对象里面
			pro.setIndentState(5+"");//修改状态为5质检已提交
			proService.updateByPrimaryKeySelective(pro);//修改生产对象
		}else{
			qua.setPurcId(purcId);//把采购id放入质检对象
			ErpPurchase pur = new ErpPurchase();//得到采购对象
			pur.setPurcId(purcId);//把采购id放入采购对象
			pur.setState(4);//修改采购状态为已提交质检
			purService.updateByPrimaryKeySelective(pur);//修改状态
		}
		qua.setCreater(sid);//得到创建人id
		int rows = insertSelective(qua);//添加质检
		return rows;
	}

}

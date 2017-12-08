/**
 * 
 */
package com.yidu.service.sctockmp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpAnnexMapper;
import com.yidu.dao.ErpLedgyrMapper;
import com.yidu.dao.ErpSctockmpDetailMapper;
import com.yidu.dao.ErpSctockmpMapper;
import com.yidu.dao.ErpSumstockMapper;
import com.yidu.model.ErpAnnex;
import com.yidu.model.ErpLedgyr;
import com.yidu.model.ErpSctockmp;
import com.yidu.model.ErpSctockmpDetail;

/**
 * 分店销售订单service实现接口
 * @author ouyang
 * @dataTime 2017年11月23日16:30:36
 */
@Service
public class SctockmpServiceImpl implements SctockmpService{
	@Resource
	ErpSctockmpMapper sctockmpDao;//分店销售订单
	@Resource
	ErpSctockmpDetailMapper sctockmpDetailDao;//分店销售订单明细
	@Resource
	ErpSumstockMapper sumstockDao;//分店库存表
	@Resource
	ErpLedgyrMapper ledgyrDao;//分店支出（收入）明细
	@Resource
	ErpAnnexMapper annexDao;//分店表

	@Override
	public int addSctockmp(ErpSctockmp sctockmp, List<ErpSctockmpDetail> list) {
		//增加销售订单
		int row1 = sctockmpDao.insertSelective(sctockmp);
		//增加销售订单明细
		int row2 = sctockmpDetailDao.addSctockmpDetailList(list);
		//如果为零售(则需减库存，增加财务)
		if(sctockmp.getSaleIfWholesale()==0){
			//减库存
			List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
			for(int i =0;i<list.size();i++){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("annexId",sctockmp.getAnnexId());
				map.put("kinId",list.get(i).getKinId());
				map.put("kmpNum",list.get(i).getKmpNum());
				mapList.add(map);
			}
			int row3 = sumstockDao.updateStockSuount(mapList);
			if(row3<1){
				return 0;
			}
			
			//增加财务(先增加分店收入明细，再增加分店表的总资产)
			/*  增加分店收入明细  */
			ErpLedgyr ledgyr = new ErpLedgyr();
			ledgyr.setGyrId(UUID.randomUUID()+"");
			ledgyr.setSaleId(sctockmp.getSaleId());
			ledgyr.setAnnexId(sctockmp.getAnnexId());
			ledgyr.setGyrSreial(UUID.randomUUID()+"");
			ledgyr.setGyrPrice(sctockmp.getSaleMoney1());
			ledgyr.setCreater(sctockmp.getCreater());
			ledgyr.setCreatetime(sctockmp.getCreatetime()+"");
			int row4 = ledgyrDao.insertSelective(ledgyr);
			if(row4<1){
				return 0;
			}
			
			/*  增加分店表的总资产  */
			ErpAnnex annex = new ErpAnnex();
			annex.setAnnexId(sctockmp.getAnnexId());
			annex.setAnnexPrice(sctockmp.getSaleMoney1());
			int row5 = annexDao.updateAnnexPriceAdd(annex);
			if(row5<1){
				return 0;
			}
		}
		int rows = row1+row2;
		return rows;
	}

	@Override
	public List<Map<String, Object>> findAll(Map<String, Object> sctockmpMap) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> sctockmpList = sctockmpDao.findAll(sctockmpMap);
		for (Iterator iterator = sctockmpList.iterator(); iterator.hasNext();) {
			Map<String, Object> mapList = (Map<String, Object>) iterator.next();
			mapList.put("SALE_DATE", mapList.get("SALE_DATE")+"");
			list.add(mapList);
		}
		return list;
	}

	@Override
	public int findAllSize(Map<String, Object> map) {
		return sctockmpDao.findAllSize(map);
	}
	
}

package com.yidu.service.ErpDrugResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpDrugResultMapper;
import com.yidu.model.ErpDrugResult;
import com.yidu.util.BackException;

/**
 * @author 大晶儿
 * 2017年10月23日
 */
@Service
public class ErpDrugResultServiceImpl implements ErpDrugResultService{
	//药品药效的导
	@Resource
	private ErpDrugResultMapper mapper;

	public int deleteByPrimaryKey(String drugResId) {
		return mapper.deleteByPrimaryKey(drugResId);
	}

	public int insert(ErpDrugResult record) {
		return 0;
	}

	public int insertSelective(ErpDrugResult record) {
		return mapper.insertSelective(record);
	}

	public int updateByPrimaryKey(ErpDrugResult record) {
		return 0;
	}

	public int updateByPrimaryKeySelective(String kindId, Integer[] resId) throws BackException{
		List<ErpDrugResult> drlist =mapper.selectByPrimaryKind(kindId);
		for (Iterator iterator = drlist.iterator(); iterator.hasNext();) {
			ErpDrugResult erpDrugResult = (ErpDrugResult) iterator.next();
			int rows = mapper.deleteByPrimaryKey(erpDrugResult.getDrugResId());
			if(rows<-1){
				throw new BackException("发生修改药效时了一个报错!");//抛出异常 
			}
		}
		List<ErpDrugResult> res = new ArrayList<ErpDrugResult>();
		int rows = 0;
		for(int i=0;i<resId.length;i++){ //循环数组取出值
			ErpDrugResult erpDrugResult = new ErpDrugResult();
			erpDrugResult.setResId(resId[i]+""); //把数组取出的值放入药品药效类里面
			res.add(erpDrugResult);//添加药品药效类到药品药效类的集合
		}
		for (Iterator iterator = res.iterator(); iterator.hasNext();) {
			ErpDrugResult erpDrugResult = (ErpDrugResult) iterator.next();
			erpDrugResult.setKinId(kindId);
			rows = mapper.insertSelective(erpDrugResult);
		}
		 return rows;
	}

	public List<ErpDrugResult> selectByPrimaryKey(String rawId) {
		return mapper.selectByPrimaryKey(rawId);
	}

	
	public List<ErpDrugResult> selectByPrimRew(String resId) {
		
		return mapper.selectByPrimRes(resId);
	}
	
	public int insertSelectiveRuiKind(String kindId, String[] resId) throws BackException {
		List<ErpDrugResult> res = new ArrayList<ErpDrugResult>();
		int rows = 0;
		for(int i=0;i<resId.length;i++){ //循环数组取出值
			ErpDrugResult erpDrugResult = new ErpDrugResult();
			erpDrugResult.setResId(resId[i]+""); //把数组取出的值放入药品药效类里面
			res.add(erpDrugResult);//添加药品药效类到药品药效类的集合
		}
		for (Iterator iterator = res.iterator(); iterator.hasNext();) {
			ErpDrugResult erpDrugResult = (ErpDrugResult) iterator.next();
			erpDrugResult.setKinId(kindId);
			System.out.println("-----------------------------"+kindId+"------------------------------");
			rows = mapper.insertSelective(erpDrugResult);
			if(rows<-1){
				throw new BackException("发生添加药效时了一个报错!");//抛出异常 
			}
		}
		return rows;
	}

	@Override
	public int deleteKindsRes(String resId, String kindsId) {
		return mapper.deleteKindsRes(resId, kindsId);
	}
}

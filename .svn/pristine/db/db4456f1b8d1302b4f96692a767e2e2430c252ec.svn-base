/**
 * 
 */
package com.yidu.service.ErpRaw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpRawMapper;
import com.yidu.model.ErpDrugResult;
import com.yidu.model.ErpImg;
import com.yidu.model.ErpRaw;
import com.yidu.service.ErpDrugResult.ErpDrugResultService;
import com.yidu.service.ErpImg.ErpImgService;
import com.yidu.util.BackException;
import com.yidu.util.Tools;

/**
 * 原材料接口
 * @author 大晶儿
 * 2017年10月21日
 */
@Service
public class ErpRawImpl implements ErpRawService{
	@Resource
	private ErpRawMapper mapper;//原材料导
	@Resource
	private ErpDrugResultService dresService; //药品药效service
	@Resource
	private ErpImgService imgService;//原材料的图片
	
	public int insertSelective(ErpRaw record,List<ErpDrugResult> res) throws BackException {
		String data = mapper.selectSerial(Tools.getDateStr(new Date()));//得到今天创建的最后一条数据
		record.setRawSerial(Tools.getSerial(data,"YCL"));//用工具类生产编号
		record.setCreatetime(Tools.getTimeStr(new Date()));//添加创建时间
		String uuid = UUID.randomUUID()+"";
		record.setRawId(uuid);
		record.setIsva(0);
		int rows = mapper.insertSelective(record);//得到添加原材料返回函数
		 if(rows>-1){//判断返回函数 添加成功
			 
			 for (Iterator iterator = res.iterator(); iterator.hasNext();) {
				ErpDrugResult erpDrugResult = (ErpDrugResult) iterator.next();
				erpDrugResult.setRawId(uuid);//把原材料添加到药品药效里面
				int row = dresService.insertSelective(erpDrugResult);//执行药品药效添加语句
				if(row<-1){//药品药效添加失败抛出异常事物回滚
					throw new BackException("您输入的是"+row+",规定除数不能为负数!");//抛出异常 
				}
			 }
		 }else{
			 rows = -2;
		 }
		return rows;
	}

	
	public int updateByPrimaryKeySelective(ErpRaw record,List<ErpDrugResult> res) throws BackException {
		
		int rows = 0;
		List<ErpDrugResult> drlist =dresService.selectByPrimaryKey(record.getRawId());//得到该药品的所有药效
		
		for(ErpDrugResult su:drlist){//先把数据库里面的药效删除了
			int rws = dresService.deleteByPrimaryKey(su.getDrugResId());
			if(rws<-1){//药品药效添加失败抛出异常事物回滚
				throw new BackException("修改原材料是发生了报错!");//抛出异常 
			}
		}
		for(ErpDrugResult rest:res){//沥遍页面得到的药效集合添加进药效数据库
			rest.setRawId(record.getRawId());
			int row = dresService.insertSelective(rest);//执行药品药效添加语句
			if(row<-1){//药品药效添加失败抛出异常事物回滚
				throw new BackException("发生添加药效时了一个报错!");//抛出异常 
			}
			
		}
			rows = mapper.updateByPrimaryKeySelective(record);
		return rows;
	}

	public List<ErpRaw> findListRaw() {
		List<ErpRaw> list = mapper.findListRaw();//得到所有的原材料的集合
		return list;
	}
	public List<ErpRaw> findDimRaw(Map<String, Object> map) {
		return mapper.findDimRaw(map);
	}
	public int deleteByPrimaryKey(ErpRaw record) {
		return mapper.updateByPrimaryKeySelective(record);
	}
	public int insert(ErpRaw record) {
		// TODO Auto-generated method stub
		return 0;
	}

	 
	public List<ErpRaw> selectByPrimaryKey(String rawId) {
		return mapper.selectByPrimaryKey(rawId);
	}


	public int updateByPrimaryKey(ErpRaw record) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<ErpRaw> findRawList() {
		return mapper.findRawList();
	}


}

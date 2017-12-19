/**
 * 
 */
package com.yidu.service.ErpOutbank;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.common.Tools;
import com.yidu.dao.ErpOutbankMapper;
import com.yidu.dao.ErpQualityMapper;
import com.yidu.model.ErpFdproform;
import com.yidu.model.ErpInvedet;
import com.yidu.model.ErpOutbank;
import com.yidu.model.ErpQuality;
import com.yidu.service.ErpFdproform.ErpFdproformService;
import com.yidu.service.ErpInvedet.ErpInvedetService;
import com.yidu.util.BackException;

/**
 * service
 * @author 大晶儿
 * 2017年12月8日
 */
@Service
public class ErpOutbankImpl implements ErpOutbankService{
	@Resource
	private ErpOutbankMapper mapper;//出库的mapp

	@Resource
	private ErpInvedetService invService;//库存明细表service
	@Resource
	private ErpQualityMapper qualitMapper;//质检表mapper
	@Resource
	private ErpFdproformService fdService;//分店采购表
	@Override
	public int deleteByPrimaryKey(String obId) {
		return mapper.deleteByPrimaryKey(obId);
	}

	@Override
	public int insert(ErpOutbank record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(ErpOutbank record,List<ErpInvedet> list,String fdproId) {
		String uuid = UUID.randomUUID()+"";//得到一个uuid
		String data = mapper.selectSerial(Tools.getCurDate());//得到当前编号
		record.setObNumber(Tools.getSerial(data, "RK"));//通过工具类得到一个新的编号
		record.setCreatetime(Tools.getCurDateTime());//得到当前创建时间
		record.setIsva(1);//是否有效
		record.setObId(uuid);//uuid加入出库id
		record.setObBusibess(2);//加入出库状态
		record.setKinordId(fdproId);//把出库单里面放入分店采购id
		for (Iterator iterator = list.iterator(); iterator.hasNext();)  {
			ErpInvedet erpInvedet = (ErpInvedet) iterator.next();
			erpInvedet.setObId(uuid);//出库id放入uuid
			int rows = invService.insertSelective(erpInvedet);//添加库存明细
			if(rows<-1){//入库明细添加失败抛出异常事物回滚； 
				try {
					throw new BackException("添加库存明细的时候报错");
				} catch (BackException e) {
					e.printStackTrace();
				}//抛出异常 
			}
		}
		ErpFdproform f = new ErpFdproform();//得到一个分店采购的对象
		f.setFdproId(fdproId);//把分店采购id放入对象
		f.setFdproIsva(3);//修改状态为等待出库
		fdService.updateByPrimaryKeySelective(f);//修改状态
		return mapper.insertSelective(record);//添加出库单
	}

	@Override
	public ErpOutbank selectByPrimaryKey(String obId) {
		return mapper.selectByPrimaryKey(obId);
	}

	@Override
	public int updateByPrimaryKeySelective(ErpOutbank record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKey(ErpOutbank record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<ErpOutbank> selectAll(Map<String, Object> map) {
		return mapper.selectAll(map);
	}

	@Override
	public int selectAllConut(Map<String, Object> map) {
		return mapper.selectAllConut(map);
	}

}

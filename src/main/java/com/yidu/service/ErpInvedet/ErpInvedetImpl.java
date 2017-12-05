/**
 * 
 */
package com.yidu.service.ErpInvedet;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpInvedetMapper;
import com.yidu.model.ErpInvedet;
import com.yidu.util.Tools;

/**
 * 入库明细烦service的接口
 * @author 大晶儿
 * 2017年12月5日
 */
@Service
public class ErpInvedetImpl implements ErpInvedetService{
	@Resource
	private ErpInvedetMapper mapper;//入库明细的导接口
	
	@Override
	public int deleteByPrimaryKey(String invedetId) {
		return 0;
	}

	@Override
	public int insert(ErpInvedet record) {
		return 0;
	}

	@Override
	public int insertSelective(ErpInvedet record) {
		record.setCreatetime(Tools.getCurDateTime());//得到创建时间
		return mapper.insertSelective(record);
	}

	@Override
	public ErpInvedet selectByPrimaryKey(String invedetId) {
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(ErpInvedet record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(ErpInvedet record) {
		return 0;
	}

}

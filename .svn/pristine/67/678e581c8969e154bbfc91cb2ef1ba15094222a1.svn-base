/**
 * 
 */
package com.yidu.service.ErpImg;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpImgMapper;
import com.yidu.model.ErpImg;

/**
 * 图片
 * @author 大晶儿
 * 2017年10月26日
 */
@Service
public class ErpImgServiceImpl implements ErpImgService{
	@Resource
	private ErpImgMapper mapper; //图片的导
	
	public int insert(ErpImg record) {
		return 0;
	}

	
	public int insertSelective(String imgUrl,String rawId) {
		ErpImg record = new ErpImg();
		record.setImgUrl(imgUrl);
		record.setRawId(rawId);
		return mapper.insertSelective(record);
	}

	
	public int updateImg(ErpImg record) {
		return mapper.updateImg(record);
	}

	
	public List<ErpImg> findImg(Map map) {
		return mapper.findImg(map);
	}

	
	public List<ErpImg> findImgRaw() {
		System.out.println("到达的查询的img-----------------------------------");
		return mapper.findImgRaw();
	}


	@Override
	public int insertSelectiveKin(String imgUrl, String kinId) {
		
		return mapper.insertSelectiveKin(imgUrl, kinId);
	}

}

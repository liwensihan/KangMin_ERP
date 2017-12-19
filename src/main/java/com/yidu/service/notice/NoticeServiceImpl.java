/**
 * 
 */
package com.yidu.service.notice;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpNoticeMapper;
import com.yidu.model.ErpNotice;

/**
 * 公告service接口
 * @author ouyang
 * @dataTime 2017年12月7日18:39:05
 */
@Service
public class NoticeServiceImpl implements NoticeService{
	@Resource
	ErpNoticeMapper noticeDao;//公告dao
	
	@Override
	public List<ErpNotice> findAll(Map<String, Object> map) {
		return noticeDao.findAll(map);
	}

	@Override
	public int findAllSize(Map<String, Object> map) {
		return noticeDao.findAllSize(map);
	}

	@Override
	public ErpNotice findById(String noticeId) {
		return noticeDao.findById(noticeId);
	}

	@Override
	public int insert(ErpNotice notice) {
		return noticeDao.insert(notice);
	}

	@Override
	public int findToDay() {
		return noticeDao.findToDay();
	}

}

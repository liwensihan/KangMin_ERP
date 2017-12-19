/**
 * 
 */
package com.yidu.service.notice;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpNotice;

/**
 * 公告service接口
 * @author ouyang
 * @dataTime 2017年12月7日18:39:05
 */
public interface NoticeService {
	
	/**
     * 查询今天发布的公告数量
     * @return 公告数量
     * @author ouyang
	 * @dataTime 2017年12月9日09:38:55
     */
	public int findToDay();
	
	/**
     * 增加公告
     * @param notice 公告对象
     * @return 影响行数
     * @author ouyang
	 * @dataTime 2017年12月8日09:50:07
     */
    public int insert(ErpNotice notice);
	
	/**
     * 根据公告ID查询公告信息
     * @param noticeId 公告ID
     * @return 公告对象
     * @author ouyang
	 * @dataTime 2017年12月8日08:39:59
     */
	public ErpNotice findById(String noticeId);
	
	/**
     * 查询所有公告
     * @param map 查询参数
     * @return 公告集合
     * @author ouyang
	 * @dataTime 2017年12月7日18:23:10
     */
	public List<ErpNotice> findAll(Map<String,Object> map);
	
	/**
     * 查询所有公告的总行数
     * @param map 查询参数
     * @return 公告集合行数
     * @author ouyang
	 * @dataTime 2017年12月7日18:23:40
     */
	public int findAllSize(Map<String,Object> map);
}

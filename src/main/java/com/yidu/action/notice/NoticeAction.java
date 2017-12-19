/**
 * 
 */
package com.yidu.action.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.common.Tools;
import com.yidu.model.ErpNotice;
import com.yidu.model.ErpStaff;
import com.yidu.service.notice.NoticeService;

/**
 * 公告action
 * @author ouyang
 * @dataTime 2017年12月7日18:39:05
 */
@Controller
@RequestMapping("/notice")
public class NoticeAction {
	@Resource
	NoticeService noticeService;//公告service
	
	/**
     * 查询今天发布的公告数量
     * @return 公告数量
     * @author ouyang
	 * @dataTime 2017年12月9日09:38:55
     */
	@RequestMapping("/findToDay")
	@ResponseBody
	public int findToDay(){
		return noticeService.findToDay();//公告:查询今天发布的公告数量
	}
	
	/**
	 * 增加公告s
	 * @param noticeTitle 公告标题
	 * @param noticeContent 公告正文
	 * @param session HttpSession
	 * @return 影响行数
	 * @author ouyang
	 * @dateTime 2017年12月8日09:51:59
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public int insert(String noticeTitle,String noticeContent,HttpSession session){
		ErpStaff staff=(ErpStaff) session.getAttribute("staff");//得到session人员信息
		ErpNotice notice = new ErpNotice();//实例化公告
		//赋值
		notice.setNoticeId(UUID.randomUUID()+"");//公告ID-随机生产
		notice.setStaId(staff.getStaId());//发送人-人员ID
		notice.setNoticeTitle(noticeTitle);//公告标题
		notice.setNoticeContent(noticeContent);//公告内容
		notice.setNoticeTime(Tools.getCurDateTime());//发送时间-工具类
		notice.setOper(staff.getStaId());//修改人-人员ID
		notice.setOptime(Tools.getCurDateTime());//修改时间-工具类
		notice.setIsva(1);//是否有效-是
		return noticeService.insert(notice);//增加公告(不可为空)
	}
	
	/**
	 * 根据公告ID查询公告对象
	 * @param noticeId 公告ID
	 * @return 公告对象
	 * @author ouyang
	 * @dateTime 2017年12月8日08:42:24
	 */
	@RequestMapping("/findById")
	@ResponseBody
	public ErpNotice findById(String noticeId){
		return noticeService.findById(noticeId);//根据公告ID查询公告信息
	}
	
	/**
	 * 查询所有公告
	 * @param page 当前页数
	 * @param limit 显示行数
	 * @param noticeData 查询参数
	 * @param noticeTime 查询发布时间
	 * @return 公告集合
	 * @author ouyang
	 * @dateTime 2017年12月7日18:43:24
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String,Object> findAll(int page,int limit,String noticeData,String noticeTime){
		Map<String, Object> map = new HashMap<String, Object>();//实例化map
		//map赋值
		map.put("firstRows", limit*(page-1));//开始行数
		map.put("limit", limit);//显示行数
		map.put("noticeData",noticeData);//混合数据
		
		if(noticeTime!=null && !"".equals(noticeTime)){//如果发布时间不为空
			String str[] = noticeTime.split(" "+"-"+" ");//分割字符串发布时间 -
			//map赋值
			map.put("noticeTime_begin", str[0]);//开始时间
			map.put("noticeTime_end", str[1]);//发布时间
		}
		
		List<ErpNotice> data = noticeService.findAll(map);//公告：查询所有
		int count = noticeService.findAllSize(map);//公告：总行数
		
		Map<String,Object> mapResult = new HashMap<String, Object>();//实例化map
		//layui数据表格需要返回的参数
		map.put("count", count);//总行数
		map.put("data", data);//数据
		map.put("code",0);//状态
		map.put("msg", "");//消息
		return map;
	}
}

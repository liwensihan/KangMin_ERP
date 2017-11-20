/**
 * 
 */
package com.yidu.action.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.common.Tools;
import com.yidu.model.ErpMember;
import com.yidu.service.Member.MemberService;
import com.yidu.util.Pages;
import com.yidu.util.SsmMessage;


/**
 * @author dong
 * @da2017年11月2日
 * @version 1.0
 */
@Controller
@RequestMapping("member")
public class MemberAction {

	@Resource
	private MemberService memberService;
	
	/**
	 * 查询所有方法
	 * @param page
	 * @param limit
	 * @param area
	 * @return
	 */
	@RequestMapping("/showList")
	@ResponseBody  //ajax注解
	public Map<String,Object> showList(int page ,int limit,ErpMember member){
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String,Object> pagmap = new HashMap<String, Object>();
		Pages ps=new Pages();
		ps.setCurPage(page);
		ps.setMaxResult(limit);
		pagmap.put("page", ps.getFirstRows());//把页数传到map
		pagmap.put("limit", ps.getMaxResult());//把页数传到map
		System.out.println(member.getMemberName()+"----  "+member.getMemberPhone()+"  "+member.getMemberSex());
		pagmap.put("memberName", member.getMemberName());//姓名
		pagmap.put("memberPhone", member.getMemberPhone());//姓名
		pagmap.put("memberSex", member.getMemberSex());//姓名
		
		List<ErpMember> list =memberService.selectByPrimaryKey(pagmap);
		
		//layui数据表格需要返回的参数
		map.put("count",memberService.findRowCount(pagmap));//总行数
		map.put("data", list);
		map.put("code",0);
		map.put("msg", "");
		return map;
	}
	
	/**
	 * 增加和修改
	 * @param express
	 * @return
	 */
	@RequestMapping("/addOrUpdate")
	@ResponseBody
	public SsmMessage addOrUpdate(ErpMember member){
		SsmMessage mes = new SsmMessage();
		member.setMemberId(member.getMemberId());//ID
		member.setMemberName(member.getMemberName());//姓名
		member.setMemberSex(member.getMemberSex());//性别
		member.setMemberPhone(member.getMemberPhone());//电话
		member.setMemberEmail(member.getMemberEmail());//邮箱
		member.setMemberStauts("1");//是否有效
		
		if(Tools.isEmpty(member.getMemberId())){
			
			member.setMemberStarttime(Tools.getCurDateTime());//当前时间
			int rows=memberService.insert(member);//增加方法
			if(rows>0){
				mes.setMes("操作成功");
				mes.setState(1);
			}else{
				mes.setMes("操作失败");
				mes.setState(0);
			}
			
		}else{
			int rows=memberService.updateByPrimaryKeySelective(member);//修改方法
			if(rows>0){
				mes.setMes("操作成功");
				mes.setState(1);
			}else{
				mes.setMes("操作失败");
				mes.setState(0);
			}
		}
		
		return mes;
		
	}
	
	
	
	/**
	 * 根据ID查询
	 * @param express
	 * @return
	 */
	@RequestMapping("/findById")
	@ResponseBody
	public ErpMember findById(ErpMember member){
		ErpMember e=memberService.select(member.getMemberId());
		return e;
		
	}
	
	/**
	 * 删除方法
	 * @param express
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public SsmMessage delete(ErpMember member){
		member.setMemberStauts("0");//定义0
		int rows = memberService.updateByPrimaryKeySelective(member);//删除方法
		SsmMessage mes = new SsmMessage();
		if(rows>0){
			mes.setMes("操作成功");
			mes.setState(1);
		}else{
			mes.setMes("操作失败");
			mes.setState(0);
		}
		return mes;
	}
}

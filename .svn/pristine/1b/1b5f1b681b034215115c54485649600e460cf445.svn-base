/**
 * 
 */
package com.yidu.action.ErpDrugResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.model.ErpDrugResult;
import com.yidu.model.ErpKinds;
import com.yidu.service.ErpDrugResult.ErpDrugResultService;
import com.yidu.util.BackException;
import com.yidu.util.SsmMessage;

/**
 * 药品药效表
 * @author 大晶儿
 * 2017年10月23日
 */
@Controller
@RequestMapping("ErpDrugResultAction")
public class ErpDrugResultAction {
	@Resource
	private ErpDrugResultService service;
	@RequestMapping("deleteByPrimaryKeySelective")
	@ResponseBody
	public SsmMessage deleteByPrimaryKeySelective(String resId,String kindsId){
		SsmMessage mes = new SsmMessage();
		System.out.println("--------"+kindsId+"-----");
		int rows = service.deleteKindsRes(resId, kindsId);
		if(rows>-1){
			mes.setMes("删除成功");
			mes.setState(1);
		}else{
			mes.setMes("删除失败");
			mes.setState(0);
		}
		return mes;
	}
	/**
	 * 添加药品药效
	 * @param kindId 药品id
	 * @param resId 药效的数组
	 * @return 返回消息类
	 */
	@RequestMapping("insertSelective")
	@ResponseBody
	public SsmMessage insertSelective(String kinId,String[] resId){
		SsmMessage mes = new SsmMessage();
		System.out.println("--------------------------"+kinId+"------------------------------------------");
		try {
			int rows = service.insertSelectiveRuiKind(kinId, resId);
			if(rows>-1){
				mes.setMes("添加成功");
				mes.setState(1);
				return mes;
			}
		} catch (BackException e) {
			e.printStackTrace();
		}
		mes.setMes("添加失败");
		mes.setState(0);
		return mes;
	}
}

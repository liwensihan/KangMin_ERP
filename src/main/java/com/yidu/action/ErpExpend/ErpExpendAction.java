/**
 * 
 */
package com.yidu.action.ErpExpend;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.model.ErpExpend;
import com.yidu.service.ErpExpend.ErpExpendService;
import com.yidu.util.SsmMessage;

/**
 * @author zhangwei
 * 2017年10月19日
 */
@Controller
@RequestMapping("/ErpExpend")
public class ErpExpendAction {
	@Resource
	private ErpExpendService service;
	
}

/**
 * 
 */
package com.yidu.action.ErpIncome;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.model.ErpIncome;
import com.yidu.service.ErpIncome.ErpIncomeService;
import com.yidu.util.SsmMessage;

/**
 * @author zhangwei
 * 2017年10月23日
 */
@Controller
@RequestMapping("/ErpIncome")
public class ErpIncomeAction {
	@Resource
	private ErpIncomeService service;
	
}

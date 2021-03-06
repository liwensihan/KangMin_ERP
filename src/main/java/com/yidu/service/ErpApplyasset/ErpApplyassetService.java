/**
 * 
 */
package com.yidu.service.ErpApplyasset;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.yidu.model.ErpApplyasset;
import com.yidu.model.ErpFinance;

/**
 * @author zhangwei
 * 2017年10月19日
 */
public interface ErpApplyassetService {
	
	/**
	 * 初始化页面显示
	 * 根据选择的年份查询该年份1月-12月份 的支出
	 * @author 胡鑫
	 * @date 2017年11月6日16:00:06
	 * @param date 年份
	 * @return 返回资金申请list
	 */
	public List<ErpApplyasset>applyassetShowList(String date);
	
	/**
	 * 模糊 分页查询全部支出集合
	 * @author 胡鑫
	 * @date 2017年11月9日09:37:15
	 * @param map 分页参数 模糊查询参数
	 * @return 返回支出集合
	 */
	public List<ErpApplyasset>showList(Map<String,Object> map);
	
	/**
	 * 模糊查询全部支出集合
	 * @author 胡鑫
	 * @date 2017年11月9日09:37:15
	 * @param map 模糊查询参数
	 * @return 返回支出集合行数
	 */
	public int findCount(Map<String,Object> map);
	
	/**
	 * 根据资金申请id 增加审核信息
	 * @author 胡鑫
	 * @date 2017年11月14日10:41:42
	 * @param map 存放的参数
	 * @return 返回执行的行数
	 */
	public int auditApplyasset(Map<String, Object> map);
}

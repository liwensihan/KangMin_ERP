/**
 * 
 */
package com.yidu.service.ErpPay;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpApplyasset;
import com.yidu.model.ErpFinance;
import com.yidu.model.ErpPay;

/**
 * @author zhangwei
 * 2017年10月19日
 */
public interface ErpPayService {
	/**
	 * 初始化页面显示
	 * 根据选择的年份查询该年份1月-12月份 的收入
	 * @author 胡鑫
	 * @date 2017年11月8日10:37:34
	 * @param date 年份
	 * @return 返回收入集合
	 */
	public List<ErpPay>showListPrice(String date);
	
	/**
	 * 模糊 分页查询全部收入集合
	 * @author 胡鑫
	 * @date 2017年11月13日14:49:52
	 * @param map 分页参数 模糊查询参数
	 * @return 返回收入集合
	 */
	public List<ErpPay>showList(Map<String,Object> map);
	
	/**
	 * 模糊查询全部收入集合
	 * @author 胡鑫
	 * @date 2017年11月13日14:49:52
	 * @param map 模糊查询参数
	 * @return 返回收入集合行数
	 */
	public int findCount(Map<String,Object> map);
	
	
	/**
     * 选择性添加
     * @param record 类型对象
     * @return 返回类型
     */
    int insertSelective(ErpPay record);
}

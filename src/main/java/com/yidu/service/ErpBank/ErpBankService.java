package com.yidu.service.ErpBank;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpBank;
import com.yidu.model.ErpInvedet;

/**
 * 入库Service
 * @author Gjwen
 * 2017年11月13日-上午8:59:12
 */
public interface ErpBankService {
	/**
	 * 查询显示
	 * @param map
	 * @return
	 */
	List<ErpBank> selectAll(Map<String,Object> map);
	/**
	 * 查询和显示的中行数
	 * @param map 分页和模糊查询的参数
	 * @return int
	 */
	int selectAllConut(Map<String,Object> map);
	 /**
     * 添加
     * @param record 入库对象
     * @return int
     */
    int insertSelective(ErpBank record,List<ErpInvedet> list,String quaId);
    /**
     * 查询单个对象
     * @param bankId 入库id
     * @return 入库对象
     */ 
    ErpBank selectByPrimaryKey(String bankId);
    
    /**
     * 修改入库
     * @param record 入库id
     * @return 入库对象
     */
    int updateByPrimaryKeySelective(ErpBank record);
    /**
	 * 仓库入库审核
	 * @author 胡鑫
	 * @date 2017年12月12日09:44:26
	 * @param bankId 申请id
	 * @param feedback 审核反馈信息
	 * @return 返回消息类
	 */
	int auditBank(Map<String, Object> map);
    
}

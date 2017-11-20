/**
 * 
 */
package com.yidu.service.ErpRaw;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpDrugResult;
import com.yidu.model.ErpRaw;
import com.yidu.util.BackException;

/**
 * 原材料的接口
 * @author 大晶儿
 * 2017年10月21日
 */
public interface ErpRawService {
	/**
	 * 删除
	 * @param rawId 原材料id
	 * @return 返回int
	 */
    int deleteByPrimaryKey(ErpRaw record);
    /**
     * 天剑
     * @param record 原材料对象 
     * @return 返回int
     */
    int insert(ErpRaw record);
    /**
     * 选择添加
     * @param record 原材料对象
     * @return 返回int
     */
    int insertSelective(ErpRaw record,List<ErpDrugResult> res)throws BackException;
    /**
     * 查询单个对象
     * @param rawId
     * @return
     */
    List<ErpRaw> selectByPrimaryKey(String rawId);
    /**
     * 选择修改
     * @param record 原材料对象
     * @return 返回int
     */
    int updateByPrimaryKeySelective(ErpRaw record,List<ErpDrugResult> res)throws BackException;
    /**
     * 修改全部
     * @param record 原材料对象
     * @return 返回int
     */
    int updateByPrimaryKey(ErpRaw record);
    
    /**
     * 得到所有类型
     * @return
     */
	List<ErpRaw> findListRaw();
	/**
	 * 模糊查询
	 * @param price 值
	 * @return type对象的集合
	 */
	List<ErpRaw> findDimRaw(Map<String,Object> map);
	/**
	 * 查询原材料
	 * @return
	 */
	List<ErpRaw> findRawList();
}

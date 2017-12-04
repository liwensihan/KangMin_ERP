/**
 * 
 */
package com.yidu.service.ErpQuality;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpQuality;
import com.yidu.model.ErpQualityDetail;
import com.yidu.util.BackException;

/**
 * 质检的service
 * @author 大晶儿
 * @Date 2017年11月10日
 */
public interface ErpQualityService {
	/**
	 *删除
	 * @param quaId 质检id
	 * @return 返回int
	 */
    int deleteByPrimaryKey(String quaId);
    /**
     * 添加
     * @param record 质检对象
     * @return int
     */
    int insert(ErpQuality record);
    /**
     * 选择添加
     * @param record
     * @return
     */
    int insertSelective(ErpQuality record);
    /**
     * 查询单个对象
     * @param quaId 质检id
     * @return 质检对象
     */
    ErpQuality selectByPrimaryKey(Map<String,Object> map);
    /**
     * 修改
     * @param record 质检对象
     * @return int
     */
    int updateByPrimaryKeySelective(ErpQuality record,List<ErpQualityDetail> detlist) throws BackException;
    /**
     * 选择修改
     * @param record 质检对象
     * @return int
     */
    int updateByPrimaryKey(ErpQuality record);
    /**
     * 查询质检对象
     * @param map 参数
     * @return 质检对象集合
     */
    List<ErpQuality> selectByPrimaryNew(Map<String,Object> map);
    /**
     * 查询质检对象的总行数
     * @param map 参数
     * @return int
     */
    int selectByPrimaryNewCount(Map<String,Object> map);
}

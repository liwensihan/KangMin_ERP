package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpQuality;
/**
 * 质检表的导
 * @author 大晶儿
 * @Date 2017年11月10日
 */
public interface ErpQualityMapper {
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
    ErpQuality selectByPrimaryKey(String quaId);
    /**
     * 修改
     * @param record 质检对象
     * @return int
     */
    int updateByPrimaryKeySelective(ErpQuality record);
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
    /**
     * 查询编号
     * @param data 当前时间
     * @return 今天最大的编号
     */
   String  selectSerial(String data);
}
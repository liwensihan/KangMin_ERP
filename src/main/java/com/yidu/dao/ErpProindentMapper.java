package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpProindent;
/**
 * 生产dao
 * @author dong
 * 2017年11月13日-上午10:43:25
 */
public interface ErpProindentMapper {
    int deleteByPrimaryKey(String indentId);

    //根据ID修改生产状态 
    int updateId(Map<String, Object> map);
    
    //订单明细总行数
    int findcount(String indentId);
    
   //查询产品，订单，订单明细，订单生产日志，订单生产日志明细，根据订单ID查询
    List<Map<String, Object>> findByshow(Map<String, Object> map);
    
    //下拉框查询
    List<ErpProindent> findStation();
    
    
    //根据订单ID查询商品，下拉框 
    List<Map<String, Object>> findStationid(String indentId);
    
    //增加方法
    int insert(ErpProindent record);

    //总行数
    int findRowCount(Map<String, Object> map);
    
    int insertSelective(ErpProindent record);

    //查询所有
    List<ErpProindent> selectByPrimaryKey(Map<String, Object> map);
    /**
     * 根据订单id查询单个对象
     * @param indentId 订单id
     * @return 返回药品对象
     */
    List<Map<String, Object>> selectByPrimaryProid(String indentId);
    
    List<ErpProindent> showPro(Map<String, Object> map);
    //修改或删除
    int updateByPrimaryKeySelective(ErpProindent record);

    //根据订单id查询明细，和商品表
    List<Map<String, Object>> selectByPrimaryKeyid(String indentId);
    
    
  //根据订单id查询明细，和商品表查看明细
    List<Map<String, Object>> showid(String indentId);
    
    int updateByPrimaryKey(ErpProindent record);

    /**
     * 查询ID
     * @param indentId
     * @return
     */
    ErpProindent findById(String indentId);

}
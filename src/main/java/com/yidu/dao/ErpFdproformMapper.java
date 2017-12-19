package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpFdproform;

public interface ErpFdproformMapper {
    int deleteByPrimaryKey(String fdproId);

    int insert(ErpFdproform record);

    int insertSelective(ErpFdproform record);

    ErpFdproform selectByPrimaryKey(String fdproId);

    int updateByPrimaryKeySelective(ErpFdproform record);

    int updateByPrimaryKey(ErpFdproform record);
    
    List<ErpFdproform>findAll(Map<String, Object>map);
    
    int findRowCount (Map<String, Object>map);
    
    int deleteFdpro(String id);
    
    List<ErpFdproform>ratifyFindAll(Map<String, Object>map);
    
    int ratifyFindAllCout (Map<String, Object>map);
    
    int updateThrough(String id);
    
    int noThrough(String id);
    
    int updateValue(ErpFdproform record);
}
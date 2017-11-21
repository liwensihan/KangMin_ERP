package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpAnnex;

public interface ErpAnnexMapper {
	/**
     * 查询所有分站
     * @return 分站集合
     * @author 欧阳丰
	 * @date 2017年11月16日08:48:35
	 * @version 1.1
     */
	public List<ErpAnnex> findAll(Map<String,Object> map);
	
	/**
     * 查询所有分站的总行数
     * @return 分站集合
     * @author 欧阳丰
	 * @date 2017年11月16日08:48:35
	 * @version 1.1
     */
	public int findAllSize(Map<String,Object> map);
	
    int deleteByPrimaryKey(String annexId);

    int insert(ErpAnnex record);
    
    /**
     * 增加分站
     * @return 影响行数
     * @author 欧阳丰
	 * @date 2017年11月16日14:33:04
	 * @version 1.1
     */
    public int insertSelective(ErpAnnex record);
    /**
     * 根据分店ID查询分店
     * @return 分店对象
     * @author ouyang
	 * @date 2017年11月16日15:29:51
	 * @version 1.1
     */
    public ErpAnnex selectByPrimaryKey(String annexId);
    
    /**
     * 修改分店信息
     * @return 影响行数
     * @author ouyang
	 * @date 2017年11月16日15:44:10
	 * @version 1.1
     */
    public int updateByPrimaryKeySelective(ErpAnnex record);

    int updateByPrimaryKey(ErpAnnex record);
    
    /**
     * 查询所有isva为1的数据
     * @return
     */
    public List<ErpAnnex> getAnnex();
}
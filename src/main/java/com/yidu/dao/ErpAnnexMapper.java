package com.yidu.dao;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpAnnex;
/**
 * 分店表
 * @author ouyang
 * @data 2017年11月16日
 */
public interface ErpAnnexMapper {
	
	/**
	 * 增加分店的总资产
	 * @param annex
	 * @return 影响行数
	 * @author ouyang
	 * @date 2017年11月24日11:52:21
	 */
	public int updateAnnexPriceAdd(ErpAnnex annex);
	
	/**
     * 查询所有分站
     * @return 分站集合
     * @author ouyang
	 * @date 2017年11月16日08:48:35
     */
	public List<ErpAnnex> findAll(Map<String,Object> map);
	
	/**
     * 查询所有分站的总行数
     * @return 分站集合
     * @author ouyang
	 * @date 2017年11月16日08:48:35
     */
	public int findAllSize(Map<String,Object> map);
	
    int deleteByPrimaryKey(String annexId);

    int insert(ErpAnnex record);
    
    /**
     * 增加分站
     * @return 影响行数
     * @author 欧阳丰
	 * @date 2017年11月16日14:33:04
     */
    public int insertSelective(ErpAnnex record);
    /**
     * 根据分店ID查询分店
     * @return 分店对象
     * @author ouyang
	 * @date 2017年11月16日15:29:51
     */
    public ErpAnnex selectByPrimaryKey(String annexId);
    
    /**
     * 修改分店信息
     * @return 影响行数
     * @author ouyang
	 * @date 2017年11月16日15:44:10
     */
    public int updateByPrimaryKeySelective(ErpAnnex record);

    int updateByPrimaryKey(ErpAnnex record);
    
    /**
     * 查询所有isva为1的数据
     * @return
     */
    public List<ErpAnnex> getAnnex();
    /**
     * 初始化加载分店销售统计图
     * @author 胡鑫
     * @date 2017年12月7日14:04:47
     * @param parMap sql参数
     * @return 返回map集合
     */
	public List<ErpAnnex> showChar(Map<String, Object> parMap);
}
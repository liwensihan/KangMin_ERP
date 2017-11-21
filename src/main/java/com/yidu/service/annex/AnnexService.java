/**
 * 
 */
package com.yidu.service.annex;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpAnnex;

/**
 * 分店service接口
 * @author ouyang
 * @data 2017年11月16日10:39:49
 */
public interface AnnexService {
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
    public ErpAnnex findById(String annexId);
    
    /**
     * 修改分店信息
     * @return 影响行数
     * @author ouyang
	 * @date 2017年11月16日15:44:10
	 * @version 1.1
     */
    public int updateByPrimaryKeySelective(ErpAnnex record);
    
    
    
    /**
     * 查询所有isva为1的数据
     * @return
     */
    public List<ErpAnnex> getAnnex();
}

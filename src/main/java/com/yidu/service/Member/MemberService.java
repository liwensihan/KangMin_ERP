/**
 * 
 */
package com.yidu.service.Member;

import java.util.List;
import java.util.Map;

import com.yidu.model.ErpMember;

/**
 * @author zq
 * @date 2017年11月2日
 * @version 1.0
 */
public interface MemberService {
	
	/**
	 * 查询所有
	 * @param map
	 * @return
	 */
	List<ErpMember>  selectByPrimaryKey(Map<String, Object> map);

	/**
	 * 增加
	 * @param record
	 * @return
	 */
	int insert(ErpMember record);
	
	/**
	 * 根据ID查询
	 * @param memberId
	 * @return
	 */
    ErpMember select(String memberId);
    
    /**
     * 修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ErpMember record);

    /**
     * 总行数
     * @param map
     * @return
     */
    int findRowCount(Map<String, Object> map);
}

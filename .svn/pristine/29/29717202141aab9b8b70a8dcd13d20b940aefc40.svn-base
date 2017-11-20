/**
 * 
 */
package com.yidu.service.Member;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpMemberMapper;
import com.yidu.model.ErpMember;

/**
 * @author dong
 * @da2017年11月2日
 * @version 1.0
 */
@Service
public class MemberServiceImpl implements MemberService{

	@Resource
	private ErpMemberMapper erpMemberMapper;
	
	
	/**
	 * 查询所有
	 */
	@Override
	public List<ErpMember> selectByPrimaryKey(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return erpMemberMapper.selectByPrimaryKey(map);
	}


	/**
	 * 增加
	 */
	@Override
	public int insert(ErpMember record) {
		// TODO Auto-generated method stub
		return erpMemberMapper.insert(record);
	}


	/**
	 * 根据ID查询
	 */
	@Override
	public ErpMember select(String memberId) {
		// TODO Auto-generated method stub
		return erpMemberMapper.select(memberId);
	}


	/**
	 * 修改
	 */
	@Override
	public int updateByPrimaryKeySelective(ErpMember record) {
		// TODO Auto-generated method stub
		return erpMemberMapper.updateByPrimaryKeySelective(record);
	}


	/**
	 * 总行数
	 */
	@Override
	public int findRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return erpMemberMapper.findRowCount(map);
	}

}

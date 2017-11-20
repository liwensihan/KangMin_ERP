/**
 * XLe1丶
 * 2017年10月19日 2017年8月1日16:02:52
 */
package com.yidu.service.ErpApply;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpApplyMapper;
import com.yidu.model.ErpApply;

/**
 * 实现供货商接口
 * @author Gjwen
 * 2017年10月30日-下午2:07:24
 */
@Service
public class ErpApplyServiceImpl implements ErpApplyService{
	@Resource
	private ErpApplyMapper mapper;

	public List<ErpApply> findErpApply() {
		System.out.println("到达service");
		List<ErpApply>  list = mapper.findErpApply();
		return list;
	}
	/**
	 * 集合查询所有供货商
	 */
	@Override
	public List<ErpApply> selectAll(Map<String, Object> map) {
		System.out.println("到了查询供货商");
		return mapper.selectAll(map);
	}
	/**
	 * 根据Id删除 修改状态
	 */
	@Override
	public int delete(ErpApply isva) {
		return mapper.delete(isva);
	}
	/**
	 * 根据ID查询
	 */
	@Override
	public ErpApply selectByPrimaryKey(String applyId) {
		return mapper.selectByPrimaryKey(applyId);
	}
	/**
	 * 增加
	 */
	@Override
	public int insert(ErpApply record) {
		return mapper.insert(record);
	}
	/**
	 * 编辑
	 */
	@Override
	public int updateByPrimaryKeySelective(ErpApply applyId) {
		return mapper.updateByPrimaryKeySelective(applyId);
	}
	/**
	 * 分页
	 */
	@Override
	public int applyFindRows(Map<String, Object> map) {
		return mapper.applyFindRows(map);
	}
	

}

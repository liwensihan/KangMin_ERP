/**
 * 
 */
package com.yidu.service.Proindent;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.common.Tools;
import com.yidu.dao.ErpAuditMapper;
import com.yidu.dao.ErpProindentMapper;
import com.yidu.model.ErpAudit;
import com.yidu.model.ErpProindent;

/**
 * 订单表service接口
 * @author dong
 * @da2017年11月6日
 * @version 1.0
 */
@Service
public class ProindentServiceImpl implements ProindentService{
	
	@Resource
	private ErpProindentMapper erpProindentMapper;
	@Resource
	private ErpAuditMapper auditMapper;//审核mapper
	/**
	 * 增加方法
	 */
	@Override
	public int insert(ErpProindent record) {
		// TODO Auto-generated method stub
		return erpProindentMapper.insert(record);
	}

	/**
	 * 查询所有
	 */
	@Override
	public List<ErpProindent> selectByPrimaryKey(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return erpProindentMapper.selectByPrimaryKey(map);
	}

	/**
	 * 总行数
	 */
	@Override
	public int findRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return erpProindentMapper.findRowCount(map);
	}

	/**
	 * 删除或修改
	 */
	@Override
	public int updateByPrimaryKeySelective(ErpProindent record) {
		// TODO Auto-generated method stub
		return erpProindentMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 根据订单id查询明细，和商品表
	 */
	@Override
	public List<Map<String, Object>> selectByPrimaryKeyid(String indentId) {
		// TODO Auto-generated method stub
		return erpProindentMapper.selectByPrimaryKeyid(indentId);
	}
	/**
	 * 根据订单id查询明细，和商品表查看明细
	 */
	@Override
	public List<Map<String, Object>> showid(String indentId) {
		// TODO Auto-generated method stub
		return erpProindentMapper.showid(indentId);
	}

	/**
	 * 下拉框查询
	 */
	public List<ErpProindent> findStation() {
		// TODO Auto-generated method stub
		return erpProindentMapper.findStation();
	}

	
	/**
	  * 根据订单ID查询商品，下拉框 
	  * @return
	  */
	@Override
	public List<Map<String, Object>> findStationid(String indentId) {
		// TODO Auto-generated method stub
		return erpProindentMapper.findStationid(indentId);
	}
	
	@Override
	public List<ErpProindent> showPro(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return erpProindentMapper.showPro(map);
		
		
	}
	
	public List<Map<String, Object>> selectByPrimaryProid(String indentId) {
		return erpProindentMapper.selectByPrimaryProid(indentId);
	}

	@Override
	public ErpProindent findById(String indentId) {
		// TODO Auto-generated method stub
		return erpProindentMapper.findById(indentId);
	}

	/**
	 * 查询产品，订单，订单明细，订单生产日志，订单生产日志明细，根据订单ID查询
	 */
	@Override
	public List<Map<String, Object>> findByshow(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return erpProindentMapper.findByshow(map);
	}

	/**
	 * 订单明细总行数
	 */
	@Override
	public int findcount(String indentId) {
		// TODO Auto-generated method stub
		return erpProindentMapper.findcount(indentId);
	}

	/**
	 * 根据ID修改生产状态
	 */
	@Override
	public int updateId(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return erpProindentMapper.updateId(map);
	}

	/**
	 * 订单日志查询,根据商品，订单，日志，日志明细
	 */
	@Override
	public List<Map<String, Object>> findByrz(String indentId) {
		// TODO Auto-generated method stub
		return erpProindentMapper.findByrz(indentId);
	}

	 /**
	  * 订单明细，商品，配方，原材料，查询配方 
	  * @param indentId
	  * @return
	  */
	@Override
	public List<Map<String, Object>> showpf(String indentId) {
		// TODO Auto-generated method stub
		return erpProindentMapper.showpf(indentId);
	}

	@Override
	public ErpProindent showidQualit(String indentId) {
		return erpProindentMapper.showidQualit(indentId);
	}
	/**
	 * 生产订单审核
	 * @author 胡鑫
	 * @date 2017年11月30日09:33:52
	 * @param map 生产订单id 审核状态 回馈信息 
	 * @return 返回执行的行数
	 */
	@Override
	public int auditPpoindent(Map<String, Object> map) {
		String indentId = (String) map.get("indentId");//得到生产订单id
		String feedBack = (String) map.get("feedBack");//得到反馈信息
		String state = (String) map.get("state");//得到审核转台 0未通过 2通过 
		
		ErpAudit audit = new ErpAudit();//定义一个审核实体类
		audit.setBusinessId(indentId);//生产订单id
		audit.setFeedBack(feedBack);//设置反馈信息
		audit.setAudTime(Tools.getCurDateTime());//设置审核时间
		audit.setIsva(1);//设置是否有效
		audit.setState(Integer.valueOf(state));//设置审核状态  0未通过 2通过
		auditMapper.insertSelective(audit);//执行审核表增加
		return erpProindentMapper.auditPpoindent(map);
	}
}
	
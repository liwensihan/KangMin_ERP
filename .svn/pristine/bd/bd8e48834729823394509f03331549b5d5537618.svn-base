/**
 * XLe1丶
 * 2017年10月24日 2017年8月1日16:02:52
 */
package com.yidu.service.ErpDepa;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpDepaMapper;
import com.yidu.model.ErpDepa;

/**
 * @author XLe1丶
 * 2017年10月24日
 */
@Service
public class ErpDepaServiceImpl implements ErpDepaService{

	@Resource
	private ErpDepaMapper dao;// 部门dao
	
	/**
	 * 得到部门
	 */
	public List<ErpDepa> getDepa() {
		return dao.getDepa();
	}
	/**
     * 模糊、分页查询部门集合
     * @author 胡鑫
     * @date 2017年10月30日09:00:55
     * @param map map集合 用于存放分页对象 搜索对象....
     * @return 返回部门集合
     */
	@Override
	public List<ErpDepa> depaFindList(Map<String, Object> map) {
		List<ErpDepa> list = dao.depaFindList(map);//查询部门集合 返回list集合
		
		
		return list;
	}
	/**
     * 模糊部门集合   行数
     * @author 胡鑫
     * @date 2017年10月30日09:00:55
     * @param map map集合 用于存放 搜索对象....
     * @return 返回部门集合
     */
	@Override
	public int depaFindListRows(Map<String, Object> map) {
		int rows = dao.depaFindListRows(map);
		return rows;
	}
	/**
     * 部门增加
     * @author 胡鑫
     * @date 2017年10月30日15:34:49
     * @param record 部门实体类
     * @return 返回执行的行数
     */
	@Override
	public int insertSelective(ErpDepa record) {
		return dao.insertSelective(record);
	}
	/**
     * 根据部门id查询部门信息
     * @author 胡鑫
     * @date 2017年10月31日09:25:12
     * @param depaId 部门id
     * @return 返回部门类
     */
	@Override
	public ErpDepa selectByPrimaryKey(String depaId) {
		return dao.selectByPrimaryKey(depaId);
	}
	/**
     * 根据部门id修改部门信息
     * @author 胡鑫
     * @date 2017年10月31日15:30:25
     * @param record 部门对象
     * @return 返回执行的行数
     */
	@Override
	public int updateByPrimaryKeySelective(ErpDepa record) {
		return dao.updateByPrimaryKeySelective(record);
	}
	
	/**
     * 根据部门id删除该部门(修改该部门状态isva为1)
     * @author 胡鑫
     * @date 2017年11月1日11:43:30
     * @param depaId 部门id
     * @return 返回执行的行数
     */
	@Override
    public int deleteByDepaId(String depaId){
		return dao.deleteByDepaId(depaId);
	}
}

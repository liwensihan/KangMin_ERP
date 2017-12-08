/**
 * 
 */
package com.yidu.service.annex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.druid.sql.visitor.functions.Substring;
import com.yidu.dao.ErpAnnexMapper;
import com.yidu.model.ErpAnnex;
import com.yidu.model.ErpApplyasset;
import com.yidu.util.Tools;

/**
 * 分店service实现接口
 * @author ouyang
 * @data 2017年11月16日10:39:49
 */
@Service
public class AnnexServiceImpl implements AnnexService{
	
	@Resource
	ErpAnnexMapper dao;

	@Override
	public List<ErpAnnex> findAll(Map<String, Object> map) {
		return dao.findAll(map);
	}

	@Override
	public int findAllSize(Map<String, Object> map) {
		return dao.findAllSize(map);
	}

	@Override
	public int insertSelective(ErpAnnex record) {
		return dao.insertSelective(record);
	}

	@Override
	public ErpAnnex findById(String annexId) {
		return dao.selectByPrimaryKey(annexId);
	}

	@Override
	public int updateByPrimaryKeySelective(ErpAnnex record) {
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<ErpAnnex> getAnnex() {
		return dao.getAnnex();
	}
	/**
     * 初始化加载分店销售统计图
     * @author 胡鑫
     * @date 2017年12月7日14:04:47
     * @param parMap sql参数
     * @return 返回map集合
     */
	@Override
	public Map<String, Object> showChar(Map<String, Object> parMap) {
		Map<String, Object> map = new HashMap<String,Object>();//定义一个map集合用于返回数据
		String year = (String) parMap.get("year");//年份
		String month = (String) parMap.get("month");//月份
		List<List>listFour = new ArrayList<List>();
		List<ErpAnnex>list = getAnnex();//得到所有的分店集合
		
		if(Tools.isEmpty(year)){//判断是否为空
			
		}else{
			for (int k=0;k<list.size();k++) {
				ErpAnnex erpAnnex = (ErpAnnex) list.get(k);
				parMap.put("annexId", erpAnnex.getAnnexId());//设置分店id
				List<ErpAnnex>listThree = new ArrayList<ErpAnnex>();//定义一个list集合用于对应统计图需要的数据
				List<ErpAnnex> list2 = dao.showChar(parMap);
				for(int i=1;i<=12;i++){//循环12月 用于判断取出的值有无该月份
					ErpAnnex annex = new ErpAnnex();//定义一个分店实体类
					if(Tools.isEmpty(list2)){//判断字符串是否为空 
						annex.setAnnexName(erpAnnex.getAnnexName().substring(erpAnnex.getAnnexName().length()-4,erpAnnex.getAnnexName().length()));
					}else{
						for (Iterator iterator2 = list2.iterator(); iterator2.hasNext();) {
							ErpAnnex erpAnnex2 = (ErpAnnex) iterator2.next();
							if(i<10){
								if(erpAnnex2.getAnnexTime().equals("0"+i)){
									annex.setAnnexTime(erpAnnex2.getAnnexTime());
									annex.setAnnexNumber(erpAnnex2.getAnnexNumber());
									annex.setAnnexName(erpAnnex.getAnnexName().substring(erpAnnex.getAnnexName().length()-4,erpAnnex.getAnnexName().length()));
									break;
								}else{
									annex.setAnnexTime("0"+i);
									annex.setAnnexNumber("0");
									annex.setAnnexName(erpAnnex.getAnnexName().substring(erpAnnex.getAnnexName().length()-4,erpAnnex.getAnnexName().length()));
								}
							}else{
								if(erpAnnex2.getAnnexTime().equals(""+i)){
									annex.setAnnexTime(erpAnnex2.getAnnexTime());
									annex.setAnnexNumber(erpAnnex2.getAnnexNumber());	
									annex.setAnnexName(erpAnnex.getAnnexName().substring(erpAnnex.getAnnexName().length()-4,erpAnnex.getAnnexName().length()));
									break;
								}else{
									annex.setAnnexTime(""+i);
									annex.setAnnexNumber("0");
									annex.setAnnexName(erpAnnex.getAnnexName().substring(erpAnnex.getAnnexName().length()-4,erpAnnex.getAnnexName().length()));
								}
							}
						}
					}
					listThree.add(annex);
				}
				
				listFour.add(listThree);
				map.put("listFour", listFour);//map中放入list集合
				map.put("count", list.size());//list大小
				map.put("erpAnnexList", list);//map中放入分店集合
			}
		}
		return map;
	}
	
}

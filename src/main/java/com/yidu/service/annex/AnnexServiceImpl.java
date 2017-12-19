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
	public Map<String, Object> showShouChar(Map<String, Object> parMap) {
		Map<String, Object> map = new HashMap<String,Object>();//定义一个map集合用于返回数据
		String year = (String) parMap.get("year");//年份
		String month = (String) parMap.get("month");//月份
		List<List>listFour = new ArrayList<List>();
		List<ErpAnnex>list = getAnnex();//得到所有的分店集合
		
		if(Tools.isEmpty(year)){//判断是否为空
			String[] years = month.substring(1,month.length()-1).split("-");//将年份和月份分割 
			int date = 0;
			
			switch(years[1]){
				case "1":date=31;
				case "3":date=31;
				case "5":date=31;
				case "7":date=31;
				case "8":date=31;
				case "10":date=31;
				case "12":date=31;
				case "2":
					if(Tools.isLeapYear(Integer.valueOf(years[0]))){//传入的年份 判断是否为闰年 返回true
						date=29;
					}else{
						date=28;
					};
				case "4":date=30;
				case "6":date=30;
				case "9":date=30;
				case "11":date=30;
			}
			String []dates= new String[date];
			System.out.println(month+"      "+date+"        "+years[1]);
			for (int k=0;k<list.size();k++) {//循环得到分店集合大小
				ErpAnnex erpAnnex = (ErpAnnex) list.get(k);//得到索引的分店对象
				parMap.put("annexId", erpAnnex.getAnnexId());//设置分店id
				List<ErpAnnex>listThree = new ArrayList<ErpAnnex>();//定义一个list集合用于对应统计图需要的数据
				List<ErpAnnex> list2 = dao.showShouChar(parMap);//进行统计sql查询方法
				
				for(int i=1;i<=date;i++){
					
					dates[i-1]=i+"";
					getShouru(erpAnnex, listThree, list2, i);//调用本类封装重复代码
				}
				listFour.add(listThree);
				map.put("listFour", listFour);//map中放入list集合
				map.put("count", list.size());//list大小
				map.put("erpAnnexList", list);//map中放入分店集合
			}
			map.put("date", dates);
		}else{
			for (int k=0;k<list.size();k++) {
				ErpAnnex erpAnnex = (ErpAnnex) list.get(k);
				parMap.put("annexId", erpAnnex.getAnnexId());//设置分店id
				List<ErpAnnex>listThree = new ArrayList<ErpAnnex>();//定义一个list集合用于对应统计图需要的数据
				List<ErpAnnex> list2 = dao.showShouChar(parMap);
				for(int i=1;i<=12;i++){//循环12月 用于判断取出的值有无该月份
					getShouru(erpAnnex, listThree, list2, i);//调用本类封装重复代码
				}
				
				listFour.add(listThree);
				map.put("listFour", listFour);//map中放入list集合
				map.put("count", list.size());//list大小
				map.put("erpAnnexList", list);//map中放入分店集合
			}
			String[]date = {"一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"};
			map.put("date", date);
		}
		return map;
	}
	
	
	/**
     * 初始化加载分店支出统计图
     * @author 胡鑫
     * @date 2017年12月7日14:04:47
     * @param parMap sql参数
     * @return 返回map集合
     */
	@Override
	public Map<String, Object> showZhiChar(Map<String, Object> parMap) {
		Map<String, Object> map = new HashMap<String,Object>();//定义一个map集合用于返回数据
		String year = (String) parMap.get("year");//年份
		String month = (String) parMap.get("month");//月份
		List<List>listFour = new ArrayList<List>();
		List<ErpAnnex>list = getAnnex();//得到所有的分店集合
		
		if(Tools.isEmpty(year)){//判断是否为空
			String[] years = month.substring(1,month.length()-1).split("-");//将年份和月份分割 
			int date = 0;
			
			switch(years[1]){
				case "1":date=31;
				case "3":date=31;
				case "5":date=31;
				case "7":date=31;
				case "8":date=31;
				case "10":date=31;
				case "12":date=31;
				case "2":
					if(Tools.isLeapYear(Integer.valueOf(years[0]))){//传入的年份 判断是否为闰年 返回true
						date=29;
					}else{
						date=28;
					};
				case "4":date=30;
				case "6":date=30;
				case "9":date=30;
				case "11":date=30;
			}
			String []dates= new String[date];
			System.out.println(month+"      "+date+"        "+years[1]);
			for (int k=0;k<list.size();k++) {//循环得到分店集合大小
				ErpAnnex erpAnnex = (ErpAnnex) list.get(k);//得到索引的分店对象
				parMap.put("annexId", erpAnnex.getAnnexId());//设置分店id
				List<ErpAnnex>listThree = new ArrayList<ErpAnnex>();//定义一个list集合用于对应统计图需要的数据
				List<ErpAnnex> list2 = dao.showZhiChar(parMap);//进行统计sql查询方法
				
				for(int i=1;i<=date;i++){
					
					dates[i-1]=i+"";
					getShouru(erpAnnex, listThree, list2, i);//调用本类封装重复代码
				}
				listFour.add(listThree);
				map.put("listFour", listFour);//map中放入list集合
				map.put("count", list.size());//list大小
				map.put("erpAnnexList", list);//map中放入分店集合
			}
			map.put("date", dates);
		}else{
			for (int k=0;k<list.size();k++) {
				ErpAnnex erpAnnex = (ErpAnnex) list.get(k);
				parMap.put("annexId", erpAnnex.getAnnexId());//设置分店id
				List<ErpAnnex>listThree = new ArrayList<ErpAnnex>();//定义一个list集合用于对应统计图需要的数据
				List<ErpAnnex> list2 = dao.showZhiChar(parMap);
				for(int i=1;i<=12;i++){//循环12月 用于判断取出的值有无该月份
					getShouru(erpAnnex, listThree, list2, i);//调用本类封装重复代码
				}
				
				listFour.add(listThree);
				map.put("listFour", listFour);//map中放入list集合
				map.put("count", list.size());//list大小
				map.put("erpAnnexList", list);//map中放入分店集合
			}
			String[]date = {"一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"};
			map.put("date", date);
		}
		return map;
	}
	
	
	//重复代码封装调用
	private void getShouru(ErpAnnex erpAnnex, List<ErpAnnex> listThree, List<ErpAnnex> list2, int i) {
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
	
	
	
}

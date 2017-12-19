/**
 * 
 */
package com.yidu.service.sctockmp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpAnnexMapper;
import com.yidu.dao.ErpAuditMapper;
import com.yidu.dao.ErpLedgyrMapper;
import com.yidu.dao.ErpSctockmpDetailMapper;
import com.yidu.dao.ErpSctockmpMapper;
import com.yidu.dao.ErpSumstockMapper;
import com.yidu.model.ErpAnnex;
import com.yidu.model.ErpAudit;
import com.yidu.model.ErpLedgyr;
import com.yidu.model.ErpSctockmp;
import com.yidu.model.ErpSctockmpDetail;
import com.yidu.model.ErpStaff;
import com.yidu.util.Tools;

/**
 * 分店销售订单service实现接口
 * @author ouyang
 * @dataTime 2017年11月23日16:30:36
 */
@Service
public class SctockmpServiceImpl implements SctockmpService{
	@Resource
	ErpSctockmpMapper sctockmpDao;//分店销售订单
	@Resource
	ErpSctockmpDetailMapper sctockmpDetailDao;//分店销售订单明细
	@Resource
	ErpSumstockMapper sumstockDao;//分店库存表
	@Resource
	ErpLedgyrMapper ledgyrDao;//分店财务
	@Resource
	ErpAnnexMapper annexDao;//分店表
	@Resource
	ErpAuditMapper auditDao;//审核表

	@Override
	public int addSctockmp(ErpSctockmp sctockmp, List<ErpSctockmpDetail> list) {
		//增加销售订单
		int row1 = sctockmpDao.insertSelective(sctockmp);//订单:增加(可以为空)
		//增加销售订单明细
		int row2 = sctockmpDetailDao.addSctockmpDetailList(list);//订单明细:批量增加销售订单明细
		//如果为零售(则需减库存，增加财务)
		if(sctockmp.getSaleIfWholesale()==0){//如果销售订单对象的是否批发 等于零的时候
			//减库存
			List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();//实例化一个map集合
			for(int i =0;i<list.size();i++){//循环分店销售订单明细集合
				Map<String, Object> map = new HashMap<String, Object>();//实例化map集合
				map.put("annexId",sctockmp.getAnnexId());//map赋值-分店ID-订单中的分店ID
				map.put("kinId",list.get(i).getKinId());//map赋值-商品ID-明细订单集合第i个中的商品ID
				map.put("kmpNum",list.get(i).getKmpNum());//map赋值-商品数量-明细订单集合第i个中的商品数量
				mapList.add(map);//把map加入到map集合
			}
			int row3 = sumstockDao.updateStockSuount(mapList);//分店库存：批量减少库存(根据分店ID和商品ID减少)
			if(row3<1){//如果减少库存的影响行数小于1
				return 0;//返回0
			}
			
			//增加财务(先增加分店收入明细，再增加分店表的总资产)
			/*  增加分店收入明细  */
			ErpLedgyr ledgyr = new ErpLedgyr();//实例化一个分店财务模型
			ledgyr.setGyrId(UUID.randomUUID()+"");//赋值-分店财务ID-随机生成
			ledgyr.setSaleId(sctockmp.getSaleId());//赋值-分店销售ID
			ledgyr.setAnnexId(sctockmp.getAnnexId());//赋值-分店ID-订单中的分店ID
			ledgyr.setGyrSreial(UUID.randomUUID()+"");//赋值-分店支出收入编号-随机生成
			ledgyr.setGyrPrice(sctockmp.getSaleMoney1());//赋值-分店支出金钱-订单中的应付金额
			ledgyr.setCreater(sctockmp.getCreater());//赋值-创建人-订单中的创建人
			ledgyr.setCreatetime(sctockmp.getCreatetime()+"");//赋值-创建时间-订单中的创建时间
			int row4 = ledgyrDao.insertSelective(ledgyr);//分店财务：增加(可以为空)
			if(row4<1){//如果增加的影响行数小于1
				return 0;
			}
			
			/*  增加分店表的总资产  */
			ErpAnnex annex = new ErpAnnex();//实例化一个分店模型
			annex.setAnnexId(sctockmp.getAnnexId());//分店赋值-分店ID-订单中的分店ID
			annex.setAnnexPrice(sctockmp.getSaleMoney1());//分店赋值-分店总资产-订单中的应付金额
			int row5 = annexDao.updateAnnexPriceAdd(annex);//分店：增加分店的总资产
			if(row5<1){//如果 增加分店的总资产 的影响行数小于1
				return 0;
			}
		}
		int rows = row1+row2;
		return rows;
	}

	@Override
	public List<Map<String, Object>> findAll(Map<String, Object> sctockmpMap) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();//实例化一个map集合
		List<Map<String, Object>> sctockmpList = sctockmpDao.findAll(sctockmpMap);//订单:查询订单列表
		//把订单时间转换为字符串
		for (Iterator iterator = sctockmpList.iterator(); iterator.hasNext();) {//迭代器循环-订单列表
			Map<String, Object> mapList = (Map<String, Object>) iterator.next();
			mapList.put("SALE_DATE", mapList.get("SALE_DATE")+"");//把map中的订单时间重新赋值-订单时间+‘’
			list.add(mapList);//加入到map集合
		}
		return list;
	}

	@Override
	public int findAllSize(Map<String, Object> map) {
		return sctockmpDao.findAllSize(map);//订单：查询订单列表数量
	}

	@Override
	public int updateWholesaleStateAdd(String saleId,HttpSession session) {
		int state =sctockmpDao.findWholesaleStateBySaleId(saleId);//订单:根据订单ID查询当前订单批发状态
		if(state==3){//如果状态等于3
			ErpSctockmp sctockmp = sctockmpDao.selectByPrimaryKey(saleId);//订单类=订单：根据订单ID查询订单
			List<Map<String, Object>> list = sctockmpDetailDao.findBySaleId(saleId);//map集合=订单明细：根据订单ID查找订单明细
			//减库存
			List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();//实例化一个map集合
			for(int i =0;i<list.size();i++){//循环订单明细集合
				Map<String, Object> map = new HashMap<String, Object>();//实例化一个map
				map.put("annexId",sctockmp.getAnnexId());//map赋值：分店ID-订单中的分店ID
				map.put("kinId",list.get(i).get("KIN_ID"));//map赋值：商品ID-第i个订单明细中的商品ID
				map.put("kmpNum",list.get(i).get("KMP_NUM"));//map赋值：商品数量-第i个订单明细中的商品数量
				mapList.add(map);//把map加入map集合
			}
			sumstockDao.updateStockSuount(mapList);//无返回-库存:批量减少库存(根据分店ID和商品ID减少)
			//增加财务(先增加分店收入明细，再增加分店表的总资产)
			/*  增加分店收入明细  */
			ErpLedgyr ledgyr = new ErpLedgyr();//实例化一个分店财务模型
			ledgyr.setGyrId(UUID.randomUUID()+"");//赋值-分店财务ID-随机生成
			ledgyr.setSaleId(sctockmp.getSaleId());//赋值-订单中的分店销售ID
			ledgyr.setAnnexId(sctockmp.getAnnexId());//赋值-分店ID-订单中的分店ID
			ledgyr.setGyrSreial(UUID.randomUUID()+"");//赋值-分店支出收入编号-随机生成
			ledgyr.setGyrPrice(sctockmp.getSaleMoney1());//赋值-分店支出金钱-订单中的应付金额
			ledgyr.setCreater(sctockmp.getCreater());//赋值-创建人-订单中的创建人
			ledgyr.setCreatetime(sctockmp.getCreatetime()+"");//赋值-创建时间-订单中的创建时间
			ledgyrDao.insertSelective(ledgyr);//无返回-分店财务：增加(可以为空)
			
			/*  增加分店表的总资产  */
			ErpAnnex annex = new ErpAnnex();//实例化一个分店模型
			annex.setAnnexId(sctockmp.getAnnexId());//赋值-分店ID-订单中的分店ID
			annex.setAnnexPrice(sctockmp.getSaleMoney1());//赋值-分店总资产-订单中的应付金额
			annexDao.updateAnnexPriceAdd(annex);//无返回-分店：增加分店的总资产
			
		}
		//增加审核表
		ErpAudit audit = new ErpAudit();//实例化一个审核类
		audit.setBusinessId(saleId);//审核赋值-业务ID-订单ID
		audit.setAudSerial(UUID.randomUUID()+"");//赋值-审核编号-随机生产
		ErpStaff staff = (ErpStaff) session.getAttribute("staff");//得到Session中的员工对象
		audit.setAudName(staff.getStaName());//赋值-审核人-员工姓名
		audit.setAudTime(Tools.getCurDateTime());//赋值-审核时间-工具类：得到当前日期时间
		audit.setState(2);//赋值-审核状态-2
		audit.setCreatetime(Tools.getCurDateTime());//赋值-创建时间-工具类：得到当前日期时间
		audit.setCreater(staff.getStaId());//赋值-创建人-员工ID
		audit.setIsva(1);//赋值-是否有效-是
		auditDao.insertSelective(audit);//无返回-审核：增加(可以为空)
		//最后增加订单状态
		return sctockmpDao.updateWholesaleStateAdd(saleId);//订单：审核通过，增加批发状态
	}

	@Override
	public int updateWholesaleStateZero(String saleId,String feedBack,HttpSession session) {
		//增加审核表
		ErpAudit audit = new ErpAudit();//实例化一个审核类
		audit.setBusinessId(saleId);//审核赋值-业务ID-订单ID
		audit.setAudSerial(UUID.randomUUID()+"");//审核赋值-审核编号-随机生产
		ErpStaff staff = (ErpStaff) session.getAttribute("staff");//得到Session中的员工对象
		audit.setAudName(staff.getStaName());//审核赋值-审核人-员工姓名
		audit.setAudTime(Tools.getCurDateTime());//审核赋值-审核时间-工具类：得到当前日期时间
		audit.setState(0);//审核赋值-审核状态-0
		audit.setFeedBack(feedBack);//审核赋值-反馈-打回原因
		audit.setCreatetime(Tools.getCurDateTime());//审核赋值-创建时间-工具类：得到当前日期时间
		audit.setCreater(staff.getStaId());//审核赋值-创建人-员工ID
		audit.setIsva(1);//审核赋值-是否有效-是
		auditDao.insertSelective(audit);//无返回-审核：增加(可以为空)
		//更改状态
		ErpSctockmp sctockmp = new ErpSctockmp();//实例化一个订单
		sctockmp.setSaleId(saleId);//订单赋值-订单ID
		sctockmp.setSaleWholesaleState(0);//订单赋值-批发状态-0
		return sctockmpDao.updateByPrimaryKeySelective(sctockmp);//订单：根据订单ID修改订单信息
	}

	@Override
	public int updateSctockmp(ErpSctockmp sctockmp, List<ErpSctockmpDetail> list) {
		//修改订单
		sctockmpDao.updateByPrimaryKeySelective(sctockmp);//无返回-订单：根据订单ID修改订单信息
		//删除之前的订单明细
		sctockmpDetailDao.updateIsvaBySaleId(sctockmp.getSaleId());//无返回-订单明细：根据订单ID把详细订单设为无效
		//增加订单明细
		sctockmpDetailDao.addSctockmpDetailList(list);//无返回-订单明细：批量增加销售订单明细
		//如果为零售(则需减库存，增加财务)
		if(sctockmp.getSaleIfWholesale()==0){
			//减库存
			List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
			for(int i =0;i<list.size();i++){//循环 明细订单集合
				Map<String, Object> map = new HashMap<String, Object>();//实例化map
				map.put("annexId",sctockmp.getAnnexId());//map赋值-分店ID-订单中分店ID
				map.put("kinId",list.get(i).getKinId());//map赋值-商品ID-第i个明细订单中的商品ID
				map.put("kmpNum",list.get(i).getKmpNum());//map赋值-商品数量-第i个明细订单中的商品数量
				mapList.add(map);//把map加入集合
			}
			int row3 = sumstockDao.updateStockSuount(mapList);//订单:批量减少库存(根据分店ID和商品ID减少)
			if(row3<1){
				return 0;
			}
			
			//增加财务(先增加分店收入明细，再增加分店表的总资产)
			/*  增加分店收入明细  */
			ErpLedgyr ledgyr = new ErpLedgyr();//实例化一个分店财务模型
			ledgyr.setGyrId(UUID.randomUUID()+"");//赋值-分店支出收入id-随机生成
			ledgyr.setSaleId(sctockmp.getSaleId());//赋值-分店销售ID-订单ID
			ledgyr.setAnnexId(sctockmp.getAnnexId());//赋值-分店ID-订单分店ID
			ledgyr.setGyrSreial(UUID.randomUUID()+"");//赋值-分店支出收入编号-随机生成
			ledgyr.setGyrPrice(sctockmp.getSaleMoney1());//赋值-分店支出金钱-订单应付金额
			ledgyr.setCreater(sctockmp.getCreater());//赋值-创建人-订单创建人
			ledgyr.setCreatetime(sctockmp.getCreatetime()+"");//赋值-创建时间-订单创建时间
			int row4 = ledgyrDao.insertSelective(ledgyr);//分店财务：增加(可以为空)
			if(row4<1){
				return 0;
			}
			
			/*  增加分店表的总资产  */
			ErpAnnex annex = new ErpAnnex();//实例化分店类
			annex.setAnnexId(sctockmp.getAnnexId());//分店赋值-分店ID-订单分店ID
			annex.setAnnexPrice(sctockmp.getSaleMoney1());//分店赋值-分店总资产-应付金额
			int row5 = annexDao.updateAnnexPriceAdd(annex);//分店：增加分店的总资产
			if(row5<1){
				return 0;
			}
		}
		return 2;
	}

	@Override
	public int findToDay() {
		return sctockmpDao.findToDay();//订单：查询今天的订单数量
	}
	
}

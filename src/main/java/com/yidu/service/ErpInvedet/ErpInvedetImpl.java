/**
 * 
 */
package com.yidu.service.ErpInvedet;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yidu.dao.ErpInvedetMapper;
import com.yidu.dao.ErpOutbankMapper;
import com.yidu.model.ErpBank;
import com.yidu.model.ErpFdproform;
import com.yidu.model.ErpInvedet;
import com.yidu.model.ErpOutbank;
import com.yidu.model.ErpSumstock;
import com.yidu.model.ErpWarehouse;
import com.yidu.service.ErpBank.ErpBankService;
import com.yidu.service.ErpFdproform.ErpFdproformService;
import com.yidu.service.ErpWarehouse.ErpWarehouseService;
import com.yidu.service.sumstock.SumstockService;
import com.yidu.util.BackException;
import com.yidu.util.Tools;

/**
 * 入库明细烦service的接口
 * @author 大晶儿
 * 2017年12月5日
 */
@Service
public class ErpInvedetImpl implements ErpInvedetService{
	@Resource
	private ErpInvedetMapper mapper;//入库明细的导接口
	@Resource
	private ErpWarehouseService warService;//仓库service
	@Resource
	private ErpBankService bankService;//入库的service
	@Resource
	private ErpOutbankMapper outMapper;//出库的mapp
	@Resource
	private ErpFdproformService fdService;//分店采购表
	@Resource
	private SumstockService stService;//分店库存
	@Override
	public int deleteByPrimaryKey(String invedetId) {
		return 0;
	}
	@Override
	public int insert(ErpInvedet record) {
		return 0;
	}

	@Override
	public int insertSelective(ErpInvedet record) {
		record.setCreatetime(Tools.getCurDateTime());//得到创建时间
		return mapper.insertSelective(record);
	}

	@Override
	public String selectByPrimaryKey(String obId,String staId,String annexId) {
		List<ErpInvedet> inv = mapper.selectByPrimaryKey(obId);
		for (Iterator iterator = inv.iterator(); iterator.hasNext();) {
			ErpInvedet erpInvedet = (ErpInvedet ) iterator.next();
			String peice = "";//定义一个参数
			peice=erpInvedet.getKinId();//peice参数为商品id不然就是原材料id
			ErpWarehouse war = warService.selectByPrimaryKey(peice);//查询仓库里面有没有改产品
			if(war!=null){//判断得到的仓库对象是否为空
				if(war.getWareNum()-erpInvedet.getInvedetNum()<0){
					ErpOutbank out = new ErpOutbank();
					out.setObId(obId);//把出库id放入对象
					out.setObBusibess(5);//修改出库表状态 已材料不足
					out.setObTime(Tools.getCurDateTime());//放入出库时间
					out.setObStaffid(staId);//放入出库人
					int row = outMapper.updateByPrimaryKeySelective(out);//调用修改方法
					return "有货品库存不足"+war.getKinName();
				}
				war.setWareNum(war.getWareNum()-erpInvedet.getInvedetNum());//把仓库当前数量加上库存明细里面的数量
				erpInvedet.setWareId(war.getWareId());//得到当前入库对象的仓库id放入库存明细里面
				 mapper.updateByPrimaryKey(erpInvedet);//得到入库修改的方法
				int rows = warService.updateByPrimaryKeySelective(war);//调用修改的方法
				if(rows<-1){//仓库修改失败抛出异常事物回滚； 
					try {
						throw new BackException("修改库存的时候报错");
					} catch (BackException e) {
						e.printStackTrace();
					}//抛出异常 
				}
				//根据商品id和分店id查询库存
				ErpSumstock sum = stService.selectKindAnn(erpInvedet.getKinId(), annexId);
				if(sum!=null){//判断得到的对象是否为空
					sum.setStockSuount(sum.getStockSuount()+erpInvedet.getInvedetNum());//修改分店库存
					stService.updateByPrimaryKeySelective(sum);//执行修改语句
					System.out.println("------------------正在执行修改库存语句----------------");
				}else{
					ErpSumstock tock = new ErpSumstock();//得到一个行的库存对象
					tock.setKinId(erpInvedet.getKinId());//放入商品id
					tock.setStockSuount(erpInvedet.getInvedetNum());//把当前详情的数量放入分店仓库
					tock.setIsva(1);
					
					ErpOutbank  ban = outMapper.selectByPrimaryKey(obId);//根据订单id查询出库单
					ErpFdproform r =fdService.selectByPrimaryKey(ban.getKinordId());//根据 采购id得到采购对象
					tock.setAnnexId(r.getAnnexId());//把采购对象里面得到的东西放入当前分店id
					tock.setCreater(staId);//创建人放入当前人员id
					tock.setCreatetime(Tools.getCurDateTime());//得到当前时间 当创建时间
					String data = stService.selectSerial(Tools.getDateStr(new Date()));//掉用得到最后一个编号
					tock.setStockSreial(Tools.getSerial(data,"FCK"));//通过工具类得到的编号放入仓库编号里面
					int row = stService.insertSelective(tock);
					if(row<-1){//仓库修改失败抛出异常事物回滚； 
						try {
							throw new BackException("添加分店库存的时候报错");
						} catch (BackException e) {
							e.printStackTrace();
						}//抛出异常 
					}
					System.out.println("------------------正在执行添加分店库存语句----------------");
				}
			}else{
				return "有货品库存不足";
			}
		}  
		System.out.println("-------------------------出循环执行到修改入库状态");
		ErpOutbank out = new ErpOutbank();
		out.setObId(obId);//把出库id放入对象
		out.setObBusibess(4);;//修改出库表状态 已入库
		out.setObTime(Tools.getCurDateTime());//放入出库时间
		out.setObStaffid(staId);//放入出库人
		int row = outMapper.updateByPrimaryKeySelective(out);//调用修改方法
		System.out.println("-------------------------方法调用完毕开始反回");
		
		
		System.out.println("-------------------------出循环执行到修改分店采购状态");
		ErpOutbank  ban = outMapper.selectByPrimaryKey(obId);//根据订单id查询出库单
		ErpFdproform f = new ErpFdproform();//得到一个分店采购的对象
		f.setFdproId(ban.getKinordId());//把分店采购id放入对象
		f.setFdproIsva(4);//修改状态为已完成
		fdService.updateByPrimaryKeySelective(f);//修改状态
		System.out.println("-------------------------方法调用完毕开始结束");
		return row+"";
	}

	@Override
	public int updateByPrimaryKeySelective(ErpInvedet record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(ErpInvedet record) {
		return 0;
	}

	@Override
	public int selectByPrimaryNew(String bankId,String staId) {
		List<ErpInvedet> list = mapper.selectByPrimaryNew(bankId);//得到改入库单的所有商品
		ErpBank bank = new ErpBank();//创建一个入库对象
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {//迭代list
			ErpInvedet erpInvedet = (ErpInvedet) iterator.next();
			System.out.println("-----------------------"+erpInvedet.getInvedetId());
			String peice = "";//定义一个参数
			if(Tools.isEmpty(erpInvedet.getKinId())){//使用工具类商品id为空时
				peice=erpInvedet.getRawId();
			}else{
				peice=erpInvedet.getKinId();//peice参数为商品id不然就是原材料id
			}
			ErpWarehouse war = warService.selectByPrimaryKey(peice);//查询仓库里面有没有改产品
			
			if(war!=null){//判断得到的仓库对象是否为空
				war.setWareNum(war.getWareNum()+erpInvedet.getInvedetNum());//把仓库当前数量加上库存明细里面的数量
				System.out.println("-----------------------------------------------------------------------------"+war.getWareNum()+erpInvedet.getInvedetNum());
				erpInvedet.setWareId(war.getWareId());//得到当前入库对象的仓库id放入库存明细里面
				 mapper.updateByPrimaryKey(erpInvedet);//得到入库修改的方法
				 
				erpInvedet.setCreatetime(Tools.getCurDateTime());//放入创建时间
				int row = mapper.updateByPrimaryKey(erpInvedet);//得到入库修改的方法
				 
				int rows = warService.updateByPrimaryKeySelective(war);//调用修改的方法
				if(rows<-1){//仓库修改失败抛出异常事物回滚； 
					try {
						throw new BackException("修改库存的时候报错");
					} catch (BackException e) {
						e.printStackTrace();
					}//抛出异常 
				}
			}else{
				ErpWarehouse warh = new ErpWarehouse();//得到仓库对象
				
				
				if(erpInvedet.getKinId()!=null && erpInvedet.getKinId()!=""){//商品id不为空时
					warh.setKinId(erpInvedet.getKinId());//peice参数为商品id不然就是原材料id
				}else{
					warh.setRawId(erpInvedet.getRawId());//peice参数为商品id不然就是原材料id
				}
				System.out.println("----------------------------  药品"+erpInvedet.getKinId()+"-------------------------------------------------原材料"+erpInvedet.getRawId());
				
				String uuid = UUID.randomUUID()+"";//得到一个仓库id
				warh.setWareNum(erpInvedet.getInvedetNum());//放入数量
				warh.setCreater(staId);//放入创建人
				warh.setWareId(uuid);//放入id
				warh.setCreatetime(Tools.getCurDateTime());//放入创建时间
				
				erpInvedet.setWareId(uuid);//得到uuid放入当前库存明细里面
				erpInvedet.setCreatetime(Tools.getCurDateTime());//放入创建时间
				int row = mapper.updateByPrimaryKey(erpInvedet);//得到入库修改的方法
				
				int rows = warService.insertSelective(warh);//掉用方法
				if(rows<-1){//仓库添加失败抛出异常事物回滚； 
					try {
						throw new BackException("创建库存的时候报错");
					} catch (BackException e) {
						e.printStackTrace();
					}//抛出异常 
				}
			}
		}
		System.out.println("-------------------------出循环执行到修改入库状态");
		
		bank.setBankId(bankId);//把入库id放入对象
		bank.setBankIsva(4);//入库状态修改
		bank.setBankTime(Tools.getCurDateTime());//把当前时间放入入库时间
		bank.setBankStaffid(staId);//放入入库人
		int row = bankService.updateByPrimaryKeySelective(bank);//调用修改方法
		System.out.println("-------------------------方法调用完毕开始反回");
		return row;
	}
	
}

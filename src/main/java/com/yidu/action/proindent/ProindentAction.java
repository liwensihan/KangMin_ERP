/**
 * 
 */
package com.yidu.action.proindent;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.common.MyException;
import com.yidu.common.Tools;
import com.yidu.model.ErpProindent;
import com.yidu.model.ErpProindentDetail;
import com.yidu.service.ErpWarehouse.ErpWarehouseService;
import com.yidu.service.Proindent.ProindentService;
import com.yidu.service.ProindentDetail.ProindentDetailService;
import com.yidu.util.Pages;
import com.yidu.util.SsmMessage;

/**
 * 订单action
 * @author dong
 * @da2017年11月7日
 * @version 1.0
 */
@Controller
@RequestMapping("dent")
public class ProindentAction {
	@Resource
	private ProindentService proindentService;//订单
	
	@Resource
	private ProindentDetailService ProindentDetailService;//订单明细
	
	@Resource
	private ErpWarehouseService erpWarehouseService;//仓库
	
	
	SsmMessage  mes=new SsmMessage();//消息类
	
	
	
	/**
	 * 下拉框查询所有订单
	 * @return list
	 */
	@RequestMapping("/findByxl")
	@ResponseBody
	public List<ErpProindent> findByxl(ErpProindent dent){
		List<ErpProindent> list=proindentService.findStation();
		
		return list;
		
	}
	
	
	
	
	
	/**
	 * 下拉框查询所有订单
	 * @param express
	 * @return map
	 */
	@RequestMapping("/findByshowxl")
	@ResponseBody
	public List<Map<String, Object>> findByshowxl(ErpProindent dent){
		
		List<Map<String, Object>> map=proindentService.findStationid(dent.getIndentId());//根据订单ID查询商品，下拉框 
		
		return map;
		
	}
	
	
	
	/**
	 * 订单日志查询,根据商品，订单，日志，日志明细 
	 * @param express
	 * @return
	 */
	@RequestMapping("/findByrz")
	@ResponseBody
	public List<Map<String, Object>> findByrz(ErpProindent dent){
		
		List<Map<String, Object>> map=proindentService.findByrz(dent.getIndentId());//根据订单id查询订单日志查询,根据商品，订单，日志，日志明细
		
		return map;
		
	}
	
	/**
	 * 订单明细，商品，配方，原材料，查询配方 
	 * @param express
	 * @return
	 */
	@RequestMapping("/showpf")
	@ResponseBody
	public List<Map<String, Object>> showpf(ErpProindent dent){
		
		List<Map<String, Object>> map=proindentService.showpf(dent.getIndentId());//根据订单id查询订单明细，商品，配方，原材料，查询配方 
		
		return map;
		
	}
	
	
	
	
	
	/**
	 * 根据ID查询
	 * @param express
	 * @return
	 */
	@RequestMapping("/findById")
	@ResponseBody
	public List<Map<String, Object>> findById(ErpProindent dent){
		List<Map<String, Object>> map=proindentService.selectByPrimaryKeyid(dent.getIndentId());//根据订单id查询明细，和商品表
		
		return map;
		
	}
	
	
	/**
	 * 根据ID查询所有，根据订单id查询明细，和商品表查看明细
	 * @param express
	 * @return
	 */
	@RequestMapping("/findByshowId")
	@ResponseBody
	public List<Map<String, Object>> findByshowId(ErpProindent dent){
		List<Map<String, Object>> map=proindentService.showid(dent.getIndentId());//根据订单id查询明细，和商品表查看明细
		
		return map;
		
	}
	
	
	
	
	/**
	 * 根据ID查询单个订单
	 * @param express
	 * @return
	 */
	@RequestMapping("/show")
	@ResponseBody
	public ErpProindent show(ErpProindent dent){
		ErpProindent map=proindentService.findById(dent.getIndentId());//根据ID查询
		
		return map;
		
	}
	

	/**
	 * 删除方法
	 * @param express
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public SsmMessage delete(ErpProindentDetail detail,ErpProindent dent){
	
		detail.setIsva("0");//赋值，订单明细是否有效改变
		detail.setIndentId(dent.getIndentId());//给订单明细，生产订单主键赋值生产订单主键
		
		dent.setIsva("0");//赋值，订单是否有效改变
		dent.setIndentId(dent.getIndentId());//给生产订单主键，赋值生产订单主键
		
		SsmMessage mes = new SsmMessage();//new出消息类
		
		int rows=0;//定义数值等于0
		
		rows = proindentService.updateByPrimaryKeySelective(dent);//订单删除方法
		rows=ProindentDetailService.updateByPrimaryKeySelective(detail);//订单明细删除方法
		
		if(rows>0){//数值大于0
			mes.setMes("操作成功");
			mes.setState(1);
		}else{
			mes.setMes("操作失败");
			mes.setState(0);
		}
		
		return mes;
	}
	
	/**
	 * 查询产品，订单，订单明细，订单生产日志，订单生产日志明细，根据订单ID查询
	 * @param express
	 * @param indentId 生产订单主键
	 * @param int 总行数
	 * @return
	 */
	@RequestMapping("/findByshow")
	@ResponseBody
	public List<Map<String, Object>> findByshow(ErpProindent dent){
		
		int num=proindentService.findcount(dent.getIndentId());//根据生产订单主键，查询订单明细总行数
		
		Map<String, Object> m=new HashMap<String,Object>();//定义map
		
		m.put("indentId", dent.getIndentId());//把生产订单主键传入map中
		m.put("int", num);//把订单明细总行数传入map中
		
		List<Map<String, Object>> map=proindentService.findByshow(m);//查询产品，订单，订单明细，订单生产日志，订单生产日志明细，根据订单ID查询和订单明细总行数查询
		
		return map;
		
	}
	
	/**
	 * 查询所有方法
	 * @param page 当前页数
	 * @param limit 每页最大显示条数
	 * @param key 关键字
	 * @param indentUrgency 是否紧急
	 * @param state 审核状态
	 * @param indentState 订单状态
	 * @param data 返回所有
	 * @return
	 */
	@RequestMapping("/showList")
	@ResponseBody  //ajax注解
	public Map<String,Object> showList(int page ,int limit,ErpProindent dent,String key){
		
		Map<String,Object> map = new HashMap<String, Object>();//定义map
		
		Map<String,Object> pagmap = new HashMap<String, Object>();//定义map
		
		Pages ps=new Pages();//new出分页工具类
		ps.setCurPage(page);//分页工具类赋值，当前页数
		ps.setMaxResult(limit);//分页工具类赋值，每页最大显示条数
		pagmap.put("page", ps.getFirstRows());//map赋值，取出，开始的行数 --需要计算的
		pagmap.put("limit", ps.getMaxResult());//map赋值，取出，每页最大显示条数
		pagmap.put("key", key);//map赋值，关键字
		pagmap.put("indentUrgency", dent.getIndentUrgency());//map赋值，是否紧急
		pagmap.put("state", dent.getState());//map赋值，订单取出，审核状态
		pagmap.put("indentState", dent.getIndentState());//map赋值，订单状态
		
		
		List<ErpProindent> list=proindentService.selectByPrimaryKey(pagmap);//定义订单list查询所有
		
		//layui数据表格需要返回的参数
		map.put("count",proindentService.findRowCount(pagmap));//总行数返回count
		
		map.put("data", list);//返回所有，传list
		map.put("code",0);
		map.put("msg", "");
		return map;
	}
	
	
	/**
	 * 修改订单明细和修改订单
	 * @param detail 订单明细表
	 * @param dent 订单表
	 * @return
	 */
	@RequestMapping("update")
	@ResponseBody
	public SsmMessage update(ErpProindentDetail detail,ErpProindent dent,String str){
		
		String[] sourceStrArray = str.split("&");//取出jsp中传来的数组，字符串分割&
	
		//订单明细增加
		for(int i =0;i<sourceStrArray.length;i++){//循环
			String[] str3 = sourceStrArray[i].split("_");//取上面的数组，字符串分割_
			detail.setEntdeNum(Integer.valueOf(str3[1]));//赋值订单明细总数量，循环第一个,强转数字型
			BigDecimal a=new BigDecimal(str3[2]);//把double转换成BigDecimal，循环第二个
			detail.setEntdePrice(a);//赋值，订单明细，金额
			detail.setEntdeId(str3[3]);//赋值，订单明细，生产订单明细id，循环第三个
			ProindentDetailService.update(detail);//订单明细，修改
		}
		int quantity=0;//定义一个需要相加的数值，数量相加
		double price=0;//价格相加,价格型
		for(int i =0;i<sourceStrArray.length;i++){//循环
			String[] str1 = sourceStrArray[i].split("_");//取上面的数组，字符串分割_
			quantity=quantity+Integer.parseInt(str1[1]);//数量相加,循环第一个，强转数字型
			price=price+Double.valueOf(str1[2]);//价格相加,循环第二个，强转价格型
		}
		BigDecimal a=new BigDecimal(price);//把double转换成BigDecimal，价格
		dent.setIndentMoney(a);//赋值,订单，生产订单金额
		dent.setIndentCount(quantity);//赋值，订单，生产订单数量
		dent.setIndentId(dent.getIndentId());//赋值，订单，取值生产订单主键
		proindentService.updateByPrimaryKeySelective(dent);//订单，修改或删除		
		mes.setState(1);//直接返回1
	
		return mes;
		
	}
	
	/**
	 * 查看库存是否足够
	 * @param detail 
	 * @param dent
	 * @return
	 * @throws MyException 
	 */
	@RequestMapping("showcp")
	@ResponseBody
	public SsmMessage showcp(ErpProindentDetail detail,ErpProindent dent,String str,HttpServletResponse response){
		
		if(str==null || "".equals(str)){//如果等于空就返回0
			mes.setState(0);//赋值，返回0
		}else{
			String[] sourceStrArray=str.split("&");//取jsp传来的数组，字符串分割&
			int rows = erpWarehouseService.updateck(sourceStrArray,response);//仓库，鏍规嵁閰嶆柟ID淇敼浠撳簱鏁伴噺
			if(rows!=0){//判断不等于0
				mes.setState(1);//赋值，返回1
				proindentService.updatezt(dent.getIndentId());//订单，根据生产订单主键修改生产状态
			}
		}
		return mes;
		
	}
	
	
	

	/**
	 * 根据ID查询
	 * @param express
	 * @return
	 */
	@RequestMapping("/selectByPrimaryProid")
	@ResponseBody
	private List<Map<String, Object>> selectByPrimaryProid(String indentId){
		List<Map<String, Object>> dent = proindentService.selectByPrimaryProid(indentId);//订单，根据id查询单个对象
		return dent;
	}
	
	
	
	
	
	/**
	 * 根据ID查询
	 * @author 刘晶
	 * @param express
	 * @return
	 */
	@RequestMapping("/showidQualit")
	@ResponseBody
	public ErpProindent showidQualit(String indentId){
		return proindentService.showidQualit(indentId);//质检表查询单个对象
	}
	/**
	 * 生产订单审核
	 * @author 胡鑫
	 * @date 2017年11月30日09:32:09
	 * @param indentId 生产订单id
	 * @param state 审核状态
	 * @param feedBack 反馈信息
	 * @return 返回消息类
	 */
	@ResponseBody
	@RequestMapping("/auditPpoindent")
	public SsmMessage auditPpoindent(String indentId,String state,String feedBack){
		SsmMessage mes = new SsmMessage();//定义一个消息类用于返回jsp
		Map<String,Object>map = new HashMap<String,Object>();//定义一个map集合
		if(Tools.isEmpty(feedBack)){//判断字符串是否为空
			map.put("feedBack", "暂无反馈信息");
		}else{
			map.put("feedBack", feedBack);//map集合中存入 反馈消息
		}
		map.put("indentId", indentId);//map集合中存入财务id
		map.put("state", state);//map集合中存入 审核是否通过   state=2 通过 state=0 不通过
		int rows = proindentService.auditPpoindent(map);
		return mes;
	}
}

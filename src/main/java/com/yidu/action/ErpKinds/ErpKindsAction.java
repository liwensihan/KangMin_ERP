/**
 * 
 */
package com.yidu.action.ErpKinds;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yidu.common.Tools;
import com.yidu.model.ErpKinds;
import com.yidu.model.ErpStaff;
import com.yidu.service.ErpKinds.ErpKindsService;
import com.yidu.util.Pages;
import com.yidu.util.SsmMessage;

/**
 * 药品的action
 * @author 大晶儿
 * 2017年10月31日
 */
@Controller
@RequestMapping("ErpKindsAction")
public class ErpKindsAction {
	@Resource
	private ErpKindsService service;
	
	/**
	 * 根据条形码查询药品
	 * @param kinBarcode 条形码
	 * @author ouyang
	 * @dateTime 2017年11月6日11:23:48
	 * @return 药品实体类
	 */
	@RequestMapping("/findByKinBarcode")
	@ResponseBody
	public ErpKinds findByKinBarcode(String kinBarcode){
		return service.findByKinBarcode(kinBarcode);
	}
	
	/**
	 * 添加
	 * @param kinds 药品对象
	 * @return 返回消息类
	 */
	@RequestMapping("insertSelectiveKind")
	@ResponseBody
	public SsmMessage insertSelectiveKind(ErpKinds kinds){
		SsmMessage mes = new SsmMessage();
		int rows = service.insertSelective(kinds);
		if(rows>-1){ 
			mes.setMes("添加成功");
			mes.setState(1);
		}else{
			mes.setMes("添加失败");
			mes.setState(0);
		}
		return mes;
	}
	/**
	 * 删除
	 * @param kinId 药品id 
	 * @return 返回消息类
	 */
	@RequestMapping("deleteKind")
	@ResponseBody
	public SsmMessage deleteKind(String kinId){
		SsmMessage mes = new SsmMessage();
		ErpKinds kin = new ErpKinds();
		kin.setKinId(kinId);
		int rows = service.deleteByPrimaryKey(kin);
		if(rows>-1){ 
			mes.setMes("删除成功");
			mes.setState(1);
		}else{
			mes.setMes("删除失败");
			mes.setState(0);
		}
		return mes;
	}
	/**
	 * 修改
	 * @param kinds 药品对象
	 * @return 返回消息类
	 */
	@RequestMapping("updateKind")
	@ResponseBody
	public SsmMessage updateKind(ErpKinds kinds){
		SsmMessage mes = new SsmMessage();
		int rows = service.updateByPrimaryKeySelective(kinds);
		if(rows>-1){ 
			mes.setMes("修改成功");
			mes.setState(1);
		}else{
			mes.setMes("修改失败");
			mes.setState(0);
		}
		return mes;
	}
	/**
	 * 查询所有的药品
	 * @return 返回map
	 */
	@RequestMapping("findListKind")
	@ResponseBody
	public Map findListKind(Integer page,Integer limit,String pricer){
		Map<String,Object> map1 = new HashMap<String,Object>();
		Pages pa = new Pages();
		pa.setCurPage(page);
		pa.setMaxResult(limit);
		map1.put("page", pa.getFirstRows());
		map1.put("limit", pa.getMaxResult());
		map1.put("pricer", pricer);
		List<ErpKinds> list = service.findPrimaryKinds(map1);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count",service.selectConut(map1));
		map.put("data", list);
		return map;
	}
	/**
	 * 得到当前创建的id
	 * @param dateStr
	 * @return
	 */
	@RequestMapping("selectId")
	@ResponseBody
	public String selectId(String dateStr){
		return service.selectId(Tools.getDateStr(new Date()));
		
	}
	
	/**
	 * 查询所有商品，下拉框
	 * @param session
	 * @return
	 * @author 刘东
	 * @throws JsonProcessingException
	 */
	@RequestMapping("/showListAjax")
	@ResponseBody  //ajax的注解
	public List<ErpKinds> showListAjax(){
		
		List<ErpKinds> list = service.findStation();//查询所有商品
		return list;
	}
	
	

	/**
	 * 根据ID查询
	 * @param session
	 * @return
	 * @author 刘东
	 * @throws JsonProcessingException
	 */
	@RequestMapping("/findById")
	@ResponseBody  //ajax的注解
	public ErpKinds findById(ErpKinds kinds){
		
		ErpKinds list = service.selectByPrimaryKey(kinds.getKinId());//查询所有商品
		return list;
	}
	/**
	 * 查询单个对象仓库使用方法
	 * @param kinId 商品id
	 * @return 返回药品单个对象
	 */
	@RequestMapping("/selectByPrimaryNewKinId")
	@ResponseBody  //ajax的注解
	public ErpKinds selectByPrimaryNewKinId(String kinId){
		
		return service.selectByPrimaryNewKinId(kinId);
	}
	
	/**
	 * Excel导入
	 * @param file Excel文件
	 * @param session HttpSession
	 * @return 是否成功
	 * @author ouyang
	 * @dataTime 2017年12月7日13:33:19
	 */
	@RequestMapping("/excelIn")
	@ResponseBody  //ajax的注解
	public Map<String,Object> excelIn(MultipartFile file,HttpSession session){
		ErpStaff staff = (ErpStaff) session.getAttribute("staff");
		Map<String,Object> map = new HashMap<String,Object>();
		//根据指定的文件输入流导入Excel从而产生Workbook对象
		Workbook wb =null;
		try {
			wb = new HSSFWorkbook(file.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取Excel文档中的第一个表单
		Sheet sht0 = wb.getSheetAt(0);
		//对Sheet中的每一行进行迭代
        for (Row r : sht0) {
	        //如果当前行的行号（从0开始）未达到2（第三行）则从新循环
			if(r.getRowNum()<2){
				continue;
			}
			//当前列的数据
			ErpKinds kinds = new ErpKinds();
			if(r.getCell(0)!=null){
				r.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
				kinds.setKinSerial(r.getCell(0).getStringCellValue());
			}
			if(r.getCell(4)!=null){
				r.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
				if(r.getCell(4).getStringCellValue().indexOf(".")>-1){
					String barcode = r.getCell(4).getStringCellValue().split("\\.")[0];
					kinds.setKinBarcode(barcode);
				}else{
					kinds.setKinBarcode(r.getCell(4).getStringCellValue());
				}
			}
			if(r.getCell(1)!=null){
				r.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
				kinds.setKinName(r.getCell(1).getStringCellValue());
			}
			if(r.getCell(5)!=null){
				r.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
				kinds.setKinContent(new BigDecimal(r.getCell(5).getStringCellValue()));
			}
			if(r.getCell(6)!=null){
				r.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
				kinds.setKinExpiration(r.getCell(6).getStringCellValue());
			}
			if(r.getCell(7)!=null){
				r.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
				kinds.setKinPrice(new BigDecimal(r.getCell(7).getStringCellValue()));
			}
			if(r.getCell(9)!=null){
				r.getCell(9).setCellType(Cell.CELL_TYPE_STRING);
				kinds.setKinSellinf(new BigDecimal(r.getCell(9).getStringCellValue()));
			}
			if(r.getCell(8)!=null){
				r.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
				kinds.setKinStost(new BigDecimal(r.getCell(8).getStringCellValue()));
			}
			if(r.getCell(10)!=null){
				r.getCell(10).setCellType(Cell.CELL_TYPE_STRING);
				kinds.setRemark(r.getCell(10).getStringCellValue());
			}
			kinds.setIsva(1);
			kinds.setCreatetime(Tools.getCurDateTime());
			kinds.setCreater(staff.getStaId());
			
			service.insertSelective(kinds);
        }
		map.put("state", 0);
		return map;
	}
	
	/**
	 * Excel导出
	 * @param page 当前页数
	 * @param limit 显示行数
	 * @param response HttpServletResponse
	 * @author ouyang
	 * @dataTime 2017年12月7日13:33:19
	 */
	@RequestMapping("/excelOut") 
	public void excelOut(Integer page,Integer limit,HttpServletResponse response){
		Map<String,Object> map = new HashMap<String,Object>();
		if(page==null){
			page=0;
		}
		if(limit==null){
			limit=100;
		}
		map.put("page", limit*(page-1));
		map.put("limit", limit);
		List<ErpKinds> list = service.findPrimaryKinds(map);
		
		//创建HSSFWorkbook对象(excel的文档对象)
	    HSSFWorkbook wb = new HSSFWorkbook();
	    //建立新的sheet对象（excel的表单）
	    HSSFSheet sheet=wb.createSheet("商品表");
	    //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
	    HSSFRow row1=sheet.createRow(0);
	    //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
	    HSSFCell cell=row1.createCell(0);
	    //设置单元格内容
	    cell.setCellValue("商品列表");
	    //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
	    sheet.addMergedRegion(new CellRangeAddress(0,0,0,10));
	    //在sheet里创建第二行
	    HSSFRow row2=sheet.createRow(1);    
	    //创建单元格并设置单元格内容
		row2.createCell(0).setCellValue("编号");
		row2.createCell(1).setCellValue("药品名");    
		row2.createCell(2).setCellValue("类型");
		row2.createCell(3).setCellValue("药效");
		row2.createCell(4).setCellValue("条形码"); 
		row2.createCell(5).setCellValue("净含量");
		row2.createCell(6).setCellValue("保质期");
		row2.createCell(7).setCellValue("成本价");
		row2.createCell(8).setCellValue("销售价");
		row2.createCell(9).setCellValue("批发价");
		row2.createCell(10).setCellValue("备注");
		
		for(int i =0;i<list.size();i++){
			ErpKinds kind = list.get(i);
			HSSFRow row3=sheet.createRow(2+i);
			row3.createCell(0).setCellValue(kind.getKinSerial());
			row3.createCell(1).setCellValue(kind.getKinName());
			row3.createCell(2).setCellValue(kind.getTyper().getTypeName());
			row3.createCell(3).setCellValue(kind.getResName());
			row3.createCell(4).setCellValue(kind.getKinBarcode());
			row3.createCell(5).setCellValue(kind.getKinContent().doubleValue());
			row3.createCell(6).setCellValue(kind.getKinExpiration());
			row3.createCell(7).setCellValue(kind.getKinPrice().doubleValue());
			row3.createCell(8).setCellValue(kind.getKinStost().doubleValue());
			row3.createCell(9).setCellValue(kind.getKinSellinf().doubleValue());
			row3.createCell(10).setCellValue(kind.getRemark());
		}
		//输出Excel文件
	    try {
			OutputStream output=response.getOutputStream();
			response.reset();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String time =  sdf.format(new Date()).replace("-", "");
			response.setHeader("Content-disposition", "attachment; filename=kinds"+time+".xls");
		    response.setContentType("application/msexcel");   
		    wb.write(output);
		    output.flush();
		    output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

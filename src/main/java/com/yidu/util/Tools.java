package com.yidu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tools {
	
	/**
	 * 分页条数
	 */
	public final static int MAX_RESULT=5; 

	static SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
	static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 返回日期格式
	 * @param date
	 * @return
	 */
	public static String getDateStr(Date date){
		if(date==null) return "";
		return sdfDate.format(date);
	}
	
	/**
	 * 返回日期格式
	 * @param date
	 * @return
	 */
	public static Date parseDate(String date){
		if(date==null) return null;
		try {
			return sdfDate.parse(date);
		} catch (ParseException e) { 
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 返回时间格式
	 * @param date
	 * @return
	 */
	public static String getTimeStr(Date date){
		if(date==null) return "";
		return sdfTime.format(date);
	}
	
	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str==null) return true ;
		if("".equals(str)) return true ;
		return false ;
	}
	/**
	 * 得到编号
	 * @param data
	 * @param type
	 * @return
	 */
	public static String getSerial(String data,String type){
		if(Tools.isEmpty(data)){
			return type+""+Tools.getDateStr(new Date())+"-001";
		}
		String ser = data.substring(data.lastIndexOf("-")+1,data.length());
		String seril ="";
		if(ser.indexOf("0")!=-1){
			seril = ser.substring(ser.lastIndexOf("0")+1,ser.length());
			System.out.println("输出一下serial+"+seril);
		}else{
			seril = ser.substring(ser.lastIndexOf("-")+1,ser.length());
		}
		if(Tools.isEmpty(seril)){
			seril = ser.substring(ser.lastIndexOf("0")-2,ser.length());
		}else{
			System.out.println("输出一下serial+"+ser);
			seril = ser.substring(ser.lastIndexOf("0")+1,ser.length());
		}
		System.out.println("再输出"+seril);
		int num = Integer.valueOf(seril)+1;
		String str ="";
		if(num<10){
			str = "00"+num;
		}else if(num<99){
			str="0"+num;
		}
		String serial = type+""+Tools.getDateStr(new Date())+""+str;
		return serial;
		
	}
}
/**
 * 
 */
package com.yidu.util;

/**
 * 自定义异常类
 * @author 大晶儿
 * 2017年10月23日
 */
public class BackException extends Exception{
	/**
	 * 判断
	 * @param rows 返回值
	 */
	public BackException(String rows){
		super(rows); 
	}
}

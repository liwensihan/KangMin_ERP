/**
 * 
 */
package com.yidu.common;

/**
 * 可能抛出异常的方法 
 * @author dong
 * @data 2017年11月27日
 */
public class ExceptionClass {
	 public String setNumber(int number) throws MyException
	    {
	        if(number >= 1)
	        {
	            return "正常";
	        }
	        else
	        {
	            throw new MyException("输入错误");
	        }
	    }
}

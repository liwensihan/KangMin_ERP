/**
 * 
 */
package com.yidu.common;

/**
 * 自定义异常
 * @author dong
 * @data 2017年11月27日
 */
public class MyException extends RuntimeException{

	 public MyException(){

	  }
	 
	  public MyException(String s){
		  
	        super(s);
	  }
}

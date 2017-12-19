/**
 * 
 */
package com.yidu.util;

import java.io.Serializable;

/**
 * 分页工具类
 * @author liandyao
 * @date 2017年9月29日 下午6:16:21
 * @version 1.0
 */
public class Pages  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3989807655700311131L;

	/**
	 * 成功页面
	 */
	 public static final String SUCCESS ="success" ;
	 
	/**
	 * 错误页面
	 */
	 public static final String ERROR ="error" ;
	 
	 /**
	  * session过期页面
	  */
	 public static final String SESSION_ERROR ="login" ;
	 
	 
	private int curPage = 1 ; //当前页数
	private int totalRows; //总记录数
	private int firstRows; //开始的行数 --需要计算的
	private int maxResult=10; //每页最大显示条数
	private int totalPage ;//总页数  --需要计算的
	
	/**
	 * 总页数  --需要计算的
	 * @return
	 */
	public int getTotalPage() {
		if(totalRows%maxResult==0){
			totalPage = totalRows/maxResult ; //50    5  应该多少页 11
		}else{
			totalPage = totalRows/maxResult+1 ;
		}
		
		return totalPage;
	}
	/**
	 * 总页数  --需要计算的
	 * @return
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	/**
	 * 当前页数
	 * @return
	 */
	public int getCurPage() {
		return curPage;
	}
	
	/**
	 * 当前页数
	 * @return
	 */
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	
	/**
	 * 总记录数
	 * @return
	 */
	public int getTotalRows() {
		return totalRows;
	}
	/**
	 * 总记录数
	 * @return
	 */
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	/**
	 * 开始的行数 --需要计算的
	 * @return
	 */
	public int getFirstRows() {
		firstRows = maxResult*(curPage-1);
		return firstRows;
	}
	/**
	 * 开始的行数 --需要计算的
	 * @return
	 */
	public void setFirstRows(int firstRows) {
		this.firstRows = firstRows;
	}
	/**
	 * 每页最大显示条数
	 * @return
	 */
	public int getMaxResult() {
		return maxResult;
	}
	/**
	 * 每页最大显示条数
	 * @return
	 */
	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}
}

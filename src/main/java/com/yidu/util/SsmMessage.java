/**
 * 
 */
package com.yidu.util;

/**
 * @author zhangwei
 *
 */
public class SsmMessage {

	private String mes; //消息内容
	private int state ; //消息状态
	
	
	public SsmMessage() {
		super();
	}
	public SsmMessage(String mes, int state) {
		super();
		this.mes = mes;
		this.state = state;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
}

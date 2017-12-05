/**
 * 
 */
package com.yidu.common;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;

import com.alibaba.druid.filter.config.ConfigTools;

/**
 * 工具类
 * @author liandyao
 * @date 2017年9月29日 上午11:30:10
 * @version 1.0 
 * 
 * @author 原作者
 * @update 修改人 
 * @date 修改时间
 * 修改内容.................
 */
public class Tools {
	static Random random = new Random();

	static char[] char_random = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '2', '3', '4', '5', '6', '7', '8', '9', '0' };

	/**
	 * 随机生成字符串 共40位
	 * @return 随机字符串
	 */
	public static String getRandomString(){
		String s = RandomStringUtils.random(20,char_random) ;
		String s1 = RandomStringUtils.random(20, char_random) ;
		return s+s1 ;
	}

	/**
	 * 随机生成字符串
	 * @param size 位数
	 * @return 随机字符串
	 */
	public static String getRandomString(int size){
		String s = RandomStringUtils.random(size,char_random) ; 
		return s  ;
	}

	/**
	 * 得到随机数字
	 * @param num
	 * @return
	 */
	public static int getRandomNumber(int num){
		int n = random.nextInt(num) ;
		return n ;
	}
	/**
	 * 提供字符串判断是否为空
	 * @param input
	 * @return input为空返回true
	 */
	public static boolean isEmpty(String input){
		return null==input || 0==input.length() || 0==input.replaceAll("\\s", "").length();
	}
	/**
	 * 得到编号
	 * @param data
	 * @param type
	 * @return
	 */
	public static String getSerial(String data,String type){
		if(Tools.isEmpty(data)){
			return type+"-"+Tools.getDateStr(new Date())+"-001";
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

	
	/**
	 * 判断集合是否为空
	 * @param list
	 * @return list为空返回true
	 */
	public static boolean isEmpty(List list){
		if(list==null) return true ;
		return list.isEmpty();
	}
	 
	/**
	 * 得到当前日期
	 * yyyy-MM-dd
	 * @return 格式化的r日期字符串
	 */
	public static String getCurDate(){
		Date date = new Date();
		return CommomUtils.SDF_DATE.format(date);
	}
	
	/**
	 * 得到当前日期时间
	 * yyyy-MM-dd HH:mm:ss
	 * @return 格式化的r日期字符串
	 */
	public static String getCurDateTime(){
		Date date = new Date();
		return CommomUtils.SDF_TIME.format(date);
	}
	
	/**
	 * 返回日期格式
	 * yyyy-MM-dd
	 * @param date
	 * @return 格式化的r日期字符串
	 */
	public static String getDateStr(Date date){
		if(date==null) return "";
		return CommomUtils.SDF_DATE.format(date);
	}
	
	/**
	 * 返回时间格式
	 * yyyy-MM-dd HH:mm:ss
	 * @param date
	 * @return 格式化的r日期字符串
	 */
	public static String getTimeStr(Date date){
		if(date==null) return "";
		return CommomUtils.SDF_TIME.format(date);
	}
	
	/**
	 * 得到订单编码格式:日期格式如:20161222211800,分别代表的是年月日时分秒+5位随机字符串
	 * @return
	 */
	public static String getDateOrderNo(){
		Date date = new Date();
		String temp = CommomUtils.SDF_TIME.format(date);
		temp = temp+getRandomString(10);
		String a[]=temp.split("-");
		temp = a[0]+a[1]+a[2];
		String b[]=temp.split(":");
		temp = b[0]+b[1]+b[2];
		String c[]=temp.split(" ");
		temp = c[0]+c[1];
		return temp ;
	}

	/**
	 * 得到多少月份之后的时间
	 * @param size 多少月
	 * @return 返回字符串
	 */
	public static String getAfterDate(int size){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, size);

		Date date = cal.getTime();
		String str = CommomUtils.SDF_DATE.format(date);
		return str ;
	}

	/**
	 * 与当前时间比
	 * @param date
	 * @return 如果未超过返回true，如果已经超过返回false
	 * @throws ParseException 
	 */
	public static boolean isDateBefore(String date) throws ParseException{
		if(isEmpty(date)) return false ;
		Date exp = CommomUtils.SDF_TIME.parse(date);
		Date now = new Date();
		return now.before(exp);
	}
	
	/**
     * 获取前一天日期yyyyMMdd
     * @see 经测试，针对闰年02月份或跨年等情况，该代码仍有效。测试代码如下
     * @see calendar.set(Calendar.YEAR, 2013);
     * @see calendar.set(Calendar.MONTH, 0);
     * @see calendar.set(Calendar.DATE, 1);
     * @see 测试时，将其放到<code>calendar.add(Calendar.DATE, -1);</code>前面即可
     * @return 返回的日期格式为yyyyMMdd
     */
    public static String getYestoday(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return CommomUtils.SDF_DATE.format(calendar.getTime());
    }
	
	/**
	 * 将首字母大写
	 * @param name 属性名
	 * @return 例如传入属性name,得到的结果是Name
	 */
	public static String firstUpp(String name){
		if(isEmpty(name)) return name ;
		char first = name.charAt(0) ;
		String newName = Character.toUpperCase(first)+name.substring(1) ;
		return newName ;
	}
	
	/**
	 * 将字符串编码,utf-8格式
	 * @param str
	 * @return
	 */
	public static String encode(String str){
		try {
			 return URLEncoder.encode(str, "utf-8");
		} catch (UnsupportedEncodingException e) { 
			e.printStackTrace();
		}
		return null ;
	}
	
	 /**
     * 字符解码
     * @see 该方法默认会以UTF-8解码字符串
     * @see 若想自己指定字符集,可以使用<code>decode(String chinese, String charset)</code>方法
     */
    public static String decode(String chinese){
        return decode(chinese, "UTF-8");
    }
    
    /**
     * 字符解码
     * @see 该方法通常用于对中文进行解码
     * @see 若系统不支持指定的解码字符集,则直接将<code>chinese</code>原样返回
     */
    public static String decode(String chinese, String charset){
        chinese = (chinese==null ? "" : chinese);
        try {
            return URLDecoder.decode(chinese, charset);
        } catch (UnsupportedEncodingException e) {
            Logger.getLogger(Tools.class).error("解码字符串[" + chinese + "]时发生异常:系统不支持该字符集[" + charset + "]");
            return chinese;
        }
    }
	
	/**
	 * 得到当前时间戳,1970年到目前的秒数
	 * @return 时间戳
	 */
	public static String getTimeStamp(){
		return System.currentTimeMillis()/1000+"";
	}
	
	 /**
     * 获取系统流水号
     * @see 若欲指定返回值的长度or是否全由数字组成等,you can call {@link TradePortalUtil#getSysJournalNo(int, boolean)}
     * @return 长度为20的全数字
     */
    public static String getSysJournalNo(){
        return getSysJournalNo(20, true);
    }
	
	/**
     * 获取系统流水号
     * @param length   指定流水号长度
     * @param toNumber 指定流水号是否全由数字组成
     */
    public static String getSysJournalNo(int length, boolean isNumber){
        //replaceAll()之后返回的是一个由十六进制形式组成的且长度为32的字符串
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        if(uuid.length() > length){
            uuid = uuid.substring(0, length);
        }else if(uuid.length() < length){
            for(int i=0; i<length-uuid.length(); i++){
                uuid = uuid + Math.round(Math.random()*9);
            }
        }
        if(isNumber){
            return uuid.replaceAll("a", "1").replaceAll("b", "2").replaceAll("c", "3").replaceAll("d", "4").replaceAll("e", "5").replaceAll("f", "6");
        }else{
            return uuid;
        }
    }
    
    /**
     * 金额元转分
     * @see 注意:该方法可处理贰仟万以内的金额,且若有小数位,则不限小数位的长度
     * @see 注意:如果你的金额达到了贰仟万以上,则不推荐使用该方法,否则计算出来的结果会令人大吃一惊
     * @param amount  金额的元进制字符串
     * @return String 金额的分进制字符串
     */
    public static String moneyYuanToFen(String amount){
        if(isEmpty(amount)){
            return amount;
        }
        //传入的金额字符串代表的是一个整数
        if(-1 == amount.indexOf(".")){
            return Integer.parseInt(amount) * 100 + "";
        }
        //传入的金额字符串里面含小数点-->取小数点前面的字符串,并将之转换成单位为分的整数表示
        int money_fen = Integer.parseInt(amount.substring(0, amount.indexOf("."))) * 100;
        //取到小数点后面的字符串
        String pointBehind = (amount.substring(amount.indexOf(".") + 1));
        //amount=12.3
        if(pointBehind.length() == 1){
            return money_fen + Integer.parseInt(pointBehind)*10 + "";
        }
        //小数点后面的第一位字符串的整数表示
        int pointString_1 = Integer.parseInt(pointBehind.substring(0, 1));
        //小数点后面的第二位字符串的整数表示
        int pointString_2 = Integer.parseInt(pointBehind.substring(1, 2));
        //amount==12.03,amount=12.00,amount=12.30
        if(pointString_1 == 0){
            return money_fen + pointString_2 + "";
        }else{
            return money_fen + pointString_1*10 + pointString_2 + "";
        }
    }
    
    /**
     * 金额分转元
     * @see 注意:如果传入的参数中含小数点,则直接原样返回
     * @see 该方法返回的金额字符串格式为<code>00.00</code>,其整数位有且至少有一个,小数位有且长度固定为2
     * @param amount  金额的分进制字符串
     * @return String 金额的元进制字符串
     */
    public static String moneyFenToYuan(String amount){
        if(isEmpty(amount)){
            return amount;
        }
        if(amount.indexOf(".") > -1){
            return amount;
        }
        if(amount.length() == 1){
            return "0.0" + amount;
        }else if(amount.length() == 2){
            return "0." + amount;
        }else{
            return amount.substring(0, amount.length()-2) + "." + amount.substring(amount.length()-2);
        }
    }
    
    /**
     * @title 金额分转元
     * @description 传入一个金额的分进制字符串,返回一个金额的元进制字符串
     * @see 注意:如果传入的参数中不
     * @see 该方法返回的金额字符串格式为<code>00.00</code>,其整数位有且至少有一个,小数位有且长度固定为2
     * @param amount  金额的分进制字符串
     * @return String 金额的元进制字符串
     * @author 罗海兵
     * @dateTime 2017年10月25日 下午1:10:54
     * @versions 1.0
     */
    public static String moneyFenToYuan2(String money){
		BigDecimal num = new BigDecimal("100"); //建立元转分倍数
		//NumberFormat currency = NumberFormat.getCurrencyInstance(); //建立货币格式化引用:￥15,000.48
		try{
			BigDecimal newMoney=new BigDecimal(money).divide(num,2);//相除，保留2位小数
			return newMoney.toString();
		}catch (NumberFormatException e) {
			return money;
		}
    }
    
    /**
     * 获取一个字符串的简明效果,可以作为手机号码或者身份证号码的隐藏,例如1345***4568
     * @return String 返回的字符串格式类似于"abcd***hijk"
     */
    public static String getStringSimple(String data){
        return data.substring(0,4) + "***" + data.substring(data.length()-4);
    }
    
    /**
     * 将字符串加密,一般用于密码加密
     * @param str传入普通字符串
     * @return 返回加密之后的字符串
     */
    public static String password(String str){
    	if(str==null) return null;
    	String password = null;
		try {
			password = ConfigTools.encrypt(str);
		} catch (Exception e) { 
			e.printStackTrace();
		} 
    	return password ;
    }
    
    /**
	 * 判断是否为Ajax请求的方法
	 * @param request 请求对象
	 * @return 是Ajax请求返回true,不是返回false
	 * @author 罗海兵
	 * @date 2017年10月17日
	 * @version 1.1
	 */
    public static boolean isAjaxRequest(HttpServletRequest request) { 
        String header = request.getHeader("X-Requested-With"); 
        if (header != null && "XMLHttpRequest".equalsIgnoreCase(header)) {
            return true; 
        }else{ 
            return false;
        }
    } 
    
    /** 
     * 获取当前网络ip地址 
     * @param request 请求对象
     * @return 返回一个String的ip地址
     * @author 罗海兵
	 * @date 2017年10月17日
	 * @version 1.1
     */  
    public static String getIpAddr(HttpServletRequest request){  
        String ipAddress = request.getHeader("x-forwarded-for");  
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
                ipAddress = request.getHeader("Proxy-Client-IP");  
            }  
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
                ipAddress = request.getHeader("WL-Proxy-Client-IP");  
            }  
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
                ipAddress = request.getRemoteAddr();  
                if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){  
                    //根据网卡取本机配置的IP  
                    InetAddress inet=null;  
                    try {  
                        inet = InetAddress.getLocalHost();  
                    } catch (UnknownHostException e) {  
                        e.printStackTrace();  
                    }  
                    ipAddress= inet.getHostAddress();  
                }  
            }  
            //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割  
            if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15  
                if(ipAddress.indexOf(",")>0){  
                    ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));  
                }  
            }  
            return ipAddress;   
    }
    
    public static void main(String[] args) {
		System.out.println(password("1235"));
	}
    
}

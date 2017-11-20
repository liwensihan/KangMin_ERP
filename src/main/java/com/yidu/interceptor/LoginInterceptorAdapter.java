package com.yidu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.yidu.model.ErpStaff;


/**
 * 登录拦截器
 * @author ouyang
 * @dateTime 2017年11月10日11:28:34
 * @version 1.1
 */
public class LoginInterceptorAdapter extends HandlerInterceptorAdapter{
	
	/** 
     * Handler执行之前调用这个方法 
     */  
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//获取请求的URL  
        String url = request.getRequestURI();  
        
        System.out.println("登陆拦截器,请求地址："+url+"\n\n\n");
        //URL:login.jsp是公开的;这个demo是除了login.jsp是可以公开访问的，其它的URL都进行拦截控制  
        
        if(url.indexOf("login")>=0){  
            return true;  
        } 
        HttpSession session=request.getSession();
        ErpStaff staff=(ErpStaff) session.getAttribute("staff");
    	if(staff==null){
    		String header = request.getHeader("X-Requested-With"); 
            if (header != null && "XMLHttpRequest".equalsIgnoreCase(header)) {
            	System.out.println("未登陆,这是一个Ajax请求,返回0");
    			response.getWriter().write("0");
            }else{ 
            	System.out.println("未登陆,这不是一个Ajax请求,重定向到登陆页面");
            	String path = session.getServletContext().getContextPath();
    			response.sendRedirect(path+"/page/login.jsp");
            }
    		return false;
		}
		return true;
	}
}

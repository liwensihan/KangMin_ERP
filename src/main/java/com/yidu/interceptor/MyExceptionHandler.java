package com.yidu.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 配置全局异常
 * @author ouyang
 * @dataTime 2017年11月10日09:49:20
 *
 */
public class MyExceptionHandler implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView view = new ModelAndView("error");
		view.addObject("ex", ex.toString());
	    System.err.println("访问" + request.getRequestURI() + " 发生错误, 错误信息:" + ex.toString());
	    return null;
	}

}

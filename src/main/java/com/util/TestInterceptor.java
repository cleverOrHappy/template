package com.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * 拦截器
 * @author zyh
 *
 */
public class TestInterceptor implements HandlerInterceptor{
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("1");
		
	}
  
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("2");
		
	}
	  //处理请求之前进行调用
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		 // 获取request里面的cookie cookie里面存值方式也是 键值对的方式 
		//如果没有 cookie，则返回 null。
    	Cookie[] cookiee= request.getCookies();
    	for (Cookie cookie : cookiee) {
    		String name = cookie.getName();
	    	if("keyadmin".equals(name)) {
	    		 break;
	    	}
		}
    	
    	for (Cookie cookie : cookiee) {
    		String name = cookie.getName();
	    	String value = cookie.getValue();
	    	if("keyad".equals(name)) {

					try {
						return true;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("過期。。。。");
					}
				
				
	    	}
		}
    	
    	
    	
		arg1.sendRedirect("index.do");
		return false;
	}

}

package com.action;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.json.JSONArray;

import com.util.Jwt;
import com.util.Req;

import io.jsonwebtoken.Claims;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 一般处理跳转
 * @author zyh
 *
 */
@Controller
public class IndexAction {
	@Autowired 
    HttpServletRequest request; //这里可以获取到request
   // 初始跳转
	@RequestMapping("/index.do")
	public String request() {
		return Req.req(null, "login");
		
	}
	
	//获取user
	    @ResponseBody
		@RequestMapping("/requestUser.do")
		public String requestUser( ) {
	    	String str=null;
	    	//如果没有 cookie，则返回 null。
	    	Cookie[] cookiee= request.getCookies();
	    	for (Cookie cookie : cookiee) {
	    		String name = cookie.getName();
		    	String value = cookie.getValue();
		    	if("keyadmin".equals(name)) {
		    		
		    			str="2";
			    	}
		    	if("keyad".equals(name)) {
    				try {
						Claims ke = Jwt.parseJWT(value); 
						System.out.println(ke.getSubject());
					    str=ke.getSubject();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						str="1";
					}
    			}
		    	
			}
	    	
			return str ;
		}
	//跳转到主页面去
	@RequestMapping("/requestHom.do")
	public String requestHom() {
		return Req.req("hom","homepage");
	}
	//注销跳转到登录页面
	@RequestMapping("/requestLogout.do")
	public String requestLogout(String accountId,HttpServletRequest request,HttpServletResponse response) {
		//try是为了防止没有登录而进入这url报出异常好进行及时捕获
		try {
			Cookie[] cookies = request.getCookies();  
			if (cookies != null && cookies.length > 0) {  
			    for (Cookie cookie : cookies) {  
			        String name = cookie.getName();  
			        // 找到需要删除的Cookie  
			        if (name.compareTo("keyadmin") == 0) {  
			            // 设置生存期为0  
			            cookie.setMaxAge(0);  
			            // 设回Response中生效  
			            response.addCookie(cookie);  
			        }  
			    }  
			}  
		} catch (Exception e) {
			return Req.req(null,"login");
		}
	
		return Req.req(null,"login");
	}
	
}

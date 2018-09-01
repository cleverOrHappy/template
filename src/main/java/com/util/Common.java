package com.util;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;



/**
 * 一些比较通用的方法进行封装
 * @author zyh
 *
 */
public class Common {
	private static Map<String, Object>map=null;
  /**字符串比较
   * 	
   * @param value 需要比较的值
   * @return true|| false
   */
	public static boolean eq(Object value) {
		if(null==value||"".equals(value)) {
			return false;
		}
		return true;
	}
	/**
	 * 获取一个随机的id
	 * @return
	 */
	public static String dateId() {
		       
		  Calendar calendar = Calendar.getInstance();
         return String.valueOf( calendar.getTime().getTime());
	}
	
	/**
	 * 实现一个map当缓存使用
	 * @return 
	 */
	public static Map<String, Object> map () {
		if(map==null) {
			map=  new HashMap<String, Object>();
		}
		return map;
		
	}
	/**
	 * java对象转换json
	 * @param obj 对象
	 * @return
	 */
	public static  String json(Object obj) {
		 JSONObject object = JSONObject.fromObject(obj);
		  return object.toString();
	}
	
	public static  String json(String obj) {
		 JSONObject object = JSONObject.fromObject(obj);
		  return object.toString();
	}

	/**
	 * 普通邮件进行发送  qq邮箱
	 */
	
	public static String qqmail() {
		
		return null;
		
	}
}

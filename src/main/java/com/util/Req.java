package com.util;
/**
 * 页面请求跳转
 * @author zyh
 *
 */
public class Req {
  /**跳转页面
   * 
   * @param packag 包名
   * @param vi 页面名称
   * @return
   */
	public static String req(String packag,String vi) {
		if(Common.eq(packag)&&Common.eq(vi)) {
			return "WEB-INF/view/"+packag+"/"+vi+".html";
		}
		return "WEB-INF/view/"+vi+".html";
	}
}

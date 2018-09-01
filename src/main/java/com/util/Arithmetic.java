package com.util;

import java.security.MessageDigest;
import java.util.Base64;



/**
 * 算法
 * @author zyh
 *
 */
public class Arithmetic {
/**
 * 加密算法
 * @param value 需要加密的参数
 * @return 获取加密的字符串
 */
	public static String md5(String value) {
		value+="zyh进行编译";
		try {
			MessageDigest md5= MessageDigest.getInstance("MD5");
			String consequence = Base64.getEncoder().encodeToString(md5.digest(value.getBytes("utf-8"))); 
			
			char[] chars = "0123456789ABCDEF".toCharArray();      
			StringBuilder sb = new StringBuilder("");    
			byte[] bs = consequence.getBytes();      
			int bit;      

			for (int i = 0; i < bs.length; i++)    
			{      
			    bit = (bs[i] & 0x0f0) >> 4;      
			    sb.append(chars[bit]);      
			    bit = bs[i] & 0x0f;      
			    sb.append(chars[bit]);    
			    
			}
			    
			byte[] bs1 = value.getBytes();      
			int bitt;      
			StringBuilder sb1 = new StringBuilder(""); 
			for (int i = 0; i < bs1.length; i++)    
			{      
				bitt = (bs1[i] & 0x0f0) >> 4;      
			    sb1.append(chars[bitt]);      
			    bitt = bs1[i] & 0x0f;      
			    sb1.append(chars[bitt]);        
			}      
			return sb.toString().trim()+sb1.toString().trim();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
}

package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 * 实现下载功能
 * @author zyh
 *
 */
public class Download {
	
	//实现了文件下载功能
public void  downloadFile(HttpServletResponse response,String url) {
	
	 FileInputStream fileInputStream = null;
	    ServletOutputStream servletOutputStream = null;

	    String filePath = url;
	    Calendar calendar = Calendar.getInstance();
	    try {
	        response.setContentType("application/x-msdownload;");
	        response.setHeader("Content-disposition", "attachment; filename=" + new String(String.valueOf( calendar.getTime().getTime()).getBytes("GBK"), "GBK"));
	        // 将本地文件装载到内存
	        fileInputStream = new FileInputStream(filePath);
	        // 实例化输出流
	        servletOutputStream = response.getOutputStream();
	        byte[] buff = new byte[2048];
	        int bytesRead;
	        // 每次尝试读取buff.length长字节，直到读完、bytesRead为-1
	        while ((bytesRead = fileInputStream.read(buff, 0, buff.length)) != -1) {
	            // 每次写bytesRead长字节
	            servletOutputStream.write(buff, 0, bytesRead);
	        }
	        // 刷新缓冲区
	        servletOutputStream.flush();
	    } catch (IOException e) {
	       
	    } finally {
	        if (fileInputStream != null) {
	            try {
	                fileInputStream.close();
	            } catch (IOException e) {
	               
	            }
	        }
	        if (servletOutputStream != null) {
	            try {
	                servletOutputStream.close();
	            } catch (IOException e) {
	            
	            }
	        }
	    }
	
}
//基于springMvc

public ResponseEntity<byte[]> download(String url) throws IOException {      
    File file=new File(url);  
    HttpHeaders headers = new HttpHeaders();    
    String fileName=new String("你好.xlsx".getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题  
    headers.setContentDispositionFormData("attachment", fileName);   
    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   
    return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
                                      headers, HttpStatus.CREATED);    
} 
}

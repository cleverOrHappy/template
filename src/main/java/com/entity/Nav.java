package com.entity;

import java.io.Serializable;

/**
 * 树形菜单属性类 
 * @author zyh
 *
 */
public class Nav implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private int id;	
	
	private int tid;
	
	private String state;
	
	private String text;
	
	private String url;
	
	private String iconCls;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
}

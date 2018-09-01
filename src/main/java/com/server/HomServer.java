package com.server;

import java.util.List;

import com.entity.Nav;

/**
 * 主页
 * @author zyh
 *
 */
public interface HomServer {
	//树形查询
	public  List<Nav> nav(Integer id);
}

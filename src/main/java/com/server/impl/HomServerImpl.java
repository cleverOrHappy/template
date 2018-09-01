package com.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.HomDao;
import com.entity.Nav;
import com.server.HomServer;
/**
 * 主页
 * @author zyh
 *
 */
@Service("homServer")
public class HomServerImpl implements HomServer {
	//依赖
	@Autowired
	private HomDao homDao;
	
	
	

	public HomDao getHomDao() {
		return homDao;
	}




	public void setHomDao(HomDao homDao) {
		this.homDao = homDao;
	}




	//树形查询
	@Override
	public List<Nav> nav(Integer id) {
		// TODO Auto-generated method stub
		return homDao.nav(id);
	}

}

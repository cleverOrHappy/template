package com.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AdminDao;
import com.entity.Admin;
import com.server.AdminServer;


/**
 * 账户
 * @author zyh
 *
 */
@Service("adminServer")
public class AdminServerImpl implements AdminServer {
	@Autowired
	private AdminDao adminDao;
	







public AdminDao getAdminDao() {
		return adminDao;
	}
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
//登录
public Admin login(Admin account) {
	return adminDao.login(account);
}
//查询
public List<Admin> adminInquery(int page,int rows,String adminSelectName) {
	return adminDao.adminInquery(page, rows,adminSelectName);
  	
  }
@Override
public int adminCount(String adminSelectName) {
	// TODO Auto-generated method stub	
	return adminDao.adminCount(adminSelectName);
}
@Override
public int adminAddMysql(Admin admin) {
	// TODO Auto-generated method stub
	return adminDao.adminAddMysql(admin);
}
@Override
public int admindeleteMysql(String id) {
	// TODO Auto-generated method stub
	return adminDao.admindeleteMysql(id);
}

@Override
public int adminupdateMysql(Admin admin) {
	// TODO Auto-generated method stub
	return adminDao.adminupdateMysql(admin);
}
@Override
public Admin adminupdate(String id) {
	// TODO Auto-generated method stub
	return adminDao.adminupdate(id);
}

}

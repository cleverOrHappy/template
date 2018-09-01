package com.server;

import java.util.List;

import com.entity.Admin;

/**
 * 账户
 * @author zyh
 *
 */
public interface AdminServer {
	//登录
public Admin login(Admin account);
//查询
public List<Admin> adminInquery(int page,int rows, String adminSelectName);
//查询总数
public int adminCount(String adminSelectName);
//增加账户
public int adminAddMysql(Admin admin);
//删除账户
public int admindeleteMysql(String id);
//修改账户的查询
public Admin adminupdate(String id);
//修改账户
public int adminupdateMysql(Admin admin);
}

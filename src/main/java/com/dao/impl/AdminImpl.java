package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.dao.AdminDao;
import com.entity.Admin;;

/**
 * 账户
 * 
 * @author zyh
 *
 */
@Repository("adminDao")
public class AdminImpl implements AdminDao {
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	// 登录
	public Admin login(Admin account) {
		Admin ac = this.sqlSessionTemplate.selectOne("com.dao.AdminDao.logionselect", account);
		return ac;
	}

	@Override
	public List<Admin> adminInquery(int page, int rows,String adminSelectName) {
		// TODO Auto-generated method stub
		Object[] array = { page, rows,adminSelectName};
		return this.sqlSessionTemplate.selectList("com.dao.AdminDao.inquery", array);
	}

	@Override
	public int adminCount(String adminSelectName) {
		// TODO Auto-generated method stub
		Object[] array = {adminSelectName};
		return this.sqlSessionTemplate.selectList("com.dao.AdminDao.count", array).size();
	}

	@Override
	public int adminAddMysql(Admin admin) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.insert("com.dao.AdminDao.add",admin);
	}

	@Override
	public int admindeleteMysql(String id) {
		// TODO Auto-generated method stub
		String[] array = {id };
		return  this.sqlSessionTemplate.delete("com.dao.AdminDao.delete",array);
	}

	@Override
	public Admin adminupdate(String id) {
		String[] array = {id};
		return  this.sqlSessionTemplate.selectOne("com.dao.AdminDao.update",array);
	}

	@Override
	public int adminupdateMysql(Admin admin) {
		// TODO Auto-generated method stub
		return   this.sqlSessionTemplate.update("com.dao.AdminDao.updatemysql",admin);
	}

}

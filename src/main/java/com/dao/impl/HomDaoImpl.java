package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.dao.HomDao;
import com.entity.Nav;

/**
 * 主页
 * @author zyh
 *
 */
@Repository("homDao")
public class HomDaoImpl implements HomDao{

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}



	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	//树形查询
	public  List<Nav> nav(Integer id) {
		return this.sqlSessionTemplate.selectList("com.dao.HomDao.navselect",id);
	}
}

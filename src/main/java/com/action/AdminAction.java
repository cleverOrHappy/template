package com.action;

import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Admin;
import com.server.AdminServer;
import com.util.Arithmetic;
import com.util.Common;
import com.util.Jwt;
import com.util.Req;

/*
 * 管理员action
 */
@Controller
public class AdminAction {
	@Autowired
	private AdminServer AdminServer;

	public AdminServer getAdminServer() {
		return AdminServer;
	}

	public void setAdminServer(AdminServer adminServer) {
		AdminServer = adminServer;
	}

	// 登录
	@ResponseBody
	@RequestMapping("/login.do")
	public String login(String loginId, String passWord, HttpServletResponse response, HttpSession session) {
		// 进行加密
		passWord = Arithmetic.md5(passWord);

		// 将账号密码丢入进去 账户的实体类中
		Admin ac = new Admin();
		ac.setAccountId(loginId);
		ac.setAccountPassWord(passWord);
		Admin re = AdminServer.login(ac);

		if (Common.eq(re)) {
			// 将名称给session进行保存
			// session.setAttribute("obj",re);

			// 判断存在的话就进行将账号存放到cookie内
			// new一个Cookie对象,键值对为参数 将 keyadmin 和 账号给cookie记录
			Cookie cookie = new Cookie("keyadmin", Jwt.createJWT("1", Common.json(re), 140000 * 2));
			Cookie cookiee = new Cookie("keyad", Jwt.createJWT("2", Common.json(re), 140000 * 2));
			// 如果cookie的值中含有中文时，需要对cookie进行编码，不然会产生乱码，在cookie保存敏感信息记得加密
			try {
				URLEncoder.encode("cookie的value值", "utf-8");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 设置Cookie最大生存时间,以秒为单位,负数的话为浏览器进程,关闭浏览器Cookie消失
			cookie.setMaxAge(-1);
			cookie.setPath("/");
			cookiee.setPath("/");
			cookiee.setMaxAge(-1);
			// 将Cookie添加到Response中,使之生效
			response.addCookie(cookie); // addCookie后，如果已经存在相同名字的cookie，则最新的覆盖旧的cookie4
			response.addCookie(cookiee); // addCookie后，如果已经存在相同名字的cookie，则最新的覆盖旧的cookie
			return "requestHom.do";
		}
		return "index.do";

	}

	/**
	 * 初次进入页面
	 */
	@RequestMapping("/requestIndex.do")
	public String index() {
		return Req.req("admin", "admin");
	}

	@ResponseBody
	@RequestMapping("/requestAdminInquery.do")
	public Map<String, Object> adminInquery(int page, int rows,String adminSelectName) {
		page = (page - 1) * rows;
		List<Admin> list = AdminServer.adminInquery(page, rows,adminSelectName);
		int count = AdminServer.adminCount(adminSelectName);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", count);// 总条数
		map.put("rows", list);// 数据
		return map;

	}

	@RequestMapping("/requestAdminAdd.do")
	public String adminAdd() {
		return Req.req("admin", "adminAdd");
	}

	@RequestMapping("/requestadminUpdate.do")
	public String adminUpdate() {
		return Req.req("admin", "adminUpdate");
	}

	// 增加账户
	@ResponseBody
	@RequestMapping("/requestAdminAddMysql.do")
	public String adminAddMysql(String name, String pwd, String bz) {
		pwd=Arithmetic.md5(pwd);
		Admin admin = new Admin();
		String id = Common.dateId();
		admin.setAccountId(id);
		admin.setAccountName(name);
		admin.setAccountPassWord(pwd);
		admin.setRemark(bz);
		int add = AdminServer.adminAddMysql(admin);
		if(add==1) {
			return id;
		}else {
			return "2";
		}
		

	}

	// 删除
	@ResponseBody
	@RequestMapping("/requestAdmindeleteMysql.do")
	public int admindeleteMysql(String id) {
		// TODO Auto-generated method stub
		return AdminServer.admindeleteMysql(id);
	}

	// 修改查询
	@ResponseBody
	@RequestMapping("/requestAdminupdate.do")
	public Admin adminupdate(String id) {
		// TODO Auto-generated method stub
		return AdminServer.adminupdate(id);
	}

	// 修改
	@ResponseBody
	@RequestMapping("/requestAdminUpdateMysql.do")
	public int adminupdateMysql(String name, String pwd, String bz,String pwdNone,String idNone) {
		if (!"".equals(pwd) || null != pwd) {
			pwd=Arithmetic.md5(pwd);
		}
		pwd=pwdNone;
		Admin admin = new Admin();
		admin.setAccountId(idNone);
		admin.setAccountName(name);
		admin.setAccountPassWord(pwd);
		admin.setRemark(bz);
		return AdminServer.adminupdateMysql(admin);
	}

}

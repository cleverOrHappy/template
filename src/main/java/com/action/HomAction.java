package com.action;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Nav;
import com.server.HomServer;

/**
 * 主页
 * @author zyh
 *
 */

@Controller
public class HomAction {
   //依赖server	
	@Autowired
	private HomServer homServer;
	
	
	



	public HomServer getHomServer() {
		return homServer;
	}






	public void setHomServer(HomServer homServer) {
		this.homServer = homServer;
	}





  //树形菜单
	@ResponseBody
    @RequestMapping("/nav")
	public  List<Nav> nav(@RequestParam(value = "id", required = false) Integer id){
		id = id == null ? 0 : id;
		return homServer.nav(id);
		
	}
}

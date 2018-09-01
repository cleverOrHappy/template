package template;

import java.util.Date;

import com.util.Jwt;

import io.jsonwebtoken.Claims;

public class test {
public static void main(String[] args) {
	/*
	String json=""
			+ "{"
			+"[age=12]"
			+ "}";
	try {
		
		//System.out.println(Jwt.createJWT("1",json , 6000000));
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		String jwt="eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiJEU1NGQVdEV0FEQVMuLi4iLCJzdWIiOiJ7W2FnZT0xMl19IiwidXNlcl9uYW1lIjoiYWRtaW4iLCJuaWNrX25hbWUiOiJEQVNEQTEyMSIsImV4cCI6MTUzNTcxMTIzMiwiaWF0IjoxNTM1NzA1MjMyLCJqdGkiOiIxIn0.UKPb5lZmArhRQMeZjp-8oWZl_KWWR63vfndX41wf5Ls";
		Claims c = Jwt.parseJWT(jwt);
		System.out.println("==========================================");//jwt
		System.out.println(c);//jwt
		System.out.println(c.getId());//jwt
        System.out.println(c.getIssuedAt());//Mon Feb 05 20:50:49 CST 2018
        System.out.println(c.getSubject());//{id:100,name:xiaohong}
        System.out.println(c.getIssuer());//null
        System.out.println(c.get("uid", String.class));//DSSFAWDWADAS...
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	long nowMillis = System.currentTimeMillis();//生成JWT的时间
	System.out.println(nowMillis);
	Date exp = new Date(nowMillis+60*5);
	System.out.println(exp.toString());
}
}

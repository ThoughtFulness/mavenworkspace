package com.aaa.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * className:LoginController
 * discriptoin:
 * author:毛宇
 * createTime:2018-11-15 22:04
 */
@Controller
public class LoginController {


	@RequestMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password){
		Subject subject = SecurityUtils.getSubject();
		if (!subject.isAuthenticated()){
			UsernamePasswordToken token = new UsernamePasswordToken(username,password);
			try {
				subject.login(token);
			} catch (AuthenticationException e) {
				e.printStackTrace();
			}
		}
		return "success";
	}

	/**
	 * 跳转登录界面
	 * @return
	 */
	@RequestMapping("/toLogin")
	public String toLogin(){

		return "login";
	}


	@RequestMapping("/test1")
	@ResponseBody
	public String test1(){
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.checkRole("admin");
		}catch (Exception e){
			return "不拥有admin角色";
		}
		return "拥有admin角色";
	}

	@RequestMapping("/test2")
	@ResponseBody
	public String test2(){
		Subject subject= SecurityUtils.getSubject();
		try {
			subject.checkRole("CEO");
		}catch (Exception e){
			return "不拥有CEO角色";
		}
		return "拥有CEO角色";
	}

}

package com.my.sm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * className:HelloWorldController
 * discriptoin:
 * author:毛宇
 * createTime:2018-11-09 14:41
 */
@RestController
public class HelloWorldController {

	/**
	 * 打印方法
	 * @return
	 */
	@RequestMapping("/hello")
	public Object print(){
		return "hello springBoot hello springBoot!!!";
	}
}

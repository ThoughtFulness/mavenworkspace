package com.aaa.aop.service;

/**
 * className:UserServiceImpl
 * discriptoin:模拟员工
 * author:毛宇
 * createTime:2018-11-08 14:00:42
 */
public class UserServiceImpl {

	/**
	 * 添加
	 */
	public void add(){
		System.out.println("模拟员工添加");
		//System.out.println("模拟日志记录。。。");
	}

	/**
	 * 修改
	 */
	public void update(){
		System.out.println("模拟员工修改");
		//System.out.println(1/0);
		String s=null;
		System.out.println(s.length());
		//System.out.println("模拟日志记录。。。");
	}

	/**
	 * 删除
	 */
	public void delete(){
		System.out.println("模拟员工删除");
		//System.out.println("模拟日志记录。。。");
	}
}

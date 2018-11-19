package com.aaa.aop.service;

import org.springframework.stereotype.Service;

/**
 * className:GoodsserviceImpl
 * discriptoin:
 * author:毛宇
 * createTime:2018-11-08 16:08
 */
@Service
public class GoodsServiceImpl {
	/**
	 * 添加
	 */
	public void add(){
		System.out.println("模拟商品添加");
		//String s=null;
		//System.out.println(s.length());
		//System.out.println("模拟日志记录。。。");
	}

	/**
	 * 修改
	 */
	public void update(){
		System.out.println("模拟商品修改");
		//System.out.println("模拟日志记录。。。");
	}

	/**
	 * 删除
	 */
	public void delete(){
		System.out.println("模拟商品删除");
		//System.out.println("模拟日志记录。。。");
	}
}

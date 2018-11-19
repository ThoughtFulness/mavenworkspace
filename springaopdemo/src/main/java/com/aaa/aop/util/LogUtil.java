package com.aaa.aop.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * className:LogUtil
 * discriptoin:通知类 是切面（日志记录功能）的具体实现类，放置切面代码的地方
 * author:毛宇
 * createTime:2018-11-08 14:08
 */
public class LogUtil {

	/**
	 * 记录日志功能
	 */
	public void saveLog(){
		System.out.println("模拟日志记录。。。");
	}

	/**
	 * 前置通知
	 */
	public void beforeAdvice(JoinPoint joinPoint){
		//获取连接点方法名称
		String name = joinPoint.getSignature().getName();
		System.out.println("执行业务方法"+name+"之前执行的操作。。。");
	}

	/**
	 *异常通知
	 * @param joinPoint
	 * @param ex
	 */
	public void exceptionAdvice(JoinPoint joinPoint,Exception ex){
		//获取连接点方法名称
		String name = joinPoint.getSignature().getName();
		System.out.println("执行业务方法"+name+"时候,发生了名称为"+ex.getClass().getName()+
				"的异常，异常名称为:"+ex.getMessage());
	}

	/**
	 * 最终通知
	 * @param joinPoint
	 */
	public void finalAdvice(JoinPoint joinPoint){
		System.out.println("无论连接点方法执行过程中有没有发生异常 都会执行------------");
	}

	/**
	 * 环绕通知
	 * @param proceedingJoinPoint
	 * @return
	 */
	public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		System.out.println(System.currentTimeMillis()+"在业务操作之前操作");
		//调用业务方法
		Object o=null;
		try {
			proceedingJoinPoint.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		System.out.println(System.currentTimeMillis()+"在业务操作之后操作");
		return o;
	}

}

package com.aaa.aop.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * className:LogUtilA
 * discriptoin:
 * author:毛宇
 * createTime:2018-11-08 16:17
 */
@Component //三个分层之外，用该注解
@Aspect //通知类的注解
public class LogUtilA {

	@Pointcut(value ="execution(void add*(..))||execution(void update*(..))")
	public void pointa(){

	}

	/**
	 * 记录日志功能
	 */
	//@AfterReturning(value = "pointa()")
	public void saveLog(){
		System.out.println("模拟日志记录。。。");
	}

	/**
	 * 前置通知
	 */
	//@Before(value = "pointa()")
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
	//@AfterThrowing(value = "pointa()",throwing = "ex")
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
	//@After(value = "pointa()")
	public void finalAdvice(JoinPoint joinPoint){

		System.out.println("无论连接点方法执行过程中有没有发生异常 都会执行------------");
	}

	/**
	 * 环绕通知
	 * @param proceedingJoinPoint
	 * @return
	 */
	@Around(value = "pointa()")
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

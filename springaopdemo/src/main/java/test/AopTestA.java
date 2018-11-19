package test;

import com.aaa.aop.service.GoodsServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * className:AopTestA
 * discriptoin:
 * author:毛宇
 * createTime:2018-11-08 16:24
 */
public class AopTestA {
	public static void main(String[] args) {
		//使用spring提供的配置文件加载类,加载配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springaop-annotation-config.xml");
		//使用BeanFactory接口中提供的getBean方法获取对象
		GoodsServiceImpl goodsServiceImpl = (GoodsServiceImpl) applicationContext.getBean("goodsServiceImpl");
		goodsServiceImpl.add();
		goodsServiceImpl.update();

	}
}

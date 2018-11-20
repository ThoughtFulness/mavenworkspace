package com.my.sm;

import com.my.sm.interceptor.LoginInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * className:MvcConfigClass
 * discriptoin:
 * author:毛宇
 * createTime:2018-11-10 16:44
 */
@SpringBootConfiguration//便是该类为配置类
public class MvcConfigClass implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		//配置自定义拦截路径 配置拦截路径addPathPatterns和不拦截路径excludePathPatterns 多个路径使用，隔开
		//registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/emp/toLogin","/emp/userLogin");
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/*/*").excludePathPatterns("/emp/toLogin","/emp/userLogin");
	}


}

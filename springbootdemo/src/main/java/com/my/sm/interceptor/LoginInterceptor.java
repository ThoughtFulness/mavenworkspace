package com.my.sm.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * className:LoginInterceptor
 * discriptoin:
 * author:毛宇
 * createTime:2018-11-10 16:38
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//进入业务方法之前

		Object user = request.getSession().getAttribute("user");
		/*if(user==null){
			response.sendRedirect("/sb/emp/toLogin");
			return false;
		}else {
			return true;
		}*/
		System.out.println("进入业务之前执行了过滤器");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
		//System.out.println("视图渲染之前调用的方法");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
		//System.out.println("无论如何都会执行的方法");
	}
}

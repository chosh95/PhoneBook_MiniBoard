package com.chobook.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.chobook.bean.UserBean;

public class NotLoginInterceptor implements HandlerInterceptor{
	
	private UserBean loginUserBean;
	
	public NotLoginInterceptor(UserBean loginUserBean) {
		this.loginUserBean = loginUserBean;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(loginUserBean.isLogin()==false) {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/notLogin");
			return false;
		}
		return true;
	}
}

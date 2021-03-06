package project.freehelp.webchat.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import project.freehelp.common.SettingSession;

public class MasterInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private SettingSession settingSession;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (settingSession.isLogin(request))
			return true;
		response.sendRedirect("../index");
		return false;
	}
}

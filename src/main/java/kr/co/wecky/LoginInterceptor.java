package kr.co.wecky;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession sesstion = request.getSession(false);
		if(sesstion != null) {
			Object object = sesstion.getAttribute("adminLoginedDto");
			if(object != null) {
				return true;
			}
		}
		response.sendRedirect(request.getContextPath() + "/admin/loginForm");
		return false;
	}

}

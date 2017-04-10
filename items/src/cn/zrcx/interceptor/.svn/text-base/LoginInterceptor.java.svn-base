package cn.zrcx.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	/*
	 * 表示在执行目标方法之前（执行该方法preHandle）权限判断
	 * 如果返回true表示可以调用目标方法，如果返回false就不会调用目标方法
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		    if(request.getSession().getAttribute("employee")==null)
		    {
		    	request.setAttribute("message", "您还没有登陆，请先登陆");
		    	request.getRequestDispatcher("/login.jsp").forward(request, response);
		    	return false;
		    }
		    
		    return true;
		    
		
	}
	
	/**
	  *  转向指定的视图
	*/
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	

}

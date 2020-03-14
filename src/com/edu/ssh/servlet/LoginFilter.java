package com.edu.ssh.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		
		String path = request.getServletPath();
		if(path.equals("/login.jsp") || path.equals("/loginAction") || path.endsWith(".css") 
				|| path.endsWith(".js") || path.startsWith("/images") || path.equals("/image.jsp")
				|| path.equals("codeVerify")){
			chain.doFilter(request, response);
			return;
		}
		String acount = (String)request.getSession().getAttribute("acount");
		System.out.println(acount+"||");
		if(acount == null){
			/*response.sendRedirect("/OrderSysSSH/login.jsp");*/
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}

package com.integrate;

import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.management.RuntimeErrorException;
import javax.security.auth.login.AccountException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class PrivilegeFilter
 */
public class PrivilegeFilter implements Filter {

	private Properties pp= new Properties();
	
    /**
     * Default constructor. 
     */
    public PrivilegeFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		pp=null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpServletRequest request = (HttpServletRequest) req;
		String requestURI=request.getRequestURI().replace(request.getContextPath()+"/", "");
		String action = req.getParameter("action");
		action=action==null?"":action;
		String uri=requestURI+"?action="+action;
		String role = (String) request.getSession(true).getAttribute("role");
		role=role==null?"guest":role;
		
		boolean authentificated=false;
		for(Object obj:pp.keySet()) {
			String key = ((String)obj);
			if(uri.matches(key.replace("?", "\\?").replace(".", "\\.").replace("*", "\\*"))) {
				if(role.equals(pp.get(key))) {
					authentificated=true;
					break;
				}
			}
		}
		if(!authentificated) {
			throw new RuntimeException(new com.integrate.Exception.AccountException("You have no right to access this PAGE!"));
		}
		chain.doFilter(req, res);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		String file = fConfig.getInitParameter("file");
		String realPath=fConfig.getServletContext().getRealPath(file);
		try {
			pp.load(new FileInputStream(realPath));
		} catch (Exception e) {
			fConfig.getServletContext().log("read privilege file failed.",e);
		}
	}

}

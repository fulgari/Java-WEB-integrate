package com.integrate;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.integrate.Exception.AccountException;
import com.integrate.Exception.BusinessException;

/**
 * Servlet Filter implementation class ExceptionHandleFilter
 */
public class ExceptionHandleFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ExceptionHandleFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		try {
		chain.doFilter(request, response);
		}catch (Exception e) {
			Throwable rootCauseThrowable = e; // find out root Exception
			while(rootCauseThrowable.getCause()!=null) {
				rootCauseThrowable=rootCauseThrowable.getCause();
			}
			String message=rootCauseThrowable.getMessage();
			message=message==null?"EXCEPTION:"+rootCauseThrowable.getClass().getName():message;
			request.setAttribute("message", message);
			request.setAttribute("e", e);
			if(rootCauseThrowable instanceof AccountException) {
				request.getRequestDispatcher("/AccountException.jsp").forward(request, response);
			}else if(rootCauseThrowable instanceof BusinessException){
				request.getRequestDispatcher("/BusinessException.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/Exception.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}


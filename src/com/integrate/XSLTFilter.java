package com.integrate;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Servlet Filter implementation class XSLTFilter
 */
@WebFilter("/XSLTFilter")
public class XSLTFilter implements Filter {

	private ServletContext servletContext;
    /**
     * Default constructor. 
     */
    public XSLTFilter() {
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
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		Source stySource=new StreamSource(servletContext.getRealPath("/MessageLog.xsl"));
		Source xmlSource=new StreamSource(servletContext.getRealPath(req.getRequestURI().replace(req.getContextPath()+"", "")));
		
		try {
			TransformerFactory factory=TransformerFactory.newInstance();
			Transformer transformer=factory.newTransformer(stySource);
			
			CharArrayWriter writer = new CharArrayWriter();
			StreamResult result = new StreamResult(writer);
			
			transformer.transform(xmlSource, result);
			
			res.setContentType("text/html");
			res.setContentLength(writer.toString().length());
			
			PrintWriter out=res.getWriter();
			out.write(writer.toString());
		} catch (Exception e) {
		}
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		servletContext=fConfig.getServletContext();
	}

}

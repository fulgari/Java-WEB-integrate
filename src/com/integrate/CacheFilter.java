package com.integrate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.CacheResponse;
import java.net.URLEncoder;

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

/**
 * Servlet Filter implementation class CacheFilter
 */
public class CacheFilter implements Filter {
	
	private ServletContext context;
	private File temporalDir;
	private long cacheTime=Long.MAX_VALUE;

    /**
     * Default constructor. 
     */
    public CacheFilter() {
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
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		if("POST".equals(req.getMethod())) {
			chain.doFilter(req, res);
			return;
		}
		String uri=req.getRequestURI();
		if(uri==null)
			uri="";
		uri=uri.replace(req.getContextPath()+"/", "");
		uri=uri.trim().length()==0?"index.jsp":uri;
		uri=req.getQueryString()==null?uri:(uri+"?"+req.getQueryString());
		
		File cacheFile=new File(temporalDir,URLEncoder.encode(uri,"UTF-8"));
		System.out.println(cacheFile);
		
		if(!cacheFile.exists()||cacheFile.length()==0||cacheFile.lastModified()<System.currentTimeMillis()-cacheTime) {
			CacheResponseWrapper cacheResponse = new CacheResponseWrapper(res);
			chain.doFilter(req, cacheResponse);
			
			char[] content=cacheResponse.getCacheWriter().toCharArray();
			temporalDir.mkdirs();
			cacheFile.createNewFile();
			
			Writer writer = new OutputStreamWriter(new FileOutputStream(cacheFile),"UTF-8");
			writer.write(content);
			writer.close();
		}
		
		String mimeType=context.getMimeType(req.getRequestURI());
		res.setContentType(mimeType);
		
		Reader ins=new InputStreamReader(new FileInputStream(cacheFile),"UTF-8");
		StringBuffer buffer = new StringBuffer();
		char[] cbuf = new char[1024];
		int len;
		while((len=ins.read(cbuf))>-1) {
			buffer.append(cbuf,0,len);
		}
		
		ins.close();
		
		res.getWriter().write(buffer.toString());
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		temporalDir = (File)fConfig.getServletContext().getAttribute("javax.servlet.context.tempdir");
		context=fConfig.getServletContext();
		cacheTime=new Long(fConfig.getInitParameter("cacheTime"));
	}

}

package com.integrate;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestServlet
 * #usage: showing all the info included (or packed) in the request class HttpServletRequest
 */
@WebServlet("/RequestServlet")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.log("run doGet()...");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String authType=request.getAuthType();
		String localAddr=request.getLocalAddr();
		String localName=request.getLocalName();
		int localport = request.getLocalPort();
		Locale locale = request.getLocale();
		String contextPath = request.getContextPath();
		String method=request.getMethod();
		String pathInfo=request.getPathInfo();
		String pathTranslated=request.getPathTranslated();
		String protocol=request.getProtocol();
		String remoteAddr = request.getRemoteAddr();
		int port = request.getRemotePort();
		String remoteUser=request.getRemoteUser();
		String requestedSessionId=request.getRequestedSessionId();
		String requesedSessiontId=request.getRequestedSessionId();
		String requestURI=request.getRequestURI();
		StringBuffer requestURL = request.getRequestURL();
		String scheme = request.getScheme();
		String serverName=request.getServerName();
		int serverPort = request.getServerPort();
		Principal userPrincipal=request.getUserPrincipal();
		String accept=request.getHeader("accept");
		String referer=request.getHeader("referer");
		String userAgent=request.getHeader("user-agent");
		String serverInfo=request.getServletContext().getServerInfo();
		
		
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Request Servlet</TITLE></HEAD>");
		out.println("<style>body, font, td, div{font-size:12px; line-height:18px;}</style>");
		out.println("<BODY>");
		out.println("<b>your ip is:</b>"+remoteAddr+"<b>, you are using: </b> "+userAgent+" <b> OS, you use</b> "+getLocale(locale)+". <br/>");
		out.println("<b>server ip: </b>"+localAddr+", situated at: "+localAddr+", server using port: "+serverPort+" your browser using: "+port+"<br/>");
		out.println("server app is: "+serverInfo+". server name is "+localName+"<br/>");
		out.println("your browser accept"+getAccept(accept)+", you are from referer: "+referer+"<br/>");
		out.println(" class is "+this.getClass().getCanonicalName()+"<br/>");
		out.println("protocol using: "+protocol+", url header: "+scheme+", server named: "+serverName+", URI is: "+requestURI+"<br/>");
		out.println(this.getServletContext().getRealPath("")+"  "+contextPath+"<br/>");
		out.println("<br/><br/><a href="+requestURI+"> click for refreshing. </a> ");
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private String getAccept(String accept) {
		StringBuffer buffer = new StringBuffer();
		if(accept.contains("image/gif")) buffer.append("GIF file, ");
		if(accept.contains("image/x-xbitmap")) buffer.append("BMP file, ");
		if(accept.contains("image/jpeg")) buffer.append("JPG file, ");
		if(accept.contains("application/vnd.ms-excel")) buffer.append("Excel file, ");
		if(accept.contains("application/vnd.ms-powerpoint")) buffer.append("PPT file, ");
		if(accept.contains("application/vnd.msword")) buffer.append("Word file, ");
		return buffer.toString().replace(", $", "");
	}
	
	private String getLocale(Locale locale) {
		if(Locale.FRENCH.equals(locale)) return "french";
		if(Locale.SIMPLIFIED_CHINESE.equals(locale)) return "french";
		if(Locale.TRADITIONAL_CHINESE.equals(locale)) return "french";
		if(Locale.ENGLISH.equals(locale)) return "french";
		if(Locale.JAPANESE.equals(locale)) return "french";
		return "unknown local language";
	}
	
	

}

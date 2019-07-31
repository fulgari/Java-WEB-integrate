package com.integrate;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetTimeServlet
 * #usage: shows how GET and POST works online differently
 */
@WebServlet("/GetTimeServlet")
public class GetTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetTimeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.log("running doGet method...");
		this.execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.log("running doPost method...");
		//doGet(request, response);
		this.execute(request, response);
	}
	
	public long getLastModified(HttpServletRequest request) {
		this.log("running getLastModified method..");
		return -1;
	}
	
	private void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String requestURI=request.getRequestURI(); // http header envoloped in form of request
		String method=request.getMethod();
		String param=request.getParameter("param");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("via method:"+method+", we have the param of:"+param+"<br/>");
		out.println("  <form action='"+requestURI+"' method='get'><input type='text' name='param' value='param string'><input type='submit' value='request with GET "+requestURI+"'></form>");
		out.println("  <form action='"+requestURI+"' method='post'><input type='text' name='param' value='param string'><input type='submit' value='request with POST "+requestURI+"'></form>");
		out.println("  <script>document.write('last modified at: '+document.lastModified);</script>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
}

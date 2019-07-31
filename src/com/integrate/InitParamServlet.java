package com.integrate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParamServlet
 */
@WebServlet("/InitParamServlet")
public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitParamServlet() {
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
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Please log in to check File 'Notice' (Servlet)</TITLE></HEAD>");
		out.println("<style>body, font, td, div{font-size:12px; line-height:18px;}</style>");
		out.println("<BODY>");
		out.println("<form action='"+request.getRequestURI()+"' method='post'>");
		out.println("please enter you account: <input type='text' name='username' style='width:200px'><br/>");
		out.println("please enter you password: <input type='password' name='password' style='width:200px'><br/><br/>");
		out.println("<input type='submit' value='   log in  '/>");
		out.println("</form>");
		out.println();
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Enumeration params =  this.getInitParameterNames();
		while(params.hasMoreElements()) {
			String usernameParam=(String) params.nextElement();
			String passnameParam=getInitParameter(usernameParam);
			if(usernameParam.equalsIgnoreCase(username) && passnameParam.equals(password)) {
				request.getRequestDispatcher("/WEB-INF/notice.html").forward(request, response);
				return;
			}
		}
		this.doGet(request, response);
	}

}

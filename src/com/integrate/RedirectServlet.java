package com.integrate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectServlet
 */
@WebServlet("/RedirectServlet")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Map<String, Integer> map = new HashMap<>();
    
    @Override
    public void init() throws ServletException{
    	map.put("/download/setup.exe", 0);
    	map.put("/download/application.zip", 0);
    	map.put("/download/01.mp3", 0);
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filename=request.getParameter("filename");
		// refresh
		response.setHeader("Refresh", "2; URL=http://localhost:8080/Integrate/SearchServlet");

		if(filename!=null) {
			int hit = map.get(filename);
			map.put(filename, ++hit);
			response.sendRedirect(request.getContextPath()+filename);
		}
		else {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("<HEAD><TITLE>Download Files</TITLE></HEAD>");
			out.println("<style>body, font, td, div{font-size:12px; line-height:18px;}</style>");
			out.println("<BODY>");
			out.println("<fieldset align=center style=width:90%><legend>File Download</legend>");
			out.println("<table width:100%>");
			out.println("<tr>");
			out.println("<td><b>File name</b></td>");
			out.println("<td><b>Download times</b></td>");
			out.println("<td><b>Download</b></td>");
			out.println("</tr>");

			for(Entry<String, Integer> entry : map.entrySet()) {
				out.println("<tr>");
				out.println("<td>"+entry.getKey()+"</td>");
				out.println("<td>"+entry.getValue()+"</td>");
				out.println("<td><a href='"+request.getRequestURI()+"?filename="+entry.getKey()+"' target='blank' onclick='location=location;'>Download</a></td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

    @Override
    public void destroy() {
    	map=null;
    }
}

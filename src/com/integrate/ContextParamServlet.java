package com.integrate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextParamServlet
 */
@WebServlet("/ContextParamServlet")
public class ContextParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContextParamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE>READ Context</TITLE></HEAD>");
		out.println("<link rel='stylesheet' type='text/css' href='../css/style.css'>");
		out.println("<BODY>");
		out.println("<div align=center><br/>");
		out.println("<fieldset style='width:90%'><legend>all the Context Params</legend><br/>");
		ServletContext sc = getServletConfig().getServletContext();
		String uploadFolder = sc.getInitParameter("upload folder");
		String allowedFileType = sc.getInitParameter("allowed file type");
		
		out.println("<div class='line'>");
		out.println("	<div align='left' class='leftDiv'>Real path</div>");
		out.println("	<div align='left' class='rightDiv'>"+sc.getRealPath(uploadFolder)+"</div>");
		out.println("</div>");

		out.println("<div class='line'>");
		out.println("	<div align='left' class='leftDiv'>Allowed File Type</div>");
		out.println("	<div align='left' class='rightDiv'>"+allowedFileType+"</div>");		
		out.println("</div>");
		out.println("</fileset></div>");
		
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

}

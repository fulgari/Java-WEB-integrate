package com.integrate;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println("pleas use POST to upload msg!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String sex=request.getParameter("sex");
		int age =0;
		try {
			age=Integer.parseInt(request.getParameter("age"));
		} catch (Exception e) {}
		Date birthday=null;
		try {
			DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			birthday=format.parse(request.getParameter("birthday"));
		} catch (Exception e) {}
		String area = request.getParameter("area");
		String btn = request.getParameter("btn");
		
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Thanks for filling the sheet.</TITLE></HEAD>");
		out.println("<div align=\"center\"><br/>");
		out.println("<fieldset style='width:90%'><legend>fill the blanks</legend><br/>");
		out.println("<div class='line'>");
		out.println("<div align='left' class='leftDiv'>Your name:</div>");
		out.println("<div align='left' class='rightDiv'>"+name+"</div>");
		out.println("</div>");
		out.println("<div class='line'>");
		out.println("<div align='left' class='leftDiv'>Your password:</div>");
		out.println("<div align='left' class='rightDiv'>"+password+"</div>");
		out.println("</div>");
		out.println("<div class='line'>");
		out.println("<div align='left' class='leftDiv'>Your gender:</div>");
		out.println("<div align='left' class='rightDiv'>"+sex+"</div>");
		out.println("</div>");
		out.println("<div class='line'>");
		out.println("<div align='left' class='leftDiv'>Your age:</div>");
		out.println("<div align='left' class='rightDiv'>"+age+"</div>");
		out.println("</div>");
		out.println("<div class='line'>");
		out.println("<div align='left' class='leftDiv'>Your birthday:</div>");
		out.println("<div align='left' class='rightDiv'>"+(new SimpleDateFormat("year yyyy, month MM, day dd").format(birthday)).toString()+"</div>");
		out.println("</div>");
		out.println("<div class='line'>");
		out.println("<div align='left' class='leftDiv'>Btn value:</div>");
		out.println("<div align='left' class='rightDiv'>"+btn+"</div>");
		out.println("</div>");
		out.println("<div class='line'>");
		out.println("<div align='left' class='leftDiv'></div>");
		out.println("<div align='left' class='rightDiv'><br/><input type='button' name='btn' value='return to the last page' onclick='history.go(-1); class='button'><br/>");
		out.println("</div>");
		out.println("</div>");
		out.println("<BODY>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}

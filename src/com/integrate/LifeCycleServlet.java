package com.integrate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */
@WebServlet("/LifeCycleServlet")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static double startPoint=0;
	
    @Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.log("running service() method..."); 
		super.service(arg0, arg1);
	}

	@Override
	public void init() throws ServletException {
		this.log("running init() method...");
		ServletConfig conf = this.getServletConfig(); 
		startPoint = Double.parseDouble(conf.getInitParameter("startPoint"));
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.log("running doGet() method...");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Calculate Personal Tax</TITLE></HEAD>");
		out.println("<link rel='stylesheet' type='text/css' href='../css/style.css'>");
		out.println("<BODY>");
		out.println("<div align='center'><br/><fieldset style=width:90%><legend>Person tax calculator</legend><br/>");	
		out.println("<form method='post'>");
		out.println("<div style='line'>");
		out.println("<div class='leftDiv'>Your salary</div><div class='rightDiv'><input type='text' name='income'> RMB</div>");
		out.println("</div>");
		out.println("<br/>");
		out.println("<div style='line'>");
		out.println("<div class='leftDiv'></div><div class='rightDiv'><input type='submit' value='calculate personal tax' class=button></div>");
		out.println("</div>");
		out.println("</form>");
		out.println("</BODY>");
		out.println("</HDML>");


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.log("running doPost() method...");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Calculate Personal Tax</TITLE></HEAD>");
		out.println("<link rel='stylesheet' type='text/css' href='../css/style.css'>");
		out.println("<BODY>");
		out.println("<div align='center'><br/><fieldset style=width:90%><legend>Person tax calculator</legend><br/>");
		
		try {
			double income=new Double(request.getParameter("income"));
			double charge = income-startPoint;
			double tax=0;
			if(charge<=0){
				tax=0;
			}
			if(charge>0&&charge<=500) {
				tax=charge*0.05;
			}
			if(charge>500&&charge<=2000) {
				tax=charge*0.1-25;
			}
			if(charge>2000&&charge<=5000) {
				tax=charge*0.15-125;
			}
			if(charge>5000&&charge<=20000) {
				tax=charge*0.20-375;
			}
			if(charge>20000&&charge<=40000) {
				tax=charge*0.25-1375;
			}
			if(charge>40000) {
				tax=charge*0.35-3375;
			}
			out.println("<div style='line'>");
			out.println("<div class='leftDiv'>Your salary</div><div class='rightDiv'>"+income+" RMB</div>");
			out.println("</div>");
			out.println("<div style='line'>");
			out.println("<div class='leftDiv'>You should pay TAX</div><div class='rightDiv'>"+tax+" RMB</div>");
			out.println("</div><br/>");

			out.println("<input type='button' onclick='history.go(-1);' value='back' class=button>");
		} catch(Exception e) {
			out.println("Please input numeric data.<input type='button' onclick='history.go(-1);' value='back' class=button>");
		}

		out.println();
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	@Override
	public void destroy() {
		this.log("running destroy...");
		startPoint=0;
	}
	

}

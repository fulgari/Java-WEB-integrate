package com.integrate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InjectionServlet
 */
@WebServlet("/InjectionServlet")
public class InjectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private @Resource(name="hello") String hello; // 单行获取字符串
	private @Resource(name="i") int i;

	@Resource(name="persons")
	private String persons; // 两行，通过注解获取字符串
	
	{
		try {
			Context ctx = new InitialContext(); //实例化一个Context对象
			String helloo = (String) ctx.lookup("hello"); //查找对应hello的env-entry
			Integer ii = (Integer) ctx.lookup("i");
			String personss = (String) ctx.lookup("persons");
		} catch (Exception e) { //可能会找不到，需要处理异常
			e.printStackTrace();
		}
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InjectionServlet() {
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
		out.println("<HEAD><TITLE>Injection Resource</TITLE></HEAD>");
		out.println("<style>body{font-size:12px;}</style>");
		
		out.println("<b>The String injected </b>: <br/> &nbsp;&nbsp;-&nbsp;"+hello+"<br/>");
		out.println("<b>The Integer injected </b>: <br/> &nbsp;&nbsp;-&nbsp;"+i+"<br/>");
		out.println("<b>The String array injected </b>: <br/>");
		for(String person:persons.split(",")){
			out.println("&nbsp;&nbsp;-&nbsp;"+person.trim()+"<br/>");
		}
		
		out.println("<BODY>");
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

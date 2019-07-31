package com.integrate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ThreadSafetyServlet
 */
@WebServlet("/ThreadSafetyServlet")
public class ThreadSafetyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String name;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThreadSafetyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		name = request.getParameter("name");
		try {
			Thread.sleep(10000);
		} catch(InterruptedException e) {}
		response.getWriter().println("hello, "+name+". you uploaded with GET");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		name = request.getParameter("name");
		response.getWriter().println("hello, "+name+". you uploaded with POST");
	}

}

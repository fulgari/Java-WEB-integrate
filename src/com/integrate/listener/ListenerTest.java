package com.integrate.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/**
 * Application Lifecycle Listener implementation class ListenerTest
 *
 */
@WebListener
public class ListenerTest implements HttpSessionListener, ServletContextListener, ServletRequestListener {

    /**
     * Default constructor. 
     */
    public ListenerTest() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
    	HttpSession session = arg0.getSession();
    	System.out.println("new Session, id="+session.getId());
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent arg0)  { 
         // TODO Auto-generated method stub
    	HttpServletRequest request=(HttpServletRequest) arg0.getServletRequest();
    	long time = System.currentTimeMillis()-(long)request.getAttribute("dateCreated");
    	System.out.println(request.getRemoteAddr()+" terminated, time:"+time+" ms");
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent arg0)  { 
    	HttpServletRequest request=(HttpServletRequest) arg0.getServletRequest();
    	String uri=request.getRequestURI();
    	uri=request.getQueryString()==null?uri:(uri+"?"+request.getQueryString());
    	request.setAttribute("dateCreated", System.currentTimeMillis());
    	System.out.println("IP:"+request.getRemoteAddr()+" request:"+uri);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	HttpSession session = arg0.getSession();
    	System.out.println("destroy Session, id="+session.getId());
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	ServletContext context = arg0.getServletContext();
    	System.out.println("destroying :"+context.getContextPath());
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	ServletContext context = arg0.getServletContext();
    	System.out.println("running :"+context.getContextPath());
    }
	
}

package com.integrate.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jsp.bean.PersonInfo;

/**
 * Application Lifecycle Listener implementation class LoginSessionListener
 *
 */
// singleton login listener
@WebListener
public class LoginSessionListener implements HttpSessionAttributeListener {
	
	Map<String, HttpSession> map = new HashMap<>(); 
	Log log=LogFactory.getLog(this.getClass());

    /**
     * Default constructor. 
     */
    public LoginSessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
    	String name=arg0.getName();
    	if(name.equals("personInfo")) {
    		PersonInfo personInfo=(PersonInfo) arg0.getValue();
    		if(map.get(personInfo.getAccount())!=null) {
    			HttpSession session=map.get(personInfo.getAccount());
    			PersonInfo oldPersonInfo=(PersonInfo) session.getAttribute("personInfo");
    			log.info("user "+oldPersonInfo.getAccount()+" at "+oldPersonInfo.getIp()+" forced to logout");
    			session.removeAttribute("personInfo");
    			session.setAttribute("msg", "logged in at other place");
    		}
    		map.put(personInfo.getAccount(),arg0.getSession());
    		log.info("user "+personInfo.getAccount()+" at "+personInfo.getIp()+" log in");
    	}
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
    	String name=arg0.getName();
    	if(name.equals("personInfo")) {
    		PersonInfo personInfo = (PersonInfo) arg0.getValue();
    		map.remove(personInfo.getAccount());
    		log.info("user "+personInfo.getAccount()+" log out.");
    	}
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    // combination of the Added() and Removed()
    // BindingEvent has name and value for the current thing, and have a Session for the future thing
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
    	String name=arg0.getName();
    	if(name.equals("personInfo")) {
    		PersonInfo oldPersonInfo = (PersonInfo) arg0.getValue();
    		map.remove(oldPersonInfo.getAccount());
    		PersonInfo personInfo=(PersonInfo) arg0.getSession().getAttribute("personInfo");
    		if(map.get(personInfo.getAccount())!=null) {
    			HttpSession session=map.get(personInfo.getAccount());
    			log.info("user "+oldPersonInfo.getAccount()+" at "+oldPersonInfo.getIp()+" forced to logout");
    			session.removeAttribute("personInfo");
    			session.setAttribute("msg", "logged in at other place");
    		}
    		map.put(personInfo.getAccount(), arg0.getSession());
    	}
    }
	
}

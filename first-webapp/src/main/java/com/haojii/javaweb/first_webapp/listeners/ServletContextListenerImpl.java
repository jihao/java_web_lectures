package com.haojii.javaweb.first_webapp.listeners;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.haojii.javaweb.first_webapp.usermgmt.User;

/**
 * Application Lifecycle Listener implementation class ServletContextListenerImpl
 *
 */
public class ServletContextListenerImpl implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ServletContextListenerImpl() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        HashMap<String, User> userMap = createUserMap();
        context.setAttribute("userMap", userMap);
    }

	private HashMap<String, User> createUserMap() {
		HashMap<String,User> userMap = new HashMap<String, User>();
		
		userMap.put("steve", new User("steve","steve",getDate("1981-01-01"),"steve@haojii.com"));
		userMap.put("bill", new User("bill","bill",getDate("1982-01-01"),"bill@haojii.com"));
		userMap.put("tim", new User("tim","tim",getDate("1983-01-01"),"tim@haojii.com"));
		userMap.put("zark", new User("zark","zark",getDate("1984-01-01"),"steve@haojii.com"));
		userMap.put("hao", new User("hao","hao",getDate("1985-01-01"),"hao@haojii.com"));
		
		return userMap;
	}
	
	private Date getDate(String yyyyMMdd){
		Date d = null;
		try {
			d = new SimpleDateFormat("yyyy-MM-dd").parse(yyyyMMdd);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
    

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub
    }
	
}

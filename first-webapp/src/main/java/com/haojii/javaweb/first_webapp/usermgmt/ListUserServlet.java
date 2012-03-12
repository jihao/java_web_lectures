package com.haojii.javaweb.first_webapp.usermgmt;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListUserServlet
 */
public class ListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get servletContext from httpSession
		ServletContext context = request.getSession().getServletContext();
		// get userMap from servletContext
		HashMap<String,User> userMap = (HashMap<String,User>)context.getAttribute("userMap");
		System.out.println(userMap.size());
		// just a demo to convert it to a List
		List<User> userList = extractUserList(userMap);
		System.out.println(userList.size());
		// set request attribute
		request.setAttribute("userList", userList);
		// forward the request
		request.getRequestDispatcher("/user/list.jsp").forward(request, response);
	}

	private List<User> extractUserList(HashMap<String, User> userMap) {
		List<User> userList = new LinkedList<User>();
		Iterator<Entry<String, User>> itr = userMap.entrySet().iterator();
		while(itr.hasNext()) {
			User u = itr.next().getValue();
			userList.add(u);
		}
		return userList;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

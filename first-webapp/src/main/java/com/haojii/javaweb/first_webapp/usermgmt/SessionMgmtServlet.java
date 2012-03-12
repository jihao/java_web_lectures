package com.haojii.javaweb.first_webapp.usermgmt;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionMgmtServlet
 */
public class SessionMgmtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionMgmtServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dispatchToLoginPage(request, response);
	}

	private void dispatchToLoginPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/user/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = (String)request.getParameter("method");
		HttpSession session = request.getSession();
		if(method.equalsIgnoreCase("logout")) {
			session.invalidate();
			redirectToUserHome(request, response);
		}
		else if(method.equalsIgnoreCase("login")) {
			String username = (String)request.getParameter("username");
			String password = (String)request.getParameter("password");
			handleLogin(request, response, session, username, password);
		}
	}

	private void redirectToUserHome(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		//oh, what is the contextPath?
		String contextPath = request.getSession().getServletContext().getContextPath();
		response.sendRedirect(contextPath.concat("/users"));
	}

	private void handleLogin(HttpServletRequest request,
			HttpServletResponse response, HttpSession session, String username,
			String password) throws IOException,
			ServletException {
		ServletContext context = session.getServletContext();
		boolean result = UserService.login( username, password, context);
		if(result) {
			storeUserSession(session, username);
			redirectToUserHome(request, response);
		}
		else {
			dispatchToLoginPage(request, response);
		}
	}

	/**
	 * store current user to session
	 * @param session
	 * @param username
	 * @param context
	 */
	private void storeUserSession(HttpSession session, String username) {
		User user = UserService.findUserByName(username, session.getServletContext());
		session.setAttribute("CURRENT_USER", user);
	}

	
	

}

package com.codegnan.cms.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(LogoutServlet.class);


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the current session, or create a new one if it doesn't exist
      logger.debug("Logging out bye bye************************************************************");
    	HttpSession session = request.getSession(false);

        if (session != null) {
        	session.setAttribute("userLoggedIn", false); 
            // Invalidate the session to log the user out
            session.invalidate();
        }

        // Redirect to the login page or any other page as needed
        response.sendRedirect("login.jsp");
    }
}

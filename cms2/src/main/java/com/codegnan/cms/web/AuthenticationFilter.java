package com.codegnan.cms.web;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.codegnan.cms.servlet.UpdateCandidateServlet;

@WebFilter("/*") // Apply the filter to all URLs
public class AuthenticationFilter implements Filter {
	private static final Logger logger = Logger.getLogger(AuthenticationFilter.class);


    private String excludedUrls[] = {"/LoginServlet", "/login.jsp", "/index.jsp", "/","/css/ccms.css","http://localhost:8080/ccms/images/1.png"};

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String requestURI = httpRequest.getRequestURI();
        HttpSession session = httpRequest.getSession(false); // Don't create a new session if it doesn't exist

        // Check if the request is for the login page
        String loginPage = httpRequest.getContextPath() + "/login.jsp";
        String indexPage = httpRequest.getContextPath() + "/index.jsp";
        boolean isIndexPage = httpRequest.getRequestURI().equals(indexPage);
        boolean isLoginPage = httpRequest.getRequestURI().equals(loginPage);
        
		/*
		 * boolean isExcluded = Arrays.asList(excludedUrls).contains(requestURI);
		 * System.out.println("isExcluded::::::::::::::::"+isExcluded);
		 */
        // Check if the user is authenticated by checking session attributes
        boolean isAuthenticated = session != null && session.getAttribute("userLoggedIn") != null;

        if (requestURI.endsWith("/images/1.png") || 
        		requestURI.equals(httpRequest.getContextPath() + 
        				"/LoginServlet") || requestURI.equals(httpRequest.getContextPath() + "/") 
        		|| requestURI.equals(httpRequest.getContextPath() + "/login.jsp")
        		|| requestURI.equals(httpRequest.getContextPath() + "/unauthenticated.jsp")
        		||requestURI.equals(httpRequest.getContextPath()+"/css/ccms.css")) {
            // URL is excluded, continue the request without filtering
            chain.doFilter(request, response);
        } else if (isAuthenticated) {
            // User is authenticated, continue the request
            chain.doFilter(request, response);
        } else {
            // User is not authenticated and not accessing the login page, redirect to the login page
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/unauthenticated.jsp");
        }
    }

    // Other filter methods (init and destroy) can be left empty or implemented as needed
}

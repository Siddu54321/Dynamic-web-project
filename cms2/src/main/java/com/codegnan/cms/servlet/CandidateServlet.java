package com.codegnan.cms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.codegnan.cms.beans.Candidate;
import com.codegnan.cms.service.CandidateService;

@WebServlet("/list")
public class CandidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CandidateService candidateService;
    private static final Logger logger = Logger.getLogger(CandidateServlet.class);

	public void init() {
	
			candidateService = new CandidateService();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			logger.debug("contextPath:::::::::getContextPath:::::::::" + request.getContextPath());
			String action = request.getServletPath();
			logger.debug("action:::::::::getServletPath:::::::::" + action);
			List<Candidate> listCandidates = candidateService.selectAllCandidates();
			request.setAttribute("listCandidate", listCandidates);
			RequestDispatcher dispatcher = request.getRequestDispatcher("candidateslist.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "An error occurred while processing your request.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}
	}
}

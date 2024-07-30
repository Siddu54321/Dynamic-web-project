package com.codegnan.cms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
*/
import org.apache.log4j.Logger;

import com.codegnan.cms.beans.Candidate;
import com.codegnan.cms.service.CandidateService;

@WebServlet("/update")
public class UpdateCandidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UpdateCandidateServlet.class);

	private CandidateService candidateService;

	public void init() {

		candidateService = new CandidateService();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		logger.debug("contextPath:::::::::getContextPath:::::::::" + request.getContextPath());

		String action = request.getServletPath();

		logger.debug("action:::::::::getServletPath:::::::::" + action);
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String qualification = request.getParameter("qualification");
		String state = request.getParameter("state");

		Candidate candidate = new Candidate(id, name, gender, email, qualification, state);

		candidateService.updateCandidate(candidate);

		response.sendRedirect(request.getContextPath() + "/list");

	}

}
package com.codegnan.cms.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.codegnan.cms.dao.CandidateDAO;
import com.codegnan.cms.service.CandidateService;

@WebServlet("/delete")
public class DeleteCandidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(DeleteCandidateServlet.class);

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

		candidateService.deleteCandidate(id);

		response.sendRedirect(request.getContextPath() + "/list");

	}
}

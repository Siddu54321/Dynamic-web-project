package com.codegnan.cms.service;

import java.util.List;

import com.codegnan.cms.beans.Candidate;
import com.codegnan.cms.dao.CandidateDAO;

public class CandidateService {
	private CandidateDAO candidateDAO;

	public CandidateService() {
		this.candidateDAO = new CandidateDAO();

	}

	public void insertCandidate(Candidate candidate) {
		candidateDAO.insertCandidate(candidate);
	}

	public Candidate selectCandidate(int id) {
		return candidateDAO.selectCandidate(id);
	}

	public List<Candidate> selectAllCandidates() {
		return candidateDAO.selectAllCandidates();
	}

	public boolean deleteCandidate(int id) {
		return candidateDAO.deleteCandidate(id);
	}

	public boolean isValidUser(String username, String password) {
		return candidateDAO.isValidUser(username, password);
	}

	public boolean updateCandidate(Candidate candidate) {
		return candidateDAO.updateCandidate(candidate);
	}
}

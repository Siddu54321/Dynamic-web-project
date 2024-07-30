package com.codegnan.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.codegnan.cms.beans.Candidate;
import com.codegnan.cms.helper.ConnectionManager;

public class CandidateDAO {
    private static final Logger logger = Logger.getLogger(CandidateDAO.class);

    private static final String INSERT_CANDIDATES_SQL = "INSERT INTO candidate (name, gender, email, qualification, state) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_CANDIDATE_BY_ID = "SELECT id, name, gender, email, qualification, state FROM candidate WHERE id = ?";
    private static final String SELECT_ALL_CANDIDATES = "SELECT * FROM candidate";
    private static final String DELETE_CANDIDATES_SQL = "DELETE FROM candidate WHERE id = ?;";
    private static final String UPDATE_CANDIDATES_SQL = "UPDATE candidate SET name = ?, gender = ?, email = ?, qualification = ?, state = ? WHERE id = ?;";
    private static final String SELECT_USER_BY_USERNAME = "SELECT * FROM users WHERE username = ? AND password = ?;";

    public void insertCandidate(Candidate candidate) {
        try (Connection con = ConnectionManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(INSERT_CANDIDATES_SQL)) {
            ps.setString(1, candidate.getName());
            ps.setString(2, candidate.getGender());
            ps.setString(3, candidate.getEmail());
            ps.setString(4, candidate.getQualification());
            ps.setString(5, candidate.getState());
            ps.executeUpdate();
            con.commit();
            logger.info("Inserted candidate: " + candidate);
        } catch (SQLException e) {
            logger.error("Error inserting candidate: " + candidate, e);
        }
    }

    public boolean isValidUser(String username, String password) {
        boolean isValidUser = false;
        try (Connection con = ConnectionManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_USER_BY_USERNAME)) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                isValidUser = rs.next();
            }
            logger.info("User validation for username: " + username + " - " + isValidUser);
        } catch (SQLException e) {
            logger.error("Error validating user: " + username, e);
        }
        return isValidUser;
    }

    public Candidate selectCandidate(int id) {
        Candidate candidate = null;
        try (Connection con = ConnectionManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_CANDIDATE_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    candidate = new Candidate(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getString("email"),
                        rs.getString("qualification"),
                        rs.getString("state")
                    );
                }
            }
            logger.info("Selected candidate by ID: " + id);
        } catch (SQLException e) {
            logger.error("Error selecting candidate by ID: " + id, e);
        }
        return candidate;
    }

    public List<Candidate> selectAllCandidates() {
        List<Candidate> candidates = new ArrayList<>();
        try (Connection con = ConnectionManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_ALL_CANDIDATES);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                candidates.add(new Candidate(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("gender"),
                    rs.getString("email"),
                    rs.getString("qualification"),
                    rs.getString("state")
                ));
            }
            logger.info("Selected all candidates");
        } catch (SQLException e) {
            logger.error("Error selecting all candidates", e);
        }
        return candidates;
    }

    public boolean deleteCandidate(int id) {
        boolean rowDeleted = false;
        try (Connection con = ConnectionManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(DELETE_CANDIDATES_SQL)) {
            ps.setInt(1, id);
            rowDeleted = ps.executeUpdate() > 0;
            con.commit();
            logger.info("Deleted candidate with ID: " + id);
        } catch (SQLException e) {
            logger.error("Error deleting candidate with ID: " + id, e);
        }
        return rowDeleted;
    }

    public boolean updateCandidate(Candidate candidate) {
        boolean rowUpdated = false;
        try (Connection con = ConnectionManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(UPDATE_CANDIDATES_SQL)) {
            ps.setString(1, candidate.getName());
            ps.setString(2, candidate.getGender());
            ps.setString(3, candidate.getEmail());
            ps.setString(4, candidate.getQualification());
            ps.setString(5, candidate.getState());
            ps.setInt(6, candidate.getId());
            rowUpdated = ps.executeUpdate() > 0;
            con.commit();
            logger.info("Updated candidate: " + candidate);
        } catch (SQLException e) {
            logger.error("Error updating candidate: " + candidate, e);
        }
        return rowUpdated;
    }
}

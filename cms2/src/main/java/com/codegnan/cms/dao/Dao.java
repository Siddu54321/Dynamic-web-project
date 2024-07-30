package com.codegnan.cms.dao;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.codegnan.cms.helper.ConnectionManager;

public class Dao {
    private static final Logger logger = Logger.getLogger(Dao.class);
    Connection con;

    public Dao() {
        try {
            con = ConnectionManager.getInstance().getConnection();
            logger.info("Connection established in Dao");
        } catch (SQLException e) {
            logger.error("Error establishing connection in Dao", e);
        }
    }

    public void commit() {
        try {
            if (con != null && !con.isClosed()) {
                con.commit();
                logger.info("Transaction committed");
            }
        } catch (SQLException e) {
            logger.error("Error committing transaction", e);
        } finally {
            closeConnection();
        }
    }

    public void rollback() {
        try {
            if (con != null && !con.isClosed()) {
                con.rollback();
                logger.info("Transaction rolled back");
            }
        } catch (SQLException e) {
            logger.error("Error rolling back transaction", e);
        } finally {
            closeConnection();
        }
    }

    private void closeConnection() {
        if (con != null) {
            ConnectionManager.closeConnection(con);
            logger.info("Connection closed in Dao");
        }
    }
}

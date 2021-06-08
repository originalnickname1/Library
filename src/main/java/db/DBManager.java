package db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

    private static final Logger log = LogManager.getLogger(DBManager.class);
    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/library_db?useSSL=false";
    private static final String LOGIN_AND_PASSWORD = "root";

    private static DBManager instance;

    public static synchronized DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    private DBManager() {

    }

    public Connection getConnection() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            log.error("Failed to get connection to database : " + e);
        }
        Connection con = DriverManager
                .getConnection(DB_URL,LOGIN_AND_PASSWORD,LOGIN_AND_PASSWORD);
        con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        con.setAutoCommit(false);
        return con;
    }


    public void commitAndClose(Connection con) {
        try {
            System.out.println("Connection in commitAndClose ==> " + con);
            con.commit();
            con.close();
        } catch (SQLException ex) {
            log.error("Commit and close method error! " + ex);
        }
    }

    public void rollbackAndClose(Connection con) {
        try {
            con.rollback();
            con.close();
        } catch (SQLException ex) {
            log.error("Commit and rollback method error! " + ex);
        }
    }
}

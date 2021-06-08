package db;

import db.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private static final Logger log = LogManager.getLogger(UserDao.class);

    private static final String FIND_USER_BY_LOGIN =
            "select * from users where login=?";
    private static final String FIND_USER_BY_ID =
            "SELECT * FROM users WHERE id=?";
    private static final String DELETE_USER_BY_LOGIN =
            "delete from user where username='?'";
    private static final String DELETE_USER_BY_ID =
            "delete from user where id=?";


    /**
     * Searching for user by login
     *
     * @param login
     * @return user if exists
     */
    public static User findUserByLogin(String login) {

        User user = null;
        PreparedStatement pstmt;
        ResultSet rs;
        Connection con = null;
        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(FIND_USER_BY_LOGIN);
            pstmt.setString(1, login);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                user = returnExistedUser(rs);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(con);
            log.error("Failed to findUserByLogin in UserDAO! " + ex);
        } finally {
            DBManager.getInstance().commitAndClose(con);
        }
        return user;
    }

    /**
     * Searching for a user by id
     *
     * @param id
     * @return user if exists
     */
    public static User findUserById(Integer id) {

        User user = null;
        PreparedStatement pstmt;
        ResultSet rs;
        Connection con = null;
        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(FIND_USER_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                user = returnExistedUser(rs);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(con);
            log.error("Failed to findUserByLogin in UserDAO! " + ex);
        } finally {
            DBManager.getInstance().commitAndClose(con);
        }
        return user;
    }

    public static boolean deleteUserByLogin(String login) {
        User user = null;
        PreparedStatement pstmt;
        ResultSet rs;
        Connection con = null;
        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(DELETE_USER_BY_ID);
            pstmt.setString(1, login);
            rs = pstmt.executeQuery();
            rs.close();
            pstmt.close();
            return true;
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(con);
            log.error("Failed to findUserByLogin in UserDAO! " + ex);
        } finally {
            DBManager.getInstance().commitAndClose(con);
        }
        return false;
    }

    public static void createUser(
            String login, String password, String firstName, String lastName, Integer roleId) {

        PreparedStatement pstmt;
        Connection con = null;
        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQLFields.SQL_CREATE_USER);
            pstmt.setString(1, login);
            pstmt.setString(2, password);
            pstmt.setString(3, firstName);
            pstmt.setString(4, lastName);
            pstmt.setInt(5, roleId);
            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(con);
            log.error("Failed to findUserByLogin in UserDAO! " + ex);
        } finally {
            DBManager.getInstance().commitAndClose(con);
        }
    }

    private static User returnExistedUser(ResultSet rs) {
        try {
            User user = new User();
            user.setId(rs.getInt(SQLFields.ENTITY_ID));
            user.setLogin(rs.getString(SQLFields.ENTITY_LOGIN));
            user.setPassword(rs.getString(SQLFields.ENTITY_PASSWORD));
            user.setFirstName(rs.getString(SQLFields.ENTITY_FIRST_NAME));
            user.setLastName(rs.getString(SQLFields.ENTITY_LAST_NAME));
            user.setBlocked(rs.getString(SQLFields.ENTITY_BLOCKED));
            user.setRoleId(rs.getInt(SQLFields.ENTITY_ROLES_ID));
            return user;
        } catch (SQLException ex) {
            log.error("Failed to create user in UserDAO#createUser" + ex);
        }
        return null;
    }

}

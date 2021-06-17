package db;

import db.entity.LibraryCard;
import db.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static final Logger log = LogManager.getLogger(UserDao.class);

    //sql select strings
    private static final String SQL_GET_ALL_USERS =
            "SELECT * FROM users";
    private static final String SQL_FIND_USER_BY_ID =
            "SELECT * FROM users WHERE id=?";
    private static final String SQL_FIND_USER_BY_LOGIN =
            "SELECT * FROM users WHERE login=?";
    public static final String SQL_FIND_LIBRARY_CARD_BY_ID =
            "SELECT * FROM library_cards WHERE users_id=?";

    //sql delete strings
    private static final String SQL_DELETE_USER_BY_ID =
            "DELETE FROM users WHERE id=?";
    private static final String SQL_DELETE_USER_BY_LOGIN =
            "DELETE  FROM users WHERE login=?";
    //sql insert strings
    private static final String SQL_CREATE_USER =
            "INSERT INTO users (login,password,first_name,last_name,roles_id) VALUES ( ?, ?, ?, ?, ? );";
    private static final String SQL_CREATE_LIBRARY_CARD =
            "INSERT INTO library_cards (users_id) VALUES(?)";
    //sql update strings
    private static final String SQL_UPDATE_USER =
            "UPDATE users SET login = ?, password=?, first_name=?, last_name=?, blocked=?, roles_id=?  WHERE id = ?";
    public static final String SQL_UPDATE_LIBRARY_CARD =
            "UPDATE library_cards SET time_book_taken =?, fine=? WHERE id = ?";


    /**
     * Creates User and Library Card in database
     *
     * @param login
     * @param password
     * @param firstName
     * @param lastName
     * @param roleId
     */
    public static void createUser(
            String login, String password, String firstName, String lastName, Integer roleId) {

        PreparedStatement pstmt;
        Connection con = null;
        try {
            /**
             * Creates user in database
             */
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_CREATE_USER);
            pstmt.setString(1, login);
            pstmt.setString(2, password);
            pstmt.setString(3, firstName);
            pstmt.setString(4, lastName);
            pstmt.setInt(5, roleId);
            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(con);
            log.error("Failed to create user in UserDAO! " + ex);
        } finally {
            DBManager.getInstance().commitAndClose(con);
        }
    }
    public static void createLibraryCard(String userLogin) {
        PreparedStatement pstmt;
        Connection con = null;
        User user = findUserByLogin(userLogin);
        Integer userId = user.getId();
        System.out.println("user id in createLibrarycard==> " + userId);
        try {
            con = DBManager.getInstance().getConnection();
            System.out.println("user in createLibrarycard =>>" + user);
            pstmt = con.prepareStatement(SQL_CREATE_LIBRARY_CARD);
            pstmt.setInt(1, userId);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex){
            DBManager.getInstance().rollbackAndClose(con);
            log.debug("failed to create libr card in userdao! " + ex);

        }finally {
            DBManager.getInstance().commitAndClose(con);
        }
    }

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
            pstmt = con.prepareStatement(SQL_FIND_USER_BY_LOGIN);
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
            pstmt = con.prepareStatement(SQL_FIND_USER_BY_ID);
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
    public static LibraryCard findLibraryCardById(Integer id) {

        LibraryCard lc = null;
        PreparedStatement pstmt;
        ResultSet rs;
        Connection con = null;
        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_FIND_LIBRARY_CARD_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {

            }
            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(con);
            log.error("Failed to findUserByLogin in UserDAO! " + ex);
        } finally {
            DBManager.getInstance().commitAndClose(con);
        }
        return lc;
    }

    public static void deleteUserById(Integer id) {
        PreparedStatement pstmt;
        Connection con = null;
        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_DELETE_USER_BY_ID);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(con);
            log.error("Failed to deleteUserById in UserDAO! " + ex);
        } finally {
            DBManager.getInstance().commitAndClose(con);
        }
    }

    public static List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        User user;
        Statement stmt;
        ResultSet rs;
        Connection con = null;
        try {
            con = DBManager.getInstance().getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL_GET_ALL_USERS);
            while (rs.next()){
                user = returnExistedUser(rs);
                users.add(user);
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(con);
            log.error("Failed to findUserByLogin in UserDAO! " + ex);
        } finally {
            DBManager.getInstance().commitAndClose(con);
        }
        return users;
    }

    public static void updateUser(
            Integer id, String login, String password, String firstName, String lastName, Integer blocked, Integer roleId) {

        PreparedStatement pstmt;
        Connection con = null;
        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE_USER);
            pstmt.setString(1, login);
            pstmt.setString(2, password);
            pstmt.setString(3, firstName);
            pstmt.setString(4, lastName);
            pstmt.setInt(5,blocked);
            pstmt.setInt(6, roleId);
            pstmt.setInt(7,id);
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
            user.setId(rs.getInt(SQLFields.USER_ID));
            user.setLogin(rs.getString(SQLFields.USER_LOGIN));
            user.setPassword(rs.getString(SQLFields.USER_PASSWORD));
            user.setFirstName(rs.getString(SQLFields.USER_FIRST_NAME));
            user.setLastName(rs.getString(SQLFields.USER_LAST_NAME));
            user.setBlocked(rs.getInt(SQLFields.USER_BLOCKED));
            user.setRoleId(rs.getInt(SQLFields.USER_ROLES_ID));
            return user;
        } catch (SQLException ex) {
            log.debug("Failed to returnExistedUser in UserDAO#createUser" + ex);
        }
        return null;
    }

}

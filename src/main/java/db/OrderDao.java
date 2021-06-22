package db;

import db.entity.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    public static final String SQL_CREATE_ORDER =
            "INSERT INTO orders (type,library_cards_users_id,books_id) VALUES (?,?,?)";
    private static final String SQL_FIND_ORDER_BY_LIBRARY_CARD_ID =
            "SELECT * FROM orders WHERE library_cards_users_id=?";
    private static final String SQL_FIND_ORDER_BY_ID =
            "SELECT * FROM orders WHERE id=?";
    private static final String SQL_GET_ALL_ORDERS =
            "SELECT * FROM orders";
    public static final String SQL_UPDATE_ORDER =
            "UPDATE orders SET status = ?, type = ?, time_book_taken=?, time_book_should_be_returned=?, books_id=?  WHERE id = ?";

    private static final Integer FINE_AMOUNT = 100;

    private static final Logger log = LogManager.getLogger(OrderDao.class);

    public static List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        Order order;
        Statement stmt;
        ResultSet rs;
        Connection con = null;
        try {
            con = DBManager.getInstance().getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL_GET_ALL_ORDERS);
            while (rs.next()) {
                order = returnExistedOrder(rs);
                orders.add(order);
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(con);
            log.error("Failed to getAllOrders in UserDAO! " + ex);
        } finally {
            DBManager.getInstance().commitAndClose(con);
        }
        return orders;
    }

    public static void createOrder(
            String type, Integer libraryCardId, Integer bookId) {

        PreparedStatement pstmt;
        Connection con = null;
        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_CREATE_ORDER);
            pstmt.setString(1, type);
            pstmt.setInt(2, libraryCardId);
            pstmt.setInt(3, bookId);
            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(con);
            log.error("Failed to create order in OrderDao " + ex);
        } finally {
            DBManager.getInstance().commitAndClose(con);
        }
    }

    public static Order findOrderById(Integer orderId) {
        Order order = null;
        PreparedStatement pstmt;
        ResultSet rs;
        Connection con = null;
        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_FIND_ORDER_BY_ID);
            pstmt.setInt(1, orderId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                order = returnExistedOrder(rs);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(con);
            log.debug("Failed to findBookById in bookdao! " + ex);
        } finally {
            DBManager.getInstance().commitAndClose(con);
        }
        return order;
    }

    public static void updateOrder(
            Integer id, String status, String type, Integer bookId) {

        PreparedStatement pstmt;
        Connection con = null;
        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE_ORDER);
            pstmt.setObject(1, status);
            pstmt.setObject(2, type);
            LocalDateTime timeBookTaken = LocalDateTime.now();
            pstmt.setString(3, String.valueOf(timeBookTaken));
            LocalDateTime timeBookShouldBeReturned = timeBookTaken.plusHours(24);
            pstmt.setString(4, String.valueOf(timeBookShouldBeReturned));
            pstmt.setInt(5, bookId);
            pstmt.setInt(6, id);
            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(con);
            log.error("Failed to update order in orderdao! " + ex);
        } finally {
            DBManager.getInstance().commitAndClose(con);
        }
    }

    public static List<Order> findOrderByUserId(Integer userId) {
        Order order = null;
        List<Order> orders = new ArrayList<>();
        PreparedStatement pstmt;
        ResultSet rs;
        Connection con = null;
        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_FIND_ORDER_BY_LIBRARY_CARD_ID);
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                order = returnExistedOrder(rs);
                orders.add(order);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(con);
            log.debug("Failed to findBookById in bookdao! " + ex);
        } finally {
            DBManager.getInstance().commitAndClose(con);
        }
        return orders;
    }

    public static Integer getUserFine(Integer id) {
        Integer fine = 0;
        List<Order> orders = findOrderByUserId(id);
        for (Order order : orders) {
            String status = order.getStatus();
            System.out.println("status in getUserFine==> " + status);
            if (status.equals("CONFIRMED")) {
                LocalDateTime timeShouldReturned = LocalDateTime.parse(order.getTimeBookShouldBeReturned());
                LocalDateTime now = LocalDateTime.now();
                if (now.isAfter(timeShouldReturned)) {
                    fine = fine + FINE_AMOUNT;
                }
            }
        }
        UserDao.updateFine(id,fine);
        return fine;
    }
    public static void closeOrdersByUsersId(Integer id) {
        List<Order> orders = findOrderByUserId(id);
        Integer fine = getUserFine(id);
        for (Order order : orders) {
            String status = order.getStatus();
            Integer bookId = order.getBookId();
            if (status.equals("CONFIRMED")) {
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime timeShouldReturned = LocalDateTime.parse(order.getTimeBookShouldBeReturned());
                System.out.println("timeShouldReturned ========>" + timeShouldReturned);
                if (now.isAfter(timeShouldReturned)) {
                    System.out.println("now is after");
                    updateOrder(order.getId(),"CLOSED",order.getType(),order.getBookId());
                    fine = fine - FINE_AMOUNT;
                }
            }
        }
        UserDao.updateFine(id,fine);
    }

    private static Order returnExistedOrder(ResultSet rs) {
        try {
            Order order = new Order();
            order.setId(rs.getInt(SQLFields.ORDER_ID));
            order.setStatus(rs.getString(SQLFields.ORDER_STATUS));
            order.setType(rs.getString(SQLFields.ORDER_TYPE));
            order.setLibraryCardId(rs.getInt(SQLFields.ORDER_LIBRARY_CARD_ID));
            order.setTimeBookTaken(rs.getString(SQLFields.ORDER_TIME_BOOK_TAKEN));
            order.setTimeBookShouldBeReturned(rs.getString(SQLFields.ORDER_TIME_BOOK_SHOULD_BE_RETURNED));
            order.setBookId(rs.getInt(SQLFields.ORDER_BOOK_ID));
            return order;
        } catch (SQLException ex) {
            log.debug("Failed return existed order in order" + ex);
        }
        return null;
    }
}

package db;

import db.entity.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.*;

public class BookDao {
    private static final Logger log = LogManager.getLogger(BookDao.class);

    private static final String SQL_FIND_BOOK_BY_TITLE =
            "select * from books where title=?";
    private static final String SQL_FIND_BOOK_BY_ID =
            "SELECT * FROM books WHERE id=?";
    private static final String SQL_DELETE_BOOK_BY_TITLE =
            "delete from books where title='?'";
    private static final String SQL_DELETE_BOOK_BY_ID =
            "delete from books where id=?";
    private static final String SQL_GET_ALL_BOOKS =
            "select * from books";
    public static final String SQL_CREATE_BOOK =
            "INSERT INTO books (title,year_of_publish,author,publisher,amount,description) VALUES (?,?,?,?,?,?)";
    public static final String SQL_UPDATE_BOOK =
            "UPDATE books SET title=?, year_of_publish=?, author=?, publisher=?, amount=?,description=? WHERE id = ?";

    /**
     * Searching for book by title
     *
     * @param title
     * @return user if exists
     */
    public static List<Book> findBookByTitle(String title) {
        List<Book> books = new ArrayList<>();
        Book book = null;
        PreparedStatement pstmt;
        ResultSet rs;
        Connection con = null;
        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_FIND_BOOK_BY_TITLE);
            pstmt.setString(1, title);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                book = returnExistedBook(rs);
                books.add(book);
            }
            System.out.println(books);
            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(con);
            log.error("Failed to findUserByLogin in UserDAO! " + ex);
        } finally {
            DBManager.getInstance().commitAndClose(con);
        }
        return books;
    }

    public static List<Book> findBookByAuthor() {
        return null;
    }

    public static void updateBook(Integer id, String title, Integer yearOfPublish, String author, String publisher, Integer amount, String description) {
        PreparedStatement pstmt;
        Connection con = null;
        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE_BOOK);
            pstmt.setString(1, title);
            pstmt.setInt(2, yearOfPublish);
            pstmt.setString(3, author);
            pstmt.setString(4, publisher);
            pstmt.setInt(5, amount);
            pstmt.setString(6, description);
            pstmt.setInt(7, id);
            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(con);
            log.error("Failed to findUserByLogin in UserDAO! " + ex);
        } finally {
            DBManager.getInstance().commitAndClose(con);
        }
    }

    public static Book findBookById(Integer bookId) {
        Book book = null;
        PreparedStatement pstmt;
        ResultSet rs;
        Connection con = null;
        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_FIND_BOOK_BY_ID);
            pstmt.setInt(1, bookId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                book = returnExistedBook(rs);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(con);
            log.debug("Failed to findBookById in bookdao! " + ex);
        } finally {
            DBManager.getInstance().commitAndClose(con);
        }
        return book;
    }

    public static List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        Book book;
        Statement stmt;
        ResultSet rs;
        Connection con = null;
        try {
            con = DBManager.getInstance().getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL_GET_ALL_BOOKS);
            while (rs.next()) {
                book = returnExistedBook(rs);
                books.add(book);
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(con);
            log.error("Failed to getAllBooks in UserDAO! " + ex);
        } finally {
            DBManager.getInstance().commitAndClose(con);
        }
        return books;
    }

    public static List<Book> sortBooksByTitle() {
        List<Book> books = getAllBooks();
        Comparator<Book> sortByComparator =
                Comparator.comparing(Book::getTitle);
        Collections.sort(books, sortByComparator);
        return books;
    }

    public static List<Book> sortBooksByAuthor() {
        List<Book> books = getAllBooks();
        Comparator<Book> sortByComparator =
                Comparator.comparing(Book::getAuthor);
        Collections.sort(books, sortByComparator);
        return books;
    }

    public static List<Book> sortBooksByEdition() {
        List<Book> books = getAllBooks();
        Comparator<Book> sortByComparator =
                Comparator.comparing(Book::getPublisher);
        Collections.sort(books, sortByComparator);
        return books;
    }

    public static List<Book> sortBooksByYear() {
        List<Book> books = getAllBooks();
        Comparator<Book> sortByComparator =
                Comparator.comparing(Book::getYearOfPublish);
        Collections.sort(books, sortByComparator);
        return books;
    }


    public static void createBook(
            String title, Integer yearOfPublish, String author, String publisher, Integer amount, String description) {

        PreparedStatement pstmt;
        Connection con = null;
        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_CREATE_BOOK);
            pstmt.setString(1, title);
            pstmt.setInt(2, yearOfPublish);
            pstmt.setString(3, author);
            pstmt.setString(4, publisher);
            pstmt.setInt(5, amount);
            pstmt.setString(6, description);
            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(con);
            log.error("Failed to get All books in bookDAO! " + ex);
        } finally {
            DBManager.getInstance().commitAndClose(con);
        }
    }

    private static Book returnExistedBook(ResultSet rs) {
        try {
            Book book = new Book();
            book.setId(rs.getInt(SQLFields.BOOK_ID));
            book.setTitle(rs.getString(SQLFields.BOOK_TITLE));
            book.setYearOfPublish(rs.getInt(SQLFields.BOOK_YEAR_OF_PUBLISH));
            book.setAuthor(rs.getString(SQLFields.BOOK_AUTHOR));
            book.setPublisher(rs.getString(SQLFields.BOOK_PUBLISHER));
            book.setAmount(rs.getInt(SQLFields.BOOK_AMOUNT));
            book.setDescription(rs.getString(SQLFields.BOOK_DESCRIPTION));
            return book;
        } catch (SQLException ex) {
            log.debug("Failed return existed book in bookdao" + ex);
        }
        return null;
    }

    public static void deleteBookById(Integer id) {
        PreparedStatement pstmt;
        Connection con = null;
        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_DELETE_BOOK_BY_ID);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(con);
            log.error("Failed to delete book in bookDAO! " + ex);
        } finally {
            DBManager.getInstance().commitAndClose(con);
        }
    }
}

package web.command;

import db.BookDao;
import db.OrderDao;
import db.UserDao;
import db.entity.Book;
import db.entity.LibraryCard;
import db.entity.Order;
import db.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

public class ReturnBookCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Integer bookId = Integer.valueOf(request.getParameter("bookId"));
        Integer orderId = Integer.valueOf(request.getParameter("orderId"));
        User user = (User) session.getAttribute("loggedUser");
        LibraryCard libraryCard = UserDao.findLibraryCardById(user.getId());
        System.out.println(libraryCard);
        Integer fine = libraryCard.getFine();
        Book book = BookDao.findBookById(bookId);
        Order order = OrderDao.findOrderById(orderId);
        OrderDao.updateOrder(order.getId(),"CLOSED",order.getType(),order.getBookId());
        BookDao.updateBook(book.getId(),book.getTitle(),book.getYearOfPublish(),book.getAuthor(),book.getPublisher(),book.getAmount()+1,book.getDescription());
        LocalDateTime timeShouldReturned = LocalDateTime.parse(order.getTimeBookShouldBeReturned());
        LocalDateTime now = LocalDateTime.now();
        if (now.isAfter(timeShouldReturned)) {
            fine = fine + 100;
            UserDao.updateFine(user.getId(), fine);
        }
        return "controller?command=showBooksOnAcc";
    }
}

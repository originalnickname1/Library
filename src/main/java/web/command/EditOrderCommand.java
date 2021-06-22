package web.command;

import db.BookDao;
import db.OrderDao;
import db.entity.Book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditOrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Integer id = Integer.parseInt(request.getParameter("orderId"));
        String status = request.getParameter("status");
        Integer bookId = Integer.valueOf(request.getParameter("bookId"));
        String type = request.getParameter("type");
        String forward = CommandConstants.ERROR_JSP;
        Book book = BookDao.findBookById(bookId);
        Integer amount = book.getAmount();

        if (status.equals("CONFIRMED") && amount != 0) {
            OrderDao.updateOrder(id, status, type, bookId);
            BookDao.updateBook(
                    book.getId(), book.getTitle(),book.getYearOfPublish(), book.getAuthor(),book.getPublisher(),book.getAmount()-1,book.getDescription());
            forward = "controller?command=showOrderInfo&orderId=" + id;
        } else {
            String errorMessage = "Book is out of stock";
            session.setAttribute("errorMessage",errorMessage);
        }
        return forward;
    }
}
